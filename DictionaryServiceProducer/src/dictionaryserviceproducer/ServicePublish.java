package dictionaryserviceproducer;

import java.io.IOException;
import java.util.ArrayList;

public interface ServicePublish {
	
	public String getMeaning(String word) throws IOException;
	public ArrayList<String> getSynonyms(String word) throws IOException;
	public String getExample(String word) throws IOException;

}
