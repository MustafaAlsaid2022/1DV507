package ma223zf_assign4;



public class IntHeapMain {

	public static void main(String[] args) {
		BinaryIntHeap heap = new BinaryIntHeap(); //object of binaryIntHeap//
		System.out.println("Size: " + heap.size()); //size of heap//
		System.out.println("Empty: " + heap.isEmpty()); //check if it is empty//

		/* Add integers */
		for (int i = 0; i < 10; i++) {
				heap.insert(i);
			}
		
		System.out.println("Size: " + heap.size()); //size after adding elements//
		System.out.println(heap.toString()); //string representation//
		System.out.println("Empty: " + heap.isEmpty()); //check if it is empty//
		System.out.println("Pull highest: " + heap.pullHighest()); //remove and return highest value//
		System.out.println("Size: " + heap.size()); //size of heap//
		System.out.println(heap.toString()); //string representation//

	}

}
