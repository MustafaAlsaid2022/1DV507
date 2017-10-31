package ma223zf_assign3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashWordSet implements WordSet {

	private int sz; // Current size //
	private Node[] buckets = new Node[8];

	//constructor//
	public HashWordSet() {
		sz = 0; // initial size 0//
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		for (int i = 0; i < buckets.length; i++) {
			Node node = buckets[i];
			while (node != null) {
				str.append(node.value + " ");
				node = node.next;
			}
		}
		str.append(" ]");
		return str.toString(); //to string//
	}

	@Override
	public void add(Word word) {
		int pos = getBucketNumber(word);
		Node node = buckets[pos]; //First node in list//
		while (node != null) { //Search list//
			if (node.value.equals(word))
				return; // Element found ==> return//
			else
				node = node.next; // Next node in list//
		}
		node = new Node(word); // Not found, add new node as rst entry //
		node.next = buckets[pos];
		buckets[pos] = node;
		sz++;
		if (sz == buckets.length) {
			rehash(); // Rehash if needed //
		}

	}

	@Override
	public boolean contains(Word word) {
		int pos = getBucketNumber(word);
		Node node = buckets[pos];
		while (node != null) {// Search list for element //
			if (node.value.equals(word))
				return true; // Found //
			else
				node = node.next;
		}
		return false; // Not found //

	}

	@Override
	public int size() {

		return sz;
	}

	@Override
	public Iterator<Word> iterator() {

		return new HashWordSetIterator();
	}

	private class HashWordSetIterator implements Iterator<Word> { // Inner
																	// iterator
																	// class//
		int count = 0;
		Node node = null;

		@Override
		public Word next() {

			if (node != null && node.next != null) {
				node = node.next;
			} else {
				do {
					if (count == buckets.length) {
						throw new NoSuchElementException();
					}
					node = buckets[count++];
				} while (node != null);
			}
			return node.value;

		}

		@Override
		public boolean hasNext() {
			for (int i = count; i < buckets.length; i++) {
				if (buckets[i] != null) {
					return true;
				}
			}
			return false;
		}

	}

	private class Node { // Private inner classes
		Word value;
		Node next = null;

		public Node(Word w) {
			value = w;
		}

		public String toString() {
			return value.toString();
		}
	}

	private int getBucketNumber(Word w) {
		int hc = w.hashCode(); // Use hashCode() from String class //
		if (hc < 0)
			hc = -hc; // Make sure non negative //
		return hc % buckets.length; // Simple hash function //
	}

	private void rehash() {
		Node[] temp = buckets; // Copy of old buckets //
		buckets = new Node[2 * temp.length]; // New empty buckets //
		sz = 0;
		for (Node n : temp) { // Insert old values into new buckets //
			if (n == null)
				continue; // Empty bucket //
			while (n != null) {
				add(n.value); // Add elements again //
				n = n.next;
			}
		}
	}
}
