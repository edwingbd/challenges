package assessment.Int.problems;

public class ValidateBST {

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return " "+this.val+","+(this.left==null?"null":this.left.toString())+
					","+(this.right==null?"null":this.right.toString())+"" ;
		}
	}
    /*8:00 8:26*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode;
		TreeNode treeNodeRight; 
		TreeNode treeNodeLeft ;
		treeNodeLeft= new TreeNode(1);
		treeNodeRight= new TreeNode(3);
		treeNode= new TreeNode(2, treeNodeLeft ,treeNodeRight);
		System.out.println("treeNode"+treeNode);
		System.out.println("true = IsValid "+isValidBST(treeNode) );
		
		/*Input: [2,1,3]
		Output: true* */
		
		/*Input: [5,1,4,null,null,3,6]
		 * Output: false Explanation: The root node's value is 5 but its right child's value is 4.
		 * */
		treeNodeLeft= new TreeNode(1);
		treeNodeRight= new TreeNode(4,new TreeNode(3),new TreeNode(6) );
		treeNode= new TreeNode(5, treeNodeLeft ,treeNodeRight);
		System.out.println("treeNode"+treeNode);
		System.out.println("false = IsValid "+isValidBST(treeNode) );
		
		/*
		      [3,
		1,           5,
	0,        2,   4,  6,
null,null,null, 3]
		expected false
*/
		treeNodeLeft= new TreeNode(1,new TreeNode(0),new TreeNode(2,null,new TreeNode(3)) );
		treeNodeRight= new TreeNode(5,new TreeNode(4),new TreeNode(6) );
		treeNode= new TreeNode(3, treeNodeLeft ,treeNodeRight);
		System.out.println("treeNode"+treeNode);
		System.out.println("false = IsValid "+isValidBST(treeNode) );

	}

	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root,null,null);
	}
	
	public static boolean isValidBST(TreeNode root,Integer min ,Integer max ) {
		if(root == null)
			return true;
		if( null != max && root.val >=max )
			return false;
		if( null != min && root.val <=min )
			return false;
		return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
	}
}
