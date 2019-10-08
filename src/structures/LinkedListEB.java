package structures;

public class LinkedListEB {
	public Node head;
	public void LinkedListEB() {
		head = null;
	}
	public void addValue(int value) {
		Node nnode = new Node(value);
		if (head == null) {
			head = nnode;
		}
		else {
			Node temp = head;
			while (temp.next != null ){
				temp=temp.next;
			}
			temp.next=nnode;
		}
	}
	
	@Override
	public String toString() {
		String strReturn=" toStringEB = ";
		Node temp =head;
		
		while( temp != null) {
			strReturn += temp.val.toString() +" , " ;
			temp =temp.next;
		}
		
		return strReturn;
	}
}
