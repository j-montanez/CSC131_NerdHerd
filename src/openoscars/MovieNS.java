package openoscars;

public class MovieNS {
	private String Title;
	 private String Year;
	 private String Rated;
	 private String Released;
	 private String Runtime;
	 private String Genre;
	 private String Director;
	 private String Writer;
	 private String Actors;
	 private String Plot;
	 private String Poster;
	 private String Metascore;
	 private String imdbRating;
	 private String imdbVotes;
	//THIS WHOLE THING WAS MADE TO KEEP MY SANITY
	//Any time you make a MovieObj immediately make an MovieNs and pass the MovieObj into it
	 //Then just make references to the MovieNS object instead as it is not static and is therefore instanced
	public MovieNS(MovieObj obj) {
		copyVar(obj.getTitle(), obj.getYear(), obj.getRated(), obj.getReleased(), 
				obj.getRuntime(),obj.getGenre(),obj.getDirector(),obj.getWriter(),obj.getActors(),
				obj.getPlot(),obj.getPoster(),obj.getMetascore(),obj.getimdbRating(),obj.getimdbVotes());
	}
	
	public void copyVar(String Title, String Year, String Rated, String Released, 
			String Runtime,String Genre,String Director,String Writer,String Actors,
			String Plot,String Poster,String Metascore,String imdbRating,String imdbVotes) {
			// TODO Auto-generated constructor stub
		this.Title = Title;
		this.Year = Year;
		this.Rated = Rated;
		this.Released = Released;
		this.Runtime = Runtime;
		this.Genre = Genre;
		this.Director = Director;
		this.Writer = Writer;
		this.Actors = Actors;
		this.Plot = Plot;
		this.Poster = Poster;
		this.Metascore = Metascore;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;

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
}
