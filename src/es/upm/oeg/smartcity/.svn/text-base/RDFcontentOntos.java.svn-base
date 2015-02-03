package es.upm.oeg.smartcity;

import java.io.FileNotFoundException;

import eu.dynalearn.model.GroundingTerm;
import eu.dynalearn.st.grounder.EnglishGrounder;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;
import com.hp.hpl.jena.datatypes.xsd.impl.XSDDateType;
import com.hp.hpl.jena.ontology.AnnotationProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;



public class RDFcontentOntos {
	
	private OntModel model = null;
	
	private String energyResource = "http://smartcity.linkeddata.es/resource#";
	private String energyOnto = "http://smartcity.linkeddata.es/def#";
	
	private String cal	= "http://www.w3.org/2002/12/cal/ical#";
	private String cc = "http://creativecommons.org/ns#";
	private String dc = "http://purl.org/dc/terms/";
	private String foaf = "http://xmlns.com/foaf/0.1/";
	private String frbr = "http://purl.org/vocab/frbr/core#";
	private String omv	= "http://omv.ontoware.org/2005/05/ontology#";
	private String vann = "http://purl.org/vocab/vann/";
	private String voaf = "http://purl.org/vocommons/voaf#";
	private String voidV = "http://rdfs.org/ns/void#";
	private String vs = "http://www.w3.org/2003/06/sw-vocab-status/ns#";

