package com.mbacallado.springFramework.services;

import java.util.List;

import com.mbacallado.springFramework.entity.Movie;

public interface MovieService {
	
	public List<Movie> getAllMovies();
	public void addMovie(Movie movie);
	public void editMovie(Movie movie);
	public void removeMovie(int id);
	public Movie findById(int id);

}
