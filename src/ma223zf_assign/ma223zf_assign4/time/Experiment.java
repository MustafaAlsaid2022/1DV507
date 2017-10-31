package time;

import java.util.NoSuchElementException;
import java.util.Random;

public class Experiment {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			integerInsertionSortMeasuring();
		}

		for (int i = 0; i < 5; i++) {
		    stringInsertionSortMeasuring();
		}

		for (int i = 0; i < 5; i++) {
		    integerMergeSortMeasuring();
		}

		for (int i = 0; i < 5; i++) {
			stringMergrSortMeasuring();
		}
		

	}

	public static void integerInsertionSortMeasuring() {
		int[] arr = randomIntegers(10000, 100000);
		int runTime = 0;
		while (runTime <= 1000) {
			long start = System.currentTimeMillis();
			integerInsertionSort(arr);
			long end = System.currentTimeMillis();
			runTime = (int) (end - start);
			
			System.out.println("Approximate time: " + runTime + " milliseconds." + " Total length: " + arr.length);
			
				/* To get accurate result */
				if (runTime == 999 || runTime == 1000 || runTime == 1001) {
					break;
				} else if (runTime > 1001 && runTime <= 1050) {
					arr = randomIntegers(arr.length - 1, arr.length * 10);
					runTime = 0;
				} else if (runTime > 1050) {
					arr = randomIntegers(arr.length - 1000, arr.length * 10);
					runTime = 0;
				} else if (runTime <= 950) {
					arr = randomIntegers(arr.length + 1000, arr.length * 10);
					runTime = 0;
				} else {
					
					arr = randomIntegers(arr.length + 1, arr.length * 10);
			}
		}
	}

	public static void stringInsertionSortMeasuring() {
		String [] arr = randomString(1000);
		int runTime = 0;
		while (runTime <= 1000) {
			long start = System.currentTimeMillis();
			stringInsertionSort(arr);
			long end = System.currentTimeMillis();
			runTime = (int) (end - start);
			
			System.out.println("Approximate time: " + runTime + " milliseconds." + " Total length: " + arr.length);
			
				/* To get accurate result */
				if (runTime == 999 || runTime == 1000 || runTime == 1001) {
					break;
				} else if (runTime > 1001 && runTime <= 1050) {
					arr = randomString(arr.length - 1);
					runTime = 0;
				} else if (runTime > 1050) {
					arr = randomString(arr.length - 100);
					runTime = 0;
				} else if (runTime <= 950) {
					arr = randomString(arr.length + 100);
					runTime = 0;
				} else {
					
					arr = randomString(arr.length + 1);
				}
			}
	}
	
	public static void integerMergeSortMeasuring() {
		int[] arr = randomIntegers(100000, 1000000);
		int runTime = 0;
		while (runTime <= 1000) {
			long start = System.currentTimeMillis();
			integerMergeSort(arr);
			long end = System.currentTimeMillis();
			runTime = (int) (end - start);
			
			System.out.println("Approximate time: " + runTime + " milliseconds." + " Total length: " + arr.length);
			
				/* To get accurate result */
				if (runTime == 999 || runTime == 1000 || runTime == 1001) {
					break;
				} else if (runTime > 1001 && runTime <= 1050) {
					arr = randomIntegers(arr.length - 1, arr.length * 10);
					runTime = 0;
				} else if (runTime > 1050) {
					arr = randomIntegers(arr.length - 1000, arr.length * 10);
					runTime = 0;
				} else if (runTime <= 950) {
					arr = randomIntegers(arr.length + 10000, arr.length * 10);
					runTime = 0;
				} else {
					
					arr = randomIntegers(arr.length + 1, arr.length * 10);
				}
			}
	}
	
	public static void stringMergrSortMeasuring() {
		String [] arr = randomString(100000);
		int runTime = 0;
		while (runTime <= 1000) {
			long start = System.currentTimeMillis();
			stringMergeSort(arr);
			long end = System.currentTimeMillis();
			runTime = (int) (end - start);
			
			System.out.println("Approximate time: " + runTime + " milliseconds." + " Total length: " + arr.length);
			
				/* To get accurate result */
				if (runTime == 999 || runTime == 1000 || runTime == 1001) {
					break;
				} else if (runTime > 1001 && runTime <= 1050) {
					arr = randomString(arr.length - 1);
					runTime = 0;
				} else if (runTime > 1050) {
					arr = randomString(arr.length - 100);
					runTime = 0;
				} else if (runTime <= 950) {
					arr = randomString(arr.length + 10000);
					runTime = 0;
				} else {
					
					arr = randomString(arr.length + 1);
				}
			}
	}
	
	public static int[] integerInsertionSort(int[] in) {
		int[] out = new int[in.length]; //create new array//
		System.arraycopy(in, 0, out, 0, in.length);

		//outer loop for going through each element//
		for (int i = 1; i < out.length; i++) {
			int key = out[i];
			int j = i - 1;
			// insertion and swapping//
			while (j >= 0 && out[j] > key) {
				out[j + 1] = out[j];
				j--;
			}
			out[j + 1] = key;
		}
		return out;

	}

	public static String[] stringInsertionSort(String[] in) {
		String[] out = new String[in.length]; //create new array//
		System.arraycopy(in, 0, out, 0, in.length); //copy the contents of in to the new array//
		
		// outer loop for going through each element//
		for (int i = 1; i < out.length; i++) {
			String key = out[i]; // c.compare(a[j], v)
			int j = i - 1;
			// insertion and swapping by comparing each string//
			while (j >= 0) {
				if (out[j].compareToIgnoreCase(key) <= 0)
					break;
				out[j + 1] = out[j];
				j--;
			}
			out[j + 1] = key;
		}
		return out;
	}

	public static int[] integerMergeSort(int[] in) {
		int mid = in.length / 2; // find the midpoint in array//
		int[] leftarr = new int[mid]; // create new array has the half length of
										// the original array and it represent
										// the left side//
		int[] rightarr = new int[in.length - mid]; // create new array has the
													// rest length of the
													// original array and it
													// represent the right
													// side//
		System.arraycopy(in, 0, leftarr, 0, leftarr.length); // copy the content
																// of original
																// array from 0
																// to
																// midpoint-1//
		System.arraycopy(in, mid, rightarr, 0, rightarr.length); // copy the
																	// content
																	// from
																	// midpoint
																	// to the
																	// end index
																	// of
																	// original
																	// one//
		if (in.length == 1) { // if array length is 1 return it//
			return in;
		}
		rightarr = integerMergeSort(rightarr); // recursive merge sort for right array//
		leftarr = integerMergeSort(leftarr); // recursive merge sort for left array to
										// get smaller arrays till 1 element//
		return mergeIntegerArray(leftarr, rightarr); // recursive merge left and right
											// arrays get smaller arrays till 1 element//
	}

	public static int[] mergeIntegerArray(int[] leftarr, int[] rightarr) { //doing merge//
		int[] arr = new int[leftarr.length + rightarr.length]; //new array//
		int tempLeft = 0;
		int tempRight = 0;
		int tempOut = 0;
		while (tempLeft < leftarr.length && tempRight < rightarr.length) { //insert the content from smaller value to larger//
			if (leftarr[tempLeft] <= rightarr[tempRight]) {
				arr[tempOut++] = leftarr[tempLeft++];
			} else {
				arr[tempOut++] = rightarr[tempRight++];
			}
		}
		// if one of two arrays have more values after comparing we just add it as it to the big array arr//
		while (tempLeft < leftarr.length) {
			arr[tempOut++] = leftarr[tempLeft++];
		}
		while (tempRight < rightarr.length) {
			arr[tempOut++] = rightarr[tempRight++];
		}
		return arr;
	}

	public static String[] stringMergeSort(String[] in) {
		int mid = in.length / 2; //find the midpoint in array//
		String[] leftarr = new String[mid]; //create new array has the half length of the original array and it represent the left side//
		String[] rightarr = new String[in.length - mid];// create new array has the rest length of the original array and it represent the right side//
		System.arraycopy(in, 0, leftarr, 0, leftarr.length); //copy the content of original array from 0 to midpoint-1//
		System.arraycopy(in, mid, rightarr, 0, rightarr.length); //copy the content from midpoint to the end index of original one//
		if (in.length == 1) {
			return in;
		}
		rightarr = stringMergeSort(rightarr); //recursive merge sort for right array//
		leftarr = stringMergeSort(leftarr); //recursive merge sort for left array//
		return mergeStringArray(leftarr, rightarr); //recursive merge left and right arrays//
	}

	public static String[] mergeStringArray(String[] leftarr, String[] rightarr) { //the same as mergeintarray//
		String[] arr = new String[leftarr.length + rightarr.length];
		if (arr.length == 0) {
			throw new NoSuchElementException();
		}
		int tempLeft = 0;
		int tempRight = 0;
		int tempOut = 0;
		while (tempLeft < leftarr.length && tempRight < rightarr.length) {
			if (leftarr[tempLeft].compareToIgnoreCase(rightarr[tempRight]) < 0) { // comparing
																		// to
																		// string
																		// which
																		// one
																		// first//
				arr[tempOut++] = leftarr[tempLeft++];
			} else {
				arr[tempOut++] = rightarr[tempRight++];
			}
		}
		while (tempLeft < leftarr.length) {
			arr[tempOut++] = leftarr[tempLeft++];
		}
		while (tempRight < rightarr.length) {
			arr[tempOut++] = rightarr[tempRight++];
		}
		return arr;
	}

	private static int[] randomIntegers(int length, int max) { //private method to creat random numbers and add them to a array//
		/* Setup random generator */
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		/* Add random numbers modulus max */
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = rand.nextInt() % max;
		}
		return arr;
	}

	private static String[] randomString(int length) {
		StringBuilder stb;
		Random rand = new Random();
		String[] arr = new String[length];
		String ch = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		
		for(int i = 0; i < arr.length; i++) {
			stb= new StringBuilder();
			for(int j=0;j< 9;j++) {
				stb.append(ch.charAt(rand.nextInt(ch.length())));
				j++;
			}
			arr[i] = stb.toString();
		}
		return arr;
	}
}
