package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problems_6_to_10 {

	public static void main(String[] args) {
		problem6();
		problem7();
		problem8();
		problem9();
		problem10();
	}

	public static void problemX() {
		System.out.println("Solve problem X Euler");
		System.out.println("	Solution problem X Euler");
	}
	/*The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * Find the sum of all the primes below two million.
	 * 30 min
	 * */
	public static List<Integer> lstPrime;
	public static void problem10() {
		System.out.println("Solve problem 10 Euler");
		lstPrime = new ArrayList<Integer>();
		lstPrime.add(1);
		for(int i=1;;i++) {
			lstPrime.add(nextPrime(lstPrime.get(lstPrime.size()-1) ));
			if(lstPrime.get(lstPrime.size()-1)>2000000)
			{
				//System.out.println("	greater thant 2millions="+lstPrime.get(lstPrime.size()-1) );
				lstPrime.remove(lstPrime.size()-1);
				break;
			}
		}
		System.out.println("	Solution problem 11 Euler="+lstPrime );
		System.out.println("	Solution problem 11 Euler sum="+lstPrime.stream().map(Integer::longValue).reduce(0l,(a,b)->a+b)  );
	}
	
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
		//System.out.println(" lstPrime="+(lstPrime.size()-1)+" lengt="+lstPrime.get(lstPrime.size()-1).toString().length() );
		return num;
	}
	
	/*A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
	 * a2 + b2 = c2
	 * For example, 32 + 42 = 9 + 16 = 25 = 52.
	 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 * Find the product abc.
	 * solved in 60 minutes or less but is not efficient
	 * */
	public static void problem9() {
		System.out.println("Solve problem 9 Euler");
		Integer result = 1;
//		for(int c=997;c>0;c--) {
//			for(int b=1000-c;b>0 && b<c ;b--) {
//				for(int a=1000-c-b;a>0 && a<c && a<b ;a--) {
//					//System.out.println("a="+a+" b="+b+" c="+c);
//					if(a+b+c==1000) {
//						System.out.println("a="+a+" b="+b+" c="+c);
//						System.out.println("a="+a*a+" b="+b*b+" c="+c*c);
//						System.out.println("c-b-a="+(c*c-a*a-b*b) );
//						if(a*a+b*b==c*c) {
//							System.out.println("triangle a="+a+" b="+b+" c="+c);
//							result=a*b*c;
//						}
//					}
//				}
//			}
//		}
		
		for(int c=0;c<1000;c++) {
			for(int b=0;b<1000;b++){
				for(int a=0;a<1000;a++) {
					//System.out.println("a="+a+" b="+b+" c="+c);
					if((a+b+c==1000)&&(a<b && b<c) ) {
//						System.out.println("a="+a+" b="+b+" c="+c);
//						System.out.println("a="+a*a+" b="+b*b+" c="+c*c);
//						System.out.println("c-b-a="+(c*c-a*a-b*b) );
						if(a*a+b*b==c*c) {
							System.out.println("triangle a="+a+" b="+b+" c="+c);
							result=a*b*c;
						}
					}
				}
			}
		}

		
		System.out.println("	Solution problem 9 Euler+" + result);
	}
	/*he four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
	 *Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
	 * 50 minutos el problema es el long es decir la capacidad de int y long se debe tener encuenta convertir todo a long paga poder sobrepasar este 
	 * */
	public static void problem8() {
		System.out.println("Solve problem 8 Euler");
		String numberText="73167176531330624919225119674426574742355349194934" + 
				"96983520312774506326239578318016984801869478851843" + 
				"85861560789112949495459501737958331952853208805511" + 
				"12540698747158523863050715693290963295227443043557" + 
				"66896648950445244523161731856403098711121722383113" + 
				"62229893423380308135336276614282806444486645238749" + 
				"30358907296290491560440772390713810515859307960866" + 
				"70172427121883998797908792274921901699720888093776" + 
				"65727333001053367881220235421809751254540594752243" + 
				"52584907711670556013604839586446706324415722155397" + 
				"53697817977846174064955149290862569321978468622482" + 
				"83972241375657056057490261407972968652414535100474" + 
				"82166370484403199890008895243450658541227588666881" + 
				"16427171479924442928230863465674813919123162824586" + 
				"17866458359124566529476545682848912883142607690042" + 
				"24219022671055626321111109370544217506941658960408" + 
				"07198403850962455444362981230987879927244284909188" + 
				"84580156166097919133875499200524063689912560717606" + 
				"05886116467109405077541002256983155200055935729725" + 
				"71636269561882670428252483600823257530420752963450";
		List<Integer> digits=Arrays.stream(numberText.split("")).map(Integer::parseInt)
		        .collect(Collectors.toList()); //; // .toCharArray()); //.stream().map(e->(Integer) e).collect(Collectors.toList()) ;
		List<Integer> digitsMulti;
		long greatesProduct = 1l;
		long actualProduct = 1l;
		int pos=0;
		for(int i=0;i<(1000-12);i++ ) {
			digitsMulti=digits.subList(i, i+13);
			actualProduct = digitsMulti.stream().mapToLong(e->e).reduce(1,(a, b)->a*b);
			if(greatesProduct<actualProduct) {
				//System.out.println(digitsMulti + " *="+actualProduct);
				greatesProduct =actualProduct;
				pos=i;
			}
		}
		digitsMulti=digits.subList(pos, pos+13);
		System.out.println("	Solution problem 8 Euler 13 number="+ (digitsMulti.stream().map(e->""+e).reduce("",(a,b)->a+b))  );
		System.out.println("	Solution problem 8 Euler product="+greatesProduct );
	}
	
	/*By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	 * What is the 10 001st prime number?
	 * 40 minutos eror en la posicion del arreglo por eso me tomo mas tiempo.
	 * * */
	public static List<Long> primeNumbers;
	
	public static void problem7() {
		System.out.println("Solve problem 7 Euler");
		primeNumbers = new ArrayList<Long>();
		primeNumbers.addAll( Arrays.asList(2l,3l,5l,6l,11l,13l));
		for(int i=6;i<10002;i++) {
			System.out.println( "pos="+i+" prime="+nextPrime( primeNumbers.get(primeNumbers.size()-1) ) );
		}
		System.out.println("	Solution problem 7 Euler=" + primeNumbers.get(primeNumbers.size()-1) );
	}
	public static long nextPrime(long prime) {
		Boolean flag = true;
		prime += 1;
		System.out.println(prime);
		for (int i = 0; i < primeNumbers.size() ; i++) {
			if (prime % primeNumbers.get(i) == 0) {
				i = -1;
				prime++;
			}
		}
		primeNumbers.add(prime); 
		return prime;
	}
	
	/**The sum of the squares of the first ten natural numbers is,
	 * 12+22+...+102=385
	 * 	 * The square of the sum of the first ten natural numbers is,
	 * 	 * 		(1+2+...+10)2=552=3025
	 * 	 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025-385=2640.
	 * 	 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	 *  * time 7:32
	 * */
	public static void problem6() {
		System.out.println("Solve problem 6 Euler");
		Long result =0l;
		Long square =0l;
		Long sum =0l;
		for(int i=1;i<101;i++) {
			square+=i*i;
			sum+=i;
			//System.out.println("sum"+sum+"square"+square);
		}
		result=sum*sum-square;
		System.out.println("	Solution problem 6 Euler = " + result);
	}

}
