package structures;

public class Prime {
	
	public static boolean isPrime(int n) {  
       if ((n < 2) || ( (n%2 ==0 ) && (n > 2) )) {  
           return false;  
       }  
       int top = (int) (Math.sqrt(n)+1);
       for (int i = 3; i < top; i+=2) {  
           if (n % i == 0) {  
               return false;  
           }  
       }  
       return true;  
   } 
	public static boolean isPrime(Integer n) {  
       return isPrime((int) n);  
   }
}
