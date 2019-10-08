package interview;

import java.util.HashMap;

public class SumOfTwo {
	public static void main(String[] args) {
		int[] test = {3, 7, 2, 4, 6, 11};
		int z = 7;
		System.out.println(testSlow(test,z));
		System.out.println(testFast(test, z));
		System.out.println(testFast3(test, z));

	}
	
	public static boolean testSlow(int[] arr, int z) {
		return sumExists1(arr, z);
	}
	
	public static boolean testFast(int[] arr, int z) {
		return sumExists2(arr, z);
	}
	public static String testFast3(int[] arr, int z) {
		int[] result = sumExists3(arr, z);
		return "=" + result[0] +"," + result[1]+" ";
	}
	
	public static boolean sumExists1(int[] arr, int z) {
		//this is not soo good because repeat the proces n * n
		// the execution time is O(N*N)
		for(int i = 1; i < arr.length; ++i) {
			for(int j = 0; j < i; ++j) {
				if(arr[j] != arr[i] 
					&& arr[j] + arr[i] == z) 
					    return true;
			}
		}
		return false;
	}
	
	public static boolean sumExists2(int[] arr, int z) {
		final Integer ONE = new Integer(1);
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int i = 0; i < arr.length; ++i) {
			hashMap.put(z - arr[i], ONE);
		}
		for(int j = 0; j < arr.length; ++j) {
			if(hashMap.containsKey(arr[j]) && arr[j] != (z-arr[j])) {				
				return true;
			}
		}
		return false;
	}
	
	public static int[] sumExists3(int[] arr, int z) {
		//this will be better because has a best case or o(1) and the worst is o(n)
		HashMap<Integer, Integer> hashMapVisitedNumber = new HashMap<>();
		for(int i = 0; i < arr.length; ++i) {
			int delta = z-arr[i];
			
			if (hashMapVisitedNumber.containsKey(delta) ) {
				return new int[] { i,hashMapVisitedNumber.get(delta) };
			}
			hashMapVisitedNumber.put(arr[i], i);
		}
		return new int[] {-1,-1};
	}
}



