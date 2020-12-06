package com.example.demo;

public class Movie {

	private long id;
	private String name, poster, homepage;
	//private String genre, plot;
	private int year;
	private String plot;
	private String genre;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public String getHomepage() {
		return homepage;
	}


	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public Movie(int id, String name, int year, String poster, String plot, String genre) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.year = year;
		this.poster = poster;
		this.plot = plot;
		this.genre = genre;
	}
	
	  @Override
	  public String toString() {
	    return String.format(
	        "Movie[id=%d, name='%s', year='%s']",
	        id, name, year);
	  }


	public String getPlot() {
		return plot;
	}


	public void setPlot(String plot) {
		this.plot = plot;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}

}
