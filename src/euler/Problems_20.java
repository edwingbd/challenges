package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problems_20 {
	public static void main(String[] args) {
//		problem20();
//		problem30();
		problem40();
//		problem50();
//		problem60();
	}

	public static void problemX() {
		System.out.println("Solve problem X Euler");
		System.out.println("	Solution problem X Euler");
	}
	
	public static void problem40() {
		System.out.println("Solve problem 40 Euler");
		System.out.println("	Solution problem 40 Euler");
	}
	
	/**Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
	 * 1634 = 14 + 64 + 34 + 44
	 * 8208 = 84 + 24 + 04 + 84
	 * 9474 = 94 + 44 + 74 + 44
	 * As 1 = 14 is not a sum it is not included.
	 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
	 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
	 * 10:00-10:37-37m
	 * */
	public static void problem30() {
		System.out.println("Solve problem 30 Euler");
		Boolean flag =true;
		Long number =32l;
		Long numberSuma =0l;
		List<Long> lstNumber= new ArrayList<Long>();
		HashMap<Long, Long> hmFifthPowers= new HashMap<Long, Long>();
		for(int i=0;i<10;i++)
			hmFifthPowers.put((long) i, (long) Math.pow(i, 5) );
		HashMap<Long, Long> hmForthPowers= new HashMap<Long, Long>();
		for(int i=0;i<10;i++)
			hmForthPowers.put((long) i, (long) Math.pow(i, 4) );

		HashMap<Long, Long> hmResults= new HashMap<Long, Long>();

		System.out.println(hmFifthPowers);
		do {
			number=number+1l;
			lstNumber=Arrays.asList(number.toString().split("")).stream().map(Integer::parseInt).map(e->(long) e) .collect(Collectors.toList());
			numberSuma = lstNumber.stream().map(e->hmFifthPowers.get(e)).reduce(0l,(a,b)->a+b) ;
			if(number.equals(numberSuma)) {
				hmResults.put(number, numberSuma);
			}
//			numberSuma = lstNumber.stream().map(e->hmForthPowers.get(e)).reduce(0l,(a,b)->a+b) ;
//			if(number.equals(numberSuma))
//				System.out.println(" 4Number="+number +"sum="+numberSuma );
		}while(number<200000);
		System.out.println(hmResults);
		System.out.println("	Solution problem 30 Euler"+ (hmResults.values().stream().reduce(0l, (a,b)->a+b)) );
	}

	
	/*n! means n × (n - 1) × ... × 3 × 2 × 1
	 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
	 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
	 * Find the sum of the digits in the number 100!.
	 * 9:30->9:53-23 min
	 * */
	public static void problem20() {
		System.out.println("Solve problem 20 Euler");
		System.out.println("	Solution problem 20 Euler factorial of 100="+(factoria(BigInteger.valueOf(100)) ) );
		String number = factoria(BigInteger.valueOf(100)).toString();
		System.out.println(
				"	Solution problem 20 Euler factorial of 100="+Arrays.asList(number.split("")).stream().map(Integer::parseInt).reduce(0,(a,b)->a+b));
	}
	public static BigInteger factoria(BigInteger num) {
		if(num.intValue()<3l)
			return num;
		else
		{
			return num.multiply(factoria(num.subtract(BigInteger.valueOf(1))));
		}
	}
}
