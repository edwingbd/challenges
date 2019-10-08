package interviews;

import java.util.Arrays;

public class SumArraysPositions {
/* Given an array of integers, return an array of integers which contains
[1st integer, Sum of next 2 integers (2nd, 3rd), Sum of next 3 integers (4th, 5th, 6th)…]

Input size n
[1,6,8,5,9,4,7,2]
Output size m
[1,14,18,9]



1st Element of the result Array is sum of 1st element
2nd Element of the result Array is sum of Next 2 element of input array 
3rd element of the result array is sum of next 3 Elements of input array
4th element of the result array is sum of next 4 elements of input array but there are not four elements in the array so it takes the some
of rest of the elements
*/
	public static void main(String[] args) {
		int[] inputArray = {1,6,8,5,9,4,7,2};
		int[] Output = process(inputArray);
		StringBuffer strInput= new StringBuffer("");
		for(int Val:inputArray)
			strInput.append(Val).append(",") ;
		StringBuffer strOutput= new StringBuffer("");
		for(int Val:Output)
			strOutput.append(Val).append(",") ;	
		 
		System.out.println("strInput="+strInput);
		System.out.println("strOutput="+strOutput );
	}
	
	public static int[] process(int[] inputArray) {
		int[] Output = new int[inputArray.length];
		Arrays.fill(Output, -1);
		int sizeOutPut=0;
		int pos=0;
		for(int i =0;i<inputArray.length;i++  ) {
			int result =0;
			int j;
			for(j=pos ;j<(pos+i+1) && j< inputArray.length ;j++ ) {
				result=result+inputArray[j];
			}
			if(j+1>=inputArray.length) {
				Output[i]=result;
				sizeOutPut=i;
				break;
			}else {
				pos=j;
			}		
			Output[i]=result;
		}
		int[] intOutput =new int[sizeOutPut+1];
		System.arraycopy(Output, 0, intOutput, 0, sizeOutPut+1);
		return intOutput ; 
	}
}
