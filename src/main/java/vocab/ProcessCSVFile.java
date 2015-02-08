/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class for processing the input file with the URIs and domains of the vocabs
 * @author mpoveda, dgarijo
 */
public class ProcessCSVFile {
    
    public static ArrayList<Vocabulary> processCSV(String path){
        ArrayList<Vocabulary> vocabs = new ArrayList<>();
        try{
            BufferedReader in = new BufferedReader(new FileReader(path));
            String currentLine;
            int lineN = 0;
            String currentVocab="";
            while ((currentLine = in.readLine()) != null) {
                try{                    
                    if (lineN == 0){
                            lineN++; //get rid of the headers
                    }
                    else{
//                        System.out.println(currentLine);
                        //process each vocab
                        String[] vocsAndDomains = currentLine.split(";");
                        currentVocab = vocsAndDomains[0];
                        Report.getInstance().addToReport("Dealing with Vocabulary "+currentVocab);
                        Vocabulary v = VocabUtils.getVocabularyMetadata(currentVocab);
                        //if the vocabulary is null, then we have an error to report.
                        //Also, if the vocabulary does not have description or title, report an error.
                        if(v!=null){
                            if(vocsAndDomains.length>1){
                                vocsAndDomains = vocsAndDomains[1].split(",");
                                ArrayList<String> domains = new ArrayList();
                                domains.addAll(Arrays.asList(vocsAndDomains));
                                v.setDomains(domains);
                            }else{
                                Report.getInstance().addToReport("-->Warning: no domains found for this vocab!");
                            }
                            if(v.getDescription()!=null && !v.getDescription().equals("") &&
                                    v.getTitle()!=null && !v.getTitle().equals("")){
                                vocabs.add(v);
                                Report.getInstance().addToReport("-->Vocabulary added successfully.");
                            }else{
                                Report.getInstance().addToReport("Error: title or description missing from vocabulary. Omitted");
                            }
                        }else{
                            Report.getInstance().addToReport("Error while parsing the vocabulary.");
                        }
                    }
                }catch(Exception e){
                    System.out.println("Error while dealing with vocab: "+currentVocab+" "+e.getMessage());
                    Report.getInstance().addToReport("-->Error while dealing with vocab: "+currentVocab+" "+e.getMessage());
                }
            }
            in.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return vocabs;
    }
    
//    public static void main(String[] args){
//        processCSV(ProcessCSVFile.class.getResource("/vocab/test.csv").getPath());
//    }
    
}
