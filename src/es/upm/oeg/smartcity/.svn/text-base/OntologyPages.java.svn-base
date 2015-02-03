package es.upm.oeg.smartcity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.el.ELException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.FileManager;

public class OntologyPages {

	public OntologyPages(OntModel model) throws FileNotFoundException {
		// TODO Auto-generated constructor stub		

		Iterator<Individual> individualsOnto = model.listIndividuals(model.getResource("http://purl.org/vocommons/voaf#Vocabulary"));
		
		HTMLblocksOntoPage htmlBlocks = new HTMLblocksOntoPage(); 
		Languages allLanguages = new Languages();

		
		//comienza la tabla si hay al menos un elemento
		if (individualsOnto.hasNext()){
			
			while (individualsOnto.hasNext()){
				Individual currentInd= individualsOnto.next();	
				
				System.out.println("************"+currentInd.getURI());
				
				String ontURI = currentInd.getURI();
				String ontTitle = currentInd.getPropertyValue(model.getProperty("http://purl.org/dc/terms/title")).asLiteral().getString();
			    		
				String localURL = ontURI.replace("https://","").replace("http://","").replace("/", "").replace("#", "");;
				PrintStream html = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("/Users/oeg/Documents/workspace/smartcity.linkeddata.es/output/web/ontologies/"+ localURL +".html"))), true); 

				html.print(HTMLblocksOntoPage.header);
//				html.println("<h1>" + ontTitle + "</h1>");
				html.println("<h1> <a href=\"" + ontURI +"\" target=\"_blank\">"+ ontTitle + "</a></h1>");
				html.println("<br>");

				html.println("<dl class=\"dl-horizontal\">");
					html.println("<dt>Title</dt>");
					html.println("<dd><a href=\"" + ontURI + "\" target=\"_blank\">" + ontTitle + "</a></dd>");
					
					html.println("<dt>URI</dt>");
					html.println("<dd><a href=\"" + ontURI + "\" target=\"_blank\">" + ontURI + "</a></dd>");
					
				    String ontDescr = currentInd.getPropertyValue(model.getProperty("http://purl.org/dc/terms/description")).asLiteral().getString();
				    if (ontDescr != null){
				    	html.println("<dt>Description</dt>");
						html.println("<dd>" + ontDescr + "</dd>");
				    }
					
				  //License
					Iterator<RDFNode> licenses = currentInd.listPropertyValues(model.getProperty("http://creativecommons.org/ns#license"));
					if (licenses.hasNext()){
						html.println("<dt>License</dt>");
						html.println("<dd>");

						while(licenses.hasNext()){
							RDFNode license = licenses.next();
							if (license.canAs(Individual.class)){
								String licenseURI = license.asResource().getURI();
								String licenseLabel = license.as(Individual.class).getLabel(null);
								String licenseComment = license.as(Individual.class).getComment(null);

								if (licenseLabel.contains("(No Open)")){
									html.println("<a href=\"" + licenseURI + "\" target=\"_blank\">" + licenseLabel + "</a>");
								}
								else{
									html.println("<a href=\"" + licenseURI + "\" target=\"_blank\">" + licenseLabel + "</a>");
								}
								if(licenses.hasNext()){
									html.print(", ");
								}
							}
						}
						html.println("</dd>");
					}
//					else{
//						// boton gris, unknown
//						html.println("<span class=\"label label-default\">Unknown</span>"); 
//					}
				    
					//Languages
					Iterator<RDFNode> languages = currentInd.listPropertyValues(model.getProperty("http://purl.org/dc/terms/language"));
					if (languages.hasNext()){
						html.println("<dt>Languages</dt>");
						html.println("<dd>");
						
						while(languages.hasNext()){
							
							RDFNode language = languages.next();
							String languageURI = language.asResource().getURI();
							String languageCode = allLanguages.getKey(languageURI);
							String languageName = allLanguages.mapLangEnglish.get(languageCode);
							
							if (language.isURIResource()){
								html.print("<a href=\"" + languageURI + "\" target=\"_blank\">" + languageName + "</a>");
							}
							if(languages.hasNext()){
								html.print(", ");
							}
						}
						html.println("</dd>");
					}
//					else{
//						// boton gris, unknown
//						html.println("<span class=\"label label-default\">Unknown</span>"); 
//					}
					
					//ontology languages
					Iterator<RDFNode> languagesOnt = currentInd.listPropertyValues(model.getProperty("http://omv.ontoware.org/2005/05/ontology#hasOntologyLanguage"));
					if (languagesOnt.hasNext()){
						html.println("<dt>Ontology languages</dt>");
						html.println("<dd>");
						
						while(languagesOnt.hasNext()){
							
							RDFNode languageOnt = languagesOnt.next();
							if (languageOnt.canAs(Individual.class)){
								String languageOntURI = languageOnt.asResource().getURI();
								String languageOntLabel = languageOnt.as(Individual.class).getLabel(null);
								String languageOntHomePage = languageOnt.as(Individual.class).getPropertyValue(model.getProperty("http://xmlns.com/foaf/0.1/homepage")).toString();

								html.println("<a href=\"" + languageOntHomePage + "\" target=\"_blank\">" + languageOntLabel + "</a>");

								if(licenses.hasNext()){
									html.print(", ");
								}
							}
						}
						html.println("</dd>");
					}
					
