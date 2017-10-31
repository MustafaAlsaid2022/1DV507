package priorityqueue;



public class PriorityQueueMain {

	public static void main(String[] args) {
		PriorityQueue pQueue = new BinaryHeapQueue();
		
		String[] des={"breakfast","meeting","writing report","sign papers","smoke","checkstakeholders",
				      "travel","buy new car","buy new house"};
		
		System.out.println("Size: " + pQueue.size()); //size of HeapQueue//
		System.out.println("Empty: " + pQueue.isEmpty()); //check if it is empty//
	
	   for(int i=1;i<10;i++){
		   pQueue.insert(new WorkTask(10-i,des[i-1]));
	   }
		
		
		System.out.println("Size: " + pQueue.size()); //size after adding elements//
		System.out.println(pQueue.toString()); //string representation//
		System.out.println("Empty: " + pQueue.isEmpty()); //check if it is empty//
		System.out.println("peek highest: " + pQueue.peekHighest()); //return highest value without removing it//
		System.out.println("Pull highest: " + pQueue.pullHighest()); //remove and return highest value//
		System.out.println("peek highest: " + pQueue.peekHighest()); //return highest value without removing it//
		System.out.println("Size: " +pQueue.size()); //size of heap//
		System.out.println("Contains: " + pQueue.contains(new WorkTask(10,"clean"))); //not exist//
		System.out.println("Contains: " + pQueue.contains(new WorkTask(5,"smoke"))); //exist//
		Task t = new WorkTask(10,"sleep");
		Task tx=new WorkTask(10,"sleep");
		System.out.println("Equals: " +t.equals(tx)); //check if the two tasks are equal//
		pQueue.insert(t);
		pQueue.insert(tx);
		System.out.println(pQueue.toString()); //string representation//

	}

}
