package concepts;

/*
 * You have 2 strings which have key and values (spaces between 2pairs can vary)
 * String1 = "key1=value1     key22=value2 key3=value3 key4=value4"
 * String2 = "key1=value1  key2=value2 key33=value33       key4=value44"
 * Need to write a solution to identify which keys are different in 2 strings and what those keys are 
 * For keys which are same , need to find out if values are same or not , if not print those as well;
 * 
 * Answer to problem would be -
 * String1 has key22 and key3 which are not available in string2
 * String2 has key 2 and key33 which are not available in string1
 * key4 exist in both string but values are different.
 *
 */


/*
 * You have 2 strings which have key and values (spaces between 2pairs can vary)
 * String1 = "key1=value1     key22=value2 key3=value3 key4=value4"
 * String2 = "key1=value1  key2=value2 key33=value33       key4=value44"
 * Need to write a solution to identify which keys are different in 2 strings and what those keys are 
 * For keys which are same , need to find out if values are same or not , if not print those as well;
 * 
 * Answer to problem would be -
 * String1 has key22 and key3 which are not available in string2
 * String2 has key 2 and key33 which are not available in string1
 * key4 exist in both string but values are different.
 *
 */




import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    String string1 = "key1=value1     key22=value2 key3=value3 key4=value4";
    String string2 = "key1=value1  key2=value2 key33=value33       key4=value44";
    
    HashMap<String,String> mpStr1 = new HashMap<String,String>();
    HashMap<String,String> mpStr2 = new HashMap<String,String>();
    
   //String[] arrstr1=
    
    for(String strEle : string1.split(" ") ){
      if (strEle.split("=").length >=2 ) {
        String key= strEle.split("=")[0].trim() ;
        String value= strEle.split("=")[1].trim() ;
        mpStr1.put(key,value);
      }
    }
    
    for(String strEle: string2.split(" ") ){
       if (strEle.split("=").length >=2 ) {
      String key= strEle.split("=")[0].trim() ;
      String value= strEle.split("=")[1].trim() ;
      mpStr2.put(key,value);
       }
    }
    
  //   for (Map.Entry<String, Integer> entry : items.entrySet()) {
  //   System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
  // }
    
    ///check equals.
    
    String strOutPut1="String1 has ";
    String strOutPut2="String2 has ";
    String strOutPut3="";
    
    for(Map.Entry<String, String> entry: mpStr1.entrySet() )
    {
      if( mpStr2.containsKey( entry.getKey() ))
      {
        if(!entry.getValue().equals(mpStr2.get(entry.getKey()) ) )
        {//key is in both but different
          strOutPut3=strOutPut3+ entry.getKey() ;
        }
        
      }
      else{
        //key is not in mpstr2
        strOutPut1 = strOutPut1+" "+entry.getKey() + " and ";
      }
    }
    
    for(Map.Entry<String, String> entry: mpStr2.entrySet() )
    {
      if(!mpStr1.containsKey( entry.getKey() )){
        //key is not in mpstr1
        strOutPut2 = strOutPut2+" "+entry.getKey() + " and ";
      }
    }
    // remoeve the and
    strOutPut1 = strOutPut1+ "which are not available in string2";
    strOutPut2 = strOutPut2+ "which are not available in string1";
    strOutPut3 = strOutPut3+" exist in both string but values are different.";
    System.out.println(strOutPut1);
    System.out.println(strOutPut2);
    System.out.println(strOutPut3);
  }
}
