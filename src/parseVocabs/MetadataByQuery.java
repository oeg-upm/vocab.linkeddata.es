package parseVocabs;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class MetadataByQuery {
	
	public boolean queryExc = false;
	public String vannPrefix = null;
	public String vannNS = null;
	public String title = null;
	public String description = null;
	
	public MetadataByQuery(Model model) {
//		System.err.println("     Load onto ");
//		System.out.println("     Load onto ");
        
        try {
    		
    		Queries q = new Queries();
    		
    	    Query queryMetadata = QueryFactory.create(Queries.prefixes + Queries.metadataOnto, Syntax.syntaxARQ);
    	            
	    	 // Execute the query and obtain results
	    	 QueryExecution qe = QueryExecutionFactory.create(queryMetadata, model);
	    	 ResultSet results = qe.execSelect();
	    	 
	    	 // Output query results	
//	    	 ResultSetFormatter.out(System.err, results, queryMetadata);
	    	 
	    	 int i = 0;
	    	 if(results.hasNext()){
		         	QuerySolution qs = results.next();
		         	
		         	RDFNode currentPrefix = qs.getLiteral("vocabPrefix");
		         	RDFNode currentNs = qs.getLiteral("prefNS");		         	
		         	RDFNode currentTitleTerms = qs.getLiteral("titleTerms");
		         	RDFNode currentDescriptionTerms = qs.getLiteral("descriptionTerms");
		         	RDFNode currentTitleElements = qs.getLiteral("titleElements");
		         	RDFNode currentDescriptionElements = qs.getLiteral("descriptionElements");
		         	
		         	
		         	
		         	if (currentPrefix != null){
			         	if (i == 0) {
			         		this.vannPrefix = qs.getLiteral("vocabPrefix").toString();
			         	}
			         	else{
			         		this.vannPrefix += " " + qs.getLiteral("vocabPrefix").toString();
			         	}
		         	}
		         	
		         	if (currentNs != null){
			         	if (i == 0) {
			         		this.vannNS = qs.getLiteral("prefNS").toString();
			         	}
			         	else{
			         		this.vannNS += " " + qs.getLiteral("prefNS").toString();
			         	}
		         	}		         	
		         	if (currentTitleTerms != null){
			         	if (i == 0) {
			         		this.title = qs.getLiteral("titleTerms").toString();
			         	}
			         	else{
			         		this.title += " " + qs.getLiteral("titleTerms").toString();
			         	}
		         	}
		         	if (currentDescriptionTerms != null){
			         	if (i == 0) {
			         		this.description = qs.getLiteral("descriptionTerms").toString();
			         	}
			         	else{
			         		this.description += " " + qs.getLiteral("descriptionTerms").toString();
			         	}
		         	}
		         	if (currentTitleElements != null){
			         	if (i == 0) {
			         		this.title = qs.getLiteral("titleElements").toString();
			         	}
			         	else{
			         		this.title += " " + qs.getLiteral("titleElements").toString();
			         	}
		         	}
		         	if (currentDescriptionElements != null){
			         	if (i == 0) {
			         		this.description = qs.getLiteral("descriptionElements").toString();
			         	}
			         	else{
			         		this.description += " " + qs.getLiteral("descriptionElements").toString();
			         	}
		         	}
		         	
		         	i++;         		
		     }
	    	 
	    	 // Important - free up resources used running the query
	    	 qe.close();
	    	 
        }
        catch (java.lang.Exception d){
        	System.err.println("exc query en MetadaByQuery: " + d.getMessage());
//        	System.out.println("exc query: " + d.getMessage());
        	this.queryExc = true;
        }

	}

	public boolean getQueryExc (){
		return this.queryExc;
	}
	
	public String getVannPrefix(){
		return this.vannPrefix;
	}
	
	public String getVannNS(){
		return this.vannNS;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getDescription (){
		return this.description;
	}
}
