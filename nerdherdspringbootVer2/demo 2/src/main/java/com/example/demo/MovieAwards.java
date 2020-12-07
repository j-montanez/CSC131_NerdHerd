package com.example.demo;

public class MovieAwards {

	 private String Title;
	 private String Category;
	
	public MovieAwards(String Title, String Category) {
			// TODO Auto-generated constructor stub
		this.Title = Title;
		this.Category = Category;


	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	public String getAward() {
		return Category;
	}

	public void setAward(String Category) {
		this.Category = Category;
	}

}