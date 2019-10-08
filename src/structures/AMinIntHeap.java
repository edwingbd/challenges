package structures;

import java.util.Arrays;

public class AMinIntHeap {
	private int capacity =10;
	private int size = 0;
	
	int[] items = new int[capacity];
	
	// this mettos retunr the position of the index for the relative of the heap
	private int getRightChildIndex(int parentIndex) { return parentIndex+2; }
	private int getLeftChildIndex(int parentIndex) { return parentIndex+1; }
	private int getParentIndex(int childIndex) { return (childIndex-1)/2; }
	
	// this return if the position sent has a relative
	private boolean hasLeftChildIndex(int index) { return getLeftChildIndex(index) < size;  }
	private boolean hasRightChildIndex(int index) {return getRightChildIndex(index) < size; }
	private boolean hasParentIndex(int index) { return getParentIndex(index) >= 0; }
	
	// this return the value of the relatives
	private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
	private int rightChild(int index) {return items[getRightChildIndex(index)];}
	private int parent(int index) {return items[getParentIndex(index)];}
	
	// this swap the information between two indexes 
	private void swap(int index1,int index2) {
		int temp = items[index1];
		items[index1]=items[index2];
		items[index2]=temp;
	}
	
	// this check the capacity in case that the capacity and the size be the same create a copy and increase the capacity by 2
	private void ensureExtraCapacity(){
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity*2);
			capacity *=2;
		}
	}
	
	// peek return the information in the firs elemente [0] in case that generate a error throw and IllegalStateExeception
	// peek is just a look of the value
	public int peek() {
		if (size ==0) throw new IllegalStateException();
		return items[0];
	}
	
	// is for retrieve the information take the value and return this
	public int poll() {
		if (size ==0) throw new IllegalStateException();
		int item=items[0];
		items[0] = items[size-1];/// take the last element in the heap 
		size--;
		heapifyDown();
		return item;
	}
	
	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUP();
	}
	
	private void heapifyDown() {
		int index = 0;
		while ( hasLeftChildIndex(index) ) {
			int smallerChildIndex= getLeftChildIndex(index);
			if ( hasRightChildIndex(index) && rightChild(index) < leftChild(index) ) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if (items[index] < items[smallerChildIndex] ) { // MEANS THAT EVERTHING IS GOOD
				break;
			} else {			
				swap(index,smallerChildIndex);
			}
			index=smallerChildIndex;
		}
	}
	private void heapifyUP() {
		int index=size-1;
		// This is better
		while (hasParentIndex(index) && (parent(index) > items[index])) {
				swap(index, getParentIndex(index) );
				index = getParentIndex(index);
		}
		
//		This work but the problem is the while
//		while (hasParentIndex(index)) {
//			if ( (parent(index) > items[index])   ) {
//				swap(index, getParentIndex(index) );
//				index = getParentIndex(index);
//			}
//			else
//				break;
//		}
	}
	
	public String print() {
		// in todo 
		String strReturn ="";
		for (int i=0;i<size;i++) {
			if(hasLeftChildIndex(i) )
				strReturn+=getLeftChildIndex(i)+" ";
			if(hasRightChildIndex(i))
				strReturn+=getRightChildIndex(i)+" ";			
		}
		return strReturn;
	}
	
	
}
