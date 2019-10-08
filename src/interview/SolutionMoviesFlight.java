package interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionMoviesFlight {
	List<Integer> FindPairMovies(List<Integer> movie_duration, int d){
		List<MoviePack> lstMoviesPacks = new ArrayList<MoviePack>();
		int indexMovie1=0;
		int indexMovie2=0;
//		for(Integer movie1:movie_duration) {
//			for (Integer movie2:movie_duration) {
//				MoviePack moviePack = new MoviePack(movie1, movie2);
//				if ( moviePack.duration <= (d -30) && movie1!=movie2  )
//				{
//					lstMoviesPacks.add(moviePack);
//				}
//				indexMovie2++;
//			}
//			indexMovie1++;
//		}
//		
		for(int movie1 =0; movie1<movie_duration.size()-1 ;movie1++) {
			for(int movie2 =movie1+1; movie2<movie_duration.size() ;movie2++) {
				MoviePack moviePack = new MoviePack(movie1, movie2);
				if ( moviePack.duration <= (d-30))
				{
					lstMoviesPacks.add(moviePack);
				}
				indexMovie2++;
			}
			indexMovie1++;
		}
		System.out.println("paso 1");
		System.out.println("ted"+lstMoviesPacks.stream().map(e->e.value).collect(Collectors.toList()) );
		System.out.println("paso 2");
		System.out.println("         "+lstMoviesPacks.stream().sorted(Comparator.comparingInt(MoviePack::getDuration)).map(e->e.value).collect(Collectors.toList()));
		System.out.println("paso 4");
		System.out.println("         "+lstMoviesPacks.stream().sorted(Comparator.comparingInt(MoviePack::getDuration).thenComparing(MoviePack::getLonger) ).map(e->e.value).collect(Collectors.toList()));
		System.out.println("paso 3");
		System.out.println("         "+lstMoviesPacks.stream().sorted(Comparator.comparingInt(MoviePack::getDuration).reversed() ).map(e->e.value).collect(Collectors.toList()));
		System.out.println("paso 5");
		System.out.println("         "+lstMoviesPacks.stream().sorted(Comparator.comparingInt(MoviePack::getDuration).thenComparing(MoviePack::getLonger).reversed() ).map(e->e.value).collect(Collectors.toList()));
		return lstMoviesPacks.stream()
				.sorted(Comparator.comparingInt(MoviePack::getDuration).reversed() )
				.sorted(Comparator.comparingInt(MoviePack::getLonger ))
				.map(e->e.value)
				.collect(Collectors.toList()).get(0);
	}
	
}

class MoviePack{
	int movie1;
	int movie2;
	int duration;
	int getDuration() {
		return duration;
	}
	int longer;
	int getLonger() {
		return longer;
	}
	List<Integer> value;
	MoviePack(int movie1,int movie2){
		this.movie1=movie1;
		this.movie2=movie2;
		if (movie1>movie2)
			longer = movie1;
		else
			longer = movie2;
		this.duration=this.movie1+this.movie2;
		this.value = new ArrayList<Integer>();
		this.value.add(movie1);
		this.value.add(movie2);
		this.value.add(duration);
	}
}
