package challenges;

import java.util.ArrayList;
import java.util.*;

public class permutation3 {

//	Given a collection of distinct integers, return all possible permutations.
//			Example:
//			Input: [1,2,3]
//			Output:
//			[
//			  [1,2,3],
//			  [1,3,2],
//			  [2,1,3],
//			  [2,3,1],
//			  [3,1,2],
//			  [3,2,1]
//			]
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr =  {1,2,3};
		System.out.println(Arrays.toString(arr));
		System.out.println("Permute");
		System.out.println(permute(arr));
		
		System.out.println(permute(arr).size() );

	}
	private static List<List<Integer>> permute(int[] arr)
	{
		List<List<Integer>> listNew = new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			int next1= (i+1 >= arr.length )? i+1-arr.length : i+1; 
			int next2= (i+2 >= arr.length )? i+2-arr.length : i+2; 
			List<Integer> lstInteger = new ArrayList<>();
			lstInteger.add(arr[i]);
			lstInteger.add(arr[next1]);
			lstInteger.add(arr[next2]);
			listNew.add(lstInteger);
			List<Integer> lstInteger2 = new ArrayList<>();
			lstInteger2.add(arr[i]);
			lstInteger2.add(arr[next2]);
			lstInteger2.add(arr[next1]);
			listNew.add(lstInteger2);
		}
		
		return listNew;
	}
}
