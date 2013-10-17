package parseVocabs;

import java.io.IOException;
import java.util.ArrayList;

public class ProcessVocabs {
	
	public ArrayList<Vocabulary> vocabularies =  new ArrayList<Vocabulary>();
	
	public ProcessVocabs() throws IOException {
		// TODO Auto-generated constructor stub
		
		//read the vocabs from config/vocabs.txt
		ReadConfig rc = new ReadConfig();
		
		ArrayList<String> vocabs = rc.getVocabs();
		
		//process each vocab
		for (int i = 0; i < vocabs.size(); i++){
			
			Vocabulary currentVocab = new Vocabulary(vocabs.get(i));
			
			if(currentVocab.title != null){
				this.vocabularies.add(currentVocab);
			}
			
		}
	}

	public ArrayList<Vocabulary> getVocabularies (){
		return this.vocabularies;
	}
}
