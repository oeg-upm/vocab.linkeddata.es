package es.upm.oeg.smartcity;

import java.io.PrintStream;
import java.util.ArrayList;
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

public class SiteOntoCatalogue {
	
	public SiteOntoCatalogue(OntModel model, String owlFileName, PrintStream html) {
		// TODO Auto-generated constructor stub
		
		HTMLblocksOntos htmlBlocks = new HTMLblocksOntos();
		Languages allLanguages = new Languages();
		List<String> domainList = new ArrayList<String>();
		
		html.print(htmlBlocks.header);
	
		/* Print ontology catalogue */
		html.println("<h1>Ontologies  ");
		html.println("<small><a href=\"./" + owlFileName + "\" title=\"RDF version\"> <img  width=\"25\" height=\"28\" border=\"0\" src=\"images/rdf_w3c_icon.48.gif\" alt=\"RDF Resource Description Framework Icon\"/></a></small>");
//		html.print("<small><a href=\"#\" title=\"RDF version\"> (RDF version of the data)</a></small>");
		html.println("</h1>");
		html.print(htmlBlocks.colorCode);

		Iterator<Individual> individualsOnto = model.listIndividuals(model.getResource("http://purl.org/vocommons/voaf#Vocabulary"));
		
		//comienza la tabla si hay al menos un elemento
		if (individualsOnto.hasNext()){
			
			html.println("<div class=\"ui-widget\">");
			html.println("<label for=\"tags\">Filter by domain: </label>");
			html.println("<input id=\"tags\">  <button id=\"remButt\" class=\"label label-default\" onclick=\"showRows();\" style=\"font-size: 75%; font-weight: bold; line-height: 1; display: none;\"><span class=\"submit glyphicon glyphicon-remove\"></span>  Remove filter</button>");
			html.println("</div>");
			
			html.println("<table id=\"tablesorter-demo\" class=\"tablesorter table table-hover\">");
			html.println("<thead>");
				html.println("<tr>");
					html.println("<th>Ontology</th>");
					html.println("<th  colspan = \"2\" class=\"text-center\">Online Availability <br> (RDF | HTML)</th>");
					html.println("<th>Open License</th>");
					html.println("<th>Ontology Language</th>");
					html.println("<th>Syntax</th>");
					html.println("<th>Domain</th>");
					html.println("<th>Natural Language</th>");
				html.println("</tr>");
			html.println("</thead>");
			
			html.println("<tbody>");
			
			int numId = 1;
			//relleno la tabla
			while (individualsOnto.hasNext()){
				Individual currentInd= individualsOnto.next();
				html.println("<tr id=\"tr"+numId+"\">");
				
					String ontURI = currentInd.getURI();
					String ontTitle = currentInd.getPropertyValue(model.getProperty("http://purl.org/dc/terms/title")).asLiteral().getString();
					String localURL = ontURI.replace("https://","").replace("http://","").replace("/", "").replace("#", "");
					html.println("<td><a href = \"ontologies/" + localURL + ".html\" >" + ontTitle + "</a> <a href = \"" + ontURI + "\" target=\"_blank\"><span class=\"glyphicon glyphicon-share-alt\"/></a></td>");
				
					//Availbe online
					html.println("<td>");
					boolean anyRDF = false;
					boolean anyHTML = false;
					boolean cnRDF = false;
					boolean cnHTML = false;
					boolean vapourExc = false;
					String uriVapourRDF= null;
					String uriVapourHTML= null;
					String contentTypeRDF = null;
					String contentTypeHTML = null;
					
					try {
						
						//test vapour
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
						
						//try to get RDF and load it into jena only if there has been an exception with vapour or the cn is not ok
						if (vapourExc || !cnRDF){
							LoadRDFModel loadModel = new LoadRDFModel(ontURI, uriVapourRDF, contentTypeRDF);
//							System.out.println("onto: " + ontURI + " -->" + loadModel.jenaModelExc);
							anyRDF = !loadModel.getJenaExc();
						}
						
						//try to get htmlonly if there has been an exception with vapour or the cn is not ok
						if (vapourExc || !cnHTML){
							AskForHTML askHTML = new AskForHTML(ontURI, "download");
							anyHTML = askHTML.getTypeHTML(); 
						}
				        
//						if (vapourExc) {
//							html.println("<span class=\"label label-default\">Unknown</span>");
//						}
//						else if (cnRDF && cnHTML){
//							html.println("<a href=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" target=\"_blank\"><span class=\"label label-success\">RDF</span></a>");
//							html.println("<a href=\"http://dbpedia.org/resource/HTML\" target=\"_blank\"><span class=\"label label-success\">HTML</span></a>");
//						}
//						else if (cnRDF && !cnHTML){
//							html.println("<a href=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" target=\"_blank\"><span class=\"label label-warning\">RDF</span></a>");
//						}
//						else if(!cnRDF && cnHTML){
//							html.println("<a href=\"http://dbpedia.org/resource/HTML\" target=\"_blank\"><span class=\"label label-warning\">HTML</span></a>");
//						}
//			        	else{
//							html.println("<span class=\"label label-danger\">No</span>");
//						}
						
						//calculate the ranking
						// +2 cnX
						// +1 anyX
						// 0 unknwon
						// -1 no available
						
						int rankRDF = 0;
						
						if (cnRDF){
							rankRDF = 4;
						}
						else if (!cnRDF && anyRDF){
							rankRDF = 2;
						}
						else if (vapourExc) {
							rankRDF = 0;
						}
						else /*if (!cnRDF && !anyRDF)*/{
							rankRDF = -1;
						}
						
						int rankHTML = 0;
						if (cnHTML){
							rankHTML = 4;
						}
						else if (!cnHTML && anyHTML){
							rankHTML = 2;
						}
						else if (vapourExc) {
							rankHTML = 0;
						}
						else /*if (!cnHTML && !anyHTML)*/{
							rankHTML = -1;
						}
						
						int rank = rankRDF + rankHTML;

						html.println("<span hidden>" + rank + "</span>");

						if (cnRDF){
//							html.println("<a href=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" target=\"_blank\"><span class=\"label label-success\">RDF</span></a>");
							html.println("<span class=\"label label-success\">CN OK</span>");
							html.println("</td>");
							html.println("<td>");

						}
						else if (!cnRDF && anyRDF){
//							html.println("<a href=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" target=\"_blank\"><span class=\"label label-warning\">RDF</span></a>");
							html.println("<span class=\"label label-warning\">NO CN</span>");
							html.println("</td>");
							html.println("<td>");

						}
						else if (vapourExc) {
							html.println("<span class=\"label label-default\">Unknown</span>");
							html.println("</td>");
							html.println("<td>");

						}
						else /*if (!cnRDF && !anyRDF)*/{
//							html.println("<a href=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" target=\"_blank\"><span class=\"label label-danger\">RDF</span></a>");
							html.println("<span class=\"label label-danger\">Not Av</span>");
							html.println("</td>");
							html.println("<td>");

						}
						
						if (cnHTML){
//							html.println("<a href=\"http://dbpedia.org/resource/HTML\" target=\"_blank\"><span class=\"label label-success\">HTML</span></a>");
							html.println("<span class=\"label label-success\">CN OK</span>");
						}
						else if (!cnHTML && anyHTML){
//							html.println("<a href=\"http://dbpedia.org/resource/HTML\" target=\"_blank\"><span class=\"label label-warning\">HTML</span></a>");
							html.println("<span class=\"label label-warning\">NO CN</span>");
						}
						else if (vapourExc) {
							html.println("<span class=\"label label-default\">Unknown</span>");
						}
						else /*if (!cnHTML && !anyHTML)*/{
//							html.println("<a href=\"http://dbpedia.org/resource/HTML\" target=\"_blank\"><span class=\"label label-danger\">HTML</span></a>");
							html.println("<span class=\"label label-danger\">Not Av</span>");						
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
							String ontLangHomePage = ontLanguage.as(Individual.class).getPropertyValue(model.getProperty("http://xmlns.com/foaf/0.1/homepage")).toString();
							if (ontLanguage.canAs(Individual.class)){
								if (ontLangLabel.contains("OWL") || ontLangLabel.contains("RDF-S") || 
										ontLangLabel.contains("SKOS")){
									html.println("<a href=\"" + ontLangHomePage + "\" target=\"_blank\"> <span class=\"label label-success\">" + ontLangLabel + "</span></a>");
								}
								else{
									html.println("<a href=\"" + ontLangHomePage + "\" target=\"_blank\"> <span class=\"label label-danger\">" + ontLangLabel + "</span></a>");
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
							String syntaxHomePage = syntax.as(Individual.class).getPropertyValue(model.getProperty("http://xmlns.com/foaf/0.1/homepage")).toString();
							if (syntax.canAs(Individual.class)){
								html.println("<a href=\"" + syntaxHomePage + "\" target=\"_blank\"> <span class=\"label label-primary\">" + syntaxLabel + "</span></a>");
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
					String domainText = "";
					if (domains.hasNext()){
						while(domains.hasNext()){
							RDFNode domain = domains.next();
							String domainURI = domain.asResource().getURI();
							String domainLabel = domain.as(Individual.class).getLabel(null);
							if (domain.canAs(Individual.class)){
								html.println("<a href=\"" + domainURI + "\" target=\"_blank\"> <span class=\"label label-primary\">" + domainLabel + "</span></a>");
								domainText = domainText + domainLabel + "--";
								if (!domainList.contains(domainLabel))
									domainList.add(domainLabel);
							}
						}
					}
					else{
						// boton gris, unknown
						html.println("<span class=\"label label-default\">Unknown</span>");
						if (!domainList.contains("Unknown"))
							domainList.add("Unknown");
						domainText="Unknown--";
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
					
					//Aquí añadimos la parte de oculta
					
					html.println("<input type=\"hidden\" name=\"inp"+numId+"\" id=\"inp"+numId+"\" value=\""+domainText+"\"/>");
					
				html.println("</tr>");
				numId++;
			}
			
			html.println("</tbody>");
			
			html.println("</table>");
			
		}	
		
		//Añadimos el script para los valores del filtro por dominio
		html.println("<script>");
		html.println("$(function() {");
		html.println("var availableTags = [");
		html.println("\""+domainList.get(0)+"\"");
		for (int i=1; i<domainList.size();i++ ){
			html.println(", \""+domainList.get(i)+"\"");
		}
		html.println("];");
		html.println("$( \"#tags\" ).autocomplete({");
		html.println("source: availableTags,");
		html.println("select: function(event, ui) {");		
		html.println("hideRows(ui.item.value);");
			
		html.println("}");
		html.println("});");
		html.println("});");
		html.println("</script>");
		html.println("<script>");
		html.println("function hideRows(text) {");
		html.println("index = 1;");
		html.println("tr = document.getElementById('tr'+index);");
		html.println("while (tr!=null){");
		html.println("valores = document.getElementById('inp'+index).value;");
		html.println("if (!valores.contains(text+'--')){");
		html.println("tr.style.display='none';");
		html.println("}");
		html.println("index++;");
		html.println("tr = document.getElementById('tr'+index);");
		html.println("}");
		html.println("document.getElementById('remButt').style.display='';");
		html.println("}");
		html.println("");
		html.println("");
		html.println("function showRows() {	");
		html.println("index = 1;");
		html.println("tr = document.getElementById('tr'+index);");
		html.println("while (tr!=null){");
		html.println("tr.style.display='';");		
		html.println("index++;");
		html.println("tr = document.getElementById('tr'+index);");
		html.println("}");
		html.println("butt = document.getElementById('remButt').style.display='none';");
		html.println("}");
		html.println("</script>");
		
		html.print(htmlBlocks.end);
		
	}

}
