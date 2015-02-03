package es.upm.oeg.smartcity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



public class Dataset {
	
	public String url = null;
	
	public String title = null;
	public String description = null;
		
	public ArrayList<String> domains = new ArrayList<String>();
	
	public String version = null;
	
	public String creationDate = null;
	public String lastUpdate = null;
	
	public ArrayList<String> contactPersons = new ArrayList<String>();
	
	public String publisher = null;
	
	public ArrayList<String> licenses = new ArrayList<String>();
	
	public ArrayList<String> formats = new ArrayList<String>();
	public ArrayList<String> languages = new ArrayList<String>();
	
	public String updateFrequency = null;
	
	public String availableOnline = null;
	public String digitalForm = null;
	public String publiclyAvailable = null;
	public String freeOfCharge = null;
	public String machineReadableFormat = null;
	public String bulkAvailable = null;
	public String updated = null;
		
	public Dataset(String line) {
		// TODO Auto-generated constructor stub
				
		//orden en el que recibo los datos:
//		Marca temporal	Name	URI	Description	Domains	Namespace	Version	Creation date	Last update	
//		Contact person 	Publisher	Ontology language	Format	License	Language	
//		Is the dataset an outcome of a European project? 	Comments 	References 	Your contact information	
//		Update frequency	If the dataset is avaiable online, under which URL?	Is the dataset available in digital form? 
//		Is the dataset publicly available? 	Is the dataset free of charge? 	Is the dataset available online? 	
//		Is the dataset available in a machine readable format? 	Is the dataset available in bulk? 	Is the dataset updated? 
		
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
		
		//URL ignore
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
//			this.url = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
			nextField = line.indexOf(",");
//			this.url = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("uri: " + this.uri);
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
		
		//ignore namespace
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
			nextField = line.indexOf(",");
			line = line.substring(++nextField);
//			System.err.println("uri: " + this.uri);
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
		
		//ignore ontology language
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			line = line.substring(nextField+2);
		}
		else{
			nextField = line.indexOf(",");
			line = line.substring(++nextField);
		}
		
		// Formats
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			List<String> list = Arrays.asList(line.substring(1,nextField).split(", "));
			this.formats = new ArrayList<String>(list);	
			line = line.substring(nextField+2);
//					System.err.println("formats with comma: " + this.formats.toString());
		}
		else{
			nextField = line.indexOf(",");
			this.formats.add(line.substring(0,nextField));
			line = line.substring(++nextField);
//					System.err.println("formats: " + this.formats.toString());
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
		
		// Language,
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			List<String> list = Arrays.asList(line.substring(1,nextField).split(", "));
			this.languages = new ArrayList<String>(list);	
			line = line.substring(nextField+2);
//			System.err.println("languages with comma: " + this.languages.toString());
		}
		else{
			nextField = line.indexOf(",");
			this.languages.add(line.substring(0,nextField));
			line = line.substring(++nextField);
//			System.err.println("languages: " + this.languages.toString());
		}
		
		//ignore output of a european project
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			line = line.substring(nextField+2);
		}
		else{
			nextField = line.indexOf(",");
			line = line.substring(++nextField);
		}

		//ignore comments
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			line = line.substring(nextField+2);
		}
		else{
			nextField = line.indexOf(",");
			line = line.substring(++nextField);
		}	
		
		//ignore references
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			line = line.substring(nextField+2);
		}
		else{
			nextField = line.indexOf(",");
			line = line.substring(++nextField);
		}		

		//ignore your contact information
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			line = line.substring(nextField+2);
		}
		else{
			nextField = line.indexOf(",");
			line = line.substring(++nextField);
		}
		
//		update frequency
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.updateFrequency = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("update freq with comma: " + this.updateFrequency);
		}
		else{
			nextField = line.indexOf(",");
			this.updateFrequency = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("update freq: " + this.updateFrequency);
		}
		
		//URL 
//		If the dataset is avaiable online, under which URL?
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.url = line.substring(1,nextField).trim();	
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
			nextField = line.indexOf(",");
			this.url = line.substring(0,nextField).trim();
			line = line.substring(++nextField);
//			System.err.println("uri: " + this.uri);
		}
		
		//Is the dataset available in digital form?
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.digitalForm = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
			nextField = line.indexOf(",");
			this.digitalForm = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("uri: " + this.uri);
		}		

//		Is the dataset publicly available? 	
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.publiclyAvailable = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
			nextField = line.indexOf(",");
			this.publiclyAvailable = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("uri: " + this.uri);
		}
		
//		Is the dataset free of charge? 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.freeOfCharge = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
			nextField = line.indexOf(",");
			this.freeOfCharge = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("uri: " + this.uri);
		}
		
//		Is the dataset available online? 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.availableOnline = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
			nextField = line.indexOf(",");
			this.availableOnline = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("uri: " + this.uri);
		}
		
//		Is the dataset available in a machine readable format? 	
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.machineReadableFormat = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
			nextField = line.indexOf(",");
			this.machineReadableFormat = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("uri: " + this.uri);
		}
		
//		Is the dataset available in bulk? 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.bulkAvailable = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
			nextField = line.indexOf(",");
			this.bulkAvailable = line.substring(0,nextField);
			line = line.substring(++nextField);
//			System.err.println("uri: " + this.uri);
		}
		
//		Is the dataset updated? 
		if (line.startsWith("\"")){
			//hay una coma en el siguiente campo
			nextField = line.indexOf("\"", 1);
			this.updated = line.substring(1,nextField);	
			line = line.substring(nextField+2);
//			System.err.println("uri with comma: " + this.uri);
		}
		else{
//			nextField = line.indexOf(",");
//			this.updated = line.substring(0,nextField);
//			line = line.substring(++nextField);
			this.updated = line; //por ser el ultimo campo
//			System.err.println("uri: " + this.uri);
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
	
	public String getPublisher() {
		return publisher;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getVersion() {
		return version;
	}

	public String getAvailableOnline() {
		return availableOnline;
	}
	
	public String getBulkAvailable() {
		return bulkAvailable;
	}
	
	public String getDigitalForm() {
		return digitalForm;
	}
	
	public String getFreeOfCharge() {
		return freeOfCharge;
	}
	
	public String getMachineReadableFormat() {
		return machineReadableFormat;
	}
	
	public String getPubliclyAvailable() {
		return publiclyAvailable;
	}
	
	public String getUpdated() {
		return updated;
	}
	
	public String getUpdateFrequency() {
		return updateFrequency;
	}
	
}
