import java.util.*;
public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			MovieArray mv = new MovieArray(1957);
			List<MovieNS> movies = mv.getMovies();
			List<String> tit = mv.getYup();
			for(int i = 0; i<5;i++) {
				System.out.println(movies.get(i).getTitle());
				System.out.println(i);
			}

			
	}

}
