package interview;

public class NodeBT {
	NodeBT right, left;
	int data;
	public NodeBT(int value) {
		this.data=value;
	}
	public void insert (int value) {
		if ( value > this.data) {
			if(right == null) {
				right = new NodeBT(value);
			}else {
				right.insert(value);
			}
		}else{
			if(left == null) {
				left = new NodeBT(value);
			}else {
				left.insert(value);
			}
		}		
	}
	public boolean contains(int value) {
		if(value == data) {
			return true;
		}
		else
		{
			if (value < this.data) {
				if(left != null) {
					return left.contains(value);
				}
				else
					return false;
			}else {			
				if(right != null) {
					return right.contains(value);
				}
				else 
					return false;
			}
		}
	}
	
	//print in order traversal in order 
	public void printInOrder() {
		if (left!=null) {
			left.printInOrder();
		}
		System.out.println(","+this.data+" ");
		if (right!=null) {
			right.printInOrder();
		}
			
	}
	//print in order traversal in preorder
	//root, left, right
	public void printPreOrder() {
		System.out.println(","+this.data+" ");
		if (left!=null) {
			left.printInOrder();
		}
		if (right!=null) {
			right.printInOrder();
		}	
	}
	//print in postOrder
	//root, left, right
	public void printPostOrder() {
		if (left!=null) {
			left.printInOrder();
		}
		if (right!=null) {
			right.printInOrder();
		}
		System.out.println(","+this.data+" ");	
	}
}
