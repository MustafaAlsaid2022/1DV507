package ma223zf_assign4;

import java.util.Iterator;
import java.util.NoSuchElementException;





public class LinkedQueue<T> implements Queue<T> {
	
	public LinkedQueue(){
		
	}
	
	private int size;
	private Node head;
	private Node tail;

	@Override
	public int size() { //return the size of queue//
		
		return size;
	}
	
	@Override
	 public String toString(){
		Node temp = head;
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		while (temp != null) {
			str.append(temp.value+" ");
			
			temp = temp.next;
		}

		str.append("]");
		return str.toString();
	 }

	@Override
	public boolean isEmpty() { //check if the linkedQueue is empty//
		
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void enqueue(T t) {
		if (head == null) { //Add first element//
			head = new Node(t);
			tail = head;
		} else {
			tail.next = new Node(t); // Attach new node//
			tail = tail.next; // Update tail//
		}
		size++; // increase size//
		
		
	}

	@Override
	public T dequeue() {
		
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node temp = head; // first node in index//
		head = head.next; // update head//
		size--; // decrease size//
		return temp.value;
	}

	@Override
	public T first() {
	
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.value;
	}

	@Override
	public T last() {
		
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.value;
	}
	
	private class Node {

		private T value;
		private Node next;

		public Node(T value) {
			this.value = value;
		}
	}

	@Override
	public Iterator<T> iterator() {
	
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements Iterator<T> { //Inner iterator class//
		private Node node = head; // First node is head
		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			T val = node.value; // Read current value
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

}
