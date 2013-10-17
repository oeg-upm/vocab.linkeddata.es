package parseVocabs;

public class FileExtensionInURI {
	
	private boolean hasFileExtension = false;

	/**
	 * @param args
	 */
	public FileExtensionInURI (String uri) {
		// TODO Auto-generated method stub
		
		// . owl .rdf .n3 .rdfxml
				
		if (uri.contains(".owl") || 
				uri.contains(".rdf") || 
				uri.contains(".n3") || 
				uri.contains(".ttl")){
			this.hasFileExtension = true;
		}
	}
	
	public boolean hasFileExtension (){
		return this.hasFileExtension;
	}

}
