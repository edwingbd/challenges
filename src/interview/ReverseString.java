package interview;

public class ReverseString {
	
	public static String reverseWithStringBuilder(String str) {
//		StringBuilder strBuilder = new StringBuilder();
//		strBuilder.append(str);
//		return strBuilder.reverse().toString() ;
		return new StringBuilder(str).reverse().toString();
	}
	
	public static String reverseManualy(String str) {
//		char[] cs = str.toCharArray();
//		char[] csReturn = new char[cs.length];
//		
//		for(int i =0;i< cs.length;i++  )
//			csReturn[cs.length-i-1]=cs[i];
//		
//		return String.valueOf(csReturn) ;
		StringBuilder strReturn = new StringBuilder();
		for (int i=str.length()-1;i>=0;i-- )
			strReturn.append(str.charAt(i));
		return strReturn.toString()+" _v2" ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="Hello World!";
		System.out.println(str);
		System.out.println(reverseWithStringBuilder(str) );
		System.out.println(reverseManualy(str) );
	}

}
