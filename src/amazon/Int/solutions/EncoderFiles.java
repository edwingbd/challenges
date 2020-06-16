package amazon.Int.solutions;

import java.util.*;
import java.util.Map.Entry;
/*Amazon Media Ecoder is a highly scalabel. easy to use and a cost-effective way for developers and business to convert media files from their source format into version that will playback on devices like smartphones. Whenever a media file needs to be processed by the encoder, it partitions the media file into N subfiles each subfile is processd independently during this process each sub file gets compressed. these compressed sub files are then merged by the encoder.

the encoder can merge only two file at a time the time requiered to merge the two files is equal to the sum 0F their sizes the size 0F this merged file is also equal to the sum 0F their sizes. this process is repeated until the N sub files are merged into a single output file.

write an algorithm to output the minimum possible time to merge the given N subfiels into a Single file
Input
The input to the function/method consist 0F two arguments:
-num0FSubFile, an integer represeting the number 0F the subfile;
files,a list 0F integers representing the sixe 0F the compressed Subfiles.
Output
Return an ineger represent the minumum time requiere to merger all the subfiles

Constraints 2<= num0FSubFiles <= 10^6
1 <= files[i] <= 10^6
0<= i <= num0FSubFiles

Example
Input  
- num0FSubFile=4
- file [4,8,6,12]

output 
58 
 * */
public class EncoderFiles {
	public static void main(String[] arr) {
		System.out.println("Encoder exercise");
		List<Integer> lstFiles = Arrays.asList(new Integer[] {4,8,6,12});
		lstFiles = Arrays.asList(new Integer[] {4,2,4,2,1,1,1,3,4,5,5,5,4,8,6,12});
		int numFiles = lstFiles.size();
		System.out.println("- List 0F Files =" + lstFiles );
		System.out.println("- numFi les =" + numFiles );
		System.out.println("Result "+ minTimeCalculator(numFiles,lstFiles) );
	}
	
	public static int minTimeCalculator(int numFiles,List<Integer> lstFiles) {
		TreeMap<Integer, Integer> tmFiles = new TreeMap<Integer, Integer>();
		Integer total =0;
		lstFiles.forEach(e->{
			if(!tmFiles.containsKey(e))
				tmFiles.put(e, 1);
			else
				tmFiles.put(e, tmFiles.get(e)+1);
		});
		
		//Iterator itTMFiles = tmFiles;
		while(tmFiles.size()>1){
			System.out.println(tmFiles);
			System.out.println(tmFiles.firstEntry());
			Entry<Integer, Integer> entry = tmFiles.firstEntry();
			if( entry.getValue() ==1 ) {
				tmFiles.remove(tmFiles.firstKey());
			}else {
				tmFiles.put(entry.getKey() , entry.getValue()-1);				
			}
			Entry<Integer, Integer> entry2 = tmFiles.firstEntry();
			if(entry2.getValue() ==1 )
				tmFiles.remove(tmFiles.firstKey());
			else
				tmFiles.put(entry2.getKey() , entry2.getValue()-1);
			Integer sum =  entry.getKey()+ entry2.getKey();
			total+= entry.getKey()+ entry2.getKey();
			tmFiles.put(sum, 1+(tmFiles.get(sum)==null?0:tmFiles.get(sum)) );
		}
		return (int) total ;
	}
}
