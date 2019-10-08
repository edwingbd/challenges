package interviews.artech;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PalindromeCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String texto="aaa";
		//texto="abccba";
		texto="daata";
		System.out.println(texto);
		System.out.println(countPalindromes(texto) );
	}
	public static int countPalindromes(String s) {
		
		String[] arrLetter= s.split("");
		//s.length()
		int countPal=0;
		for(int i=0;i<arrLetter.length ;i++ ) {
			for(int j=i;j<arrLetter.length ;j++ ) {
				countPal += isPalindrome(s.substring(i, j+1))? 1:0;
			}
		}
		return countPal;
	}
	
	
	
	public static boolean isPalindrome(String s) {
		if (s.length()<=1) {
			//System.out.println("		sic	_"+s);
			return (s.length()==0)?false:true;
		}
		for(int i=0;i<(s.length()/2+1) && i<s.length() ;i++ ) {
			if( s.toCharArray()[i] != s.toCharArray()[s.length()-1-i] ) {
				//System.out.println("	no_"+s);
				return false;
			}
		}
		//System.out.println(s);
		//System.out.println("		si_#	_"+s);
		return true;
	}
}
