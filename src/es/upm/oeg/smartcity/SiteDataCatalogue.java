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
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class SiteDataCatalogue {
	
	public SiteDataCatalogue(OntModel model, String owlFileName, PrintStream html) {
		// TODO Auto-generated constructor stub
		
		HTMLblocksData htmlBlocks = new HTMLblocksData();
		Languages allLanguages = new Languages();
		List<String> domainList = new ArrayList<String>();
		
		String energyOnto = "http://smartcity.linkeddata.es/def#";

		html.print(htmlBlocks.header);
	
//		/* Print datasets catalogue */
		html.println("<h1>Datasets  ");
		html.println("<small><a href=\"../" + owlFileName + "\" title=\"RDF version\"> <img  width=\"25\" height=\"28\" border=\"0\" src=\"../images/rdf_w3c_icon.48.gif\" alt=\"RDF Resource Description Framework Icon\"/></a></small>");
//		html.print("<small><a href=\"#\" title=\"RDF version\"> (RDF version of the data)</a></small>");
		html.println("</h1>");
		html.print(htmlBlocks.colorCode);

		Iterator<Individual> individualsDataset = model.listIndividuals(model.getResource("http://www.w3.org/ns/dcat#Dataset"));

		//comienza la tabla si hay al menos un elemento
		if (individualsDataset.hasNext()){
			
			html.println("<div class=\"ui-widget\">");
			html.println("<label for=\"tags\">Filter by domain: </label>");
			html.println("<input id=\"tags\">  <button id=\"remButt\" class=\"label label-default\" onclick=\"showRows();\" style=\"font-size: 75%; font-weight: bold; line-height: 1; display: none;\"><span class=\"submit glyphicon glyphicon-remove\"></span>  Remove filter</button>");
			html.println("</div>");
					
			html.println("<table id=\"tablesorter-demo\" class=\"tablesorter table table-hover\">");
			html.println("<thead>");
				html.println("<tr>");
					html.println("<th>Dataset</th>");
					html.println("<th>Digital form</th>");
					html.println("<th>Publicly available</th>");
					html.println("<th>Free of charge</th>");
					html.println("<th>Available online</th>");
					html.println("<th>Machine-readable</th>");
					html.println("<th>Available in bulk</th>");
					html.println("<th>Open License</th>");
					html.println("<th>Up to date</th>");
					html.println("<th>Domain</th>");
					html.println("<th>Natural Language</th>");
				html.println("</tr>");
			
			html.println("</thead>");
			
			html.println("<tbody>");
			
			int numId = 1;
			//relleno la tabla
			while (individualsDataset.hasNext()){

				Individual currentInd= individualsDataset.next();
//				html.println("<tr>");
				html.println("<tr id=\"tr"+numId+"\">");
				
				String dataURL = currentInd.getPropertyValue(model.getProperty("http://www.w3.org/ns/dcat#landingPage")).toString();
				String localURL = dataURL.replace("https://","").replace("http://","").replace("/", "").replace("#", "");
				String dataTitle = currentInd.getPropertyValue(model.getProperty("http://purl.org/dc/terms/title")).asLiteral().getString();;
				
				if (dataURL != null){
					html.println("<td><a href = \"" + "datasets/"+localURL + ".html\">" + dataTitle + "</a> <a href = \"" + dataURL + "\" target=\"_blank\"><span class=\"glyphicon glyphicon-share-alt\"/></a></td>");
				}
				else{
					html.println("<td>" + dataTitle + "</td>");
				}
				
				//Digital form
				html.println("<td>");
				Iterator<RDFNode> digitalForms = currentInd.listPropertyValues(model.getProperty(energyOnto + "digitalForm"));
				if (digitalForms.hasNext()){
					RDFNode digitalForm = digitalForms.next();
					Literal literal = digitalForm.asLiteral();
					boolean literalbool = literal.getBoolean();
					if (literalbool){
						html.println("<span class=\"label label-success\">" + "Yes" + "</span>");
					}
					else{
						html.println("<span class=\"label label-danger\">" + "No" + "</span>");
					}
				}
				else{
					// boton gris, unknown
					html.println("<span class=\"label label-default\">Unknown</span>"); 
				}
				html.println("</td>");
				
				//publicly available
				html.println("<td>");
				Iterator<RDFNode> publiclyAvailables = currentInd.listPropertyValues(model.getProperty(energyOnto + "publiclyAvailable"));
				if (publiclyAvailables.hasNext()){
					RDFNode publiclyAvailable = publiclyAvailables.next();
					Literal literal = publiclyAvailable.asLiteral();
					boolean literalbool = literal.getBoolean();
					if (literalbool){
						html.println("<span class=\"label label-success\">" + "Yes" + "</span>");
					}
					else{
						html.println("<span class=\"label label-danger\">" + "No" + "</span>");
					}
				}
				else{
					// boton gris, unknown
					html.println("<span class=\"label label-default\">Unknown</span>"); 
				}
				html.println("</td>");
				
				//free of charge
				html.println("<td>");
				Iterator<RDFNode> freeOfCharges = currentInd.listPropertyValues(model.getProperty(energyOnto + "freeOfCharge"));
				if (freeOfCharges.hasNext()){
					RDFNode freeOfCharge = freeOfCharges.next();
					Literal literal = freeOfCharge.asLiteral();
					boolean literalbool = literal.getBoolean();
					if (literalbool){
						html.println("<span class=\"label label-success\">" + "Yes" + "</span>");
					}
					else{
						html.println("<span class=\"label label-danger\">" + "No" + "</span>");
					}
				}
				else{
					// boton gris, unknown
					html.println("<span class=\"label label-default\">Unknown</span>"); 
				}
				html.println("</td>");
				
				//available online
				html.println("<td>");
				Iterator<RDFNode> availableOnlines = currentInd.listPropertyValues(model.getProperty(energyOnto + "availableOnline"));
				if (availableOnlines.hasNext()){
					RDFNode availableOnline = availableOnlines.next();
					Literal literal = availableOnline.asLiteral();
					boolean literalbool = literal.getBoolean();
					if (literalbool){
						html.println("<span class=\"label label-success\">" + "Yes" + "</span>");
					}
					else{
						html.println("<span class=\"label label-danger\">" + "No" + "</span>");
					}
				}
				else{
					// boton gris, unknown
					html.println("<span class=\"label label-default\">Unknown</span>"); 
				}
				html.println("</td>");

				//machine readable
				html.println("<td>");
				Iterator<RDFNode> machineReadableFormats = currentInd.listPropertyValues(model.getProperty(energyOnto + "machineReadableFormat"));
				if (machineReadableFormats.hasNext()){
					RDFNode machineReadableFormat = machineReadableFormats.next();
					Literal literal = machineReadableFormat.asLiteral();
					boolean literalbool = literal.getBoolean();
					if (literalbool){
						html.println("<span class=\"label label-success\">" + "Yes" + "</span>");
					}
					else{
						html.println("<span class=\"label label-danger\">" + "No" + "</span>");
					}
				}
				else{
					// boton gris, unknown
					html.println("<span class=\"label label-default\">Unknown</span>"); 
				}
				html.println("</td>");
				
				//available bulk
				html.println("<td>");
				Iterator<RDFNode> bulkAvailables = currentInd.listPropertyValues(model.getProperty(energyOnto + "bulkAvailable"));
				if (bulkAvailables.hasNext()){
					RDFNode bulkAvailable = bulkAvailables.next();
					Literal literal = bulkAvailable.asLiteral();
					boolean literalbool = literal.getBoolean();
					if (literalbool){
						html.println("<span class=\"label label-success\">" + "Yes" + "</span>");
					}
					else{
						html.println("<span class=\"label label-danger\">" + "No" + "</span>");
					}
				}
				else{
					// boton gris, unknown
					html.println("<span class=\"label label-default\">Unknown</span>"); 
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
				
				//up to date
				html.println("<td>");
				Iterator<RDFNode> updateds = currentInd.listPropertyValues(model.getProperty(energyOnto + "updated"));
				if (updateds.hasNext()){
					RDFNode updated = updateds.next();
					Literal literal = updated.asLiteral();
					boolean literalbool = literal.getBoolean();
					if (literalbool){
						html.println("<span class=\"label label-success\">" + "Yes" + "</span>");
					}
					else{
						html.println("<span class=\"label label-danger\">" + "No" + "</span>");
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
					if (!domainList.contains("Unknown"))
						domainList.add("Unknown");
					domainText="Unknown--";
				}
				html.println("</td>");
				
				//añadimos el campo input oculto con los valores del dominio
				
				html.println("<input type=\"hidden\" name=\"inp"+numId+"\" id=\"inp"+numId+"\" value=\""+domainText+"\"/>");
				
				// end 
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
		
		
		System.out.println(domainList);
		
	}	

}
