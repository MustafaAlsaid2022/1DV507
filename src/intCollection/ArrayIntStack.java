package intCollection;;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {
	
	private int current=0; //current elements in the stack//
	

	@Override
	public void push(int n) { //push an integer to the stack stack//

		if (size == values.length) {
			resize();
		}
		values[current] = n;
		size++;
		current++;
		
	}

	@Override
	public int pop() throws IndexOutOfBoundsException { //pop method with exception it returns and removes integer at top of stack//

		if (super.isEmpty()) { //throws exception when the stack is empty//
			throw new IndexOutOfBoundsException("array stack is empty");
		}
		return super.values[current--];
	}

	@Override
	public int peek() throws IndexOutOfBoundsException { //peek method with exception it returns without removing integer at top of stack//
		if (super.isEmpty()) { //throws exception when the stack is empty//
			throw new IndexOutOfBoundsException("array stack is empty");
		}
		return super.values[current-1]; 
	}

}
