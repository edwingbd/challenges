package interview;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashMap;

public class SolutionAircraft {
	List<List<Integer>> optimalUtilization (int maxTravelDist,
			List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRoutedList)
	{
		Plan plan = new Plan(forwardRouteList,returnRoutedList);
		return plan.generatePlan(maxTravelDist);
	}

}

class Plan{
	List<setRoute> lstRoutes;
	List<List<Integer>> forwardRouteList;
	List<List<Integer>> returnRoutedList;
	Plan(List<List<Integer>> forwardRouteList,List<List<Integer>> returnRoutedList){
	
		lstRoutes = new ArrayList<>();
		
		forwardRouteList
			.stream()
			.map(f->
			{
				returnRoutedList
				.stream()
				.map(r->
				{
					lstRoutes.add( new setRoute(f, r));	
					return 1;
				}).count();
				return 1;
			}).count();
	}
	List<List<Integer>> generatePlan(int maxTravelDist){
		List<setRoute> lstPlan;
		
		lstPlan = lstRoutes.stream()
				.filter(e->e.distance <= maxTravelDist)
				.sorted(Comparator.comparingInt(setRoute::getDistance))
				.collect(Collectors.toList());
		int max = lstPlan.get(lstPlan.size()-1).distance;		
			
		return lstPlan.stream().filter(e->e.distance==max).map(e->e.value).collect(Collectors.toList());
	}
}

class setRoute{
	List<Integer> forwardRoute;
	List<Integer> returnRoute;
	List<Integer> value;
	int distance;
	public int getDistance() {
		return this.distance;
	}
	setRoute(List<Integer> forwardRoute,List<Integer> returnRoute){
		this.forwardRoute=forwardRoute;
		this.returnRoute=returnRoute;
		this.value = new ArrayList<Integer>();
		this.distance=this.forwardRoute.get(1)+this.returnRoute.get(1);
		this.value.add(this.forwardRoute.get(0));
		this.value.add(this.returnRoute.get(0));
	}
}