	public RDFcontentOntos (ArrayList<Ontology> ontologies, PrintStream outputLog) throws FileNotFoundException, UnsupportedEncodingException{
		
		//fichero para sacar los grounding
//		PrintStream groundingLog = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("/Users/oeg/Documents/workspace/smartcity.linkeddata.es/groundingOntos.csv"))), true); 
//		groundingLog.println("tag, label con contexto, URI con contexto, label sin contexto, URI sin contexto, Para ontolog�a");

		OntModelSpec s = new OntModelSpec( OntModelSpec.OWL_MEM );
		this.model = ModelFactory.createOntologyModel( s );
		
		//vamos a crear las clases y propiedades que necesitamos tener en el modelo
		OntClass thing = this.model.getOntClass("http://www.w3.org/2002/07/owl#Thing");
		OntClass voafVocab = this.model.createClass(voaf + "Vocabulary");
		OntProperty dcTitle = this.model.createOntProperty( dc + "title");
		OntProperty dcDescription = this.model.createOntProperty( dc + "description");
		AnnotationProperty vannPrefix = this.model.createAnnotationProperty(vann + "preferredNamespacePrefix");
		AnnotationProperty vannNs = this.model.createAnnotationProperty(vann + "preferredNamespaceUri");
		OntClass omvDomain = this.model.createClass(omv + "OntologyDomain"); 
		ObjectProperty omvHasDomain = this.model.createObjectProperty(omv + "hasDomain");
		OntProperty dcIssued = this.model.createOntProperty( dc + "issued");
		OntProperty dcModified = this.model.createOntProperty( dc + "modified");
		OntProperty foafHomepage = this.model.createOntProperty( foaf + "homepage");

		//contact person
		//publiser
		
		//crear la clase licencia de cc, ontology syntax y ontology language de omv
		OntProperty ccLicense = this.model.createOntProperty(cc + "license");
		ObjectProperty omvHasOntologySyntax = this.model.createObjectProperty(omv + "hasOntologySyntax");
		ObjectProperty omvHasOntologyLanguage = this.model.createObjectProperty(omv + "hasOntologyLanguage");
		OntProperty dcLanguage = this.model.createOntProperty( dc + "language");
		
		//vamos a crear las instancias de lenguajes, sintaxis y licencias que necesitemos
		
		//syntax
		Individual indRDFXML = this.model.createIndividual("http://dbpedia.org/resource/RDF/XML", thing);
		indRDFXML.addLabel(this.model.createTypedLiteral(new String("RDF/XML")));
		indRDFXML.setPropertyValue(foafHomepage, this.model.createIndividual("http://www.w3.org/TR/rdf-syntax-grammar/", thing));
		
		Individual indTTL = this.model.createIndividual("http://dbpedia.org/resource/Turtle_(syntax)", thing);
		indTTL.addLabel(this.model.createTypedLiteral(new String("Turtle")));
		indTTL.setPropertyValue(foafHomepage, this.model.createIndividual("http://www.w3.org/TR/2014/REC-turtle-20140225/", thing));
		
		Individual indN3 = this.model.createIndividual("http://dbpedia.org/resource/Notation3", thing);
		indN3.addLabel(this.model.createTypedLiteral(new String("N3")));
		indN3.setPropertyValue(foafHomepage, this.model.createIndividual("http://www.w3.org/TeamSubmission/n3/", thing));
		
		Individual indNtriples = this.model.createIndividual("http://dbpedia.org/resource/N-Triples", thing);
		indNtriples.addLabel(this.model.createTypedLiteral(new String("N-Triples")));
		indNtriples.setPropertyValue(foafHomepage, this.model.createIndividual("http://www.w3.org/2001/sw/RDFCore/ntriples/", thing));
		
		Individual indTriX = this.model.createIndividual("http://dbpedia.org/resource/TriX_(syntax)", thing);
		indTriX.addLabel(this.model.createTypedLiteral(new String("TriX")));
		indTriX.setPropertyValue(foafHomepage, this.model.createIndividual("http://www.w3.org/2004/03/trix/", thing));

		Individual indTriG = this.model.createIndividual("http://dbpedia.org/resource/TriG_(syntax)", thing);
		indTriG.addLabel(this.model.createTypedLiteral(new String("TriG")));
		indTriG.setPropertyValue(foafHomepage, this.model.createIndividual("http://www.w3.org/TR/trig/", thing));
		
		//ontology languages
		Individual indOWL = this.model.createIndividual("http://dbpedia.org/resource/Web_Ontology_Language", thing);
		indOWL.addLabel(this.model.createTypedLiteral(new String("OWL")));
		indOWL.setPropertyValue(foafHomepage, this.model.createIndividual("http://www.w3.org/TR/owl-ref/", thing));
		Individual indRDFS = this.model.createIndividual("http://dbpedia.org/resource/RDF_Schema", thing);
		indRDFS.addLabel(this.model.createTypedLiteral(new String("RDF-S")));
		indRDFS.setPropertyValue(foafHomepage, this.model.createIndividual("http://www.w3.org/TR/rdf-schema/", thing));
		Individual indSKOS = this.model.createIndividual("http://dbpedia.org/resource/Simple_Knowledge_Organization_System", thing);
		indSKOS.addLabel(this.model.createTypedLiteral(new String("SKOS")));
		indSKOS.setPropertyValue(foafHomepage, this.model.createIndividual("http://www.w3.org/TR/skos-primer/", thing));

		//licenses
		Individual indCC010 = this.model.createIndividual("http://creativecommons.org/publicdomain/zero/1.0/", thing);
		indCC010.addLabel(this.model.createTypedLiteral(new String("CC0")));
		indCC010.addComment(this.model.createTypedLiteral(new String("CC0 1.0 Universal")));
		
		Individual indCCBY40 = this.model.createIndividual("http://creativecommons.org/licenses/by/4.0/", thing);
		indCCBY40.addLabel(this.model.createTypedLiteral(new String("CC-BY 4.0")));		
		indCCBY40.addComment(this.model.createTypedLiteral(new String("CC-BY Creative Commons Attribution International")));		
		Individual indCCBY30 = this.model.createIndividual("http://creativecommons.org/licenses/by/3.0/", thing);
		indCCBY30.addLabel(this.model.createTypedLiteral(new String("CC-BY 3.0")));
		indCCBY30.addComment(this.model.createTypedLiteral(new String("CC-BY Creative Commons Attribution Unported")));
		
		Individual indCCBYSA40 = this.model.createIndividual("http://creativecommons.org/licenses/by-sa/4.0/", thing);
		indCCBYSA40.addLabel(this.model.createTypedLiteral(new String("CC-BY-SA 4.0")));
		indCCBYSA40.addComment(this.model.createTypedLiteral(new String("CC-BY-SA Creative Commons Attribution-ShareAlike International")));
		Individual indCCBYSA30 = this.model.createIndividual("http://creativecommons.org/licenses/by-sa/3.0/", thing);
		indCCBYSA30.addLabel(this.model.createTypedLiteral(new String("CC-BY-SA 3.0")));
		indCCBYSA30.addComment(this.model.createTypedLiteral(new String("CC-BY-SA Creative Commons Attribution-ShareAlike Unported")));
		
		Individual indCCBYND40 = this.model.createIndividual("http://creativecommons.org/licenses/by-nd/4.0/", thing);
		indCCBYND40.addLabel(this.model.createTypedLiteral(new String("CC-BY-ND 4.0")));
		indCCBYND40.addComment(this.model.createTypedLiteral(new String("CC-BY-ND CreativeCommons Attribution-NoDerivs International")));
		Individual indCCBYND30 = this.model.createIndividual("http://creativecommons.org/licenses/by-nd/3.0/", thing);
		indCCBYND30.addLabel(this.model.createTypedLiteral(new String("CC-BY-ND 3.0")));
		indCCBYND30.addComment(this.model.createTypedLiteral(new String("CC-BY-ND CreativeCommons Attribution-NoDerivs Unported")));
		
		Individual indCCBYNC40 = this.model.createIndividual("http://creativecommons.org/licenses/by-nc/4.0/", thing);
		indCCBYNC40.addLabel(this.model.createTypedLiteral(new String("CC-BY-NC 4.0")));	
		indCCBYNC40.addComment(this.model.createTypedLiteral(new String("CC-BY-NC CreativeCommons Attribution-NonCommercial International")));	
		Individual indCCBYNC30 = this.model.createIndividual("http://creativecommons.org/licenses/by-nc/3.0/", thing);
		indCCBYNC30.addLabel(this.model.createTypedLiteral(new String("CC-BY-NC 3.0")));
		indCCBYNC30.addComment(this.model.createTypedLiteral(new String("CC-BY-NC CreativeCommons Attribution-NonCommercial Unported")));
		
		Individual indCCBYNCSA40 = this.model.createIndividual("http://creativecommons.org/licenses/by-nc-sa/4.0/", thing);
		indCCBYNCSA40.addLabel(this.model.createTypedLiteral(new String("CC-BY-NC-SA 4.0")));	
		indCCBYNCSA40.addComment(this.model.createTypedLiteral(new String("CC-BY-NC-SA Creative Commons Attribution-NonCommercial-ShareAlike International")));	
		Individual indCCBYNCSA30 = this.model.createIndividual("http://creativecommons.org/licenses/by-nc-sa/3.0/", thing);
		indCCBYNCSA30.addLabel(this.model.createTypedLiteral(new String("CC-BY-NC-SA 3.0")));	
		indCCBYNCSA30.addComment(this.model.createTypedLiteral(new String("CC-BY-NC-SA Creative Commons Attribution-NonCommercial-ShareAlike Unported")));	
		
		Individual indCCBYNCND40 = this.model.createIndividual("http://creativecommons.org/licenses/by-nc-nd/4.0/", thing);
		indCCBYNCND40.addLabel(this.model.createTypedLiteral(new String("CC-BY-NC-ND 4.0")));	
		indCCBYNCND40.addComment(this.model.createTypedLiteral(new String("CC-BY-NC-ND Creative Commons Attribution-NonCommercial-NoDerivs International")));	
		Individual indCCBYNCND30 = this.model.createIndividual("http://creativecommons.org/licenses/by-nc-nd/3.0/", thing);
		indCCBYNCND30.addLabel(this.model.createTypedLiteral(new String("CC-BY-NC-ND 3.0")));	
		indCCBYNCND30.addComment(this.model.createTypedLiteral(new String("CC-BY-NC-ND Creative Commons Attribution-NonCommercial-NoDerivs Unported")));	
		
		Individual indGFDL = this.model.createIndividual("http://www.gnu.org/copyleft/fdl.html", thing); 
		indGFDL.addLabel(this.model.createTypedLiteral(new String("GFDL")));
		indGFDL.addComment(this.model.createTypedLiteral(new String("GNU Free Documentation License (GFDL)")));
		
		Individual indPDDL = this.model.createIndividual("http://www.opendatacommons.org/licenses/pddl/", thing); 
		indPDDL.addLabel(this.model.createTypedLiteral(new String("PDDL")));
		indPDDL.addComment(this.model.createTypedLiteral(new String("Public Domain Dedication and License � Public Domain for data/databases")));
		
		Individual  indODCby = this.model.createIndividual("http://www.opendatacommons.org/licenses/by/", thing); 
		indODCby.addLabel(this.model.createTypedLiteral(new String("ODC-By")));
		indODCby.addComment(this.model.createTypedLiteral(new String("Open Data Commons Attribution (ODC-By) � Attribution for data/databases")));
		
		Individual indODBL = this.model.createIndividual("http://www.opendatacommons.org/licenses/odbl/", thing); 
		indODBL.addLabel(this.model.createTypedLiteral(new String("ODBL")));
		indODBL.addComment(this.model.createTypedLiteral(new String("ODBL: Open Database License (ODC-ODbL) � Attribution Share-Alike for data/databases")));
		
		Individual indARR = this.model.createIndividual("http://dbpedia.org/resource/All_rights_reserved", thing); 
		indARR.addLabel(this.model.createTypedLiteral(new String("All rights reserve")));
		
		Individual indMIT = this.model.createIndividual("http://dbpedia.org/resource/MIT_License", thing);
		indMIT.addLabel(this.model.createTypedLiteral(new String("MIT")));
		indMIT.addComment(this.model.createTypedLiteral(new String("The MIT License")));
		
		
		Individual indW3C = this.model.createIndividual("http://dbpedia.org/resource/W3C_Software_Notice_and_License", thing);
		indW3C.addLabel(this.model.createTypedLiteral(new String("W3C")));
		
		 for (int i = 0;i<ontologies.size();i++){
			 
			 Ontology currentOntology = ontologies.get(i);
	            			 
			//URI
			 String uri = currentOntology.getUri();
			 Individual indOnto = this.model.createIndividual( uri, voafVocab );
			 
			 outputLog.println(i + ") Analizing ontology: " + uri);
//			 System.out.println(i + ") Analizing ontology: " + uri);
			
			//title
			 Literal title = this.model.createTypedLiteral(new String(currentOntology.getTitle()));
			 if (title!=null && !title.equals("")){
				 indOnto.addProperty(dcTitle, title);
				 indOnto.addLabel(title);
			 }
			 
			// prefix
			 String prefix = currentOntology.getPrefix();
			 if(prefix!=null && !prefix.equals("")){
				 Literal prefixL = this.model.createTypedLiteral(new String(prefix));
				 indOnto.addProperty(vannPrefix, prefixL);
			 }
			
			// namespace
			 String namespace = currentOntology.getNamespace();
			 if(namespace!=null && !namespace.equals("")){
				 Literal namespaceL = this.model.createTypedLiteral(new String(namespace));
				 indOnto.addProperty(vannNs, namespaceL);
			 }
				
			// description
			 String description = currentOntology.getDescription();
			 if(description!=null && !description.equals("")){
				 Literal descriptionL = this.model.createTypedLiteral(new String(description));
				 indOnto.addProperty(dcDescription, descriptionL);				
			 }
				
			// Domains 
			 ArrayList<String> domains = currentOntology.getDomains();
			 
			 for (int j = 0; j<domains.size(); j++){
				 //hay que decidir de que clases son los domains
				 String term = domains.get(j);
//				 System.out.println("Try with term: "+ term);
				 EnglishGrounder grounder = new EnglishGrounder();
				 GroundingTerm groundingTerm = grounder.getFirstGrounding(term, domains);
				 
//				 GroundingTerm groundingTermNC = grounder.getFirstGrounding(term);
				 
				 if (groundingTerm != null){
					 String resultURI = groundingTerm.getURI();
					 String resultLabel = groundingTerm.getLabel();
//					 System.out.println("The first grounding in the list is: "+ resultURI);
					 
					//link to dbpedia
					 Individual indDomain = this.model.createIndividual(resultURI, omvDomain);
//					 Individual indDomain = this.model.createIndividual(energy + domains.get(j), omvDomain);
					 indOnto.addProperty(omvHasDomain, indDomain);
					 //indDomain.addLabel(this.model.createTypedLiteral(new String(resultLabel)));
					 indDomain.addLabel(this.model.createTypedLiteral(new String(term.toLowerCase())));
					 
//					 //mostrar los groundings
//					 if (groundingTermNC != null){
//						 String resultURINC = groundingTermNC.getURI();
//						 String resultLabelNC = groundingTermNC.getLabel();
////						 System.out.println("The first grounding in the list is: "+ resultURI);
//						 
////						 groundingLog.println(term + ", " + resultLabel + ", " +  resultURI + ", "+ resultLabelNC + ", " +  resultURINC + ", " + uri);
//						 
//					 }
//					 else{
////						 groundingLog.println(term + ", " + resultLabel + ", " +  resultURI + ", - , - , " + uri); 
//					 }
					 
				 }
				 else{
					 // create a new individual
					//mejorar estas uris.
//					 System.out.println("NO GROUNDING FOR: "+ term);
					 String urlDomain = energyResource + URLEncoder.encode(term, "UTF-8").replace("+","%20");
					 Individual indDomain = this.model.createIndividual(urlDomain, omvDomain);
//					 Individual indDomain = this.model.createIndividual(energy + domains.get(j), omvDomain);
					 indOnto.addProperty(omvHasDomain, indDomain);
					 indDomain.addLabel(this.model.createTypedLiteral(new String(term.toLowerCase())));
				 }
				 
			 }
				
			// Version 
			 String version = currentOntology.getVersion();
			 if(version!=null && !version.equals("")){
				 indOnto.addVersionInfo(version);
			 }
			 
			// Creation date 
			 String issued = currentOntology.getCreationDate();	
			 if(issued!=null && issued.length() > 9){
				 //year month date
				 String date = Integer.parseInt(issued.split("/")[2]) + "-" +
						 		Integer.parseInt(issued.split("/")[1]) + "-" + 
						 		Integer.parseInt(issued.split("/")[0]);
				 Literal issuedL = this.model.createTypedLiteral(date, XSDDatatype.XSDdate);
				 indOnto.addProperty(dcIssued, issuedL);
			 }
				
			// Last update,
			 String modified = currentOntology.getLastUpdate();
			 if(modified!=null && modified.length() > 9){
				 //year month date
				 String date = Integer.parseInt(modified.split("/")[2]) + "-" +
					 		Integer.parseInt(modified.split("/")[1]) + "-" + 
					 		Integer.parseInt(modified.split("/")[0]);				 
				 Literal modifiedL = this.model.createTypedLiteral(date, XSDDatatype.XSDdate);
				 indOnto.addProperty(dcModified, modifiedL);
			 }
				
			//Contact person 
				
			// Publisher
				
			// Licenses
			 ArrayList<String> licenses = currentOntology.getLicenses();
			 
			 for (int j = 0; j<licenses.size(); j++){
				 //hay que decidir de que clases son los domains
				 String license = licenses.get(j);
				 
				 if (license.contains("CC0 1.0 Universal")){
					 indOnto.addProperty(ccLicense, indCC010);
				 }
				 else if (license.contains("CC-BY Creative Commons Attribution International")){
					 indOnto.addProperty(ccLicense, indCCBY40);
				 }
				 else if (license.contains("CC-BY Creative Commons Attribution Unported")){
					 indOnto.addProperty(ccLicense, indCCBY30);
				 }
				 else if (license.contains("CC-BY-SA Creative Commons Attribution-ShareAlike International")){
					 indOnto.addProperty(ccLicense, indCCBYSA40);
				 }
				 else if (license.contains("CC-BY-SA Creative Commons Attribution-ShareAlike Unported")){
					 indOnto.addProperty(ccLicense, indCCBYSA30);
				 }
				 else if (license.contains("CC-BY-ND CreativeCommons Attribution-NoDerivs International")){
					 indOnto.addProperty(ccLicense, indCCBYND40);
				 }
				 else if (license.contains("CC-BY-ND CreativeCommons Attribution-NoDerivs Unported")){
					 indOnto.addProperty(ccLicense, indCCBYND30);
				 }
				 else if (license.contains("CC-BY-NC CreativeCommons Attribution-NonCommercial International")){
					 indOnto.addProperty(ccLicense, indCCBYNC40);
				 }
				 else if (license.contains("CC-BY-NC CreativeCommons Attribution-NonCommercial Unported")){
					 indOnto.addProperty(ccLicense, indCCBYNC30);
				 }
				 else if (license.contains("CC-BY-NC-SA Creative Commons Attribution-NonCommercial-ShareAlike International")){
					 indOnto.addProperty(ccLicense, indCCBYNCSA40);
				 }
				 else if (license.contains("CC-BY-NC-SA Creative Commons Attribution-NonCommercial-ShareAlike Unported")){
					 indOnto.addProperty(ccLicense, indCCBYNCSA30);
				 }
				 else if (license.contains("CC-BY-NC-ND Creative Commons Attribution-NonCommercial-NoDerivs International")){
					 indOnto.addProperty(ccLicense, indCCBYNCND40);
				 }
				 else if (license.contains("CC-BY-NC-ND Creative Commons Attribution-NonCommercial-NoDerivs Unported")){
					 indOnto.addProperty(ccLicense, indCCBYNCND30);
				 }
				 else if (license.contains("GNU Free Documentation License (GFDL)")){
					 indOnto.addProperty(ccLicense, indGFDL);
				 }
				 else if (license.contains("PDDL: Public Domain Dedication and License (PDDL)")){
					 indOnto.addProperty(ccLicense, indPDDL);
				 }
				 else if (license.contains("ODC-By: Open Data Commons Attribution (ODC-By) - “Attribution for data/databases”")){
					 indOnto.addProperty(ccLicense, indODCby);
				 }
				 else if (license.contains("ODBL: Open Database License (ODC-ODbL) - “Attribution Share-Alike for data/databases”")){
					 indOnto.addProperty(ccLicense, indODBL);
				 }
				 else if (license.contains("All rights reserved / no license")){
					 indOnto.addProperty(ccLicense, indARR);
				 }
				 else if (license.contains("MIT")){
					 indOnto.addProperty(ccLicense, indMIT);
				 }
				 else if (license.contains("W3C")){
					 indOnto.addProperty(ccLicense, indW3C);
				 }
				 else if (license.contains("Unknown")){
					 //
				 }
				 else{
					 //new license --> avisar e incluir email? log?
					 outputLog.println("\t New LICENCSE: " + license);
				 }
				 
			 }
				
			// Format 
			 ArrayList<String> formats = currentOntology.getFormats();
			 
			 for (int j = 0; j<formats.size(); j++){
				 //hay que decidir de que clases son los domains
				 String format = formats.get(j);
				 
				 if (format.contains("RDF/XML")){
					 indOnto.addProperty(omvHasOntologySyntax, indRDFXML);
				 }
				 else if (format.contains("Turtle")){
					 indOnto.addProperty(omvHasOntologySyntax, indTTL);
				 }
				 else if (format.contains("N3")){
					 indOnto.addProperty(omvHasOntologySyntax, indN3);
				 }
				 else if (format.contains("N-Triples")){
					 indOnto.addProperty(omvHasOntologySyntax, indNtriples);
				 }
				 else if (format.contains("TriX")){
					 indOnto.addProperty(omvHasOntologySyntax, indTriX);
				 }
				 else if (format.contains("TriG")){
					 indOnto.addProperty(omvHasOntologySyntax, indTriG);
				 }
				 else{
					//new format --> avisar e incluir email? log?
					 outputLog.println("\t New FORMAT: " + format);
				 }
			 }
			 
				
			// Ontology language 
			 ArrayList<String> ontoLanguages = currentOntology.getOntLanguages();
			 
			 for (int j = 0; j<ontoLanguages.size(); j++){
				 //hay que decidir de que clases son los domains
				 String ontoLanguage = ontoLanguages.get(j);
				 
				 if (ontoLanguage.contains("OWL")){
					 indOnto.addProperty(omvHasOntologyLanguage, indOWL);
				 }
				 else if (ontoLanguage.contains("RDF-S")){
					 indOnto.addProperty(omvHasOntologyLanguage, indRDFS);
				 }
				 else if (ontoLanguage.contains("SKOS")){
					 indOnto.addProperty(omvHasOntologyLanguage, indSKOS);
				 }
				 else{
					//new license --> avisar e incluir email? log?
					 outputLog.println("\t New ONT LANGUAGE: " + ontoLanguage);
				 }
			 }
			 
			// Language
			 HashMap <String, String> mapLang = new Languages().getMapLang();
			 
			 ArrayList<String> languages = currentOntology.getLanguages();
			 
			 for (int j = 0; j<languages.size(); j++){
				 //hay que decidir de que clases son los domains
				 String language = languages.get(j);
				 if (!language.contentEquals("") && !language.contains("unknown")){
					 if (mapLang.containsKey(language.substring(0, 2))){
						 indOnto.addProperty(dcLanguage, this.model.createIndividual(mapLang.get(language.substring(0, 2)), thing));
					 }
					 else{
						//no se reconoce el lenguaje --> avisar e incluir email? log?
						 outputLog.println("\t NATURAL LANGUAGE not recognize: " + language);
					 }
				 }
				 
			 }
			 			 
		 }
		
	}

	public void write (FileOutputStream outputRDF){
		
		this.model.write(outputRDF, "TURTLE", "http://smartcity.linkeddata.es/ontology#");
//		this.model.write(outputRDF, "RDF/XML", "http://smartcity.linkeddata.es/ontology#");
	}
	
	public OntModel getModel() {
		return this.model;
	}
}
