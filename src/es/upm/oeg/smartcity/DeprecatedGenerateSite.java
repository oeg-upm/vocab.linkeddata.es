package es.upm.oeg.smartcity;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import net.sf.vapour.api.Format;
import net.sf.vapour.api.VapourApi;
import net.sf.vapour.api.VapourApiFactory;
import net.sf.vapour.api.VapourReport;
import net.sf.vapour.api.VapourTest;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class DeprecatedGenerateSite {
	
	public DeprecatedGenerateSite(OntModel model, PrintStream html) {
		// TODO Auto-generated constructor stub
		
		HTMLblocksOntos htmlBlocks = new HTMLblocksOntos();
		Languages allLanguages = new Languages();
		
		html.print(htmlBlocks.header);
	
		/* Print ontology catalogue */
		html.println("<h1>Ontologies  ");
		html.println("<small><a href=\"#\" title=\"RDF version\"> <img  width=\"25\" height=\"28\" border=\"0\" src=\"images/rdf_w3c_icon.48.gif\" alt=\"RDF Resource Description Framework Icon\"/></a></small>");
//		html.print("<small><a href=\"#\" title=\"RDF version\"> (RDF version of the data)</a></small>");
		html.println("</h1>");

		Iterator<Individual> individualsOnto = model.listIndividuals(model.getResource("http://purl.org/vocommons/voaf#Vocabulary"));
		
		//comienza la tabla si hay al menos un elemento
		if (individualsOnto.hasNext()){
			
			html.println("<table class=\"table table-hover\">");
			html.println("<thead>");
				html.println("<tr>");
					html.println("<th>Ontology</th>");
					html.println("<th>Online Availability</th>");
					html.println("<th>Open License</th>");
					html.println("<th>Ontology Language</th>");
					html.println("<th>Syntax</th>");
					html.println("<th>Domain</th>");
					html.println("<th>Natural Language</th>");
				html.println("</tr>");
			html.println("</thead>");
			
			html.println("<body>");
			
			//relleno la tabla
			while (individualsOnto.hasNext()){
				Individual currentInd= individualsOnto.next();
				html.println("<tr>"); 
				
					String ontURI = currentInd.getURI();
					String ontTitle = currentInd.getPropertyValue(model.getProperty("http://purl.org/dc/terms/title")).toString();
					html.println("<td><a href = \"" + ontURI + "\" target=\"_blank\">" + ontTitle + "</a></td>");
				
					//Availbe online
					html.println("<td>");
					boolean cnRDF = false;
					boolean cnHTML = false;
					boolean vapourExc = false;
					String uriVapourRDF= null;
					String uriVapourHTML= null;
					String contentTypeRDF = null;
					String contentTypeHTML = null;
					
					try {
						VapourApi vapourApi = VapourApiFactory.createVapourApi();
						VapourReport report = vapourApi.check(ontURI, false, true, Format.RDFXML);
				        
				        List <VapourTest> tests = report.getTests();
				        
				        uriVapourRDF = tests.get(1).getFinalUri();
				        contentTypeRDF = tests.get(1).getFinalContentType();
				        cnRDF = tests.get(1).isSucess();
				        
				        if(!cnRDF && ontURI.contains("http://purl.org/") ){
//				        	System.err.println("RDF test purl");
				        	TestVapour testVapourRDF = new TestVapour(tests.get(1), "RDF");
				        	cnRDF = testVapourRDF.getCnPURL();
				        }
				        
				        uriVapourHTML = tests.get(2).getFinalUri();
				        contentTypeHTML = tests.get(2).getFinalContentType();
				        cnHTML = tests.get(2).isSucess();
				        
				        if(!cnHTML && ontURI.contains("http://purl.org/") ){
//				        	System.err.println("HTML test purl");
				        	TestVapour testVapourHTML = new TestVapour(tests.get(2), "HTML");
				        	cnHTML = testVapourHTML.getCnPURL();
				        }
					}
					
					catch (java.lang.NullPointerException b){
			        	System.err.println("Exception NullPointerException EN : " + ontURI + " conectando con Vapour ");
			        	vapourExc = true;
			        	
			        }
			        catch (java.lang.RuntimeException c){
			        	System.err.println("Exception RuntimeException EN: " + ontURI + " conectando con Vapour");
			        	vapourExc = true;
			        }
			        catch (java.lang.Exception d){
			        	System.err.println("Exception generica EN: " + ontURI + " conectando con Vapour");
			        	vapourExc = true;
			        }
					finally{
						if (vapourExc) {
							html.println("<span class=\"label label-default\">Unknown</span>");
						}
						else if (cnRDF && cnHTML){
							html.println("<a href=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" target=\"_blank\"><span class=\"label label-success\">RDF</span></a>");
							html.println("<a href=\"http://dbpedia.org/resource/HTML\" target=\"_blank\"><span class=\"label label-success\">HTML</span></a>");
						}
						else if (cnRDF && !cnHTML){
							html.println("<a href=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" target=\"_blank\"><span class=\"label label-warning\">RDF</span></a>");
						}
						else if(!cnRDF && cnHTML){
							html.println("<a href=\"http://dbpedia.org/resource/HTML\" target=\"_blank\"><span class=\"label label-warning\">HTML</span></a>");
						}
						else{
							html.println("<span class=\"label label-danger\">No</span>");
						}
					}
					
					html.println("</td>");
					
					//License
					html.println("<td>");
					Iterator<RDFNode> licenses = currentInd.listPropertyValues(model.getProperty("http://creativecommons.org/ns#license"));
					if (licenses.hasNext()){
						while(licenses.hasNext()){
							RDFNode license = licenses.next();
							if (license.canAs(Individual.class)){
								String licenseURI = license.asResource().getURI();
								String licenseLabel = license.as(Individual.class).getLabel(null);
								if (licenseLabel.contains("(No Open)")){
									html.println("<a href=\"" + licenseURI + "\" target=\"_blank\"><span class=\"label label-warning\">" + licenseLabel + "</span></a>");
								}
								else{
									html.println("<a href=\"" + licenseURI + "\" target=\"_blank\"><span class=\"label label-success\">" + licenseLabel + "</span></a>");
								}
							}
						}
					}
					else{
						// boton gris, unknown
						html.println("<span class=\"label label-default\">Unknown</span>"); 
					}
					html.println("</td>");
					
					//Ontology Language
					html.println("<td>");
					Iterator<RDFNode> ontLanguages = currentInd.listPropertyValues(model.getProperty("http://omv.ontoware.org/2005/05/ontology#hasOntologyLanguage"));
					if (ontLanguages.hasNext()){
						while(ontLanguages.hasNext()){
							RDFNode ontLanguage = ontLanguages.next();
							String ontLangURI = ontLanguage.asResource().getURI();
							String ontLangLabel = ontLanguage.as(Individual.class).getLabel(null);
							if (ontLanguage.canAs(Individual.class)){
								if (ontLangLabel.contains("OWL") || ontLangLabel.contains("RDF-S") || 
										ontLangLabel.contains("SKOS")){
									html.println("<a href=\"" + ontLangURI + "\" target=\"_blank\"> <span class=\"label label-success\">" + ontLangLabel + "</span></a>");
								}
								else{
									html.println("<a href=\"" + ontLangURI + "\" target=\"_blank\"> <span class=\"label label-danger\">" + ontLangLabel + "</span></a>");
								}
							}
						}
					}
					else{
						// boton gris, unknown
						html.println("<span class=\"label label-default\">Unknown</span>"); 
					}
					html.println("</td>");
					
					//Ontology syntax
					html.println("<td>");
					Iterator<RDFNode> syntaxs = currentInd.listPropertyValues(model.getProperty("http://omv.ontoware.org/2005/05/ontology#hasOntologySyntax"));
					if (syntaxs.hasNext()){
						while(syntaxs.hasNext()){
							RDFNode syntax = syntaxs.next();
							String syntaxURI = syntax.asResource().getURI();
							String syntaxLabel = syntax.as(Individual.class).getLabel(null);
							if (syntax.canAs(Individual.class)){
								html.println("<a href=\"" + syntaxURI + "\" target=\"_blank\"> <span class=\"label label-primary\">" + syntaxLabel + "</span></a>");
							}
						}
					}
					else{
						// boton gris, unknown
						html.println("<span class=\"label label-default\">Unknown</span>"); 
					}
					html.println("</td>");
					
					//Domains
					html.println("<td>");
					Iterator<RDFNode> domains = currentInd.listPropertyValues(model.getProperty("http://omv.ontoware.org/2005/05/ontology#hasDomain"));
					if (domains.hasNext()){
						while(domains.hasNext()){
							RDFNode domain = domains.next();
							if (domain.canAs(Individual.class)){
								html.println("<span class=\"label label-primary\">" + domain.as(Individual.class).getLabel(null) + "</span>");
							}
						}
					}
					else{
						// boton gris, unknown
						html.println("<span class=\"label label-default\">Unknown</span>"); 
					}
					html.println("</td>");
					
					//Languages
					html.println("<td>");
					Iterator<RDFNode> languages = currentInd.listPropertyValues(model.getProperty("http://purl.org/dc/terms/language"));
					if (languages.hasNext()){
						while(languages.hasNext()){
							RDFNode language = languages.next();
							String languageURI = language.asResource().getURI();
							String languageCode = allLanguages.getKey(languageURI);
							if (language.isURIResource()){
								html.println("<a href=\"" + languageURI + "\" target=\"_blank\"> <span class=\"label label-primary\">" + languageCode + "</span></a>");
							}
						}
					}
					else{
						// boton gris, unknown
						html.println("<span class=\"label label-default\">Unknown</span>"); 
					}
					html.println("</td>");
					
				html.println("</tr>");
			}
			
			html.println("</tbody>");
			
			html.println("</table>");
			
		}
		
//		/* Print datasets catalogue */
		html.println("<h1>Datasets  ");
		html.println("<small><a href=\"#\" title=\"RDF version\"> <img  width=\"25\" height=\"28\" border=\"0\" src=\"images/rdf_w3c_icon.48.gif\" alt=\"RDF Resource Description Framework Icon\"/></a></small>");
//		html.print("<small><a href=\"#\" title=\"RDF version\"> (RDF version of the data)</a></small>");
		html.println("</h1>");
		
		//Luego hay que cambiarlo con el if por si hay 0 elementos
		
		html.println("<table class=\"table table-hover\">");
		html.println("<thead>");
			html.println("<tr>");
				html.println("<th>Dataset</th>");
				html.println("<th>Digital form</th>");
				html.println("<th>Publicly available</th>");
				html.println("<th>Free of charge</th>");
				html.println("<th>Available online</th>");
				html.println("<th>Macrhine-readable</th>");
				html.println("<th>Available in bulk</th>");
				html.println("<th>Open License</th>");
				html.println("<th>Up to date</th>");
				html.println("<th>Domain</th>");
				html.println("<th>Natural Language</th>");
			html.println("</tr>");
		
		html.println("</thead>");
		
		html.println("<tbody>");
		
		//ejemplo para borrar
		html.println("<tr>");
			html.println("<td><a href = \"http://aws.amazon.com/datasets/Climate/2759\" target=\"_blank\">Daily Global Weather Measurements</a></td>");
			html.println("<td>");
			html.println("<span class=\"label label-default\">Unknown</span>");
			html.println("</td>");
			html.println("<td>");
			html.println("<span class=\"label label-default\">Unknown</span>");
			html.println("</td>");
			html.println("<td>");
			html.println("<span class=\"label label-default\">Unknown</span>");
			html.println("</td>");
			html.println("<td>");
			html.println("<span class=\"label label-default\">Unknown</span>");
			html.println("</td>");
			html.println("<td>");
			html.println("<span class=\"label label-default\">Unknown</span>");
			html.println("</td>");
			html.println("<td>");
			html.println("<span class=\"label label-default\">Unknown</span>");
			html.println("</td>");
			html.println("<td>");
			html.println("<span class=\"label label-success\">Yes</span>");
			html.println("</td>");
			html.println("<td>");
			html.println("<span class=\"label label-default\">Unknown</span>");
			html.println("</td>");
			html.println("<td>");
			html.println("<span class=\"label label-primary\">organization</span>");
			html.println("<span class=\"label label-primary\">organizational structure</span>");
			html.println("</td>");
			html.println("<td>");
			html.println("<a href=\"http://lexvo.org/id/iso639-3/eng\" target=\"_blank\"> <span class=\"label label-primary\">en</span></a>");
			html.println("</td>");
		html.println("</tr>");
		
		html.println("</tbody>");
		
		html.println("</table>");
		
		
		html.print(htmlBlocks.end);
		
	}

}
