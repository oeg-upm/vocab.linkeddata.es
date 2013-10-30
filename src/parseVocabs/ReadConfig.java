package parseVocabs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadConfig {
	
	public ArrayList<String> vocabs = new ArrayList<String>();
	
	public ReadConfig() throws IOException {
		

        
		BufferedReader in;
		
		try {
			in = new BufferedReader(new FileReader("/Users/oeg/Documents/workspace/vocab.linkeddata.es/config/vocabs.txt"));
			String str;
			while ((str = in.readLine()) != null) {
				this.vocabs.add(str);
			}
			in.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getVocabs (){
		return this.vocabs;
	}

}
