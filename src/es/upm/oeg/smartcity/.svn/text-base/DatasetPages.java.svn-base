package es.upm.oeg.smartcity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;


public class DatasetPages {

	public DatasetPages(ArrayList<Dataset> datasets) throws FileNotFoundException {
		
		for (Dataset dataset:datasets){
			System.out.println("************"+dataset.url);
			String dataURL = dataset.url;
			String dataTitle = dataset.title;
			String localURL = dataURL.replace("https://","").replace("http://","").replace("/", "").replace("#", "");
			
			PrintStream html = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("output/web/datasets/datasets/"+ localURL +".html"))), true); 

			html.print(HTMLblocksDataPage.header);
//			html.println("<h1>" + ontTitle + "</h1>");
			html.println("<h1> <a href=\"" + dataURL +"\" target=\"_blank\">"+ dataTitle + "</a></h1>");
			html.println("<br>");
			
			html.println("<dl class=\"dl-horizontal\">");
			html.println("<dt>Title</dt>");
			html.println("<dd><a href=\"" + dataURL + "\" target=\"_blank\">" + dataTitle + "</a></dd>");
						
		    if (dataset.description != null){
		    	html.println("<dt>Description</dt>");
				html.println("<dd>" + dataset.description + "</dd>");
		    }
		    
		    if (dataset.domains.size()>0){
			    html.println("<dt>Domain</dt>");
				html.println("<dd>");
				for (int i=0; i<dataset.domains.size();i++){										
					html.println(dataset.domains.get(i));					
					if(i+1<dataset.domains.size()){
						html.print(", ");
					}					
				}
				html.println("</dd>");
		    }
		    
		    if (dataset.version != null){
		    	html.println("<dt>Version</dt>");
				html.println("<dd>" + dataset.version + "</dd>");
		    }
		    
		    if (!dataset.creationDate.equals("")){
				html.println("<dt>Creation date</dt>");
				html.println("<dd>" + dataset.creationDate + "</dd>");
			}
		    
		    if (!dataset.lastUpdate.equals("")){
				html.println("<dt>Last update</dt>");
				html.println("<dd>" + dataset.lastUpdate + "</dd>");
			}
		    
		    if (dataset.contactPersons.size()>0){
			    html.println("<dt>Contact person</dt>");
				html.println("<dd>");
				for (int i=0; i<dataset.contactPersons.size();i++){										
					html.println(dataset.contactPersons.get(i));					
					if(i+1<dataset.contactPersons.size()){
						html.print(", ");
					}					
				}
				html.println("</dd>");
		    }
		    
		    if (!dataset.publisher.equals("")){
				html.println("<dt>Publisher</dt>");
				html.println("<dd>" + dataset.publisher + "</dd>");
			}
		    
		    if (dataset.licenses.size()>0){
			    html.println("<dt>License</dt>");
				html.println("<dd>");
				for (int i=0; i<dataset.licenses.size();i++){										
					html.println(dataset.licenses.get(i));					
					if(i+1<dataset.licenses.size()){
						html.print(", ");
					}					
				}
				html.println("</dd>");
		    }
		    
		    if (dataset.formats.size()>0){
			    html.println("<dt>Format</dt>");
				html.println("<dd>");
				for (int i=0; i<dataset.formats.size();i++){										
					html.println(dataset.formats.get(i));					
					if(i+1<dataset.formats.size()){
						html.print(", ");
					}					
				}
				html.println("</dd>");
		    }
			
		    if (dataset.languages.size()>0){
			    html.println("<dt>Language</dt>");
				html.println("<dd>");
				for (int i=0; i<dataset.languages.size();i++){										
					html.println(dataset.languages.get(i));					
					if(i+1<dataset.languages.size()){
						html.print(", ");
					}					
				}
				html.println("</dd>");
		    }
		    
		    if (!dataset.updateFrequency.equals("")){
				html.println("<dt>Update frequency</dt>");
				html.println("<dd>" + dataset.updateFrequency + "</dd>");
			}
		    
		    if (!dataset.availableOnline.equals("")){
				html.println("<dt>Available online</dt>");
				html.println("<dd>" + dataset.availableOnline + "</dd>");
			}
		    
		    if (!dataset.digitalForm.equals("")){
				html.println("<dt>Digital form</dt>");
				html.println("<dd>" + dataset.digitalForm + "</dd>");
			}
		    
		    if (!dataset.publiclyAvailable.equals("")){
				html.println("<dt>Publicly available</dt>");
				html.println("<dd>" + dataset.publiclyAvailable + "</dd>");
			}
		    
		    if (!dataset.freeOfCharge.equals("")){
				html.println("<dt>Free of charge</dt>");
				html.println("<dd>" + dataset.freeOfCharge + "</dd>");
			}
		    
		    if (!dataset.machineReadableFormat.equals("")){
				html.println("<dt>Machine readable format</dt>");
				html.println("<dd>" + dataset.machineReadableFormat + "</dd>");
			}
		    
		    if (!dataset.bulkAvailable.equals("")){
				html.println("<dt>Bulk available</dt>");
				html.println("<dd>" + dataset.bulkAvailable + "</dd>");
			} 
		    
		    html.println("</dl>");
		    
		    html.print(HTMLblocksDataPage.end);
		    html.close();

		}

	}

}
