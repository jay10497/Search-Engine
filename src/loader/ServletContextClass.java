/**
 * 	
 * @author kevin
 * 	
 * 			MAIN CLASS...........
 * 
 * ---------using html files of tutorialpoint---------------
 * 			returns result to the inndex.html
 */
package loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import service.Sequences;
import service.TST;

public class ServletContextClass implements ServletContextListener {

	
	//-------------check the file paths!!!!!!!!!!!!!!!!
	public static String webPagePath = "ACC_SearchEngine_Group_3\\HTMLFiles";
	public static String txtPath = "ACC_SearchEngine_Group_3\\TextFiles\\";
	public static ArrayList<TST<Integer>> TST = new ArrayList<>();
	public static Set<String> wordHashSet = new HashSet<>();
	private static String[] allHTMLFiles;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ContextDestroyed Called..");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Inside Initializer..");
		
		File fileRepo = new File(webPagePath);
		allHTMLFiles = fileRepo.list();
		System.out.println(webPagePath);

		// Converting html to text
		// long s = System.currentTimeMillis();
		
		//	HTMLtoText.htmlToText(allHTMLFiles);
		
		// long e = System.currentTimeMillis();
		// System.out.println(e-s);
		
		// reading text folder
		fileRepo = new File(txtPath);
		String[] strFiles = fileRepo.list();

		// reading each text file
		for (String file : strFiles) {	
			TST<Integer> fileTST = new TST<>();
			String[] txtToken = StringTokenizer.textTokenizing(file);
			// storing the tokens into TST
			for (int i = 0; i < txtToken.length; i++) {
				// Calculating frequency of word and storing it as value in
				// TST.(taking more Time)
				
				//removing all specalized characters
				String tmp = txtToken[i].replaceAll("[^a-zA-Z]", "");
				
				wordHashSet.add(tmp);
				if (tmp.length() > 0) {
					if (fileTST.contains(tmp)) {
						fileTST.put(tmp, fileTST.get(tmp) + 1);
					} else {
						fileTST.put(tmp, 1);
					}
				}
			}
			TST.add(fileTST);
		}
		
		//if successful print 
		System.out.println("Pre-processed Data!");
	}

	//takes input of web search
	public static List<String> finalCall(String input) {

		String searchWord = input.toLowerCase();
		String[] keywords = GenerateString.generateKeyword(searchWord);

		String sw = RecommandWord.wordSuggestion(keywords);
		if (sw.trim().equals(String.join(" ", keywords))) {
			sw = "";
		}

		List<String> result = new ArrayList<>();
		result.add(sw);
		int[][] f = SearchRex.search(keywords);
		Arrays.sort(f, new Comparator<int[]>() {

			@Override
			public int compare(final int[] entry1, final int[] entry2) {

				if (entry1[0] < entry2[0])
					return 1;
				else
					return -1;
			}
		});


		for (int i = 0; i < f.length; i++) {
			
			int index = f[i][1];
			if(f[i][0] == 0) {
				break;
			}
			// System.out.println(myHTMLFiles[index]);
			result.add(allHTMLFiles[index]);
		}
		//return to display
		return result;
	}	
}
