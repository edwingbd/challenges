package hackerrank;

public class Question19 {
	public static void main (String[] args) {
		Parent child = new Child();
		System.out.print(child.value+"&"+child.getValue() );
		//parent then child because is not override the method it will go to the parent method instead of the own method
	}
}

