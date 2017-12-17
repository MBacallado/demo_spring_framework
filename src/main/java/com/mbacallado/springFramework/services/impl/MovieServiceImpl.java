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
public class MovieServiceImpl implements MovieService{

	private static final Log LOG = LogFactory.getLog(MovieServiceImpl.class);
	private static final String TAG = MovieServiceImpl.class.getSimpleName();
	
	@Autowired
	@Qualifier("moviesRepository")
	private MoviesRepository moviesRepository;
	
	@Override
	public List<Movie> getAllMovies() {
		LOG.info(TAG + " --getAllMovies" );
		return moviesRepository.findAll();
	}

	@Override
	public void addMovie(Movie movie) {
		LOG.info(TAG + " --insertMovie" );
		moviesRepository.save(movie);
	}

	@Override
	public void editMovie(Movie movie) {
		LOG.info(TAG + " --editMovie" );
		moviesRepository.save(movie);
	}

	@Override
	public void removeMovie(int id) {
		LOG.info(TAG + " --deleteMovie");
		moviesRepository.delete(id);
	}

	@Override
	public Movie findById(int id) {
		LOG.info(TAG + " --findById");
		return moviesRepository.findOne(id);
	}

}
