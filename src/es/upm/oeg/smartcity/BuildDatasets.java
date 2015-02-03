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

public class BuildDatasets {
	
	public ArrayList<Dataset> datasets =  new ArrayList<Dataset>();
	
	public BuildDatasets() {
		// TODO Auto-generated constructor stub

		//read csv
		BufferedReader in;
		
		try {
			
			/* Process data for ontologies*/
			in = new BufferedReader(new FileReader("/Users/oeg/Documents/workspace/smartcity.linkeddata.es/input/dataset/Dataset metadata (respuestas) - Respuestas de formulario.csv"));
			String str;
			int lineN = 0;
			while ((str = in.readLine()) != null) {
				
				if (lineN == 0){
					lineN++; //get rid of the headers
				}
				else{
					
					//pasar la linea al parser especializado que rellena los campos
					Dataset currentDataset = new Dataset(str);
					// mas adelante habr� que ver que las ontos no se repitan o si se complementan
					datasets.add(currentDataset);
				}
			}
			in.close();
			
			//create file for log
			Date d = new Date();
			String outputFileDate = new String (d.toString().replace(" ", "-").replace(":", "-"));			
			PrintStream outputLog = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("/Users/oeg/Documents/workspace/smartcity.linkeddata.es/output/log/dataset/log"+outputFileDate+".txt"))), true); 
			
			//generate RDF from the csv for ontologies
			RDFcontentData rdfContentData = new RDFcontentData(datasets, outputLog);
			outputLog.close();
						
			//create file to write the RDF 
//		    PrintStream outputRDF = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("/Users/oeg/Documents/workspace/energy.linkeddata.es/output/rdf/RDF"+outputFileDate+".owl"))), true); 
//			String owlFileName = "/Users/oeg/Documents/workspace/smartcity.linkeddata.es/output/web/rdf/dataset/RDF"+outputFileDate+".owl";
			String owlFileName = "/Users/oeg/Documents/workspace/smartcity.linkeddata.es/output/web/rdf/datasetRDF.ttl";
			FileOutputStream outputRDF =  new FileOutputStream(new File(owlFileName));
		    rdfContentData.write(outputRDF);
		    outputRDF.close();
						
			//generate site	for datasets
		    PrintStream outputHTMLData = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("/Users/oeg/Documents/workspace/smartcity.linkeddata.es/output/web/datasets/index.html"))), true); 
		    SiteDataCatalogue siteData = new SiteDataCatalogue (rdfContentData.getModel(),"rdf/datasetRDF.ttl", outputHTMLData);
		    outputHTMLData.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.err.println("End Datasets");

	}

}
