package interviews.artech;

public class FizzBuzz {
	/*
	// * Given a number n, for each integer i in the range from 1 to n inclusive, print one value per line as follows:
	//If i is a multiple of both 3 and 5, print FizzBuzz.
	//If i is a multiple of 3 (but not 5), print Fizz.
	//If i is a multiple of 5 (but not 3), print Buzz.
	//If i is not a multiple of 3 or 5, print the value of i.
	//Function Description
	//Complete the function fizzBuzz in the editor below. The function must print the appropriate response for
	//each value i belongs {1, 2, ... n} in ascending order, each on a separate line. There is no return value expected.
	//fizzBuzz has the following parameter(s):
	//n: upper limit of values to test (inclusive)
	//Constraints
	//0 < n < 2 10 5	 * */
	public static void main(String[] args) {
		System.out.println("Execise FIZZ BUZZ");
		int n =50 ;
		fizzBuzz(n);
		
	} 
	public static void fizzBuzz(int n) {
		System.out.println("n="+n);
		for(Integer i=1;i<=n;i++) {
			String printLine="";
			if(i%5==0)
				printLine="Buzz";
			if(i%3==0)
				printLine="Fizz"+printLine;
			if(printLine.isEmpty() )
				printLine= i.toString() ;
			System.out.println(printLine);
		}
	}
}
