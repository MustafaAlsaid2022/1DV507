package ma223zf_assign1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class WarAndPeace {

	public static void main(String[] args) throws IOException {
		
		String text = readText("C:\\java_courses\\1DV507\\src\\ma223zf_assign1\\WarAndPeace.txt");
		text=text.replaceAll("[^a-zA-Z ]", ""); //keep only whitespace and letters a-zA-Z//
		String[] words = text.split(" ");  //Simple split, will be cleaned up later on//
		System.out.println("Initial word count: "+words.length);   
	    //Stream <String> s = Arrays.stream(words).distinct();
		List<String> wordstream = Arrays.asList(words);	
		long counterStream = wordstream.stream().map(String::toLowerCase).distinct().count(); //convert to lower case and after that count the unique word//
		System.out.println("Number of unique words:" + counterStream);
	}

	private static String readText(String path) throws IOException {
        StringBuilder contents = new StringBuilder(); //create string builder to store in it//
        Scanner scan = new Scanner(new File(path)); //scanner scan the text file//
        while(scan.hasNext()) { // while there are words//
        contents.append(scan.nextLine() + " "); //add to string builder//
        }
        scan.close();
        return contents.toString(); 
}

	
	
	
}
