/**
 * @author kevin shah
 * 
 * ------- edit distance----
 * for word suggestion
 * 
 * using Sequences class
 */

package loader;

import service.Sequences;

public class RecommandWord {
	
	public static String wordSuggestion(String[] searchedStrings) {
		String suggestString = "";
		int editDistance = 1000;
		int distance;
		String word = null;
		for (String string : searchedStrings) {
			for (String temp : ServletContextClass.wordHashSet) {
				distance = Sequences.editDistance(string, temp);
				if (distance < editDistance) {
					editDistance = distance;
					word = temp;
				}
			}
			suggestString += word + " ";
			editDistance = 1000;
		}
		return suggestString;
	}
}
