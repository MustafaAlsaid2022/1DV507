package ma223zf_assign2;

import org.junit.Test; // Support for JUnit annotations (e.g. @Test)

import static org.junit.Assert.*; // Make static Assert methods available

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;

public class LinkedQueueTest {
	LinkedQueue queue = new LinkedQueue();// new LinkedQueue();
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
	public void testSize() {

		assertEquals(0, queue.size());
	}

	@Test
	public void testToString() {

		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(8);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(22);
		queue.enqueue(22);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(0);

		assertEquals("[ 85422220 ]", queue.toString());
		
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.enqueue(5);
		assertTrue(!queue.isEmpty());
	}

	@Test
	public void testEnqueue() {
		queue.enqueue(5); // test enqueue//
		LinkedQueue queue1 = build(5); // test enqueue using build method//
		assertEquals(5, queue1.size());
		LinkedQueue queue2 = build(10);
		assertEquals(10, queue2.size());
	}

	@Test
	public void testDequeue() { 
		queue.enqueue(8); //test dequeue method//
		assertEquals(queue.dequeue(), 8);
	}

	@Test
	public void testFirst() {
		queue.enqueue(2);
		queue.enqueue(1);
		assertEquals(2, queue.first());
	}

	@Test
	public void testLast() {
		queue.enqueue(2);
		queue.enqueue(1);
		queue.enqueue(8);
		assertEquals(queue.last(), 8);
	}

	@Test
	public void testIterator() {
		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(8);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(22);
		queue.enqueue(22);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(0);

		Iterator<Object> itr = queue.iterator();
		assertTrue(itr.hasNext());
		;
	}
	@Test
	public final void testHasNex() throws NoSuchElementException {
		Iterator<Object> itr = queue.iterator();
		assertFalse(itr.hasNext());
	}

	private LinkedQueue build(int size) {
		LinkedQueue queue = new LinkedQueue();
		
		for (int i = 0; i < size; i++)
			queue.enqueue(i);
		return queue;
	}

	@Test(expected = NoSuchElementException.class)
	public void testDequeueOnEmpty() {
		queue.dequeue();
	}

	@Test(expected = NoSuchElementException.class)
	public void testDequeueOnEmptyQueue() {
		assertTrue(queue.isEmpty());
		queue.dequeue();
	}

}
