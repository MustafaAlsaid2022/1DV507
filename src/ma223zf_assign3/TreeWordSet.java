package ma223zf_assign3;

import java.util.Iterator;

public class TreeWordSet implements WordSet {

	private Node root = null;
	private int size; // Current size //
	private Word[] arr = new Word[8];
	private int index = 0;

	// constructor//
	public TreeWordSet() {
		size = 0; // initial size 0//
	}

	@Override
	public String toString() {
		return "["+root.print()+ "]";
	}

	@Override
	public void add(Word word) {

		if (root == null){
			root = new Node(word); 
		size++;
		}		else
			root.add(word);
		
	}

	@Override
	public boolean contains(Word word) {

		return root.contains(word);
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public Iterator<Word> iterator() {

		return new TreeWordSetIterator();

	}

	private class TreeWordSetIterator implements Iterator<Word> { // Inner iterator class//
		int count = 0;

		public TreeWordSetIterator() {
			root.getWordArray(); // calling method to fill array
		}

		@Override
		public Word next() {

			return arr[count++];
		}

		@Override
		public boolean hasNext() {
			return count < arr.length && arr[count]!=null;
		}

	}

	private void resize() {
		Word[] tmp = new Word[2 * arr.length];
		System.arraycopy(arr, 0, tmp, 0, arr.length);
		arr = tmp;
	}

	private class Node { // Private inner classes//
		Word value;
		Node right = null;
		Node left = null;
		StringBuilder str = new StringBuilder();

		public Node(Word w) {
			value = w;
		}

		private void add(Word word) {
			if (word.compareTo(value) < 0) {
				if (left == null) {
					left = new Node(word);
					size++;
				} else
					left.add(word);

			} else if (word.compareTo(value) > 0) {
				if (right == null) {
					right = new Node(word);
					size++;
				} else
					right.add(word);
			}
		}

		boolean contains(Word word) { // recursive lookup//
			if (word.compareTo(value) < 0) { // search left branch//
				if (left == null)
					return false;
				else
					return left.contains(word);
			} else if (word.compareTo(value) > 0) { // search right branch//
				if (right == null)
					return false;
				else
					return right.contains(word);
			}
			return true; // Found//
		}

		private String print() {
			 if(left != null) // visit left child
				str.append(left.print());
			str.append(" " + value); // ascending order appened value
			 if(right != null) // visit right child
				str.append(right.print());
			return str.toString();
		}

		private Word[] getWordArray() {
			if (left != null)
				left.getWordArray();
			if (index == arr.length)
				resize();
			arr[index] = value;
			index++;
			if (right != null)
				right.getWordArray();
			return arr;
		}

	}

}
