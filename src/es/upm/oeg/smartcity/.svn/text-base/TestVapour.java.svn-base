package es.upm.oeg.smartcity;

import java.util.List;
import net.sf.vapour.api.VapourAssertion;
import net.sf.vapour.api.VapourTest;

public class TestVapour {

	public boolean cnPURL = false;
	public boolean cnPURLexc = false;
		
	public TestVapour(VapourTest test, String string) {
		// TODO Auto-generated constructor stub
				
        try {
        	
        	List<VapourAssertion> assertions = test.getAssertions();
        	
        	if (assertions.size() > 1){
        		if ((assertions.get(0).getResponse().getStatusCode() == 302)
        			&& (assertions.get(1).getResponse().getStatusCode() == 303)
        			&& (assertions.get(2).getResponse().getStatusCode() == 200)){
//        				System.err.println("OK");
//        				System.out.println("OK");
        				
        				// now I have to check the content type 
        				if ( string.contains("RDF")){
        					this.cnPURL = cnRDF(assertions.get(2).getResponse().getContentType());	
        				}
        				else if ( string.contains("HTML")){
        					this.cnPURL = cnHTML(assertions.get(2).getResponse().getContentType());	
        				}
        				else{
        					System.err.println("Esto no deber’a pasar. TestVapour.");
        				}
        			}
//        		else{
//        			System.err.println("still wrong?");
//        			System.out.println("still wrong?");
//        			for (int i = 0; i < assertions.size(); i++){
//        				System.err.println("   " + assertions.get(i).getResponse().getStatusCode());
//        				System.out.println("   " + assertions.get(i).getResponse().getStatusCode());
//        			}
//        		}
        	}
        }

        catch (java.lang.Exception d){
        	this.cnPURLexc = true;
        }

	}
	
	private boolean cnRDF( String cn){
		
		if (cn.contains("text/xml")
				|| cn.contains("text/turtle")
				|| cn.contains("text/rdf+n3")
				|| cn.contains("application/xml")
				|| cn.contains("application/x-download")
				|| cn.contains("application/rdf+xml")){
			return true;
		}
		return false;
	}
	
	private boolean cnHTML (String cn){
		if (cn.contains("application/xhtml+xml") || cn.contains("text/html")){
			return true;
		}
		return false;
	}
	
	public boolean getCnPURL (){
		return this.cnPURL;
	}
	
}
