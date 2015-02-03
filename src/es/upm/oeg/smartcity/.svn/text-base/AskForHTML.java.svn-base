package es.upm.oeg.smartcity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AskForHTML {
	
	public boolean type = false;
	
	public AskForHTML (String urlToFetch, String prefix) { 
		
//		System.out.println("Url used: " + urlToFetch);
					
		try {
			URL url = new URL(urlToFetch);
			tryDownload( url, prefix);
		}
		catch (java.net.MalformedURLException m){
			System.err.println ("1) "+ m.getMessage());
//			System.out.println ("1) "+ m.getMessage());
		}
		catch (IOException n){	
			System.err.println ("2) "+ n.getMessage());
//			System.out.println ("2) "+ n.getMessage());
		}
		
	}
	
	private void tryDownload (URL url, String prefix) throws IOException{     

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		HttpURLConnection.setFollowRedirects(true);
		conn.connect();

        InputStream stream = conn.getInputStream();	
        
//        HttpURLConnection conn2 = (HttpURLConnection) url.openConnection();
//		HttpURLConnection.setFollowRedirects(true);
//		conn2.connect();
//
//        InputStream stream2 = conn2.getInputStream();
	
		try {

            if (stream != null) {
            	            	
//            	FileOutputStream fout = new FileOutputStream("htmlFiles/"+ prefix + ".html");

            	InputStreamReader is = new InputStreamReader(stream);
            	StringBuilder sb=new StringBuilder();
            	BufferedReader br = new BufferedReader(is);
            	String read = br.readLine();

            	while(read != null) {
            	    //System.out.println(read);
            	    sb.append(read);
            	    read =br.readLine();
            	}

            	String content = sb.toString();
        		
//            	byte[] buffer = new byte[4096];  
//            	int bytesRead;  
//            	while ((bytesRead = stream2.read(buffer)) != -1) { 
//            		
//            		fout.write(buffer, 0, bytesRead);  
//            	}            	
//            	stream.close();
//            	stream2.close();
//            	fout.close();
            	
            	if (content.contains("<!DOCTYPE html")
            			|| content.contains("<html>")
            			|| content.contains("<head>")){
//            		System.out.println("HTML in: " + url.toString());
            		this.type = true;
            	}
            	else{
//            		System.out.println("other in: " + url.toString());
            	}
            }
            
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
	
	public boolean getTypeHTML (){
		return this.type;
	}
}

