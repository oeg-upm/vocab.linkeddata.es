package parseVocabs;

import java.util.List;

import net.sf.vapour.api.Format;
import net.sf.vapour.api.VapourApi;
import net.sf.vapour.api.VapourApiFactory;
import net.sf.vapour.api.VapourReport;
import net.sf.vapour.api.VapourTest;


import com.hp.hpl.jena.rdf.model.Model;

public class Vocabulary {
	
	public String uri = null;
	
	public String title = null;
	public String description = null;
		
	public String vannPrefix = null;
	public String vannNS = null;
		
	public boolean cnRDF = false;
	public boolean cnHTML = false;
	
	public String uriVapourRDF= null;
	public String uriVapourHTML= null;
	
	public String uriUsedRDF = null;
	public String uriUsedHTML = null;
	
	public String contentTypeRDF = null;
	public String contentTypeHTML = null;
	
	public boolean vapourExc = false;
	public boolean jenaModelExc = false;
	
	//when loading the onto as and RDF model
	public Model modelRDF;

	public int ontoClasses = 0;
	public int ontoProperties = 0;
	public int ontoAttributes = 0;
	
	//bad points
	public boolean fileExtension = false;
	
	public boolean askingRDF = false;
	public boolean askingHTML = false;
	public boolean notAvailable = false;
		
	public Vocabulary(String uri) {
		// TODO Auto-generated constructor stub
				
		this.uri = uri;
		
        try {
        	
        	VapourApi vapourApi = VapourApiFactory.createVapourApi();
	        VapourReport report = vapourApi.check(this.uri, false, true, Format.RDFXML);
	        
	        List <VapourTest> tests = report.getTests();
	        
	        this.uriVapourRDF = tests.get(1).getFinalUri();
	        this.contentTypeRDF = tests.get(1).getFinalContentType();
	        this.cnRDF = tests.get(1).isSucess();
	        
	        if(!this.cnRDF && this.uri.contains("http://purl.org/") ){
//	        	System.err.println("RDF test purl");
	        	TestVapour testVapourRDF = new TestVapour(tests.get(1), "RDF");
	        	this.cnRDF = testVapourRDF.getCnPURL();
	        }
	        
	        if (this.uriVapourRDF == null){
//	        	System.err.println("La uri RDF devuelta por Vapour es null");
	        	this.uriUsedRDF = new FollowRedirectRDF(uri).getNewUrl();
	        }
	        else{
	        	this.uriUsedRDF = this.uriVapourRDF;
	        }
	        
	        this.uriVapourHTML = tests.get(2).getFinalUri();
	        this.cnHTML = tests.get(2).isSucess();
	        
	        if(!this.cnHTML && this.uri.contains("http://purl.org/")){
//	        	System.err.println("HTML test purl");
	        	TestVapour testVapourHTML = new TestVapour(tests.get(2), "HTML");
	        	this.cnHTML = testVapourHTML.getCnPURL();
	        }
	        
	        if (this.uriVapourHTML == null){
//	        	System.err.println("La uri html devuelta por Vapour es null");
	        	this.uriUsedHTML = uri;
	        }
	        else{
	        	this.uriUsedHTML = this.uriVapourHTML;
	        }
	        
        }
        catch (java.lang.NullPointerException b){
        	System.err.println("Exception NullPointerException EN : " + uri + " conectando con Vapour ");
        	this.uriUsedRDF = new FollowRedirectRDF(uri).getNewUrl();
        	this.uriUsedHTML = uri;
        	this.vapourExc = true;
        	
        }
        catch (java.lang.RuntimeException c){
        	System.err.println("Exception RuntimeException EN: " + uri + " conectando con Vapour");
        	this.uriUsedRDF = new FollowRedirectRDF(uri).getNewUrl();
        	this.uriUsedHTML = uri;
        	this.vapourExc = true;
        }
        catch (java.lang.Exception d){
        	System.err.println("Exception generica EN: " + uri + " conectando con Vapour");
        	this.uriUsedRDF = new FollowRedirectRDF(uri).getNewUrl();
        	this.uriUsedHTML = uri;
        	this.vapourExc = true;
        }
        finally{
        	
//        	// loading as owl ontology
//	        LoadOnto loadOnto = new LoadOnto(this.uriUsedRDF, contentTypeRDF);
//	        this.elementsOnto = loadOnto.getElements();
//	        this.jenaOntoExc = loadOnto.getJenaExc();
//	        
//	        this.modelOnto = loadOnto.getModel();
//	        	
//	        VannMetadata vannOnto = new VannMetadata(this.modelOnto);
//	        
//	        this.vannPrefix = vannOnto.getVannPrefix();
//	        this.vannNS = vannOnto.getVannNS();
	        
	        
	        // loading as rdf model
	        LoadRDFModel loadModel = new LoadRDFModel(this.uriUsedRDF, contentTypeRDF);
//	        this.statementsModel = loadModel.getElements();
	        this.jenaModelExc = loadModel.getJenaExc();
	        
	        this.modelRDF = loadModel.getModel();
	        
	        MetadataByQuery metadataFromQuery = new MetadataByQuery(this.modelRDF);
	        
	        this.vannPrefix = metadataFromQuery.getVannPrefix();
	        this.vannNS = metadataFromQuery.getVannNS();
	        
	        String titleWithLang = metadataFromQuery.getTitle();
	        if (titleWithLang != null){
	        	if (titleWithLang.contains("@")){
	        	this.title = titleWithLang.substring(0, titleWithLang.lastIndexOf("@"));
		        }
		        else{
		        	this.title = titleWithLang.replace("^^http://www.w3.org/2000/01/rdf-schema#Literal", "");
		        	this.title = titleWithLang.replace("^^http://www.w3.org/2001/XMLSchema#string", "");
		        }
	        }
	        
	        String descriptionWithLang = metadataFromQuery.getDescription();
	        if (descriptionWithLang != null){
	        	 if (descriptionWithLang.contains("@")){
		        	this.description= descriptionWithLang.substring(0, descriptionWithLang.lastIndexOf("@"));
		        }
		        else{
		        	this.description = descriptionWithLang.replace("^^http://www.w3.org/2000/01/rdf-schema#Literal", "");
		        	this.title = titleWithLang.replace("^^http://www.w3.org/2001/XMLSchema#string", "");
		        }
	        	
	        }
	       	        
        	        		        
	        if (!this.jenaModelExc) {
	        	this.askingRDF = true;
	        	
	        }
	        else{ //if there was an error when loading the model
	        	this.askingRDF = false;
	        }
        	
        	AskForHTML askHTML = new AskForHTML(this.uriUsedHTML, this.vannPrefix);
        	this.askingHTML = askHTML.getTypeHTML();
        	
        }
        
        //calculating some bad points
        
        //file extension in uri
        this.fileExtension = new FileExtensionInURI(this.uri).hasFileExtension();
        
        // if there is no RDF nor HTML
        if (!this.askingRDF && !this.askingHTML){
        	this.notAvailable = true;
        }
        
	}
	
	public String printAll(){
		return this.uri + "\n" + this.title  + "\n" + this.description  + "\n" + this.cnHTML  + "\n" + this.cnRDF;
	}
	
	public String getPrefix (){
		return this.vannPrefix;
	}
	
	public String getNS (){
		return this.vannNS;
	}
	
	public String getTitle (){
		return this.title;
	}

	public String getDescription (){
		return this.description;
	}
}
