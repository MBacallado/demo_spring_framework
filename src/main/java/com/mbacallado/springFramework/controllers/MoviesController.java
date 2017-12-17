package com.mbacallado.springFramework.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mbacallado.springFramework.entity.Movie;
import com.mbacallado.springFramework.services.MovieService;

@Controller
@RequestMapping("/movies")
public class MoviesController {

	private static final String MOVIES_VIEW = "movies";
	private static final String ADD_VIEW = "add";
	private static final String EDIT_VIEW = "edit";
	private static final String REMOVE_VIEW = "remove";
	
	private static final Log LOG = LogFactory.getLog(MoviesController.class);
	
	private static final String TAG = MoviesController.class.getSimpleName();
	
	@Autowired
	@Qualifier("movieServiceImpl")
	private MovieService moviesService;
	
	@GetMapping("/all")
	public ModelAndView getAllMovies() {
		LOG.info("Call: " + TAG + " getAllMovies()");
		ModelAndView mav = new ModelAndView(MOVIES_VIEW);
		mav.addObject(MOVIES_VIEW, moviesService.getAllMovies());
		return mav;
	}
	
	@RequestMapping(value="/processAction", params="add", method=RequestMethod.POST)
	public String add(@ModelAttribute("movie") Movie movie) {
		return ADD_VIEW;
	}
	
	@GetMapping(value="/edit")
	public ModelAndView edit(@RequestParam(name = "id") int id) {
		LOG.info("Call: " + TAG + " editParam()");
		ModelAndView mav = new ModelAndView(EDIT_VIEW);
		mav.addObject("movie", moviesService.findById(id));
		return mav;
	}

	@RequestMapping(value="/processAction", params="remove", method=RequestMethod.POST)
	public ModelAndView remove(@ModelAttribute("movie") Movie movie) {
		ModelAndView mav = new ModelAndView(REMOVE_VIEW);
		//mav.addObject("movie", new Movie());
		mav.addObject("movie", movie);
		return mav;
	}
	
	@PostMapping("/addMovie")
	public RedirectView addMovie(@ModelAttribute("movie") Movie movie) {
		LOG.info("Call: " + TAG + " addMovie()");
		movie.toString();
		moviesService.addMovie(movie);
		return new RedirectView(MOVIES_VIEW);
	}
	
	@PostMapping("/editMovie")
	public RedirectView editMovie(@ModelAttribute("movie") Movie movie) {
		LOG.info("Call: " + TAG + " editMovie()");
		moviesService.editMovie(movie);
		return new RedirectView("/movies/all");
	}
	
	@GetMapping("/removeMovie")
	public String removeMovie(@ModelAttribute("movie") Movie movie) {
		LOG.info("Call: " + TAG + " removeMovie()");
		moviesService.removeMovie(movie.getId());
		return "redirect:/movies/all";
	}
}
