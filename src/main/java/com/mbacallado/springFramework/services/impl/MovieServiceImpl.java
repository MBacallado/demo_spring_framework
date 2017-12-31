package com.mbacallado.springFramework.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mbacallado.springFramework.entity.Movie;
import com.mbacallado.springFramework.repository.MoviesRepository;
import com.mbacallado.springFramework.services.MovieService;

@Service("movieServiceImpl")
public class MovieServiceImpl implements MovieService {

	private static final Log LOG = LogFactory.getLog(MovieServiceImpl.class);
	private static final String TAG = MovieServiceImpl.class.getSimpleName();
	
	@Autowired
	@Qualifier("moviesRepository")
	private MoviesRepository moviesRepository;
	
	/**
	 * Method that returns all movies
	 */
	@Override
	public List<Movie> getAllMovies() {
		LOG.info("call: " + TAG + " --getAllMovies" );
		return moviesRepository.findAll();
	}

	/**
	 * Method that adds a movie to the db
	 */
	@Override
	public void addMovie(Movie movie) {
		LOG.info("call: " + TAG + " --insertMovie" );
		moviesRepository.save(movie);
	}

	/**
	 * Method that edits a movie with a hidden id to the db
	 */
	@Override
	public void editMovie(Movie movie) {
		LOG.info("call: " + TAG + " --editMovie" );
		moviesRepository.save(movie);
	}

	/**
	 * Method that removes a movie by his id of the db
	 */
	@Override
	public void removeMovie(int id) {
		LOG.info("call: " + TAG + " --deleteMovie");
		moviesRepository.delete(id);
	}

	/**
	 * Method that finds a movie by his id
	 */
	@Override
	public Movie findById(int id) {
		LOG.info("call: " + TAG + " --findById");
		return moviesRepository.findOne(id);
	}

}
