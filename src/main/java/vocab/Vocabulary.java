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

import java.util.ArrayList;

/**
 * Class that defines the attributes of a vocabulary
 * @author dgarijo, mpoveda
 */
public class Vocabulary {
    private String title;
    private String uri;
    private String lovURI;
    private ArrayList<String> supportedSerializations;
    private String license;
    private String description;
    private ArrayList<String> languages;
    private ArrayList<String> domains;
    private String prefix;
    private String creationDate;
    private String lastModifiedDate;

    public Vocabulary(String uri) {
        this.uri = uri;
        this.supportedSerializations = VocabUtils.getSerializationsOfVocab(uri);
    }

    public Vocabulary(String title, String uri, String lovURI, ArrayList<String> supportedSerializations, String license, String description, ArrayList<String> languages, ArrayList<String> domains, String prefix, String creationDate, String lastModifiedDate) {
        this.title = title;
        this.uri = uri;
        this.lovURI = lovURI;
        this.supportedSerializations = supportedSerializations;
        this.license = license;
        this.description = description;
        this.languages = languages;
        this.domains = domains;
        this.prefix = prefix;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    
    /*
     * Getters 
     */

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getDomains() {
        return domains;
    }

    public ArrayList<String> getLanguage() {
        return languages;
    }

    public String getLicense() {
        return license;
    }

    public ArrayList<String> getSupportedSerializations() {
        return supportedSerializations;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }

    public String getLovURI() {
        return lovURI;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }
    
    
    /**
     * Setters
     */ 

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDomains(ArrayList<String> domains) {
        this.domains = domains;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setSupportedSerializations(ArrayList<String> supportedSerializations) {
        this.supportedSerializations = supportedSerializations;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setLovURI(String lovURI) {
        this.lovURI = lovURI;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }
    
    /**
     * Method that returns an html serialization of the vocabulary.
     * Assuming that there is a table 
     * @param id id for the vocab in the table
     * @return 
     */
    public String getHTMLSerializationAsRow(String id){
        String html = ("<tr id=\"tr"+id+"\">\n");
        //URI and title
        String ontURI = this.uri;
        String ontTitle = this.getTitle();
        String localURL = ontURI.replace("https://","").replace("http://","").replace("/", "").replace("#", "").trim();
        html +=("<td><a href = \""+ ontURI + "\" >" + ontTitle + "</a> <a href = \"ontologies/" + localURL + ".html\" target=\"_blank\"><span class=\"glyphicon glyphicon-info-sign\"/></a></td>\n");

        //Serializations
        html+="<td>\n";
        if(supportedSerializations!=null){
            for(String s:this.supportedSerializations){
                html+="<span class=\"label label-primary\">"+s.replace("application/", "").replace("text/", "")+"</span>\n";
            }
        }
        html+="</td>\n";
        //License
        html+=("<td>");
        //this should be made to support more than one license @TO DO
        String licenseLabel = license.replace("http://creativecommons.org/licenses/", "");
        //Temporary solution: to do!
        html+= "<a href=\"" + license + "\" target=\"_blank\"><span class=\"label label-success\">" + licenseLabel + "</span></a>";        
//        else{
//            // boton gris, unknown
//            html.println("<span class=\"label label-default\">Unknown</span>"); 
//        }
        html+=("</td>\n");

        //Ontology Language
        html+=("<td>");
        if(languages!=null){
            for(String lang: languages){
                html+="<span class=\"label label-success\">" + lang + "</span>";
            }
        }else{
            html+="<span class=\"label label-default\">Undefined</span>";
        }
        html+="</td>\n";    
        //Domains
        html+="<td>";
        String domainText="";
        if(domains!=null){
            for(String d:domains){
                html+="<span class=\"label label-primary\">" + d + "</span>\n";
                domainText = domainText + "--";
            }
        }else{
            html+="<span class=\"label label-default\">Undefined</span>";
        }
        html+=("</td>\n");
        
        //description
        html+="<td>" + description + "</td>\n";
        html+="<input type=\"hidden\" name=\"inp"+id+"\" id=\"inp"+id+"\" value=\""+domainText+"\"/>";
        html+=("</tr>");        
        return html;
    }
    
}
