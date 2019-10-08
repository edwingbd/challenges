package hackerrank;

public class Question18 {
	public static void main(String[] args) {
		ImplInter1Inter2 obj = new ImplInter1Inter2();
		// you have to define the methods when is repeated in differences interfaces like talk and the methods default too
		System.out.println("obj.talk()="+ obj.talk() );
		System.out.println("obj.shout()="+ obj.shout());
		System.out.println("obj.whisper()="+ obj.whisper() );
		System.out.println("obj.yell()="+ obj.yell() );
	}
}
