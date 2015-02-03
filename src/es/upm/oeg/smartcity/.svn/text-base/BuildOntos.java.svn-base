package es.upm.oeg.smartcity;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.hpl.jena.ontology.OntModel;

public class BuildOntos {
	
	public ArrayList<Ontology> ontologies =  new ArrayList<Ontology>();
	
	public OntModel model = null;
	
	public BuildOntos() {
		// TODO Auto-generated constructor stub

		//read csv
		BufferedReader in;
		
		try {
			
			/* Process data for ontologies*/
			in = new BufferedReader(new FileReader("/Users/oeg/Documents/workspace/smartcity.linkeddata.es/input/ontology/Ontology metadata (respuestas) - Respuestas de formulario.csv"));
			String str;
			int lineN = 0;
			while ((str = in.readLine()) != null) {
				
				if (lineN == 0){
					lineN++; //get rid of the headers
				}
				else{
					
					//pasar la linea al parser especializado que rellena los campos
					Ontology currentOnto = new Ontology(str);
					// mas adelante habr� que ver que las ontos no se repitan o si se complementan
					ontologies.add(currentOnto);
				}
			}
			in.close();
			
			//create file for log
			Date d = new Date();
			String outputFileDate = new String (d.toString().replace(" ", "-").replace(":", "-"));			
			PrintStream outputLog = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("/Users/oeg/Documents/workspace/smartcity.linkeddata.es/output/log/ontology/log"+outputFileDate+".txt"))), true); 
			
			//generate RDF from the csv for ontologies
			RDFcontentOntos rdfContentOntos = new RDFcontentOntos(ontologies, outputLog);
			outputLog.close();
						
			//create file to write the RDF 
//		    PrintStream outputRDF = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("/Users/oeg/Documents/workspace/energy.linkeddata.es/output/rdf/RDF"+outputFileDate+".owl"))), true); 
//		    String owlFileName = "/Users/oeg/Documents/workspace/smartcity.linkeddata.es/output/web/rdf/ontology/RDF"+outputFileDate+".owl";
		    String owlFileName = "/Users/oeg/Documents/workspace/smartcity.linkeddata.es/output/web/rdf/ontologyRDF.ttl";
			FileOutputStream outputRDF =  new FileOutputStream(new File(owlFileName));
		    rdfContentOntos.write(outputRDF);
		    outputRDF.close();
		    
		    this.model = rdfContentOntos.getModel();
				
		    //generate page for each ontology with evaluation
		    // should get back a relation between ontology URI and relative path HashMap
		    
		    //OntologyPages ontologyPages = new OntologyPages (rdfContentOntos.getModel());
		    
		    // devolver aqui el map de uris y urls para pasarselo a siteOnto

			//generate site	for ontologies
		    PrintStream outputHTMLOnto = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("/Users/oeg/Documents/workspace/smartcity.linkeddata.es/output/web/index.html"))), true); 
		    SiteOntoCatalogue siteOnto = new SiteOntoCatalogue (rdfContentOntos.getModel(), "rdf/ontologyRDF.ttl" , outputHTMLOnto);
		    outputHTMLOnto.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.err.println("End Ontologies");

	}
	
	public OntModel getModel() {
		return this.model;
	}

}
