package intCollection;

import java.util.Iterator;

public class CollectionMain {

	public static void main(String[] args) {
		ArrayIntList intlist = new ArrayIntList();
		ArrayIntStack stack = new ArrayIntStack(); // Stack can have 10 element
		try {
			stack.push(3); // push an object element in stack
			stack.push(4);
			System.out.println("Stack size:" + stack.size());
			System.out.println("the stack elements are ");
			Iterator<Integer> it = stack.iterator();
			while (it.hasNext()) {
				Integer obj = it.next();
				System.out.println(obj + " ");
			}
			int peek = (Integer) stack.peek(); // check out "4"//
			System.out.println("The last element in stack: " + peek); // print
																		// "4"
			stack.pop(); // remove 4//
			System.out.println("The last element in stack: " + stack.peek()); // print
																				// "3"//
			stack.pop(); // there is no element in stack after pop//
			System.out.println(stack.peek());

		} catch (Exception e) {
			System.out.println("Exception message:" + e.getMessage());
		}

		for (int i = 1; i <= 20; i++) // Add 20 integers 10,20,30,...
			intlist.add(i * 10);

		System.out.println("Size: " + intlist.size());
		System.out.println("Content: " + intlist.toString());
		System.out.println("Integer at position 5: " + intlist.get(5));
		System.out.println("The index of " + intlist.values[2] + " is " + intlist.indexOf(intlist.get(2)));
		intlist.addAt(22, 2);
		System.out.println("number in index "+intlist.indexOf(intlist.get(2))+" is "+intlist.get(2));
		System.out.println("Content: " + intlist.toString());
		System.out.println("Size: " + intlist.size());
		intlist.remove(3);
		intlist.remove(1);
		System.out.println("Content: " + intlist.toString());
		System.out.println("Size: " + intlist.size());

	}

}
