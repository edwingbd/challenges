package cat;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CATexercise();
		minimumCommuneDivisor();
	}
	
	// how to ....9:00
	public static void minimumCommuneDivisor() {
		String text1 = "xaxaxaxa";
		String text2 = "xaxa";
		System.out.println(text1 + " " + text2 + " Result =" + minimumCommuneDivisor(text1, text2));
	    
		text1 = "bbbb";
		text2 = "bbb";
	    System.out.println(text1 + " " + text2 + " Result =" + minimumCommuneDivisor(text1, text2));		
	}
	
	public static int minimumCommuneDivisor(String text1,String text2) {
		int size=0;
		String strMCD =(text1.length()<text2.length())? text1:text2;
		String strGrader =(text1.length()<text2.length())? text2:text1;
			
		size=strMCD.length();
		while(strMCD.length() >0) {
			if ( isDivisor(text1,strMCD) && isDivisor(text2,strMCD))
					size=strMCD.length();
			strMCD=strMCD.substring(1);
			System.out.println("strMCD " + strMCD);
		}
		return size;
	}
	
	public static Boolean isDivisor(String texto, String divisor) {
		String result = texto.replaceAll(divisor, "");
		System.out.println("    texto="+texto+" divisor="+divisor+" Result="+ result);
		return result.equals("");
	}
	
	/*tehere is two solutions check the time*/
	// End 
	// CAT Interview 
	// function that receive two string and one character returns int
	// function retun how many times the given character is in the given string
	// "hello world" char o = 2

	public static void CATexercise(){
		String text = "hello world";
		char caracter='o';
		System.out.println("result="+countChar(text,caracter) );
	}
	
	public static int countChar(String str,char caracter) {
		//str.le
		if( str.equals(""))
			return 0;
		if(str.charAt(0) == caracter)
			return 1 + countChar(str.substring(1),caracter) ;
		else
			return 0 + countChar(str.substring(1),caracter) ;
	}
	// End Cat
}
