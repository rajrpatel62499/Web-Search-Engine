import java.io.*;

import org.jsoup.Jsoup;

public class HtmlToTextConverter {

	// This method converts HTML Files into text documents.
	public static void convertHtmlToText() throws IOException, FileNotFoundException, NullPointerException {
		org.jsoup.nodes.Document myDoc = null;
		BufferedWriter bw = null;

		try {
			File files = new File(".\\HTMLFiles");
			File[] file_Array = files.listFiles();
			int i = 0;
			for (File file : file_Array) 
			{
				myDoc = Jsoup.parse(file, "UTF-8");
				String my_string = file.getName().substring(0, file.getName().lastIndexOf('.'));
				bw = new BufferedWriter(new FileWriter("ConvertedTextFiles\\" + my_string + ".txt"));
				bw.write(myDoc.text());
				bw.close();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
