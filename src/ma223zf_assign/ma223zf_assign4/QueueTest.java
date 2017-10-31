package ma223zf_assign4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueTest {

	Queue<Integer> queue = new LinkedQueue<Integer>(); 
	Queue <String> stringQueue = new LinkedQueue<String>();
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
		assertEquals(0, stringQueue.size());
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

		assertEquals("[ 8 5 4 22 22 0 ]", queue.toString());
		
		stringQueue.enqueue("a");
		stringQueue.enqueue("b");
		stringQueue.enqueue("x");
		stringQueue.enqueue("y");
		stringQueue.dequeue();
		stringQueue.enqueue("i");
		stringQueue.dequeue();
		stringQueue.enqueue("f");
		
		assertEquals("[ x y i f ]", stringQueue.toString());
		
		
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.enqueue(5);
		assertTrue(!queue.isEmpty());
		
		assertTrue (stringQueue.isEmpty());
		stringQueue.enqueue("hi");
		assertTrue(!stringQueue.isEmpty());
		
	}

	@Test
	public void testEnqueue() {
		queue.enqueue(5); // test enqueue for integers//
		LinkedQueue<Integer> queue1 = build(5); // test enqueue using build method//
		assertEquals(5, queue1.size());
		LinkedQueue<Integer> queue2 = build(10);
		assertEquals(10, queue2.size());
		
		stringQueue.enqueue("hi"); //test enqueue for string//
		LinkedQueue<String> queue3= buildString(5);
		assertEquals(5, queue3.size());
		LinkedQueue<String> queue4 = buildString(10);
		assertEquals(10, queue4.size());
		
	}

	@Test
	public void testDequeue() { 
		queue.enqueue(8); //test dequeue method for integers//
		int x= queue.dequeue();
		assertEquals(8, x);
		
		stringQueue.enqueue("queue"); //test dequeue method for string//
		String y=stringQueue.dequeue();
		assertEquals("queue", y);
	}

	@Test
	public void testFirst() {
		queue.enqueue(2);
		queue.enqueue(1);
		assertEquals(2,(int)queue.first());
		
		stringQueue.enqueue("queue");
		stringQueue.enqueue("list");
		assertEquals("queue", stringQueue.first());
	}

	@Test
	public void testLast() {
		queue.enqueue(2);
		queue.enqueue(1);
		queue.enqueue(8);
		assertEquals((int)queue.last(), 8);
		
		stringQueue.enqueue("queue");
		stringQueue.enqueue("list");
		assertEquals("list", stringQueue.last());
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

		Iterator<Integer> itr = queue.iterator();
		assertTrue(itr.hasNext());
		
		stringQueue.enqueue("a");
		stringQueue.enqueue("b");
		stringQueue.enqueue("x");
		stringQueue.enqueue("y");
		stringQueue.dequeue();
		stringQueue.enqueue("i");
		stringQueue.dequeue();
		stringQueue.enqueue("f");
		
		Iterator<String> itrSt = stringQueue.iterator();
		assertTrue(itrSt.hasNext());
		
	}

	public final void testHasNex() throws NoSuchElementException {
		Iterator<Integer> itr = queue.iterator();
		assertFalse(itr.hasNext());
		
		Iterator<String> itrSt = stringQueue.iterator();
		assertFalse(itrSt.hasNext());
		
	}

	private LinkedQueue<Integer> build(int size) {
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		
		for (int i = 0; i < size; i++)
			queue.enqueue(i);
		return queue;
	}
	
	private LinkedQueue<String> buildString(int size) {
		LinkedQueue<String> stringQueue = new LinkedQueue<String>();
		
		for (int i = 0; i < size; i++)
			stringQueue.enqueue("hi");
		return stringQueue;
	}

	@Test(expected = NoSuchElementException.class)
	public void testDequeueOnEmpty() {
		queue.dequeue();
		stringQueue.dequeue();
	}

	@Test(expected = NoSuchElementException.class)
	public void testDequeueOnEmptyQueue() {
		assertTrue(queue.isEmpty());
		queue.dequeue();
		stringQueue.dequeue();
	}

	

}
