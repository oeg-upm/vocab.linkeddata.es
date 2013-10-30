package parseVocabs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReadConfig {
	
	public ArrayList<String> vocabs = new ArrayList<String>();
	
	public ReadConfig() throws IOException {
		//BufferedReader in;
		//try {
			//File dir1 = new File (".");
            //String path = dir1.getCanonicalPath();

<<<<<<< HEAD
        
		BufferedReader in;
		
		File dir1 = new File (".");
		String path = dir1.getCanonicalPath();

		
		try {
//			in = new BufferedReader(new FileReader("/Users/oeg/Documents/workspace/vocab.linkeddata.es/config/vocabs.txt"));
			in = new BufferedReader(new FileReader(path +"/config/vocabs.txt"));

			String str;
			while ((str = in.readLine()) != null) {
				this.vocabs.add(str);
			}
			in.close();
			
			
		} catch (FileNotFoundException e) {
=======
            //FileWriter csvWriter = new FileWriter (path +"/usos.csv", true);
			//in = new BufferedReader(new FileReader("/Users/oeg/Documents/workspace/vocab.linkeddata.es/config/vocabs.txt"));
            //System.out.println(path +"/config/vocabs.txt");
            //in = new BufferedReader(new FileReader(path +File.separator+"config/vocabs.txt"));
			//String str = Constants.vocabularies;
			//while ((str = in.readLine()) != null) {
			//	this.vocabs.add(str);
			//}
			//in.close();
			//TO DO a better way to parse the vocabularies	
		//} catch (FileNotFoundException e) {
>>>>>>> a26931eb45728cec28a45571f307f220d3b62d36
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		String[] vocs = Constants.vocabularies.split("\n");
		for(int i=0; i<vocs.length;i++){
			vocabs.add(vocs[i]);
		}
		
	}
	
	/**
	 * An ArrayList with all the vocabularies stated in Constants.vocabularies
	 * @return
	 */
	public ArrayList<String> getVocabs (){
		return this.vocabs;
	}

}
