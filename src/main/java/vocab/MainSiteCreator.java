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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import oops.CreateOOPSEvalPage;
import static vocab.ProcessCSVFile.processCSV;

/**
 * Class for processing vocabularies and converting them to HTML.
 * Input: csv with 2 columns: URI of vocab and domains (separated by ,)
 * Input 2: Path where you want the output
 * Output: an html file with the table summarizing all the vocabs
 * @author dgarijo and mpoveda
 */
public class MainSiteCreator {
    public static void createFolderStructure(String savePath){
        VocabUtils.unZipIt(TextConstants.vocabResources, savePath);
        //copy vocab on the Ontologies folder
        File ont = new File( savePath+File.separator+TextConstants.ontologyFolder);
        ont.mkdirs();
        VocabUtils.unZipIt(TextConstants.oopsResources, ont.getAbsolutePath());
        
//        File reportFolder = new File (savePath+File.separator+TextConstants.reportFolder);
//        reportFolder.mkdirs(); 
//        VocabUtils.unZipIt(TextConstants.vocabResources, reportFolder.getAbsolutePath());
    }
    public static void main(String[] args) throws IOException{
        String pathVocabsFile = "";
        if(args.length<2){
            System.out.println("Usage: java-jar vocab.jar -i input CSV file path [-o outputDirectoryPath]");
            return;
        }
        pathVocabsFile = args[1];
        String outputFile = null;
        if(args.length==4 && args[2].equals("-o")){
            outputFile = args[3];
        }
//        pathVocabsFile = "C:\\Users\\dgarijo\\Dropbox (OEG-UPM)\\NetBeansProjects\\vocab\\VocabulariesReduced.csv";
        String urlOut = "";
        File auxF;
        if(outputFile==null){
            auxF = new File(urlOut);
            auxF = new File (auxF.getAbsolutePath()+File.separator+TextConstants.getsiteFolderName());
            auxF.mkdirs();
        }else{
            auxF = new File(outputFile);
            auxF.mkdirs();
        }
        MainSiteCreator.createFolderStructure(auxF.getAbsolutePath());
        String catalogOutPath = auxF.getAbsolutePath()+File.separator+TextConstants.siteName;
        String urlReportOut = auxF.getAbsolutePath()+File.separator+TextConstants.reportName;
        String html = TextConstants.header+TextConstants.navBarVocab;
        html+=TextConstants.tableHeadVocab;
        try{
            //ArrayList<Vocabulary> vocs = processCSV(ProcessCSVFile.class.getResource("/vocab/test.csv").getPath());
            ArrayList<Vocabulary> vocs = processCSV(pathVocabsFile);
            ArrayList<String> domains = new ArrayList();
            int i=1;
            for(Vocabulary v:vocs){
                html+=v.getHTMLSerializationAsRow(""+i);
                ArrayList<String> currVocDomains = v.getDomains();
                //we add the title as welll to filter
                domains.add(v.getTitle());
                    if(currVocDomains!=null){
                        for(String aux:currVocDomains){
                            if(!domains.contains(aux)){
                                domains.add(aux);
                            }
                        }
                }
                i++;                  
            }
            //note: d will have all the domains
            html+=TextConstants.tableEnd+TextConstants.end+TextConstants.getScriptForFilteringAndEndDocument(domains);
            VocabUtils.saveDocument(catalogOutPath, html);
            Report.getInstance().saveReport(urlReportOut);//save report!
            //we generate the evaluations separately in a folder called 'ontologies'
            File ontologyDir  = new File(auxF.getAbsolutePath()+File.separator+TextConstants.ontologyFolder);
    //        ontologyDir.mkdir();
            for(Vocabulary v:vocs){
                try{
                    new CreateOOPSEvalPage(v).createPage(ontologyDir.getPath());            
                }catch(Exception e){
                    System.out.println("Error while printing the evaluation of"+ v.getUri());
                }
            }
        }catch(Exception e){
            System.err.println("Could not create the site: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
}
