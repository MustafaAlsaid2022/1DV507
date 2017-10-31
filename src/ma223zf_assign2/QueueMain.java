package ma223zf_assign2;

import java.util.Iterator;
/**
 * 
 * The main class implements all methods in class LinkedQueue.
 * @author Mustafa Alsaid
 * 
 * 
 * 
 * 
 * 
 * @version 1.0
 *
 */

public class QueueMain {
    
    public static void main(String[] arrstring) {	
        
    	LinkedQueue queue=new LinkedQueue();
    	queue.enqueue(2);
    	queue.enqueue(4);
    	queue.enqueue(8);
    	System.out.println(queue.toString());
    	System.out.println("the queue has "+queue.size()+" elements");
    	System.out.println("first in the queue: "+queue.first());
    	queue.dequeue();
    	System.out.println(queue.toString());
    	System.out.println("the queue has "+queue.size()+" elements");
    	System.out.println("first in the queue: "+queue.first());
    	System.out.println("last in the queue: "+queue.last());
    	if(queue.isEmpty()){
    		System.out.println("the queue is empty");
    	}
    	else{
    		System.out.println("the queue is not empty");
    	}
    	
    	Iterator <Object>itr = queue.iterator();
    	System.out.print("the queue elements: ");
        while(itr.hasNext())
           System.out.print(itr.next() + " ");
        System.out.println();
    	
    }
}
