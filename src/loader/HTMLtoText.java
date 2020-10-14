/**
 * @author Pujan Soni
 * 	*-*-*-*-*- jsoup api*-*-*--*
 * conversion of html to text
 *
 */

package loader;

import java.io.File;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLtoText {

	
	public static void htmlToText(String[] allHTMLFiles) {
		try {
			for (int i = 0; i < allHTMLFiles.length; i++) {
				//path of htmlfile
				File htmlFile = new File(ServletContextClass.webPagePath + allHTMLFiles[i]);
				Document document = Jsoup.parse(htmlFile, "UTF-8");
				//convert to textfile
				String fileText = document.text();
				PrintWriter pw = new PrintWriter(ServletContextClass.txtPath + allHTMLFiles[i].replaceAll(".htm*", ".txt"));
				//writing the file
				pw.println(fileText);
				pw.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
