package structures;

import java.util.HashMap;
import java.util.Map;

class Fibonacci
{
	private static Map<Integer,Integer> previousValues;
	
	static {
		previousValues = new HashMap<Integer, Integer>();
		previousValues.put(0, 0);
		previousValues.put(1, 1);
    }
	
	static int fib(int n) // with out recursion
 	{
	/* Declare an array to store Fibonacci numbers. */
	   int f[] = new int[n+1];
	   int i;
	
	   /* 0th and 1st number of the series are 0 and 1*/
	   f[0] = 0;
	   f[1] = 1;
	
	   for (i = 2; i <= n; i++)
	   {
	       /* Add the previous 2 numbers in the series
	    and store it */
	       f[i] = f[i-1] + f[i-2];
	    }
	
	    return f[n];
 	}
	// need to test 
	static int fibRecursion(Integer n) {
		 if (n==0)
			 return 0;
		 if (n==1)
			 return 1;
		 if (previousValues.containsKey(n) )
			 return previousValues.get(n);
		 previousValues.put(n, fibRecursion(n-2)+fibRecursion(n-1));
		 return previousValues.get(n);
	}
}