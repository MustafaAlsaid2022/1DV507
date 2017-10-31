package ma223zf_assign3;

import java.util.Arrays;
import java.util.Comparator;

public class SortingAlgorithmsMain {
	
	public static void main(String[] args) {
		
		int[] arr = { 2, 5, 1, 0, 8, 6, 4, 3 };
		int[] newarr = SortingAlgorithms.insertionSort(arr);
		System.out.println("unsorted int array: "+Arrays.toString(arr));
		System.out.println("sorted int array by insertion sort: "+Arrays.toString(newarr));
		
		int[] mergeSortInt = SortingAlgorithms.mergeSort(arr);
		System.out.println("unsorted array: "+Arrays.toString(arr));
		System.out.println("sorted int array by merge sort: "+Arrays.toString(mergeSortInt));
		
		String [] str={"programing","trigonometry","network","security","java"};
		Comparator<String> c = String::compareToIgnoreCase;
		String [] stout=SortingAlgorithms.insertionSort(str,c);
		System.out.println("unsorted String array: "+Arrays.toString(str));
		System.out.println("sorted String array by insertion sort: "+Arrays.toString(stout));
		
		String [] string={"programing","trigonometry","network","security","java","object"};
		String [] mergeSortStr=SortingAlgorithms.mergeSort(string,c);
		System.out.println("unsorted String array: "+Arrays.toString(string));
		System.out.println("sorted String array by merge sort: "+Arrays.toString(mergeSortStr));
	}


}
