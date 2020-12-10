package openoscars;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class Test {

//	@org.junit.jupiter.api.Test
	void test() {
		MovieArray mv = new MovieArray("actor");
		MovieObj ahhh = new MovieObj("Star Wars");
		MovieNS yeah = new MovieNS(ahhh);
		List<MovieNS> movies = mv.getMovies();
		List<String> tit = yeah.getAwards();
		System.out.println(tit.get(0));
		System.out.println("something shoudl be above me");



	}

}
