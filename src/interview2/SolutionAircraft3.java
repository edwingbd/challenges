package interview2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashMap;

public class SolutionAircraft3 {
	List<List<Integer>> optimalUtilization (int maxTravelDist,
			List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRoutedList)
	{
		List<RoundTrip> saveReturnRoutedList = new ArrayList<RoundTrip>();
		int max = 0;
		for (List<Integer> infoForward : forwardRouteList) {
			for (List<Integer> infoReturn : returnRoutedList) {
				RoundTrip trNew = new RoundTrip(infoForward,infoReturn);
				if (trNew.getTravelMiles() <= maxTravelDist ) {
					if (max < trNew.getTravelMiles())
						max=trNew.getTravelMiles();
					saveReturnRoutedList.add(trNew);
				}
			}
		}
		final int max2=max;
		return saveReturnRoutedList.stream()
				.filter(e-> (e.getTravelMiles() == max2)?true:false)
				.map(e->e.value)
				.collect(Collectors.toList());
	}
	public class RoundTrip{
		private List<Integer> forwardFly;
		private List<Integer> returnFly;
		private List<Integer> value;
		private int travelMiles;
		private String key;
		
		public List<Integer> getValue() {
			return this.value;
		}
		
		public String getKey() {
			return this.key;
		}
		
		public int getTravelMiles() {
			return this.travelMiles;
		}
		
		public List<Integer> getForwardFly() {
			return forwardFly;
		}
		
		public RoundTrip(List<Integer> datosForward,List<Integer> datosReturn) {
			this.forwardFly = datosForward;
			this.returnFly=datosReturn;
			travelMiles=this.forwardFly.get(1)+this.returnFly.get(1);
			key=this.forwardFly.get(0)+"-"+this.returnFly.get(1);
			value=new ArrayList<>();
			value.add(this.forwardFly.get(0));
			value.add(this.returnFly.get(0));
		}
	}
}
