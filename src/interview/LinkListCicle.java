package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LinkListCicle {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedListT llStr = new linkedListT();
		llStr.add("hola");
		llStr.add("como");
		llStr.add("estas");
		Node cicle=llStr.add("1");
		llStr.add("2");
		llStr.add("3");
		llStr.add("4");
		//llStr.add("loop").next = cicle;
		// the list has a cicle
		llStr.print();
		System.out.println(llStr.delete("1"));
		llStr.print();
		
		System.out.println(hasCicle1(llStr) );
		System.out.println(hasCicle2(llStr) );
		System.out.println(hasCicle3(llStr) );
	}
	
	public static boolean hasCicle1(linkedListT llStr) {
		HashSet<Node> hm = new HashSet<Node>();
		Node temp = llStr.getHead();
		while (temp!= null){
			if ( hm.contains(temp))
				return true;
			hm.add(temp);
			temp=temp.next;
		}
		return false;
	}
	
	public static boolean hasCicle3(linkedListT llStr) {
		Node tempFast = llStr.getHead();
		Node tempSlow = llStr.getHead();
		while (tempFast != null && tempSlow != null ){
			tempFast=(tempFast.next != null)? (tempFast.next != null)? tempFast.next.next:null:null;  
			tempSlow=(tempSlow.next != null)? tempSlow.next:null;
			if ( tempFast == tempSlow)
				return true;
		}
		return false;
	}
	
	public static boolean hasCicle2(linkedListT llStr) {
		HashMap<Node,Node> hm = new HashMap<Node, Node>();
		Node temp = llStr.getHead();
		while (temp!= null){
			if ( hm.containsKey(temp))
				return true;
			hm.put(temp, temp);
			temp=temp.next;
		}
		return false;
	}
}

class Node{
	String data;
	Node next;
	public Node (String strData) {
		this.data=strData;
	}
	public Node (String strData,Node next) {
		this.data=strData;
		this.next=next;
	}
}

class linkedListT{
	private Node head;
	public Node getHead() {
		return head;
	} 
	public linkedListT() {
		head = null;
	}
	
	public Node add(String str ) {
		Node node = new Node(str,null);
		Node temp;
		if (head ==null) {
			this.head = node;
			return node;
		}
		temp = head;
		while (! (temp.next == null)) {
			temp=temp.next;
		}
		temp.next = node;
		return node;
	}
	
	public boolean delete(String str) {
		Node current=head;
		if (head==null)
				return false;
		if (head.data.equals(str)) {
			head = head.next;
			return true;
		}
		while( current.next != null) {
			if (current.next.data.equals(str)){
				current.next =  current.next.next;
				return true;
			}
			current = current.next;
		}
		return false; // this system didn't found the register 
	}
	
	public void print() {
		Node temp;
		if (head ==null) {
			System.out.println("This is empty");
		}
		else {
			temp = head;
			while (! (temp.next == null)) {
				System.out.println("-"+temp.data+"-");
				temp=temp.next;
			}
		}
		
	}
}
