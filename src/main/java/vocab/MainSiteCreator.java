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

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import oops.OOPSevaluation;
import static vocab.ProcessCSVFile.processCSV;
import static vocab.VocabUtils.getVocabularyMetadata;

/**
 * Class for processing vocabularies and converting them to HTML.
 * Input: csv with 2 columns: URI of vocab and domains (separated by ;)
 * Input 2: Path where you want the output
 * Output: an html file with the table summarizing all the vocabs
 * @author dgarijo and mpoveda
 */
public class MainSiteCreator {
    public static void main(String[] args) throws IOException{
        //System.out.println("test");
//        OOPSevaluation eval = new OOPSevaluation("http://purl.org/net/p-plan", "");
//        System.out.println(eval.printEvaluation());
        String urlOut="test.html";
        String html = TextConstants.header;
        html+=TextConstants.tableHead;
        ArrayList<Vocabulary> vocs = processCSV(ProcessCSVFile.class.getResource("/vocab/test.csv").getPath());
//        Vocabulary v = getVocabularyMetadata("http://purl.org/net/p-plan");
        ArrayList<String> domains = new ArrayList();
//        d.add("provenance");
//        v.setDomains(d);
//        Vocabulary v1 = getVocabularyMetadata("http://purl.org/net/wf-motifs");
////        Vocabulary v2 = getVocabularyMetadata("http://purl.org/net/ro-optimization");
//        html+=v.getHTMLSerializationAsRow(""+0);
//        html+=v1.getHTMLSerializationAsRow(""+1);
////        html+=v2.getHTMLSerializationAsRow(""+2);
//        d.add("banana");
//        d.add("Poveda");
        int i=0;
        for(Vocabulary v:vocs){
            html+=v.getHTMLSerializationAsRow(""+i);
            ArrayList<String> currVocDomains = v.getDomains();
                if(currVocDomains!=null){
                    for(String aux:currVocDomains){
                        domains.add(aux);
                    }
            }
            i++;                  
        }
        //note: d will have all the do mains
        html+=TextConstants.tableEnd+TextConstants.end+TextConstants.getScriptForFilteringAndEndDocument(domains);
        try ( //System.out.println(html);
        //export to file
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(urlOut), "UTF-8"))) {
            out.write(html);
            out.close();
        }catch(Exception e){
            System.err.println("Error while generating the site: "+e.getMessage());
        }
    }
    
    //the input will be a file with the urls and a set of tags describing the domain.
    
}
