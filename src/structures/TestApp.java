package structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class TestApp {
	public static void main(String[] args)throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String option ="0";
		String optionDefault = "51";
		while(!option.equals("5") ) {
			System.out.println("withs options do you want? \n 1- Linked List\n 21- question 1 \n 5 Exit");
			System.out.println(
					"10 \"Write a function that counts the number of primes in the range [1-N].\r\n" + 
					"11 \"Write a function that give the fibonnacti number of n \r\n" +
					"20\"Write a function that will return the number of days in a month (no using System.DateTime)\r\n" + 
					"30.Write a function that inserts an integer into a linked list in ascending order. Write the test cases for this function..\r\n" + 
					"40.Given an array of characters which form a sentence of… "
					+ "Coding questions:\r\n" + 
					"51) Given two words, find if second word is the round rotation of first word.\r\n" + 
					"For example: abc, cab\r\n" + 
					"return 1\r\n" + 
					"since cab is round rotation of abc\r\n" + 
					"\r\n" + 
					"Example2: ab, aa\r\n" + 
					"return -1\r\n" + 
					"since aa is not round rotation for aa\r\n" + 
					"\r\n" + 
					"52) Given two hexadecimal numbers find if they can be consecutive in gray code\r\n" + 
					"For example: 10001000, 10001001\r\n" + 
					"return 1\r\n" + 
					"since they are successive in gray code\r\n" + 
					"\r\n" + 
					"Example2: 10001000, 10011001\r\n" + 
					"return -1\r\n" + 
					"since they are not successive in gray code.");
			if (optionDefault != "0") {
				option = optionDefault;	
				optionDefault="0";
			}else {
				option = reader.readLine();	
			}
			switch (option) {
			
			case "51":
				amazon1();
				break;
			case "52":
				amazon2();
				break;
			case "53":
				amazon3();
				break;
			case "1":
				LinkedListOption();
				break;				
			case "21":
				Question_sort();
				break;
			case "10":
				questionCountPrime();
			case "11":
				questionFibonacci();				
				break;
			case "20":
				questionDate();				
				break;
			default:
				break;
			}
			reader.readLine();
		}
	}
	
	public static void amazon1() throws IOException {
		String readTerminal1="";
		String readTerminal2="";
		Integer n,count=0;
		System.out.print("Write the first Word\n");
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
		readTerminal1 = reader1.readLine();
		System.out.print("Write the second Word\n");
		readTerminal2 = reader1.readLine();
		System.out.print("\nthe words are="+readTerminal1+" and:"+readTerminal2);
		System.out.print("\n"+testWords(readTerminal1, readTerminal2)+"\n");
	}
	
	public static boolean testWords(String st1,String st2) {
		IntStream intStream1 = st1.chars();
		IntStream intStream2 = st2.chars();
		///intStream1.map(e->intStream2.filter(predicate))
		return true;
	} 
	
	public static void amazon2() {
		String readTerminal="";
		Integer n,count=0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	}
	public static void amazon3() {
		String readTerminal="";
		Integer n,count=0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void questionFibonacci() {
		String readTerminal="";
		Integer n,count=0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("\n \n");
			System.out.println("\n Write the n Value");
			readTerminal = reader.readLine();
			n=Integer.decode(readTerminal);
			System.out.println("    n="+n);
			System.out.println(Fibonacci.fibRecursion(n));
		}
		catch(Exception e){
			System.out.println("\n Is not valid the value");			
		}
	}
	
	public static void questionDate() {
		String readTerminal ="";
		Integer month =0;
		//int months[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		int months2[]= new int[20];
		int months3[];
		int months[] = {31,29,31,30,31,30,31,31,30,31,30,31};
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Write the month:");
			readTerminal = bufferedReader.readLine();
			month=Integer.decode(readTerminal);
			if (month<1||month>12)
				throw new InvalidValueException("the values is not correct");
			System.out.println("the month have:"+months[month-1] );
		}
		catch (InvalidValueException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println("generate and error");
		}
	}
	
	public static void questionCountPrime() {
		String readTerminal="";
		Integer n,count=0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("\\f");
			System.out.println("\n Write the n Value");
			readTerminal = reader.readLine();
			n=Integer.decode(readTerminal);
			System.out.println("Found in n="+n);
			for (int i =1 ; i<=n ;i++ ) {
				if (Prime.isPrime(i)){
					System.out.println("*"+i);
					count++;
				}
			}
			System.out.println("the count is ="+count);
		}
		catch(Exception e){
			System.out.println("\n Is not valid the value");			
		}
		
	}
	
	public static void Question_sort() {
		int a[] = {4,3,1,6,4,3,6};
		int b[][] = new int[a.length][2];
		
		MergeSort.printArray(a);
		MergeSort sorter = new MergeSort();
		sorter.sort(a);
		MergeSort.printArray(a);
		
		
		int aa[] = {4,3,1,6,8,13,16,14};
		MergeSort.printArray(aa);
		sorter.sort(aa,0,aa.length-1);
		MergeSort.printArray(aa);
		
		
	}
	
	public static void sort() {
		
	}
	
	
	public static void LinkedListOption() {
		System.out.println("this is the option of linkded list");
		ArrayList<String> aList = new ArrayList<>();
		aList.add("d");
		aList.add("w");
		aList.add("i");
		LinkedList llJava= new LinkedList();
		llJava.addFirst("e");
		llJava.addAll(aList);
		llJava.addLast("n");
		System.out.println( "java linkedList wiht add or array:"+ llJava.toString());
		LinkedListEB llEB = new LinkedListEB();
		llEB.addValue(1);
		llEB.addValue(20);
		llEB.addValue(300);
		llEB.addValue(4000);
		llEB.addValue(5000);
		System.out.println(llEB.toString());
		
		
	}

	public static Node addNumbers(Node a, Node b){
	    Node nodeResult = null,tempResult ;
//	    Node testA=a;
//	    Node aRevert=a;
//	    Node tempA,tempB;
//	    
//	    Node testB=b;
//	    Node bRevert=b;
//	    
//	    int valueA =0;
//	    int valueB =0;
//	    int intResult =0;
//	    int unit =0;
//	    
//	    tempA=aRevert.next;//i had the next
//	    aRevert.next=null;// put this at the end
//	    while(tempA.next!=null ) {
//	    	aRevert = tempA;
//	    	tempA=aRevert.next;
//	    	aRevert.next=
//	    }
//	    
//	    
//	    
//	    do{
//	        valueA=valueA*10 + testA.val;
//	        testA=testA.next;
//	    }while(testA !=null);   
//
//	    do{
//	        valueB=valueB*10 + testB.val;
//	        testB=testB.next;
//	    }while(testB !=null);
//	    
//	    intResult= valueA+valueB;
//	    
//	    nodeResult= null;
//	    do{
//	        unit= (intResult % 10);
//	        tempResult = new Node (unit);
//	        if (nodeResult == null)
//	            nodeResult=tempResult;
//	        tempResult=tempResult.next;
//	        intResult=intResult/10;
//	    }while(intResult!=0);
	    
	    return nodeResult;
	}
}