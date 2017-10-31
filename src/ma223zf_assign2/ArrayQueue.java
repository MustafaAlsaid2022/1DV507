package ma223zf_assign2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue implements Queue {

	public static void main(String[] args) {
		ArrayQueue arr = new ArrayQueue();
		arr.enqueue(2);
    	arr.enqueue(4);
    	arr.enqueue(8);
    	arr.enqueue(5);
    	arr.enqueue(4);
    	arr.enqueue(22);
    	arr.enqueue(22);
    	arr.dequeue();
    	arr.dequeue();
    	arr.enqueue(0);
    	arr.enqueue(8);
    	arr.enqueue(2);
    	arr.enqueue(1);
    	
    	System.out.println(arr.toString());
    	System.out.println("the queue has "+arr.size()+" elements");
    	System.out.println("first in the queue: "+arr.first());
    	arr.dequeue();
    	System.out.println(arr.toString());
    	System.out.println("the queue has "+arr.size()+" elements");
    	System.out.println("first in the queue: "+arr.first());
    	System.out.println("last in the queue: "+arr.last());
    	if(arr.isEmpty()){
    		System.out.println("the queue is empty");
    	}
    	else{
    		System.out.println("the queue is not empty");
    	}
		Iterator <Object>itr = arr.iterator();
    	System.out.print("the queue elements: ");
        while(itr.hasNext())
           System.out.print(itr.next() + " ");
        System.out.println();

	}

	private final int size = 8;
	private int front, rear, count;
	private Object[] queue;

	/** Create an empty queue */
	public ArrayQueue() {
		front = rear = count = 0;
		queue = new Object[size];
	}

	/** Current queue size */
	@Override
	public int size() {
		return count;
	}

	/** Returns a string representation of the queue content */
	public String toString() {
		
	StringBuilder str=new StringBuilder();
		str.append("[ ");
		int i = 0;

		while (i <= count + 1) {
			
			if(queue[i] instanceof Integer){
			str.append(queue[i]);
			}
			i++;
		}
		str.append(" ]");
		return str.toString();
	}

	/** Adds element at end of queue */
	@Override
	public void enqueue(Object element) {
		if (size() == queue.length)
			resize();

		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		count++;
	}

	/** Returns and removes first element */
	@Override
	public Object dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}
		Object result = queue[front];
		queue[front] = "";
		front = (front + 1) % queue.length;
		count--;

		return result;
	}

	/** Returns (without removing) first element */
	@Override
	public Object first() {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}
		return queue[front];
	}

	/** Returns (without removing) last element */
	@Override
	public Object last() {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}
		return queue[rear-1];
	}

	/** Returns true if this queue is empty and false otherwise */
	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public Iterator<Object> iterator() {
		return new ArrayQueueIterator( );
	}

	private class ArrayQueueIterator implements Iterator<Object>
	{
		private int index=0;      
		
		//public ArrayQueueIterator()
		//{
		//	rear= front=0;
		//}
		public Object next( ){
			
			return (Object) queue[index++];
		}
		public boolean hasNext( )
		{
			return index <=count;
		}
		public void remove( )
		{
			throw new RuntimeException("remove() is not implemented");
		}
	}

	/** Resize the queue array to insert more elements */
	private void resize() {
		Object[] temp = (new Object[queue.length * 2]);
		for (int i = 0; i < count; i++) {
			temp[i] = queue[front];
			front = (front + 1) % queue.length;
		}

		front = 0;
		rear = count;
		queue = temp;
	}

}
