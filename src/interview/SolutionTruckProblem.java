package interview;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class SolutionTruckProblem {
	public static List<List<Integer>> ClosestXdestinations (
			int numDestinations,List<List<Integer>> allLocations,int numDeliveries)
	{
		//Constraints
		if (numDeliveries > numDestinations)
			return null;
		PrePlan prePlan = new PrePlan(allLocations, numDestinations);
		
		int[] states = {1,2,3};
	    List<Integer> lst = Arrays.stream(states).boxed().collect(Collectors.toList());
		//lst.stream().min(e->e);
		return prePlan.generatePlan(numDeliveries) ;
	}
	
	 public int generalizedGCD(int num, int[] arr)
	    {
	        // WRITE YOUR CODE HERE
	        List<Integer> lstArr = new ArrayList<Integer>();
	        for(int value: arr){
	            lstArr.add(value);
	        }
	        
	        Integer min = lstArr.stream().min(Comparator.comparing(Integer::valueOf)).get();
	        
	        
	        return 1;
	    }
}

class PrePlan{
	List<Destination> lstDestinations;
	List<List<Integer>> locations;
	int numDestinations;
	PrePlan(	List<List<Integer>> locations,int numDestinations){
		this.locations=locations;
		this.numDestinations=numDestinations;
		lstDestinations = new ArrayList<>();
		this.locations.stream()
		.limit(numDestinations)
		.map(e->{
			lstDestinations.add(new Destination(e.get(0), e.get(1), e));
			return 0;
		}).count();
	}
	List<List<Integer>> generatePlan(int numDeliveries){
		return lstDestinations.stream().sorted(Comparator.comparingDouble(Destination::getDistance))
				.limit(numDeliveries).map(e->e.value).collect(Collectors.toList()) ;
	}
}

class Destination{
	int x;
	int y;
	double distance;
	public double getDistance() {
		return this.distance;
	}
	List<Integer> value;
	Destination(int x,int y,List<Integer> value){
		this.x=x;
		this.y=y;
		this.value=value;
		this.distance= Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
}