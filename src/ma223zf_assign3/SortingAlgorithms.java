package ma223zf_assign3;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortingAlgorithms {

	public static int[] insertionSort(int[] in) {
		int[] out = new int[in.length]; // create new array//
		for (int value = 0; value < in.length; value++) {
			out[value] = in[value]; // copy the contents of in to the new
									// array//
		}
		// outer loop for going through each element//
		for (int i =  1; i < out.length; i++) {
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

	public static int[] mergeSort(int[] in) {
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
		rightarr = mergeSort(rightarr); // recursive merge sort for right array//
		leftarr = mergeSort(leftarr); //recursive merge sort for left array to get smaller arrays till 1 element//
		return merge(leftarr, rightarr);  //recursive merge left and right arrays get smaller arrays till 1 elemen//
	}

	public static int[] merge(int[] leftarr, int[] rightarr) { // doing merge//
		int[] arr = new int[leftarr.length + rightarr.length]; // new array//
		int tempLeft = 0;
		int tempRight = 0;
		int tempOut = 0;
		while (tempLeft < leftarr.length && tempRight < rightarr.length) { // insert
																			// the
																			// content
																			// from
																			// smaller
																			// value
																			// to
																			// larger//
			if (leftarr[tempLeft] <= rightarr[tempRight]) {
				arr[tempOut++] = leftarr[tempLeft++];
			} else {
				arr[tempOut++] = rightarr[tempRight++];
			}
		}
		// if one of two arrays have more values after comparing we just add it
		// as it to the big array arr//
		while (tempLeft < leftarr.length) {
			arr[tempOut++] = leftarr[tempLeft++];
		}
		while (tempRight < rightarr.length) {
			arr[tempOut++] = rightarr[tempRight++];
		}
		return arr;
	}

	public static String[] insertionSort(String[] in, Comparator<String> c) {
		String[] out = new String[in.length]; // create new array//
		for (int value = 0; value < in.length; value++) { // copy the contents
															// of in to the new
															// array//
			out[value] = in[value];
		}
		// outer loop for going through each element//
		for (int i = 1; i < out.length; i++) {
			String key = out[i]; // c.compare(a[j], v)
			int j = i - 1;
			// insertion and swapping by comparing each string//
			while (j >= 0) {
				if (c.compare(out[j], key) <= 0)
					break;
				out[j + 1] = out[j];
				j--;
			}
			out[j + 1] = key;
		}
		return out;
	}

	public static String[] mergeSort(String[] in, Comparator<String> c) {
		int mid = in.length / 2; // find the midpoint in array//
		String[] leftarr = new String[mid]; // create new array has the half
											// length of the original array and
											// it represent the left side//
		String[] rightarr = new String[in.length - mid];// create new array has
														// the rest length of
														// the original array
														// and it represent the
														// right side//
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
		if (in.length == 1) {
			return in;
		}
		rightarr = mergeSort(rightarr, c); // recursive merge sort for right array//
		leftarr = mergeSort(leftarr, c); // recursive merge sort for left array//
		return mergeStringArray(leftarr, rightarr);  //recursive merge left and right arrays//
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
			if (leftarr[tempLeft].compareTo(rightarr[tempRight]) < 0) { //comparing to string which one first//
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

}
