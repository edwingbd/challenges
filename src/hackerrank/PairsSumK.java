package hackerrank;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PairsSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hackerrank return the quantity of pairs in array that sum k ");
		int arr[] = {1,2,3,4,5,1,2,3,4,1,4,1,6,7,9};
		int k = 5;
		
				
		System.out.println( "pairs that sum equals to k ="+calculatePairsSumK(arr,k) );
	}
	/*
	 * 6:48
	 * 3 escribir
	 * 5 explicando
	 * */
	public static int calculatePairsSumK(int arr[],int k) {
		Set<Integer> tsArr = new TreeSet<Integer>();
		tsArr.addAll(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)).stream().map(e->e ).collect(Collectors.toList()));
		tsArr.forEach(System.out::println) ;
		tsArr=tsArr.stream().filter(e->e<k).collect(Collectors.toSet());
		tsArr.forEach(System.out::println) ;
		return 0;
	}

}
