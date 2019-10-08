package interviews;

import java.util.LinkedList;
import java.util.Stack;

import java.util.Iterator;

/*
Given two numbers represented by two linked lists, write a function that returns the sum list. The sum list is linked list representation of the addition of two input numbers.
Example:

Input: List1: 5->6->3  // represents number 365
       List2: 8->4->2 //  represents number 248
Output: Resultant list: 3->1->6  // represents number 613


Input: List1: 7->5->9->4->6  // represents number 64957
       List2: 8->4 //  represents number 48
Output: Resultant list: 5->0->0->5->6  // represents number 65005
 * */

public class ReverseNumber {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node first = new Node(5);
		first.next = new Node(6);
		first.next.next = new Node(3);

		Node second = new Node(8);
		second.next = new Node(4);
		second.next.next = new Node(2);
		
		System.out.println(first);
		System.out.println(second);		
		
		//Node result = addNumbers(first, second);
		//Node result = addNumbers2(first, second);
		Node result = addNumbers3(first, second);
		System.out.println(result);	
		
		//case 2
		
		System.out.println("second user case");
		
		Node first2 = new Node(7);
		first2.next = new Node(5);
		first2.next.next = new Node(9);
		first2.next.next.next = new Node(4);
		first2.next.next.next.next = new Node(6);
		
		
		
		Node second2 = new Node(8);
		second2.next = new Node(4);
		
		System.out.println(first2);
		System.out.println(second2);		
		
		//Node result2 = addNumbers(first2, second2);
		//Node result2 = addNumbers2(first2, second2);
		Node result2 = addNumbers3(first2, second2);
		System.out.println(result2);	
		
	}
	
	public static Node addNumbers3(Node a, Node b) {
		
		LinkedList<Integer> lit = new LinkedList();
		LinkedList<Integer> lit2 = new LinkedList();
		LinkedList<Integer> lit3;
		
		Node tempA =a, tempB=b, returnNode =null ,tempNodo =null ;
		
		while (tempA != null) {
			lit.add(tempA.val);
			tempA=tempA.next;
		}
		
		while (tempB != null) {
			lit2.add(tempB.val);
			tempB=tempB.next;
		}
		
		Structure obj = new Structure();
		
		lit3 = obj.crear(lit, lit2);
		
		Iterator it = lit3.descendingIterator();
		
		
		while(it.hasNext())
		{
			Node actualNode = new Node((int) it.next());
			if (returnNode ==null ) {
				returnNode =actualNode;
				tempNodo=actualNode;
			}
			else {
				tempNodo.next=actualNode;
				tempNodo =tempNodo.next;
			}
		}
		
		return returnNode;
		
	}
	
	public static Node addNumbers2(Node a, Node b){
		
		Node tempA =a, tempB = b,nodeResul=null,tempNode = null;
		Integer res=0;
		while(tempA!=null ||tempB !=null ) {
			Integer valA=0,valB=0,sumU1;
			if(tempA !=null  )
				valA=tempA.val;
			if(tempB !=null  )
				valB=tempB.val;
			sumU1=valA+valB+res;
			Node actNode = new Node(sumU1 % 10 );
			res=(sumU1 -sumU1 % 10 ) /10 ;
			if (nodeResul==null) {
				nodeResul=actNode;
				tempNode=actNode;
			}else {
				tempNode.next=actNode;
				tempNode = tempNode.next;
			}
			
			if(tempA !=null) tempA=tempA.next;
			if(tempB !=null) tempB=tempB.next;
		}
		
		return nodeResul;
	}
	
	
	public static Node addNumbers(Node a, Node b){
		Integer numa = convertNumber(a);
		System.out.println("numA="+numa);
		Integer numb = convertNumber(b);
		System.out.println("numB="+numb);
		
		char[] numberChar = Integer.toString(numa + numb).toCharArray();
		
		Node returnNode = null;
		Node tempNode=null;
		
		for(int i=numberChar.length-1; i>=0;i--) {
			Node nodeUnit= new Node( numberChar[i]-48 );
			if(returnNode == null) {
				returnNode=nodeUnit;
				tempNode =returnNode;
			}else {
			tempNode.next=nodeUnit;
			tempNode =nodeUnit;
			}
		}
			
		
		return returnNode;
	}
	
	public static Integer convertNumber(Node nodeConvert) {
		Stack<Integer> num1 = new Stack<Integer>();
		Node aHead = nodeConvert ;
		int longNumber=0;
		Integer returnValue=0;
		while (aHead != null ) {
			num1.add(aHead.val );
			aHead = aHead.next;
			longNumber++;
		}
		for (int i =longNumber-1; i>=0 ;i--  ) {
			returnValue = returnValue + (int) (num1.pop()*Math.pow(10,i));
		}
		return returnValue;
	}
}
class Node{
	int val;
	Node next;
	Node(int val){
	this.val = val;
	this.next = null;
	}
	@Override
	public String toString() {
		return Integer.toString(this.val) + (this.next != null? "-"+this.next.toString(): "" ) ;  
	}
}

class Structure 
{
	
	public Integer listar(LinkedList lit)
	{
	Integer sum, aux, i =0;

	Iterator it = lit.descendingIterator();
	
	sum = 0;
	
	while(it.hasNext())
	{
		aux = Integer.parseInt(it.next().toString());
		
		if(i==0)
		{
			sum = aux * 10 ;
		}
		else
		{
			sum = sum + aux;
			sum = sum * 10;
		}
		i = i+1;
	}
	
	sum = sum/10;
	
	return sum;
	
	}
	

	public LinkedList<Integer> crear(LinkedList l1, LinkedList l2)
	{
		Integer aux, dig =0;
		
		aux = listar(l1) + listar(l2);
		
		LinkedList<Integer> list = new LinkedList();
		
		while(aux > 0)
		{
			list.add(aux%10);
			aux = aux/10;
		}
		
		return list;
		
		
	}
	

}

