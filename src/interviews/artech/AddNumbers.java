package interviews.artech;

public class AddNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		float a = 4.0000009f ;
//		float b =1.9999999f;
		float a = 3.5f ;
		float b =4.9f;
		System.out.println("Exercise Add Number");
		System.out.println("a="+ String.valueOf(a) );
		System.out.println("b="+ String.valueOf(b) );
		System.out.println("Result="+String.valueOf(addNumber(a,b)) );
		 a = 4.00000001f ;
		 b =1.99999f;		
		System.out.println("Exercise Add Number");
		System.out.println("a="+ String.valueOf(a) );
		System.out.println("b="+ String.valueOf(b) );
		System.out.println("Result="+String.valueOf(addNumber(a,b)) );		
	}
	
	public static int addNumber(float a, float b) {
		double result = a+b;
		float result2 = a+b;
		System.out.println("double="+result);
		System.out.println("float"+result2);
		return (int) (a+b);// THIS CORRECT
	}

}
