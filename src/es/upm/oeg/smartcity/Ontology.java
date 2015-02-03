package es.upm.oeg.smartcity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



public class Ontology {
	
	public String uri = null;
	
	public String title = null;
	public String description = null;
		
	public String prefix = null;
	public String namespace = null;
		
	public ArrayList<String> domains = new ArrayList<String>();
	
	public String version = null;
	
	public String creationDate = null;
	public String lastUpdate = null;
	
	public ArrayList<String> contactPersons = new ArrayList<String>();
	
	public String publisher = null;
	
	public ArrayList<String> licenses = new ArrayList<String>();
	
	public ArrayList<String> formats = new ArrayList<String>();
	public ArrayList<String> ontLanguages = new ArrayList<String>();
	public ArrayList<String> languages = new ArrayList<String>();
		
	public Ontology(String line) {
		// TODO Auto-generated constructor stub
				
		//orden en el que recibo los datos:
		//Marca temporal,Name,URI,Prefix,Namespace,Description,Domains,Version,Creation date,Last update,
		//Contact person ,Publisher,License,Format,Ontology language,Language,
		//Is the ontology an outcome of an European project? ,Comments ,References ,Your contact information
		
//		System.err.println(line);
		
		int nextField = 0;
		
		//ignorar marca temporal
		nextField = line.indexOf(",");
		line = line.substring(++nextField);
				
		//title
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 2);
			this.title = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("title with comma:" + this.title);
		}
		else{
			nextField = line.indexOf(",");
			this.title = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("title: " + this.title);
		}
		
		//URI
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.uri = line.substring(1,nextField).trim();	
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
			nextField = line.indexOf(",");
			this.uri = line.substring(0,nextField).trim();
			line = line.substring(++nextField);
//			System.err.println("uri: " + this.uri);
		}
		
		// prefix
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.prefix = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("prefix with comma: " + this.prefix);
		}
		else{
			nextField = line.indexOf(",");
			this.prefix = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("prefix: " + this.prefix);
		}
		
		// namespace
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.namespace = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("namespace with comma: " + this.namespace);
		}
		else{
			nextField = line.indexOf(",");
			this.namespace = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("namespace: " + this.namespace);
		}
		
		// description
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.description = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("description with comma: " + this.description);
		}
		else{
			nextField = line.indexOf(",");
			this.description = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("description: " + this.description);
		}
		
		// Domains 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			List<String> list = Arrays.asList(line.substring(1,nextField).split(", "));
			for (int i = 0; i < list.size(); i++){
				String aux = list.get(i).trim();
				list.set(i, aux);
			}
			this.domains = new ArrayList<String>(list);	
			line = line.substring(nextField+2);
//			System.err.println("domains with comma: " + this.domains.toString());
		}
		else{
			nextField = line.indexOf(",");
			this.domains.add(line.substring(0,nextField));
			line = line.substring(++nextField).trim();
//			System.err.println("domains: " + this.domains.toString());
		}
		
		// Version 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.version = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("version with comma: " + this.version);
		}
		else{
			nextField = line.indexOf(",");
			this.version = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("version: " + this.version);
		}
		
		// Creation date 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.creationDate = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("creationDate with comma: " + this.creationDate);
		}
		else{
			nextField = line.indexOf(",");
			this.creationDate = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("creationDate: " + this.creationDate);
		}
		
		// Last update,
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.lastUpdate = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("lastUpdate with comma: " + this.lastUpdate);
		}
		else{
			nextField = line.indexOf(",");
			this.lastUpdate = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("lastUpdate: " + this.lastUpdate);
		}
		
		//Contact person 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			List<String> list = Arrays.asList(line.substring(1,nextField).split(", "));
			this.contactPersons = new ArrayList<String>(list);	
			line = line.substring(nextField+2);
//			System.err.println("contactPersons with comma: " + this.contactPersons.toString());
		}
		else{
			nextField = line.indexOf(",");
			this.contactPersons.add(line.substring(0,nextField));
			line = line.substring(++nextField);
//			System.err.println("contactPersons: " + this.contactPersons.toString());
		}
		
		// Publisher
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.publisher = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("publisher with comma: " + this.publisher);
		}
		else{
			nextField = line.indexOf(",");
			this.publisher = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("publisher: " + this.publisher);
		}
		
		// License 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			List<String> list = Arrays.asList(line.substring(1,nextField).split(", "));
			this.licenses = new ArrayList<String>(list);	
			line = line.substring(nextField+2);
//			System.err.println("licenses with comma: " + this.licenses.toString());
		}
		else{
			nextField = line.indexOf(",");
			this.licenses.add(line.substring(0,nextField));
			line = line.substring(++nextField);
//			System.err.println("licenses: " + this.licenses.toString());
		}
		
		// Format 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			List<String> list = Arrays.asList(line.substring(1,nextField).split(", "));
			this.formats = new ArrayList<String>(list);	
			line = line.substring(nextField+2);
//			System.err.println("formats with comma: " + this.formats.toString());
		}
		else{
			nextField = line.indexOf(",");
			this.formats.add(line.substring(0,nextField));
			line = line.substring(++nextField);
//			System.err.println("formats: " + this.formats.toString());
		}
		
		// Ontology language 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			List<String> list = Arrays.asList(line.substring(1,nextField).split(", "));
			this.ontLanguages = new ArrayList<String>(list);	
			line = line.substring(nextField+2);
//			System.err.println("ontLanguages with comma: " + this.ontLanguages.toString());
		}
		else{
			nextField = line.indexOf(",");
			this.ontLanguages.add(line.substring(0,nextField));
			line = line.substring(++nextField);
//			System.err.println("ontLanguages: " + this.ontLanguages.toString());
		}
		
		// Language,
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			List<String> list = Arrays.asList(line.substring(1,nextField).toLowerCase().split(", "));
			this.languages = new ArrayList<String>(list);	
			line = line.substring(nextField+2);
//			System.err.println("languages with comma: " + this.languages.toString());
		}
		else{
			nextField = line.indexOf(",");
			this.languages.add(line.substring(0,nextField).toLowerCase());
			line = line.substring(++nextField);
//			System.err.println("languages: " + this.languages.toString());
		}
		
//		System.err.println("");
	}
	
	public ArrayList<String> getContactPersons() {
		return contactPersons;
	}
	
	public String getCreationDate() {
		return creationDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ArrayList<String> getDomains() {
		return domains;
	}
	
	public ArrayList<String> getFormats() {
		return formats;
	}
	
	public ArrayList<String> getLanguages() {
		return languages;
	}
	
	public String getLastUpdate() {
		return lastUpdate;
	}
	
	public ArrayList<String> getLicenses() {
		return licenses;
	}
	
	public String getNamespace() {
		return namespace;
	}
	
	public ArrayList<String> getOntLanguages() {
		return ontLanguages;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getUri() {
		return uri;
	}
	
	public String getVersion() {
		return version;
	}

}
