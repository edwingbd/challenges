package interview;

//TRIE
public class ContactProblem {
	// is the letters just the lowercase
	// i can use the letters us number just for examples minus the value to 'a'
	public static class Node{
		private static int NUMBER_OF_CHARACTERS =26;
		Node[] children = new Node[NUMBER_OF_CHARACTERS];
		public static int getCharIndex(char c) {
			return c-'a';
		}
		private Node getNode(char c) {
			return children[getCharIndex(c)];
		}
		
		private void setNode(char c,Node node) {
			children[getCharIndex(c)] = node;
		}
		
		public void add(String s) {
			add(s,0);
		}
		
		public void add (String s,int index) {
			if (index==s.length())
				return;
			char current = s.charAt(index);
			int charCode = getCharIndex(current);
		}
		
//		public int findCount(String s,int index) {
//			
//		}
	}
	public static void main(String[] args) {
		
	}
}
