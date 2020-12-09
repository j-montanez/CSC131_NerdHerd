package openoscars;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class MovieArray {
	static private List<MovieNS> Movies = new ArrayList<MovieNS>();
	static private List<String> yup = new ArrayList<String>();
	
	public MovieArray(int year) {
		getSpringYear(year);
	}
	
	public static void getSpringYear(int year) {
		String yr = String.valueOf(year);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/demo/findAllByYear?year="+yr)).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(MovieArray::parse)
				.join();
	}
	//takes the JSON file and puts the awards into String list
	public static void parse(String responseBody) {
		JSONArray jarray = new JSONArray(responseBody);

			for(int i = 0; i<jarray.length();i++) {
				 JSONObject movie = jarray.getJSONObject(i);
				 String Title = movie.getString("title");
				 yup.add(Title);
				 MovieObj mv = new MovieObj(Title);
				 MovieNS ugh = new MovieNS(mv);


				 Movies.add(ugh);				 
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
