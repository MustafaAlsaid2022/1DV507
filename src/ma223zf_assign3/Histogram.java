package ma223zf_assign3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Histogram {

	/* Fields */
	private String filePath = "";
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private int[] array = new int[11];
	private String[] arr = new String[11];
	private int count = 0;
	private String read = "";

	/* Constructor */
	public Histogram() {

	}

	public Histogram(String path) {
		filePath = path;
	}

	/* Getter and setters */
	public void setPath(String path) {
		filePath = path;
	}

	public String getFilePath() {
		return filePath;
	}

	/* Check if file exists */
	public boolean checkIfFileExists() {
		File file = new File(filePath);
		if (file.exists()) {
			return true;
		}
		return false;
	}

	public void readFileText() throws FileNotFoundException {
		try {
			File number = new File(filePath);
			Scanner scan = new Scanner(number);

			while (scan.hasNext()) {
				list.add(scan.nextInt()); // store numbers in array list list//
			}
			/* count how many numbers from 1 to 100 */
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i) >= 1 && list.get(i) <= 100) {
					count++;
				}
			}
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j <= 9; j++) { //  store number from 1-10 11-20 to 91-100 in array//
					if (list.get(i) >= (j * 10 + 1) && list.get(i) <= (j * 10 + 10)) {
						array[j] += 1;
					}
				}
			}
			array[10] = list.size() - count;
			for (int i = 0; i <= 9; ++i) { // store number groups format 1-10 to  91-100 in arr//
				arr[i] = (i * 10 + 1) + "-" + (i * 10 + 10);
			}
			arr[10] = "other";
			scan.close();
		} catch (IOException e) {

		}
	}

	public int[] getValue() {
		return array;
	}
	public String [] getFormat(){
		return arr;
	}

	/* Check if file is correct for bar chart */
	public boolean check() throws FileNotFoundException {
		File file = new File(filePath);
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			read = read + scan.nextLine();
		}
		scan.close();
		for (int i = 0; i < read.length(); i++) {
			char c = read.charAt(i);
			if (!Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

}
