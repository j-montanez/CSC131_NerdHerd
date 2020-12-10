package openoscars;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class MovieArraySearch {
	static private List<MovieNS> Movies = new ArrayList<MovieNS>();
	static private List<String> yup = new ArrayList<String>();
	
	public MovieArraySearch(String key) {
		System.out.println("Key: " + key);
		getSpringYear(key);
	}
	
	public static void getSpringYear(String key) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/demo/generalSearch?keyWord="+key)).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(MovieArraySearch::parse)
				.join();
	}
	//takes the JSON file and puts the awards into String list
	public static String last = "";
	public static String twoAgo = "";
	public static void parse(String responseBody) {
		JSONArray jarray = new JSONArray(responseBody);
		
			for(int i = 0; i<jarray.length();i++) {
				JSONObject movie = jarray.getJSONObject(i);
				System.out.println("movie: " + movie);
				String newTitle = movie.getString("title");
				if(i==0){
					 String Title = movie.getString("title");
					 yup.add(Title);
					 MovieObj mv = new MovieObj(Title);
					 MovieNS ugh = new MovieNS(mv);
					 Movies.add(ugh);
				} else	if(!last.equals(newTitle) && !twoAgo.equals(newTitle)){
					 String Title = movie.getString("title");
					 yup.add(Title);
					 MovieObj mv = new MovieObj(Title);
					 MovieNS ugh = new MovieNS(mv);
					 Movies.add(ugh);
				}
				if(i%2 == 0){
					last = movie.getString("title");
					System.out.println("last: " + last);
				}else{
					twoAgo = movie.getString("title");
					System.out.println("twoAgo: " + twoAgo);
				}

			}	 			
	}
	public List<MovieNS> getMovies() {
		return Movies;
	}

	public void setMovies(List<MovieNS> Movies) {
		this.Movies = Movies;
	}
	public List<String> getYup() {
		return yup;
	}

	public void setYup(List<String> yup) {
		this.yup = yup;
	}
	
}
