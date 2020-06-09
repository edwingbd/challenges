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
//		problem40();
		problem50();
//		problem60();
	}

	public static void problemX() {
		System.out.println("Solve problem X Euler");
		System.out.println("	Solution problem X Euler");
	}
	/*The prime 41, can be written as the sum of six consecutive primes:
	 * 41 = 2 + 3 + 5 + 7 + 11 + 13
	 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
	 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, 
	 * 	and is equal to 953.
	 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
	 * 1:20am
	 * */
	public static void problem50() {
		System.out.println("Solve problem X50 euler");
		lstPrime = new ArrayList<Integer>();
		lstPrime.add(1);
		while(true){
			lstPrime.add(nextPrime(lstPrime.get(lstPrime.size()-1) ));
			if(lstPrime.get(lstPrime.size()-1)>100)
			{
				//System.out.println("	greater thant 2millions="+lstPrime.get(lstPrime.size()-1) );
				lstPrime.remove(lstPrime.size()-1);
				break;
			}
		}
		System.out.println(lstPrime);
		Integer position = lstPrime.size()-1;
		Integer positionlast = position-2;
		Integer sum=0;
		Integer actual=0;
		while(position>2) {
			actual=lstPrime.get(position);
			sum=lstPrime.subList(positionlast, position-1).stream().reduce(0,(a,b)->a+b);
			if(sum==actual) {
				System.out.println(lstPrime.subList(positionlast, position-1));
				position--;
				positionlast=position-1;				
			}
			else if(sum<actual) {
				positionlast-=1;
			}else {
				position--;
				positionlast=position-1;
			}
		}
		System.out.println("	Solution problem 50 Euler");
	}
	public static List<Integer> lstPrime;
	public static Integer nextPrime(Integer num) {
		num++;
		if(num<4)
			return num;
		else
		{
			for(int i=1;i<lstPrime.size()-1;i++) {
				if(num%lstPrime.get(i)==0) {
					i=0;
					num++;
				}
			}
		}
		return num;
	}
	
	/*An irrational decimal fraction is created by concatenating the positive integers:
	 * 0.123456789101112131415161718192021...
	 * 	 12345678901234567892	
	 * It can be seen that the 12th digit of the fractional part is 1.
	 * If dn represents the nth digit of the fractional part, find the value of the following expression.
	 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
	 * 11:05-11:44->39 Minutes
	 * */
	public static void problem40() {
		System.out.println("Solve problem 40 Euler");
		HashMap<Integer, Integer> hmPosDigit = new HashMap<Integer, Integer>();
		Boolean isDone=true;
		Long number=1l;
		String strNumber=String.valueOf(number) ;
		Integer actualPos=0;
		Integer digit=1;
		hmPosDigit.put(1, digit);
		Integer searchPos=1;
		do {
			if(actualPos+ strNumber.length() >=  searchPos) {
				digit=Integer.parseInt((String) strNumber.subSequence((searchPos-actualPos-1) , (searchPos-actualPos))) ;
				hmPosDigit.put(searchPos, digit);
				searchPos=searchPos*10;
				if(searchPos==10000000)
					isDone=false;
			}
			actualPos+=strNumber.length();
			number+=1l;
			strNumber=String.valueOf(number);
		}while(isDone);
		System.out.println(hmPosDigit);
		
		System.out.println("	Solution problem 40 Euler =" +(hmPosDigit.values().stream().reduce(1,(a,b)->a*b)) );
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
