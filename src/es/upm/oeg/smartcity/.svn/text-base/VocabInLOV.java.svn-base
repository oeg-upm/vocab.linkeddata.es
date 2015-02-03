package es.upm.oeg.smartcity;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class VocabInLOV {
	
	public boolean queryExc = false;
	public boolean isInLOV = false;
	public String uriInLOV = null;
	public String prefixInLOV = null;
	
	public VocabInLOV(String uri) {
        
        try {
    		
    		Queries q = new Queries();
    		
    	    Query queryLOV = QueryFactory.create(Queries.vocabInLOV + uri + "\")}", Syntax.syntaxARQ);
    	            
	    	 // Execute the query and obtain results
	    	 QueryExecution qe = QueryExecutionFactory.sparqlService(Queries.LOVEndpoint, queryLOV);
	    	 ResultSet results = qe.execSelect();
	    	 
	    	 // Output query results	
//	    	 ResultSetFormatter.out(System.err, results, queryMetadata);
	    	 	
	    	 if(results.hasNext()){
	    		 
	    		 	isInLOV = true;
		         	QuerySolution qs = results.next();
		         	this.prefixInLOV = qs.getLiteral("vocabPrefix").toString();	
		         	this.uriInLOV = "http://lov.okfn.org/dataset/lov/details/vocabulary_"+ this.prefixInLOV +".html";

		     }
	    	 
	    	 // Important - free up resources used running the query
	    	 qe.close();
	    	 
        }
        catch (java.lang.Exception d){
        	System.err.println("exc query en VocabInLOV: " + d.getMessage());
//        	System.out.println("exc query: " + d.getMessage());
        	this.queryExc = true;
        }

	}

	public String getLOVpage (){
		return this.uriInLOV;
	}
	
	public String getPrefixInLOV (){
		return this.prefixInLOV;
	}

}
