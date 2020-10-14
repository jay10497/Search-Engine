/**
 * @author Sharvil Patel

 * 
 * *****	Inverted Index - Trie	****
 * to calculate the frequency of input words
 * using class TST.java to create the Trie
 */
package loader;

import service.TST;

public class SearchRex {
	public static int[][] search(String[] keywords) {
		
		int[][] listOfFrequency = new int[ServletContextClass.TST.size()][2];
		TST<Integer> strTST;
		
		for (int i = 0; i < ServletContextClass.TST.size(); i++) {
			strTST = ServletContextClass.TST.get(i);
			listOfFrequency[i][0] = 0;
			listOfFrequency[i][1] = i;
			for (String w : keywords) {
				if (strTST.contains(w)) {
					listOfFrequency[i][0] += strTST.get(w);
				}
			}
		}
		return listOfFrequency;
	}
}
