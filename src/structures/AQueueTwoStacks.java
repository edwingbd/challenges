package structures;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class AQueueTwoStacks {

	public static class MyQueue<T> {
		private Stack <T> stackNewestOnTop = new Stack<T>();
		private Stack <T> stackOldestOnTop = new Stack<T>();
		public  void add(T value) { // is better name this us queue but the problem is
			stackNewestOnTop.push(value);
		}
		public T peek() {
			shiftStacks();
			return stackOldestOnTop.peek();
		}
		
		public T poll() {
			shiftStacks();
			return stackOldestOnTop.pop();
		}
		
		public int size() {
			return stackNewestOnTop.size() + stackOldestOnTop.size();
		}
		
		private void shiftStacks() {
			if ( stackOldestOnTop.isEmpty()){
				while(!stackNewestOnTop.isEmpty()) {
					stackOldestOnTop.push(stackNewestOnTop.pop());
				}
			}

		}
		@Override
		public String toString() {
			String strReturn="";
			Stack <T> stackNewestOnTopTemp = (Stack<T>) stackNewestOnTop.clone() ;
			Stack <T> stackOldestOnTopTemp = (Stack<T>) stackOldestOnTop.clone() ;
			if ( stackOldestOnTopTemp.isEmpty()){
				while(!stackNewestOnTopTemp.isEmpty())
					stackOldestOnTopTemp.push(stackNewestOnTopTemp.pop());				
			} 
			while(!stackOldestOnTopTemp.isEmpty())
				strReturn += "["+stackOldestOnTopTemp.pop()+"]";
			return strReturn;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MyQueue<Integer> testQueue = new MyQueue<Integer>();
		Queue<Integer> testQueue = new LinkedList<Integer>();
		//Queue<Integer> testQueue = new PriorityQueue<>();
		testQueue.add(10) ;
		System.out.println(testQueue);
		testQueue.add(20) ;
		System.out.println(testQueue);
		testQueue.add(30) ;
		System.out.println(testQueue);
		testQueue.add(11) ;
		System.out.println(testQueue);
		testQueue.add(12) ;
		System.out.println(testQueue);
		testQueue.add(3) ;
		System.out.println(testQueue);
		System.out.println("peek "+ testQueue.peek() ); 
		System.out.println("size "+testQueue.size() );
		System.out.println("remove "+testQueue.poll() );
		System.out.println(testQueue);
		System.out.println("remove "+testQueue.poll() );
		System.out.println(testQueue);
		System.out.println("peek "+ testQueue.peek() ); 
		System.out.println("size "+testQueue.size() );
		System.out.println("remove "+testQueue.poll() );
		System.out.println(testQueue);
		System.out.println("remove "+testQueue.poll() ); 
		System.out.println(testQueue);
		
	}

}
