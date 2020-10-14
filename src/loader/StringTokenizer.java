/**
 * @author Jay Patel
 * using String Tokenizer concept.
 * reading all textfiles and string words from it
 */
package loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class StringTokenizer {
	// Returning Tokens of a file
			public static String[] textTokenizing(String file) {
				String[] stringTokens = null;
				try {
					String fileName = ServletContextClass.txtPath + file;
					File textFile = new File(fileName);

					// storing file content into string
					BufferedReader reader = new BufferedReader(new FileReader(textFile));
					String fileLine = null;
					String str;
					StringBuilder sb = new StringBuilder();
					String ls = System.getProperty(" ");

					//reading the file
					while ((fileLine = reader.readLine()) != null) {
						sb.append(fileLine);
						sb.append(ls);
					}

					reader.close();
					str = sb.toString().toLowerCase();

					// Tokenizing the string content of file 
					stringTokens = str.split(" ");

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return stringTokens;
			}	
		
}
