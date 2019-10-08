package challenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SwapArray {
	public class While{
		public void loop() {
			int i=0;
			while(1==1) {
				i=i+1;
			}
		} 
	}
	
	public static int swapArray(int[] arrToSwap) {
		
		int n = arrToSwap.length;
		// sec sorted
		int swapSorted =0;
		int[] original = new int[n];
		Integer[] arrSorted = new Integer[n];
		Map<Integer,Integer> mapOriginalSr = new HashMap<Integer,Integer>();
		
		//int swapReversed =0;
		int swapReversed =0;
		int[] original2 = new int[n];
		Integer[] arrReversed = new Integer[n];
		Map<Integer,Integer> mapOriginalRv = new HashMap<Integer,Integer>();
		
		
		for(int i=0;i<n;i++){
			original[i]=arrToSwap[i];
			arrSorted[i]=arrToSwap[i];
			mapOriginalSr.put(arrToSwap[i], i);
			mapOriginalSr.put(arrToSwap[i], i);
		}
		Arrays.sort(arrSorted);
		for(int i=0;i<n;i++) {
			if(original[i]!=arrSorted[i]) {
				//must do swap
				int temp = original[i];
				original[i] = arrSorted[i];
				original[mapOriginalSr.get( arrSorted[i])]=temp;
				swapSorted++;
				
			}
		}
		
		
		
		Arrays.sort(arrSorted);
		for(int i=0;i<n;i++) {
			if(original[i]!=arrSorted[i]) {
				//must do swap
				int temp = original[i];
				original[i] = arrSorted[i];
				original[mapOriginalSr.get( arrSorted[i])]=temp;
				swapReversed++;
			}
		}
				
		
		return Math.min(swapReversed, swapSorted);
	}
	
	 // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {

        int n= arr.length;
        // sec sorted
        int sortedSwaps = 0; 
        int[] homework = new int[n];
        Integer[] homeworkSorted = new Integer[n];
        Map<Integer,Integer> original = new HashMap<>();
        //sec unsorted
        int sortedReverseSwaps = 0;    
        int[] homework2ndCopy = new int[n];        
        Map<Integer,Integer> original2ndCopy = new HashMap<>();
        
        //Initialize our arrays and maps
        for(int i = 0; i < n; i++)
        {
            homeworkSorted[i] = arr[i];
            homework[i] = homeworkSorted[i];
            homework2ndCopy[i] = homeworkSorted[i];
            original.put(homework[i],i);
            original2ndCopy.put(homework2ndCopy[i],i);
        }
            
        Arrays.sort(homeworkSorted);//Sort the input ascending
        
        for(int i = 0; i < n; i++)
        {
            if(homework[i] != homeworkSorted[i])
            {
                //swap the element from homework to the right position
                int tmp = homework[i];
                homework[i] = homework[original.get(homeworkSorted[i])];
                homework[original.get(homeworkSorted[i])] = tmp;
                //Update index after swap
                original.put(tmp,original.get(homeworkSorted[i]));
                sortedSwaps++;               
            }
        }
        
        Arrays.sort(homeworkSorted, Collections.reverseOrder());//Sort the input descending
        
        for(int i = 0; i < n; i++)
        {
            if(homework2ndCopy[i] != homeworkSorted[i])
            {
                //swap the element from homework to the right position
                int tmp = homework2ndCopy[i];
                homework2ndCopy[i] = homework2ndCopy[original.get(homeworkSorted[i])];
                homework2ndCopy[original2ndCopy.get(homeworkSorted[i])] = tmp;
                //Update index after swap
                original2ndCopy.put(tmp, original2ndCopy.get(homeworkSorted[i]));
                sortedReverseSwaps++;
            }
        }
        return (Math.min(sortedSwaps,sortedReverseSwaps));
        
    }
	
	
	public static void printArray(int[] arrToPrint) {
		String strPrint="{";
		for(int dato:arrToPrint)
			strPrint+=dato+",";
		if(strPrint.length()>2) {
			strPrint=strPrint.substring(0, strPrint.length()-1 );}
		strPrint+="}";
		System.out.println(strPrint);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrToSwap = {50,10,20,30,40};
		System.out.println("swaps pre "+lilysHomework(arrToSwap));
		System.out.println("swaps egb "+swapArray(arrToSwap));
	}

}
