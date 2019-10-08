package interviews.artech;

import static org.junit.Assert.fail;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WholeMinuteDilemma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lst= new ArrayList<Integer>();
		lst.add(30);
		lst.add(20);
		lst.add(150);
		lst.add(100);
		lst.add(100);
		lst.add(40);
		System.out.println(lst);
		long startTime = System.nanoTime();
		System.out.println(playlist(lst));
		long endTime = System.nanoTime();
		System.out.println(playlist2(lst));
		long endTime2 = System.nanoTime();
		System.out.println("1=" + (endTime- startTime)/1000 );
		System.out.println("2=" + (endTime2- endTime)/1000 );
	}
	// old way
	public static long playlist2(List<Integer> songs) {
		//List<PairSongs> lstPairSongs = new ArrayList<>();
		long total = (long) 0 ;
		Hashtable<Integer, Integer> htTimeExpected = new Hashtable<>() ;
		for(int i=0; i<songs.size() ;i++) {
			int time=songs.get(i);
			int restominute= (time - (time/60)*60);
			//System.out.println("	time="+time+ "restominute=\t"+ restominute );
			if (!htTimeExpected.containsKey(restominute)  ) {
				htTimeExpected.put(restominute, 1);
			}else {
				htTimeExpected.put(restominute, (htTimeExpected.get(restominute)+1) );
			}
		}
		//System.out.println(htTimeExpected);
		Enumeration e = htTimeExpected.keys();
		while(e.hasMoreElements()) {
			Integer value=(Integer) e.nextElement();
			Integer res=60-value;
			//System.out.println("value"+value+"res"+res);
			if (htTimeExpected.containsKey(res)  ) {
				if(value==res)
					total = total + ( htTimeExpected.get(value))/2 ;
				else
					total = total + ( htTimeExpected.get(value)*htTimeExpected.get(res));
				htTimeExpected.remove(value);
			}
		}
		
		
		//System.out.println(htTimeExpected);
		return total;
	}
	
	public static long playlist(List<Integer> songs) {
		Long[] total = {(long) 0 };
		IntStream.range(0, songs.size()).forEach(i->{
			IntStream.range(i+1,songs.size() ).forEach(j->{
				if( (songs.get(i)+songs.get(j)) % 60 == 0 ) {
					total[0]=total[0]+1;
				}
				//System.out.println("x,y="+i+","+j);
			});
		});
		return total[0];
	}
}
