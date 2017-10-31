package priorityqueue;

public interface PriorityQueue {
	
	public void insert(Task t); //add task to queue//

	public Task pullHighest(); //return and remove highest priority task//

	public boolean contains(Task t); //return true if queue contains a task//

	public int size(); //return current size of queue//

	boolean isEmpty(); //return true if queue is empty//

	public Task peekHighest(); //return highest priority task at the top of priority heap queue//

	String toString(); //string representation of priority heap queue//




}
