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
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;
//import com.hp.hpl.jena.query.Syntax;
import java.util.ArrayList;
import java.util.Iterator;
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
            System.err.println("exc query en VocabInLOV: " + d.getMessage());
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
        String propertyName, value;
        while(it.hasNext()){
            Statement s = (Statement) it.next();
            propertyName = s.getPredicate().getLocalName();
            try{
                value = s.getObject().asLiteral().getString();
            }catch(Exception e){
                value = s.getObject().asResource().getURI();
            }
//            System.out.println(propertyName + " " + value);
            // fill in the properties here.
            if(propertyName.equals("description")){
                vocabulary.setDescription(value);
            }else
            if(propertyName.equals("abstract")){
                vocabulary.setDescription(value);
            }else
            if(propertyName.equals("title")){
                vocabulary.setTitle(value);
            }else
//            if(propertyName.equals("replaces")||propertyName.equals("wasRevisionOf")){
//                this.previousVersion = value;
//            }else
//            if(propertyName.equals("versionInfo")){
//                this.revision = value;
//            }else
            if(propertyName.equals("preferredNamespacePrefix")){
                vocabulary.setPrefix(value);
            }else
//            if(propertyName.equals("preferredNamespaceUri")){
//                this.mainOntology.setNamespaceURI(value);                
//            }else
            if(propertyName.equals("license")){
                vocabulary.setLicense(value);
//                this.license = new License();
//                if(isURL(value)){
//                    this.license.setUrl(value);
//                }else{
//                    license.setName(value);
//                }
            }else
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
            if(propertyName.equals("created")){
                vocabulary.setCreationDate(value);
            }
//                if(releaseDate==null || "".equals(releaseDate)){
//                    this.releaseDate = value;
//                }
            else
            if(propertyName.equals("modified")){
                vocabulary.setLastModifiedDate(value);
            }
//            System.out.println("Loaded properties from ontology");
            //not including imported ontologies at the moment
            //else
//            if(propertyName.equals("imports")){
//                Ontology o = new Ontology();
//                if(isURL(value)){
//                    o.setNamespaceURI(value);
//                    o.setName("imported ontology name goes here");
//                }else{
//                    o.setName(value);
//                    o.setNamespaceURI("namespace URI goes here");
//                }
//                this.importedOntologies.add(o);
//            }
            //to do: if property is comment and abstract is null, then complete abstract.
//        }
            
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
                return;
            }
            System.out.println("Vocab "+v.getUri()+" loaded successfully!");
        }
        
//        try{
//            model.read(v.getUri(), null, "RDF/XML");
//        }catch(Exception e){
//            try{
//                model.read(ontoURL, null, "TURTLE");            
//            }catch(Exception e1){
//                try{
//                    model.read(ontoURL, null, "N3");            
//                }catch(Exception e2){
//                    System.err.println("Error: no model available!!");
//                }
//        }
    }
    
    /**
     * Test to get the response of a get request.
     * @param args 
     */
//    public static void main(String[] args){
//        Vocabulary v = getVocabularyMetadata("http://purl.org/net/p-plan");
//        System.out.println(v.getHTMLSerializationAsRow(""+0));
//    }
//        Vocabulary v = new Vocabulary();
//        v.setUri("http://purl.org/net/p-plan");
//        if(getLOVPage(v)){
//            System.out.println("It has a lov page: "+ v.getLovURI());
//        }
//        ArrayList<String> s = getSerializations("http://datos.bne.es/def/");
//        System.out.println("Suported serializations:");
//        for (String a:s){
//            System.out.println(a);
//        }
//    }
    
}
