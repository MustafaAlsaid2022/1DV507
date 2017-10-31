package ma223zf_assign2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements Queue interface
 * @author Mustafa Alsaid
 * @version 1.0
 *
 */


public class LinkedQueue implements Queue {
	private int size;
	private Node head;
	private Node tail;
/**
 * Returns an integer represent the size of the queue
 */
	@Override
	public int size() {
		return size;
	}
/**
 * Returns a string representation of the object. 
 * In general, the toString method returns a string that "textually represents" this object.
 * The result should be a concise but informative representation that is easy for a person to read.
 */
	@Override
	public String toString() {
		Node temp = head;
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		while (temp != null) {
			str.append(temp.value);
			
			temp = temp.next;
		}

		str.append(" ]");
		return str.toString();
	}
/**
 * Check if the queue is empty or it has elements in it.
 * Returns true if the queue is empty and false if not
 */
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
/**
 * Adds element at end of queue 
 */
	@Override
	public void enqueue(Object object) {
		if (head == null) { // Add first element//
			head = new Node(object);
			tail = head;
		} else {
			tail.next = new Node(object); // Attach new node//
			tail = tail.next; // Update tail//
		}
		size++; // increase size//
	}
/**
 * Returns and removes first element
 */
	@Override
	public Object dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node temp = head; // first node in index//
		head = head.next; // update head//
		size--; // decrease size//
		return temp.value;

	}
/**
 * Returns (without removing) first element
 */
	@Override
	public Object first() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.value;
	}
/**
 * Return (without removing) last element 
 */
	@Override
	public Object last() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.value;
	}
/**
 * Element iterator. Iterates through all elements of queue.
 */
	@Override
	public Iterator<Object> iterator() {

		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<Object> { //Inner iterator class//
		private Node node = head; // First node is head
		public Integer next() {
			if (!hasNext()) throw new NoSuchElementException();
			int val = (int) node.value; // Read current value
			node = node.next; // Move one step ahead
			return val;
		}
		public boolean hasNext() {
			return node != null;
		}
		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}

	private class Node {

		private Object value;
		private Node next;

		public Node(Object value) {
			this.value = value;
		}
	}

}
