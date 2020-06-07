package challenges;

import java.util.*;
import java.util.stream.Collectors;

public class CharactersOfString {
	static final int MAX_CHARS = 256; 
    
    // Function to find smallest window containing 
    // all distinct characters 
	 static String findSubStringLento(String str) 
	 { 
		 List<Character> lstChar2 = str.chars().mapToObj(e-> (char) e).collect(Collectors.toList());
		 char value;
		 boolean flag=true;
		 int iRight =0 , iLeft= 0;
		 do {
			 value=lstChar2.get(iRight);
			 lstChar2.remove(iRight);
			 if ( !lstChar2.contains(value) ) {
				 lstChar2.add(iRight, value);
				 flag=false;
			 }
		 }while(flag);
		 flag = true;
		 do {
			 iLeft= lstChar2.size()-1 ;
			 value=lstChar2.get(iLeft);
			 lstChar2.remove(iLeft);
			 if ( !lstChar2.contains(value) ) {
				 lstChar2.add(iLeft, value);
				 flag=false;
			 }
		 }while(flag);
		 
		 return lstChar2.stream().map(e->e.toString() ).reduce((a,b)->a+b).orElse("") ;
	 }
	 
	 static String findSubStringFast(String str) 
	 {
		 boolean[] flagLetter = new boolean[256];
		 Arrays.fill(flagLetter, false);
		 
		 int[] countLetter = new int[256];
		 Arrays.fill(countLetter, 0);
		 
		 int n = str.length();
		 int countDist =0;
		 int countWindow=0;
		 int min=0;
		 int min_len = Integer.MAX_VALUE;
		 int startFinal=0;

		 for(int i=0;i<n;i++) {
			 if(!flagLetter[ str.charAt(i) ]) {
				 countDist++;
			 }
			 flagLetter[ str.charAt(i) ] =true;
		 }
		 
		 
		 for(int i=0;i<n;i++) {
			 if(countLetter[str.charAt(i)]==0) {
				 countWindow++;
			 }
			 countLetter[str.charAt(i)]++;
			 if(countWindow==countDist) {
				 //if length is equal finish
				 while( countLetter[str.charAt(min)] >1) {
					 //if(countLetter[str.charAt(min)] >1)
					 //{
						 countLetter[str.charAt(min)] --;
					 //}
					 min++;
				 }
				 int lengthWindow=i-min+1;//tamaño de la ventana
				 if(min_len> lengthWindow) {
					 startFinal=min;
					 min_len=lengthWindow;
				 }
			 }
		 } 
		 return str.substring(startFinal, startFinal+min_len);// +"\n\n"+"listo_"+min+"_"+max+"_"+"\n" ;
	 }
	 
	static String findSubString(String str) 
    { 
        int n = str.length(); 
       
        // Count all distinct characters. 
        int dist_count = 0; 
          
        boolean[] visited = new boolean[MAX_CHARS]; 
        Arrays.fill(visited, false); 
        for (int i=0; i<n; i++) 
        { 
            if (visited[str.charAt(i)] == false) 
            { 
                visited[str.charAt(i)] = true; 
                dist_count++; 
            } 
        } 
       
        // Now follow the algorithm discussed in below 
        // post. We basically maintain a window of characters 
        // that contains all characters of given string. 
        // https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/  
        int start = 0, start_index = -1; 
        int min_len = Integer.MAX_VALUE; 
       
        int count = 0; 
        int[] curr_count =  new int[MAX_CHARS]; 
        for (int j=0; j<n; j++) 
        { 
            // Count occurrence of characters of string 
            curr_count[str.charAt(j)]++; 
       
            // If any distinct character matched, 
            // then increment count 
            if (curr_count[str.charAt(j)] == 1 ) 
                count++; 
       
            // if all the characters are matched 
            if (count == dist_count) 
            { 
                // Try to minimize the window i.e., check if 
                // any character is occurring more no. of times 
                // than its occurrence in pattern, if yes 
                // then remove it from starting and also remove 
                // the useless characters. 
                while (curr_count[str.charAt(start)] > 1) 
                { 
                    if (curr_count[str.charAt(start)] > 1) 
                        curr_count[str.charAt(start)]--; 
                    start++; 
                } 
                  
                // Update window size 
                int len_window = j - start + 1; 
                if (min_len > len_window) 
                { 
                    min_len = len_window; 
                    start_index = start; 
                } 
            } 
        } 
        // Return substring starting from start_index 
        // and length min_len 
        return str.substring(start_index, start_index+min_len); 
    } 
       
    // Driver code 
    public static void main(String args[]) 
    { 
    	
        String str = "aabcbcdbcaaaadsfadsfdsafadsfdsafdsa werefefasdsafdsafsadqqqqeeererereeesassssaaaaaaaabcbcaaaaaaabscdwer fqaaaa"; 
        System.out.println("Smallest window containing all distinct"
               + " characters is\n");
        
        Long start= System.currentTimeMillis();
        System.out.println("texto="+str);
        System.out.println("findSubStringLento= 	"+findSubStringLento(str));
        Long end1= System.currentTimeMillis();
        
        System.out.println("findSubString= 		"+ findSubString(str));
        Long end2= System.currentTimeMillis();
        System.out.println("findSubStringFast= 	"+ findSubStringFast(str));
        Long end3= System.currentTimeMillis();
        
        
        System.out.println("findSubStringLento "+ (end1-start));
        System.out.println("findSubString  "+ (end2-end1));
        System.out.println("findSubStringFast  "+ (end3-end2));
        

    } 
} 
