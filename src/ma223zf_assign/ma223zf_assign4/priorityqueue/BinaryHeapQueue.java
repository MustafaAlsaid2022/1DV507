package priorityqueue;



public class BinaryHeapQueue implements PriorityQueue {

	// Fields
	private static Task[] task;
	private static int size;

	// Constructor
	public BinaryHeapQueue() {
		task = new Task[8];
		size = 1;

	}

	@Override
	public String toString() { // string representation of HeapQueue//
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		for (int i = 1; i <= size(); i++) {
			str.append(task[i] + " ");
		}
		str.append("]");
		return str.toString();

	}

	/*
	 * the element at position 1 during first time and increasing the size.
	 * During other times, I am simply adding the elements at position size and
	 * increasing the size by 1. In both cases I am using check() method.
	 */
	@Override
	public void insert(Task t) {
		if (size == 1) {
			task[size] = t;
			size++;
		} else if (size > 1) {
			if (size == task.length)
				resize();
			task[size++] = t;
		}
		int index = size - 1;
		check(index);
	}

	private void check(int n) {
		if (n == 1) {
			return;
		} else if (task[n].getPriority() <= task[n / 2].getPriority())
			return;
		else {
			int pos = n;
			Task temp = task[n / 2];
			int index = n / 2;
			task[index] = task[n];
			task[pos] = temp;
			check(index);
		}
	}

	@Override
	public Task pullHighest() { // Return and remove element with highest
								// priority//

		Task highest; // highest value of HeapQueue elements//
		if (isEmpty()) {
			throw new IllegalArgumentException("Queue is Empty");
		}

		else if (size() == 1) {
			highest = task[1];
			task[1] = task[0];
			size--;
		} else {
			highest = task[1];
			task[1] = task[size - 1];
			percolatingDown();
			size--;
		}
		return highest;

	}

	
	@Override
	public boolean contains(Task t) { //check if the HeapQueue contains a specific task//
		for (int i = 1; i < size; i++) {
			if (task[i].getPriority() == t.getPriority() && task[i].getDescription()==t.getDescription()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() { // current size of HeapQueue//

		return size - 1;
	}

	@Override
	public boolean isEmpty() { // check if HeapQueue isEmpty//

		return size == 1;
	}

	@Override
	public Task peekHighest() { // return highest priority task at the top of
								// priority HeapQueue//

		if (isEmpty()) {
			throw new IllegalArgumentException("Queue is Empty");
		}
		return task[1];
	}

	private static void percolatingDown() { //percolation down process//
		int currentSize = size - 1;
		Task temp = task[currentSize--];
		int parent = 1;
		int child = 2;
        
		while (child <= currentSize) {
			if (child < currentSize && task[child].getPriority() < task[child + 1].getPriority())
				child++;
			if (temp.getPriority() >= task[child].getPriority())
				break;
			task[parent] = task[child];
			parent = child;
			child *= 2;
		}
		task[parent] = temp;

	}

	private void resize() { // resize HeapQueue//
		Task[] temp = new Task[task.length * 2];
		for (int i = 1; i < size; i++) {
			temp[i] = task[i];
		}
		task = temp;
	}

}
