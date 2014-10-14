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
	public String description = "";
	
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
	    	 
	    	 if(results.hasNext()){ 
		         	QuerySolution qs = results.next();
		         	
		         	this.vannPrefix  += this.getValue("vocabPrefix", qs) + " ";
		         	this.vannNS  += this.getValue("prefNS", qs) + " ";	
		         	
		         	String titleT = null;
		         	titleT = this.getValue("titleTerms", qs);
		         	String titleE = null;
		         	titleE = this.getValue("titleElements", qs);
		         	
		         	if (titleT != null && !titleT.equals("")){
		         		this.title = titleT;
		         	}
		         	else if (titleE != null && !titleE.equals("")){
		         		this.title = titleE;
		         	}
		         	else{
		         		System.out.println ("que no hay title!!!!!!");
		         	}
		         	
		         	String descriptionT = null;
		         	descriptionT = this.getValueOnlyLiteral("descriptionTerms", qs);
		         	String descriptionE = null;
		         	descriptionE = this.getValueOnlyLiteral("descriptionElements", qs);
		         	
		         	if (descriptionT != null && !descriptionT.equals("")){
		         		this.description = descriptionT;
		         	}
		         	else if (descriptionE != null && !descriptionE.equals("")){
		         		this.description = descriptionE;
		         	}
		         	else{
		         		System.out.println ("que no hay description!!!!!!");
		         	}
		         	
		         	while (results.hasNext()){ // in case there is more than one description
			         	QuerySolution qs1 = results.next();
			         	this.description += " " + this.getValueOnlyLiteral("descriptionTerms", qs1);
			         	this.description += " " + this.getValueOnlyLiteral("descriptionElements", qs1);
		         	}
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
	
	private String getValue (String variable, QuerySolution qs){
		String value = "";
		
		try{
 			value = qs.getLiteral(variable).toString();
 		}catch(Exception e){
 			
 			try{
 				value = qs.getResource(variable).toString();
 			}
 			catch (Exception f){
 			}
 			
 		}
		
		return value;
	}
	
	private String getValueOnlyLiteral (String variable, QuerySolution qs){
		String value = "";
		
		try{
 			value = qs.getLiteral(variable).toString();
 		}catch(Exception e){
 			
 		}
		
		return value;
	}
}
