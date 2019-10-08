package interview;

import java.util.HashMap;
import java.util.HashSet;

public class TestHashSet {
	
	/*
	 System.out.println(Integer.MIN_VALUE);
     System.out.println(Integer.MAX_VALUE);
     System.out.println(Integer.MIN_VALUE - 1);
     System.out.println(Integer.MAX_VALUE + 1);
     */
	
	HashSet<Integer> hsData;// solo acepta un
	HashMap<Integer,Integer> hmData;
	TestHashSet(){
		hsData = new HashSet<Integer>();
		hmData.size();
		int datoInt=hmData.get(1).intValue();
		
		//hmData
	}
	
	 // Complete the sockMerchant function below.	
    static int sockMerchant(int n, int[] ar) {
        int pairs=0;
        // constraints
        if ( (n < 1)|| (n>100) || (ar.length < 0) || (ar.length > n) ){
            return 20;
        }
        else{
            
            HashMap<Integer,Integer> hmInteger = new HashMap <Integer,Integer>();
            for(Integer i=0;i<ar.length;i++){
                hmInteger.put(ar[i], ( hmInteger.get(ar[i]) == null)?1: hmInteger.get(ar[i]).intValue() +1 ) ;
            }
            
            for(int i=0;i<ar.length;i++){
                pairs=pairs+ (hmInteger.get(ar[i]).intValue()) / 2;
                hmInteger.put(ar[i],1);
            }
            //pairs = 1;
           // pairs = hmInteger.size();
        }
        return pairs;
        // logic

    }
    
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps =0 ;
        boolean jump1=false;
        boolean jump2=false;
        for(int i=0;i<c.length;jumps++){
            jump1 = ( ((i+1)<c.length) && c[i+1]==0)? true:false;
            jump2 = ( ((i+2)<c.length) && c[i+2]==0)? true:false;
            if (jump2)
                i=i+2;
            else
                i++;           
        }
        jumps--;
        return jumps;
    }
    

}
