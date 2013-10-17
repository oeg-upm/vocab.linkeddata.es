package parseVocabs;

import java.net.HttpURLConnection;
import java.net.URL;

import com.hp.hpl.jena.sparql.util.StrUtils;

public class FollowRedirectRDF {
	
	public String newURL = null;
	
	public FollowRedirectRDF(String url) {
		
		this.newURL = url;
		
	    try {
	    	String acceptHeaderValue = StrUtils.strjoin(",",
	                "application/rdf+xml",
	                "application/turtle;q=0.9",
	                "application/x-turtle;q=0.9",
	                "text/n3;q=0.8",
	                "text/turtle;q=0.8",
	                "text/rdf+n3;q=0.7",
	                "application/xml;q=0.5",
	                "text/xml;q=0.5",
	                "text/plain;q=0.4",     // N-triples
	                "*/*;q=0.2") ; 
			
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		HttpURLConnection.setFollowRedirects(true);
		conn.setRequestProperty("Accept", acceptHeaderValue);
		conn.setInstanceFollowRedirects(true);
		
//		conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
//		conn.addRequestProperty("User-Agent", "Mozilla");
//		conn.addRequestProperty("Referer", "google.com");
	 
//		System.out.println("Request URL ... " + url);
	 
		boolean redirect = false;
	 
		// normally, 3xx is redirect
		int status = conn.getResponseCode();
		if (status != HttpURLConnection.HTTP_OK) {
			if (status == HttpURLConnection.HTTP_MOVED_TEMP
				|| status == HttpURLConnection.HTTP_MOVED_PERM
					|| status == HttpURLConnection.HTTP_SEE_OTHER)
			redirect = true;
		}
	 
//		System.out.println("Response Code ... " + status);
	 
		if (redirect) {
	 
			// get redirect url from "location" header field
			String newUrl = conn.getHeaderField("Location");
			
			
	 
//			// get the cookie if need, for login
//			String cookies = conn.getHeaderField("Set-Cookie");
	 
//			 open the new connnection again
//			conn = (HttpURLConnection) new URL(newUrl).openConnection();
//			conn.setRequestProperty("Cookie", cookies);
//			conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
//			conn.addRequestProperty("User-Agent", "Mozilla");
//			conn.addRequestProperty("Referer", "google.com");
	 
//			System.out.println("Redirect to URL : " + newUrl);
			
			this.newURL = newUrl;
	 
		}
	 
//		BufferedReader in = new BufferedReader(
//	                              new InputStreamReader(conn.getInputStream()));
//		String inputLine;
//		StringBuffer html = new StringBuffer();
	 
//		while ((inputLine = in.readLine()) != null) {
//			html.append(inputLine);
//		}
//		in.close();
	 
//		System.out.println("URL Content... \n" + html.toString());
//		System.out.println("Done follows redirect and there was no redirect");
	 
	    } catch (Exception e) {
		e.printStackTrace();
	    }
			// TODO Auto-generated constructor stub
	}
	
	public String getNewUrl (){
		return this.newURL;
	}
}
