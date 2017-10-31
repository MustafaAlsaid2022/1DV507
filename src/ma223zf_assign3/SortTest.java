package ma223zf_assign3;

import org.junit.Test; // Support for JUnit annotations (e.g. @Test)
import static org.junit.Assert.*; // Make static Assert methods available

import java.util.Arrays;
import java.util.Comparator;
//import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;

public class SortTest {
	private static int test_count = 0;

	/* Is executed before every test method (not test case). */
	@Before
	public void setUp() {
		test_count++;
		System.out.println("Test " + test_count);
	}

	/* Is executed after every test method (not test case). */
	@After
	public void tearDown() {
	}

	@Test
	public void testInsertionSortIntArray() {
		int[] intarr = { 1, 2, 1, 0, -22, 4, 9, 8 };
		int[] newIntarr = SortingAlgorithms.insertionSort(intarr);
		assertEquals("[-22, 0, 1, 1, 2, 4, 8, 9]", Arrays.toString(newIntarr));
		int[] intarr2 = { 1 };
		int[] newIntarr2 = SortingAlgorithms.insertionSort(intarr2);
		assertEquals("[1]", Arrays.toString(newIntarr2));
		int[] intarr3 = { 1,1,1,1,1 };
		int[] newIntarr3 = SortingAlgorithms.insertionSort(intarr3);
		assertEquals("[1, 1, 1, 1, 1]", Arrays.toString(newIntarr3));

	}

	@Test
	public void testMergeSortIntArray() {
		int[] intarr = { 1, 2, 1, 0, -22, 4, 9, 8 };
		int[] newIntarr = SortingAlgorithms.insertionSort(intarr);
		assertEquals("[-22, 0, 1, 1, 2, 4, 8, 9]", Arrays.toString(newIntarr));
		int[] intarr2 = { 1 };
		int[] newIntarr2 = SortingAlgorithms.insertionSort(intarr2);
		assertEquals("[1]", Arrays.toString(newIntarr2));
		int[] intarr3 = { 1,1,1,1,1 };
		int[] newIntarr3 = SortingAlgorithms.insertionSort(intarr3);
		assertEquals("[1, 1, 1, 1, 1]", Arrays.toString(newIntarr3));

	}

	@Test
	public void testInsertionSortStringArrayComparatorOfString() {
		String[] strarr = { "orange", "banana", "apple", "pear", "beach" };
		Comparator<String> c = String::compareToIgnoreCase;
		String[] newIntarr = SortingAlgorithms.insertionSort(strarr, c);
		assertEquals("[apple, banana, beach, orange, pear]", Arrays.toString(newIntarr));
		String[] strarr2 = { "Orange", "Banana","banana", "apple", "pear", "beach" };
		String[] newIntarr2 = SortingAlgorithms.insertionSort(strarr2, c);
		assertEquals("[apple, Banana, banana, beach, Orange, pear]", Arrays.toString(newIntarr2));
		String[] strarr3 = { "Orange"};
		String[] newIntarr3 = SortingAlgorithms.insertionSort(strarr3, c);
		assertEquals("[Orange]", Arrays.toString(newIntarr3));
		String[] strarr4 = { "apple, apple, apple, beach"};
		String[] newIntarr4 = SortingAlgorithms.insertionSort(strarr4, c);
		assertEquals("[apple, apple, apple, beach]", Arrays.toString(newIntarr4));
	}

	@Test
	public void testMergeSortStringArrayComparatorOfString() {
		String[] strarr = { "orange", "banana", "apple", "pear", "beach" };
		Comparator<String> c = String::compareToIgnoreCase;
		String[] newIntarr = SortingAlgorithms.insertionSort(strarr, c);
		assertEquals("[apple, banana, beach, orange, pear]", Arrays.toString(newIntarr));
		String[] strarr2 = { "Orange", "Banana","banana", "apple", "pear", "beach" };
		String[] newIntarr2 = SortingAlgorithms.insertionSort(strarr2, c);
		assertEquals("[apple, Banana, banana, beach, Orange, pear]", Arrays.toString(newIntarr2));
		String[] strarr3 = { "Orange"};
		String[] newIntarr3 = SortingAlgorithms.insertionSort(strarr3, c);
		assertEquals("[Orange]", Arrays.toString(newIntarr3));
		String[] strarr4 = { "apple, apple, apple, beach"};
		String[] newIntarr4 = SortingAlgorithms.insertionSort(strarr4, c);
		assertEquals("[apple, apple, apple, beach]", Arrays.toString(newIntarr4));
	}

}
