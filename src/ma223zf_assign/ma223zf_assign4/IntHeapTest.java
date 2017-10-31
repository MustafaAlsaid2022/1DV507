package ma223zf_assign4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Random;

public class IntHeapTest {

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
	public void testToString() {
		BinaryIntHeap empty = new BinaryIntHeap();
		assertEquals(0, empty.size());
		assertEquals("[ ]", empty.toString());

		BinaryIntHeap one = new BinaryIntHeap();
		one.insert(234);
		assertEquals(1, one.size());
		assertEquals("[ 234 ]", one.toString());

		/* Test using random() */
		BinaryIntHeap heap = random(20, 100);
		System.out.println(heap);

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(null); // first index will not be used//

		String str = heap.toString(); // convert heap to string//
		str = str.replaceAll("[^1-9--1--9 ]", ""); // remove all not digit of
													// string content//
		for (String s : str.split(" ")) { // split the content by whitespace//
			try {
				int n = Integer.parseInt(s); // convert to integer//
				list.add(n); // add the integers to the list//
			} catch (NumberFormatException e) { // handle exception for number
												// format//

			}
		}
		for (int i = 1; i <= list.size(); i++) { // Verify larger value for
													// parents//
			if (i * 2 < list.size() && i * 2 + 1 < list.size()) {
				assertTrue(list.get(i) >= list.get(2 * i));
				assertTrue(list.get(i) >= list.get(2 * i + 1));
			}
		}
	}

	/* Check size */
	@Test
	public void testSize() {
		BinaryIntHeap heap = new BinaryIntHeap();
		assertEquals(0, heap.size()); // size is zero//
		for (int i = 0; i < 1000; i++) { // size is not zero//
			heap.insert(i);
			assertEquals(i + 1, heap.size());

		}
		assertEquals(1000, heap.size()); // size is 1000//
	}

	@Test
	public void testInsert() {

		BinaryIntHeap heap = new BinaryIntHeap();
		assertEquals(0, heap.size()); // size is zero nothing inserted//
		heap.insert(10); // one element inserted//
		System.out.println(heap.toString() + " size = " + heap.size());
		heap.pullHighest(); // remove and return the element//
		System.out.println(heap.toString() + " size = " + heap.size());
		heap = random(100, 1000);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(null); // first index will not be used//

		String str = heap.toString(); // convert heap to string//
		str = str.replaceAll("[^1-9--1--9 ]", ""); // remove all not digit of
													// string content//
		for (String s : str.split(" ")) { // split the content by whitespace//
			try {
				int n = Integer.parseInt(s); // convert to integer//
				list.add(n); // add the integers to the list//
			} catch (NumberFormatException e) { // handle exception for number
												// format//

			}
		}
		System.out.println("size of list as heap is: " + (list.size() - 1)); //number of elements in the list equal size elements of heap//
		System.out.print("[ ");
		for (int i = 1; i < list.size(); i++) { // print list elements//
			System.out.print(list.get(i) + " ");
		}
		System.out.println("]");
		System.out.println(heap.toString()); // you can see that list and heap
												// are similar//
		for (int i = 1; i <= list.size(); i++) { // Verify larger value for
													// parents//
			if (i * 2 < list.size() && i * 2 + 1 < list.size()) {
				assertTrue(list.get(i) >= list.get(2 * i));
				assertTrue(list.get(i) >= list.get(2 * i + 1));
			}
		}
	}

	@Test
	public void testIsEmpty() {
		BinaryIntHeap heap = new BinaryIntHeap();
		assertEquals(true, heap.isEmpty()); // heap is empty//
		heap.insert(2); // add an element to heap//
		assertEquals(false, heap.isEmpty()); // heap is not empty//
		heap.pullHighest(); // remove an element//
		assertEquals(true, heap.isEmpty()); // heap is empty//
		heap = random(100, 1000);
		// System.out.println(heap);
		assertEquals(false, heap.isEmpty()); // heap is not empty//
	}

	@Test
	public void testPullHighest() {
		BinaryIntHeap heap = new BinaryIntHeap();

		for (int i = 0; i < 1000; i++) { //insert 1000 elements//
			heap.insert(i);
		}
		
		for (int i = 999; i >= 0; i--) { //check if the highest values are removed. integer 999 will be the first one//
			assertEquals(i, heap.pullHighest());
		}

		//Check if throw error when queue is empty//
		boolean x = false;
		try {
			heap.pullHighest();
		} catch (IllegalArgumentException e) {
			x = true;
		}
		assertTrue(x);

	}

	private BinaryIntHeap random(int size, int max) { //private method to create random numbers and add them to a heap//
		/* Setup random generator */
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		/* Add random numbers modulus max */
		BinaryIntHeap heap = new BinaryIntHeap();
		for (int i = 0; i < size; i++) {
			int n = rand.nextInt() % max;
			heap.insert(n);
		}
		return heap;
	}

}
