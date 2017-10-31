package intCollection;;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	@Override
	public void add(int n) { //add integer to list//
		if (size == values.length) { //if list is full we resize it//
			resize();
		}
		values[size] = n;
		size++; //increment the size//
	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException { //add integer at specific index//
		if (size == values.length) //if list is full we resize it//
			resize();
		if (checkIndex(index, size)) { //check the index that we will add integer to it//
			for (int i = size - 1; i >= index; i--) { //shift the elements on step to right//
				values[i + 1] = values[i];
			}
			values[index] = n; //add the integer the specific index//
			size++; //increment the size//
		}
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException { //remove integer at specific index//

		if (checkIndex(index, size)) { //check the index that we will remove integer from it//
			for (int i = index; i < size - 1; i++) {
				values[i] = values[i + 1]; //shift the elements one step to left//
			}
			size--; //decrement the size//
		}
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException { //return the value of specific index//
		if(checkIndex(index, size)); //check index//
		return values[index]; //return the value//
	}

	@Override
	public int size() { //return current size of the list//

		return size;
	}

	@Override
	public int indexOf(int n) { //return the index of specific integer in the list//
		for (int i = 0; i < size; i++) {
			if (values[i] == n) {
				return i;
			}
		}
		return -1; //return -1 if the integer is not the list//
	}

}
