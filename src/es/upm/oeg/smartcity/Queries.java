package es.upm.oeg.smartcity;

public class Queries {
	
	public static String LOVEndpoint = "http://lov.okfn.org/dataset/lov/sparql";
	
	public static String LOVAggEndpoint = "http://lov.okfn.org/endpoint/lov_aggregator";
	
	public static String prefixes = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
			"PREFIX xsd:<http://www.w3.org/2001/XMLSchema#>" +
			"PREFIX dcterms:<http://purl.org/dc/terms/>" +
			"PREFIX dcelements:<http://purl.org/dc/elements/1.1/>" +
			"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>" +
			"PREFIX owl:<http://www.w3.org/2002/07/owl#>" +
			"PREFIX skos:<http://www.w3.org/TR/skos-reference/#>" +
			"PREFIX foaf:<http://xmlns.com/foaf/0.1/>" +
			"PREFIX void:<http://rdfs.org/ns/void#>" +
			"PREFIX vann:<http://purl.org/vocab/vann/>" ;
			
	
	public static String vocabInLOV = "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
			"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>" +
			"PREFIX voaf:<http://purl.org/vocommons/voaf#>" +
			"PREFIX vann:<http://purl.org/vocab/vann/>" +
			"SELECT ?vocabURI ?vocabPrefix " +
			"WHERE{" +
			"?vocabURI a voaf:Vocabulary." +
			"?vocabURI vann:preferredNamespacePrefix ?vocabPrefix." +
			"FILTER regex(str(?vocabURI), \"";

}
