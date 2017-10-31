package ma223zf_assign4;

public class BinaryIntHeap {

	private int size; // Number of elements in heap
	private static int[] heap; // The heap array
	private int pos; // position of an element
	private int currentSize; //current size of heap//

	public BinaryIntHeap() { //Constructs an empty heap//
		pos = 1; 
		size = 8;
		currentSize = 0;
		heap = new int[size];
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		for (int i = 1; i <= currentSize; i++) {
			str.append(heap[i] + " ");
		}
		str.append("]");
		return str.toString();

	}

	public void insert(int n) { // Add n to heap

		if (pos == size)
			resize();

		// Insert a new item to the end of the array
		heap[pos] = n;
		pos++;
		currentSize++;

		int child = pos - 1;
		int parent = child / 2;
		// percolation up//
		while (heap[parent] < heap[child] && parent > 0) {
			int temp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = temp;

			child = parent;
			parent = child / 2;
		}
		/*
		 * for (int i = size; i > 1; i--) { if (heap[i] > heap[i - 1]) { int
		 * temp = heap[i]; heap[i] = heap[i - 1]; heap[i - 1] = temp; } }
		 */
	}

	public int pullHighest() { //Return and remove element with highest priority//
		int highest = 0; //initial value for highest value of heap elements//
		if (isEmpty()) {
			throw new IllegalArgumentException("Queue is Empty");
		}

		else if (currentSize == 1) {
			highest = heap[1];
			heap[1] = heap[0];
			currentSize--;
		} else {
			highest = heap[1];
			heap[1] = heap[size-1];
			percolatingDown();
			currentSize--;
		}
		return highest;
	}

	public int size() { //return current heap size//
		return currentSize;

	}

	public boolean isEmpty() { //true if heap is empty//
		return currentSize == 0;
	}

	private static void percolatingDown() {
		int k = 1;
		int left = 2 * k;
		while (left < heap.length) {
			int max = left;
			int right = left + 1;
			if (right < heap.length) { //right child exist//
				if (heap[right] > heap[left]) { //compare right and left child//
					max++; // max will refer to right child index//
				}
			}
			if (heap[k] < heap[max]) { //compare between parent k and max//
				int temp = heap[k]; //swapping process//
				heap[k] = heap[max];
				heap[max] = temp;
				k = max;
				left = 2 * k;
			} else
				break;
		}
	}

	private void resize() {
		int[] tmp = new int[2 * size];
		System.arraycopy(heap, 0, tmp, 0, heap.length);
		heap = tmp;
		size=2*size;
	}

}
