package cat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {
		// es una funcion que que es un string con una o muchas plagaras 
		// almenos tinee texto 10 palabmas como nimo 
		// queremos que devuela la tercera palabra mas repetida.
		// si no hay tercer elemento repetido se devuelve null 
		// si hay 5 4 3 3  - cuyalqueira de las 3 es una respuesta valida
		
		String texto=" ab ab ab ab cd cd cd g g g";
		System.out.println(texto);
		System.out.println("la tercera palabra mas repetida es:"+tercerRepetida(texto) );
	}
	
	
	public static String tercerRepetida(String texto) {
		
		// 1 split de la pabra por spaci
		// 2 agregar un DS K,V 
		// 3 SI EXISTE INCREMENTO EL VLAUE
		// 4 VALUE A UN SET BUSCO LA TERCERA DEL SET Y PIDO LAS KEY DEL VALUE
		// 5 RETORNO EL PRIMER VALUE1
		String[] strArr = texto.split(" ");
		HashMap<String,Integer>  hmPalabras = new HashMap<String,Integer>();
				
		for(int i=0;i<strArr.length;i++) {
			Integer value =1;
			if ( hmPalabras.containsKey(strArr[i]) ) {
				value = hmPalabras.get(strArr[i])+1;
			}
			hmPalabras.put(strArr[i], value);
		}
		
		
		List<Integer> lstCont = new ArrayList<Integer>(hmPalabras.values());
		
		System.out.println( lstCont );
		
		return "";
	} 

}
