package hackerrank;

public class Question17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pet pet=new Cat();
		Ball ball = new Ball();
		System.out.println(String.format("My %s is playing with a %s", pet.getName(),ball.getName()  ));
		// the print is my cat is plauin wiht a shape because the ball not override the method getname and the get name access to the parent name.
	}

}
