package ma223zf_assign3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class WordCount1Main {
	static Set<Word> hashSet = new HashSet<Word>(); // empty set//
	static Set<Word> treeSet = new TreeSet<Word>(); // empty set//

	public static void main(String[] args) {
		try {
			String text = (readFile("C:\\java_courses\\1DV507\\src\\ma223zf_assign3\\words.txt"));
			for (String str : text.split(" ")) {
				Word obj1 = new Word(str.toLowerCase());
				//!hashSet.contains(obj1.getWord().toLowerCase()))
				hashSet.add(obj1);
				treeSet.add(obj1);
				
			}

			System.out.println(hashSet.toString());
			System.out.println(treeSet.toString());
			System.out.println("hashset size: " + hashSet.size());
			System.out.println("treeset size: " + treeSet.size());
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String readFile(String path) throws IOException {
		StringBuilder text = new StringBuilder();
		Scanner scan = new Scanner(new File(path)); // Might throw IOException//
		while (scan.hasNext())
			text.append(scan.nextLine() + " ");
		scan.close();
		return text.toString();
	}

}
