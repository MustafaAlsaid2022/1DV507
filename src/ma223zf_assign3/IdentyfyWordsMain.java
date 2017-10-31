package ma223zf_assign3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IdentyfyWordsMain {

	public static void main(String[] args) {
		
		try { // Handle all IOExceptions at one point
		String text = readFile("C:\\java_courses\\1DV507\\src\\ma223zf_assign3\\HistoryOfProgramming.txt"); //Read from file//
		text=text.replaceAll("[^a-zA-Z ]", "");
		saveText(text ,"C:\\java_courses\\1DV507\\src\\ma223zf_assign3\\words.txt"); //Write to file//
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
		private static String readFile ( String path) throws IOException {
		StringBuilder text = new StringBuilder ();
		Scanner scan = new Scanner(new File(path)); //Might throw IOException//
		while (scan.hasNext())
		text.append(scan.nextLine());
		scan.close();
		return text.toString ();
		}
		private static void saveText(String text , String path) throws IOException {
		PrintWriter printer = new PrintWriter(new File(path)); // Might throw IOException
		printer.print (text); //Write to file//
		printer.close ();

	}

}