					//formats
					Iterator<RDFNode> formatsOnt = currentInd.listPropertyValues(model.getProperty("http://omv.ontoware.org/2005/05/ontology#hasOntologySyntax"));
					if (formatsOnt.hasNext()){
						html.println("<dt>Ontology format</dt>");
						html.println("<dd>");
						
						while(formatsOnt.hasNext()){
							
							RDFNode formatOnt = formatsOnt.next();
							if (formatOnt.canAs(Individual.class)){
								String languageOntURI = formatOnt.asResource().getURI();
								String languageOntLabel = formatOnt.as(Individual.class).getLabel(null);
								String formatOntHomePage = formatOnt.as(Individual.class).getPropertyValue(model.getProperty("http://xmlns.com/foaf/0.1/homepage")).toString();

								html.println("<a href=\"" + formatOntHomePage + "\" target=\"_blank\">" + languageOntLabel + "</a>");

								if(licenses.hasNext()){
									html.print(", ");
								}
							}
						}
						html.println("</dd>");
					}
					
					//publisher
					
					
					// issued
					NodeIterator issueds = currentInd.listPropertyValues(model.getProperty("http://purl.org/dc/terms/issued"));
					if (issueds.hasNext()){
						RDFNode issued = issueds.next();
						String date = issued.asLiteral().getString();
						if (!date.equals("")){
							html.println("<dt>Issued</dt>");
							html.println("<dd>" + date + "</dd>");
						}
						
					}
					
					// modified
					NodeIterator modifieds = currentInd.listPropertyValues(model.getProperty("http://purl.org/dc/terms/modified"));
					if (modifieds.hasNext()){

						//while(modifieds.hasNext()){
							RDFNode modified = modifieds.next();
							String date = modified.asLiteral().getString();
							if (!date.equals("")){
								html.println("<dt>Last modified</dt>");
								html.println("<dd>" + date + "</dd>");
							}
//						}
					}
					
					// version
					NodeIterator versions = currentInd.listPropertyValues(model.getProperty("http://www.w3.org/2002/07/owl#versionInfo"));
					if (versions.hasNext()){

						//while(modifieds.hasNext()){
							String version = versions.next().asLiteral().getString();
							if (!version.equals("")){
								html.println("<dt>Version</dt>");
								html.println("<dd>" + version + "</dd>");
							}
//						}
					}
					
					//alignments
					URL alignmentURL;
					try {
						alignmentURL = new URL("http://al4sc.inrialpes.fr/html/listalignments?uri1=" + ontURI + "&uri2=all");
						HttpURLConnection conn = (HttpURLConnection) alignmentURL.openConnection();
						
						if (conn.getResponseCode() != 500) {
							html.println("<dt>Alignments</dt>");
							html.println();

							html.println("<dd> <a href=\"" + alignmentURL + "\" target=\"_blank\"> See alignments </a> </dd>");
						}
						else {
							System.out.println("no aligments for: " + alignmentURL);

						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				html.println("</dl>");

				//look if it is in LOV
	        	VocabInLOV isInLOV = new VocabInLOV(ontURI);
	        	if (isInLOV.isInLOV){
	        		String webpageInLOV = isInLOV.getLOVpage();
	        		String prefixInLOV = isInLOV.getPrefixInLOV();
	        		html.println("<p>See more information about this ontology in <a href=\"" + webpageInLOV + "\" target=\"_blank\"> Linked Open Vocabularies</a>.</p>");
	        	}
	        	
				//call OOPS web service for evaluation
				
				try {
//					System.out.println("Analizando: " + ontURI);
					OOPSevaluation evaluation = new OOPSevaluation(ontURI);

//					System.out.println(ontURI + ":  " + evaluation.printEvaluation());
					html.print(evaluation.printEvaluation());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("excepción en " + e.getClass());
					html.println("<h2>Evaluation results</h2>");
					html.println("<p>Something went wrong while evaluating this ontology.</p>");
					e.printStackTrace();
				}
				finally{
					html.print(HTMLblocksOntoPage.end);
					html.close();
				}

			}	
		}
	}
	
	public OntologyPages() throws FileNotFoundException {
		// TODO Auto-generated constructor stub		
		OntModelSpec s = new OntModelSpec( OntModelSpec.OWL_MEM );
		OntModel model = ModelFactory.createOntologyModel( s );		
		
		InputStream ontInputStream = FileManager.get().open("/Users/oeg/Documents/workspace/smartcity.linkeddata.es/input/ontology/RDFTest.ttl");
        if (ontInputStream == null) {
            System.out.println("No input file Found");
        } else {
            model.read(ontInputStream, "http://myonto.com", "TTL");
        }
		
		new OntologyPages(model);
	}
}
