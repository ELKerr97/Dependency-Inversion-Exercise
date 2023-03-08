
package spellcheck;

import java.io.IOException;
import java.util.SortedMap;


public class Main {

	public static void main(String[] args) {
	
		try {
			DocumentSource documentSource = new URLDocumentSource();
			DocumentExtractor documentExtractor = new PlainTextExtractor();
			Dictionary dictionary = new TextFileDictionary("dict.txt");
			SpellingChecker checker = new SpellingChecker(documentSource, documentExtractor, dictionary);
			SortedMap<String, Integer> mistakes = checker.check(args[0]);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

