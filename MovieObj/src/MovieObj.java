import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieObj{
	static private String Title;
	static private String Year;
	static private String Rated;
	static private String Released;
	static private String Runtime;
	static private String Genre;
	static private String Director;
	static private String Writer;
	static private String Actors;
	static private String Plot;
	static private String Poster;
	static private String Metascore;
	static private String imdbRating;
	static private String imdbVotes;
	static private List<String> Awards = new ArrayList<String>();
	static private String award;
	
	public MovieObj(String film) {
		getSpring(film);	
		getSpringAwards(film);	

	}
	
	
	//Sends Get request to localhost spirngboot server and sends the JSON to parseAwards
	public static void getSpringAwards(String film) {
		String encodedurl = null;
		try {
			encodedurl = URLEncoder.encode(film ,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/demo/findAwards?name="+encodedurl)).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(MovieObj::parseAwards)
				.join();
	}
	//takes the JSON file and puts the awards into String list
	public static void parseAwards(String responseBody) {
		JSONArray jarray = new JSONArray(responseBody);
		
			for(int i = 0; i<jarray.length();i++) {
				 JSONObject movie = jarray.getJSONObject(i);
				 Title = movie.getString("title");
				 award = movie.getString("award");
				 Awards.add(movie.getString("award"));
			}
				 
			 			
	}
	////Sends Get request to localhost spirngboot server and sends the JSON to parseImdb
	public static void getSpring(String film) {
		String encodedurl = null;
		try {
			encodedurl = URLEncoder.encode(film ,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/demo/findByName?name="+encodedurl)).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(MovieObj::parseImdb)
				.join();
	}
	//takes the JSON file and puts assigns them to the below variables
	public static void parseImdb(String responseBody) {
		JSONArray jarray = new JSONArray(responseBody);
		JSONObject movie = jarray.getJSONObject(0);
		
			 Title = movie.getString("title");
			 Year = movie.getString("year");
			 Rated = movie.getString("rated");
			 Released = movie.getString("released");
			 Runtime = movie.getString("runtime");
			 Genre = movie.getString("genre");
			 Director = movie.getString("director");
			 Writer = movie.getString("writer");
			 Actors = movie.getString("actors");
			 Plot = movie.getString("plot");
			 Poster = movie.getString("poster");
			 Metascore = movie.getString("metascore");
			 imdbRating = movie.getString("imdbRating");
			 imdbVotes = movie.getString("imdbVotes");
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	public String getYear() {
		return Year;
	}

	public void setYear(String Year) {
		this.Year = Year;
	}
	
	public String getRated() {
		return Rated;
	}

	public void setRated(String Rated) {
		this.Rated = Rated;
	}
	
	public String getReleased() {
		return Released;
	}

	public void setReleased(String Released) {
		this.Released = Released;
	}
	
	public String getRuntime() {
		return Runtime;
	}

	public void setRuntime(String Runtime) {
		this.Runtime = Runtime;
	}
	
	public String getGenre() {
		return Genre;
	}

	public void setGenre(String Genre) {
		this.Genre = Genre;
	}
	
	public String getDirector() {
		return Director;
	}

	public void setDirector(String Director) {
		this.Director = Director;
	}
	
	public String getWriter() {
		return Writer;
	}

	public void setWriter(String Writer) {
		this.Writer = Writer;
	}
	
	public String getActors() {
		return Actors;
	}

	public void setActors(String Actors) {
		this.Actors = Actors;
	}
	
	public String getPlot() {
		return Plot;
	}

	public void setPlot(String Plot) {
		this.Plot = Plot;
	}
	
	public String getPoster() {
		return Poster;
	}

	public void setPoster(String Poster) {
		this.Poster = Poster;
	}

	public String getMetascore() {
		return Metascore;
	}

	public void setMetascore(String Metascore) {
		this.Metascore = Metascore;
	}

	public String getimdbRating() {
		return imdbRating;
	}

	public void setimdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getimdbVotes() {
		return imdbVotes;
	}

	public void setimdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	
	public List<String> getAwards() {
		return Awards;
	}

	public void setCategory(List<String> Awards) {
		this.Awards = Awards;
	}
}
