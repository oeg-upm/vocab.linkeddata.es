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
    public static void main(String[] args) throws IOException{
        String urlOut="test.html";
        String urlReportOut = "report.txt";
        String html = TextConstants.header;
        html+=TextConstants.tableHead;
        ArrayList<Vocabulary> vocs = processCSV(ProcessCSVFile.class.getResource("/vocab/test.csv").getPath());
        ArrayList<String> domains = new ArrayList();
        int i=0;
        for(Vocabulary v:vocs){
            html+=v.getHTMLSerializationAsRow(""+i);
            ArrayList<String> currVocDomains = v.getDomains();
            //we add the title as welll to filter
            domains.add(v.getTitle());
                if(currVocDomains!=null){
                    for(String aux:currVocDomains){
                        domains.add(aux);
                    }
            }
            i++;                  
        }
        //note: d will have all the domains
        html+=TextConstants.tableEnd+TextConstants.end+TextConstants.getScriptForFilteringAndEndDocument(domains);
        VocabUtils.saveDocument(urlOut, html);
        Report.getInstance().saveReport(urlReportOut);//save report!
        //we generate the evaluations separately in a folder called 'ontologies'
        File f = new File (urlOut);
        File ontologyDir  = new File(f.getAbsoluteFile().getParent()+File.separator+"ontologies");
        ontologyDir.mkdir();
        for(Vocabulary v:vocs){
            try{
                new CreateOOPSEvalPage(v).createPage(ontologyDir.getPath());            
            }catch(Exception e){
                System.out.println("Error while printing the evaluation of"+ v.getUri());
            }
        }
    }
    
    //the input will be a file with the urls and a set of tags describing the domain.
    
}
