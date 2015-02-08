/*
 * Copyright 2012-2013 Ontology Engineering Group, Universidad Politécnica de Madrid, Spain
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

/**
 * This class will log whther a vocabulary has failed or not.
 * Similar to a logger, but simplified.
 * @author Daniel Garijo
 */
public class Report {
    String report;
    Report r;
    
    private Report(){
        report = "Vocabulary report +\n";
    }
    
    public Report getInstance(){
        if(r == null){
            r = new Report();
        }
        return r;        
    }
    
    public void addReport(String s){
        report +=s+"\n";
    }
    
    public void saveReport(String path){
        VocabUtils.saveDocument(path, report);
    }

}
