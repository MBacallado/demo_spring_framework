package com.mbacallado.springFramework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbacallado.springFramework.entity.Movie;
import com.mbacallado.springFramework.services.MovieService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	@Autowired
	@Qualifier("movieServiceImpl")
	private MovieService movieService;

	/**
	 * Method that returns in json format all movies stored in bbdd
	 * @return
	 */
	@GetMapping("/json")
	public ResponseEntity<List<Movie>> getJson() {
		return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
	}
}
