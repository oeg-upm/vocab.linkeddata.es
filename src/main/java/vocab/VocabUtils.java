/*
 * Copyright 2012-2013 Ontology Engineering Group, Universidad Politecnica de Madrid, Spain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package vocab;


import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Statement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Class for defining common operations for vocabularies: if the vocab is in LOV, 
 * retrieve its serializations, etc.
 * @author dgarijo, mpoveda
 */
public class VocabUtils {
    /**
     * serializations we are asking for.
     */
    private static final String[] serializations = {"application/rdf+xml","text/html",
        "text/turtle","text/n3", "application/n-quads"};
    
    
    public static ArrayList<String> getSerializationsOfVocab(String uri){
        ArrayList<String> supportedSerializations = new ArrayList<>();
        //try for: application/rdf+xml, text/html, text/turtle, text/n3
        for(String currentSer:serializations){
            if(hasSerialization(uri, currentSer)){
                supportedSerializations.add(currentSer);
            }
        }
        return supportedSerializations;
    }
    
    /**
     * Given a URI and a serialization, this method returns if it is supported.
     * @param uri
     * @param serialization
     * @return 
     */
    public static boolean hasSerialization(String uri, String serialization){
        try {
 
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Accept", serialization);
            HttpResponse response = client.execute(request);
            if(response.getStatusLine().getStatusCode() == 200){
                String contentType = response.getFirstHeader("Content-Type").getValue();
                if(contentType.contains(serialization)){
//                    System.out.println(response.getLastHeader("Location").getValue());
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error while doing http get: "+serialization+" in "+uri+" "+ e.getMessage());
        }
        return false;
    }
    
    /**
     * Given a vocabulary, this method fills its lov page.
     * @param v
     * @return true if the vocabulary is in LOV. False otherwise.
     * Method created by mpoveda
     */
    public static boolean getLOVPage(Vocabulary v){
        try {
    	    Query queryLOV = QueryFactory.create(Queries.isVocabInLOV(v.getUri()), Syntax.syntaxARQ);
//            System.out.println(queryLOV);
            // Execute the query and obtain results
            QueryExecution qe = QueryExecutionFactory.sparqlService(Queries.LOVEndpoint, queryLOV);
            ResultSet results = qe.execSelect(); 	
            if(results.hasNext()){
                QuerySolution qs = results.next();
                v.setPrefix(qs.getLiteral("vocabPrefix").toString());	
                v.setLovURI("http://lov.okfn.org/dataset/lov/details/vocabulary_"+ v.getPrefix()+".html");
                qe.close();
                return true;
            }
            qe.close();
            return false;	    	 
        }
        catch (java.lang.Exception d){
            System.err.println("exc query en VocabInLOV: " + d.getMessage()+ d.getCause().getMessage());
            return false;
        }
    }
    
    /**
     * Method that, given a URI loads the vocabulary available metadata.
     * @param vocabURI
     * @return 
     */
    public static Vocabulary getVocabularyMetadata(String vocabURI){
        OntModel currentModel = ModelFactory.createOntologyModel();
        Vocabulary vocabulary = new Vocabulary(vocabURI);
        try{
            readOnlineModel(currentModel, vocabulary);
            if(currentModel==null){
                System.err.println("could not load vocabulary");
                return null;
            }
        }catch(Exception e){
            System.err.println("could not load vocabulary");
            return null;
        }
        //we assume only one ontology per file.
        OntResource onto = currentModel.getOntClass("http://www.w3.org/2002/07/owl#Ontology").listInstances().next();
        Iterator it = onto.listProperties();//model.getResource("http://purl.org/net/wf-motifs").listProperties();
        String propertyName, value, language;
        while(it.hasNext()){
            Statement s = (Statement) it.next();
            propertyName = s.getPredicate().getLocalName();
            language = "";
            try{
                Literal l = s.getObject().asLiteral();
                value = l.getString();
                language = l.getLanguage();
                
            }catch(Exception e){
                value = s.getObject().asResource().getURI();
            }
            // fill in the properties here.
            switch (propertyName) {
                case "description":
                    if(language.equals("en")||vocabulary.getDescription()==null
                            ||vocabulary.getDescription().equals("")){
                        vocabulary.setDescription(value);
                    }
                    break;
                case "abstract":
                    if(language.equals("en")||vocabulary.getDescription()==null
                            ||vocabulary.getDescription().equals("")){
                        vocabulary.setDescription(value);
                    }
                    break;
                case "title"://by default we take the english desc
                    if(language.equals("en")||vocabulary.getTitle()==null
                            ||vocabulary.getTitle().equals("")){
                        vocabulary.setTitle(value);
                    }
                    break;
//            if(propertyName.equals("replaces")||propertyName.equals("wasRevisionOf")){
//                this.previousVersion = value;
//            }else
//            if(propertyName.equals("versionInfo")){
//                this.revision = value;
//            }else
                case "preferredNamespacePrefix":
                    vocabulary.setPrefix(value);
                    break;
//            if(propertyName.equals("preferredNamespaceUri")){
//                this.mainOntology.setNamespaceURI(value);                
//            }else
//            if(propertyName.equals("license")){ // es necesario este if? no se crea siempre
////                vocabulary.setLicense(value);
//                vocabulary.setLicense(vocabURI);
//                vocabulary.setLicenseLabel(vocabURI);
////                this.license = new License();
////                if(isURL(value)){
////                    this.license.setUrl(value);
////                }else{
////                    license.setName(value);
////                }
//            }else
//            if(propertyName.equals("creator")||propertyName.equals("contributor")){
//                Agent g = new Agent();
//                if(isURL(value)){
//                    g.setURL(value);
//                    g.setName("name goes here");
//                }else{
//                    g.setName(value);
//                    g.setURL("url oges here");
//                }
//                if(propertyName.equals("creator")){
//                    this.creators.add(g);
//                }else{
//                    this.contributors.add(g);
//                }
//            }else
                case "created":
                    vocabulary.setCreationDate(value);
                    break;
                case "modified":
                    vocabulary.setLastModifiedDate(value);
                    break;
            }
            
        }
        //since the webservice extracts the license, we don't need to find it
        try{
            vocabulary.setLicense(vocabURI);
            vocabulary.setLicenseTitle(vocabURI);
        }catch(Exception e){
            Report.getInstance().addToReport("-->Warning: could not load license from vocab");
        }
        
        //look for languages used in the vocabulary
        
        ArrayList <String> languagesUsed = new ArrayList<>();
        try {
    	    Query languagesQ = QueryFactory.create(Queries.languagesUsed);
            QueryExecution qe = QueryExecutionFactory.create(languagesQ, currentModel);
            ResultSet results = qe.execSelect() ;
            while( results.hasNext())
            {
              QuerySolution soln = results.nextSolution() ;
              RDFNode x = soln.get("langUsed") ;       // Get a result variable by name.
              if(x != null){
            	  if (!x.toString().isEmpty()){
            		  languagesUsed.add(x.toString());
//            		  System.out.println("Language added: " + x);
            	  } 
              }
            }
            vocabulary.setLanguages(languagesUsed);
            qe.close();
        }
        catch (java.lang.Exception d){
            System.err.println("error when getting the languages: " + d.getMessage());
        }
        //liberate resources    
        currentModel.close();
        //LOV
        getLOVPage(vocabulary);
        return vocabulary;
    }
    
    /**
     * The reason why the model is not returned is because I want to be able to close it later.
     * @param model
     * @param ontoPath
     * @param ontoURL 
     */
    private static void readOnlineModel(OntModel model,Vocabulary v){        
        ArrayList<String> s = v.getSupportedSerializations();
        if (s.isEmpty()){
            System.err.println("Error: no serializations available!!");
            Report.getInstance().addToReport("-->Error: no serializations available for vocab");
        }else{
            if(s.contains("application/rdf+xml")){
                model.read(v.getUri(), null, "RDF/XML");
            }else 
            if(s.contains("text/turtle")){
                model.read(v.getUri(), null, "TURTLE");
            }else
            if(s.contains("text/n3")){
                model.read(v.getUri(), null, "N3");
            }else{
                System.err.println("Error: no serializations available!!");
                Report.getInstance().addToReport("-->Error: no serializations available for vocab");
                return;
            }
            System.out.println("Vocab "+v.getUri()+" loaded successfully!");
        }
    }
    
    /**
     * Method to save a document on a path
     * @param path
     * @param textToWrite
     */
    public static void saveDocument(String path, String textToWrite){
        File f = new File(path);
        Writer out = null;
        try{
            f.createNewFile();
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
            out.write(textToWrite);
            out.close();
        }catch(IOException e){
            System.err.println("Error while creating the file "+e.getMessage()+"\n"+f.getAbsolutePath());
        }        
        
    }
    
    /**
     * Code to unzip a file. Inspired from
     * http://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/
     * Taken from 
     * @param resourceName
     * @param outputFolder 
     */
    public static void unZipIt(String resourceName, String outputFolder){
 
     byte[] buffer = new byte[1024];
 
     try{
    	ZipInputStream zis = 
    		new ZipInputStream(VocabUtils.class.getResourceAsStream(resourceName));
    	ZipEntry ze = zis.getNextEntry();
 
    	while(ze!=null){
 
    	   String fileName = ze.getName();
           File newFile = new File(outputFolder + File.separator + fileName);
           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
           if (ze.isDirectory()){
                String temp = newFile.getAbsolutePath();
                new File(temp).mkdirs();
           }
           else{
                FileOutputStream fos = new FileOutputStream(newFile);
                int len; while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len); }
                fos.close();
           }  
            ze = zis.getNextEntry();
    	}
 
        zis.closeEntry();
    	zis.close();
 
    }catch(IOException ex){
        System.err.println("Error while extracting the reosurces: "+ex.getMessage());
    }
   } 
    
}
