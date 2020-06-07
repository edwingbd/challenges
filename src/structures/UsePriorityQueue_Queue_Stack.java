package structures;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/* 2020 06 02
 * Just for remember the use of the queue priority queue and stack here the idea in general es to create these using a for
 * then remove with the methods see the structures then just make a peek or lookup without remove and print no more.
 * */
public class UsePriorityQueue_Queue_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=4;i>0 ;i--) {
			pQueue.add(10-i);
			queue.add(i);
			stack.add(i);
		}
		System.out.print("pQueue "+pQueue);
		System.out.print(" queue "+queue);
		System.out.println(" stack "+stack);
		System.out.print("pQueue.poll "+pQueue.poll());
		System.out.print(" queue.poll "+queue.poll());
		System.out.println(" stack.pop "+stack.pop());
		System.out.print("pQueue "+pQueue);
		System.out.print(" queue "+queue);
		System.out.println(" stack "+stack);
		System.out.print("pQueue.peek="+pQueue.peek() );
		System.out.print(" queue.peek="+queue.peek());
		System.out.println(" stack.peek "+stack.peek() );				
		System.out.print("pQueue "+pQueue);
		System.out.print(" queue "+queue);
		System.out.println(" stack "+stack);
	}

}
