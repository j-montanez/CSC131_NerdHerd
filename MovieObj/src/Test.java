import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		MovieArray mv = new MovieArray("ACTOR");
		List<MovieNS> movies = mv.getMovies();
		List<String> tit = mv.getYup();
		for(int i = 0; i<2;i++) {
			System.out.println(movies.get(i).getTitle());
			System.out.println(i);
		}

	}

}
