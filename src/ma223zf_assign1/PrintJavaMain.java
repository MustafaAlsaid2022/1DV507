package ma223zf_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PrintJavaMain {

	public static void main(String[] args) throws IOException {
		/*read directory*/
		File startDir = new File("C:\\java_courses\\1DV506"); 
		if (startDir.exists())
			System.out.println("Start: " + startDir);
		else
			System.out.println("Can't find directory: " + startDir);
		visitSub(startDir);
	}

	private static int depth = 1;

	private static void visitSub(File file) throws FileNotFoundException {
		if (file.isDirectory()) {
			printDir(file);
			depth++;
			File[] subs = file.listFiles();
			for (File f : subs)
				visitSub(f); //recursion visitSub calls itself//
			depth--;
		} 
		else if (!file.isDirectory()) {
				if (file.getName().endsWith(".java")) { //print java files name//
					printFile(file); //
					Scanner scan = new Scanner(file);
					int count = 0; //count lines in each java file//
					while (scan.hasNextLine()) {
						count++;
						scan.nextLine();
					}
					System.out.println(" contains " + count + " lines");
					scan.close();
				}
			}
		}
	

	private static int count = 0;

	private static void printDir(File dir) { //Indented printing the directories//
		StringBuilder st = new StringBuilder();
		for (int i = 0; i < depth; i++)
			st.append("  ");

		System.out.println((++count) + st.toString() + dir.getName() + " Size of directory " + dir.length() + " byte");

	}

	private static void printFile(File file) { //Indented printing the files in the directory and subdirectories//
		StringBuilder st = new StringBuilder();
		for (int i = 0; i < depth; i++)
			st.append("  ");

		System.out.print((++count) + st.toString() + file.getName());

	}

}
