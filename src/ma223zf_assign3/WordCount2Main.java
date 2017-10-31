package ma223zf_assign3;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCount2Main {

	public static void main(String[] args) {
		HashWordSet hashSet = new HashWordSet();
		TreeWordSet treeSet = new TreeWordSet();
		try {
			String text = (readFile("C:\\java_courses\\1DV507\\src\\ma223zf_assign3\\words.txt"));
			for (String str : text.split(" ")) {
				Word obj1 = new Word(str.toLowerCase());
				
					hashSet.add(obj1);
					treeSet.add(obj1);
				
				}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator <Word>itr = hashSet.iterator();
    	System.out.print("the hashset elements: ");
        while(itr.hasNext())
        System.out.print(itr.next() + " ");
        System.out.println();
        System.out.println(hashSet.toString());
        System.out.println("hashset size: "+hashSet.size());
        
        Iterator <Word>it = treeSet.iterator();
    	System.out.print("the treeset elements: ");
        while(it.hasNext())
        System.out.print(it.next() + " ");
        System.out.println();
        System.out.println(treeSet.toString());
        System.out.println("treeset size: "+treeSet.size());
        

		
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
