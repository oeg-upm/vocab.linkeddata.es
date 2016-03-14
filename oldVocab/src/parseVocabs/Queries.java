package parseVocabs;

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
				
	
	public static String prefix = "SELECT ?vocabPrefix "+
			"WHERE{ ?s vann:preferredNamespacePrefix ?vocabPrefix.}";
	
	public static String metadataOnto = "SELECT ?vocabPrefix ?prefNS ?titleTerms ?descriptionTerms ?titleElements ?descriptionElements "+
			"WHERE{" +
			"OPTIONAL {?s vann:preferredNamespacePrefix ?vocabPrefix.}" +
			"OPTIONAL {?s vann:preferredNamespaceUri ?prefNS.}" +
			"OPTIONAL {?s dcterms:title ?titleTerms.}" +
			"OPTIONAL {?s dcterms:description ?descriptionTerms.}" +
			"OPTIONAL {?s dcelements:title ?titleElements.}" +
			"OPTIONAL {?s dcelements:description ?descriptionElements.}" +
			"}";
	
	public static String vocabInLOV = "SELECT ?vocabURI ?vocabPrefix { " +
			"GRAPH <http://lov.okfn.org/dataset/lov>{ " +
			"?vocabURI a <http://purl.org/vocommons/voaf#Vocabulary>." +
			"?vocabURI <http://purl.org/vocab/vann/preferredNamespacePrefix> ?vocabPrefix." +
			"FILTER regex(str(?vocabURI), \"";

}
