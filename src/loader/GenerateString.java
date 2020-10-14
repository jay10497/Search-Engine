/**
 * @author kevin
 * 
 * **********build dataset*******
 * ignore the redundant words such as 'what,is,I , he,she etc......'
 * such words are stored in irrelevant.txt file
 */
package loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateString {
	public static String[] generateKeyword(String searchString) {

		//words of irrelevant.txt
		ArrayList<String> redundantStrings = new ArrayList<>();
		//string excluding redundant words
		String[] filteredString = {};
		String fileLine;
		BufferedReader bufferedReader;
		try {
			
			//check path!!!!!!!!!!!!!!!!!
			bufferedReader = new BufferedReader(new FileReader("CC_SearchEngine_Group_3\\irrelevant.txt"));
			//reading irrelevant words
			while ((fileLine = bufferedReader.readLine()) != null) {
				redundantStrings.add(fileLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//take the input and exclude the redundant words
		String[] splitStrings = searchString.split(" ");
		StringBuilder stringBuilder = new StringBuilder();
		for (String word : splitStrings) {
			word = word.trim();
			if (!redundantStrings.contains(word)) {
				stringBuilder.append(word + "\n");
			}
		}
		
		//what is string ----> string
		filteredString = stringBuilder.toString().split("\n").clone();

		
		return filteredString;

	}
}
