package com.mbacallado.springFramework.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mbacallado.springFramework.entity.Movie;
import com.mbacallado.springFramework.services.MovieService;

@Controller
@RequestMapping("/movies")
public class MoviesController {

	private static final String LIST_VIEW = "/movies/all";
	private static final String MOVIES_VIEW = "movies";
	private static final String ADD_VIEW = "add";
	private static final String EDIT_VIEW = "edit";
	private static final String REMOVE_VIEW = "remove";
	
	private static final Log LOG = LogFactory.getLog(MoviesController.class);
	private static final String TAG = MoviesController.class.getSimpleName();
	
	@Autowired
	@Qualifier("movieServiceImpl")
	private MovieService moviesService;
	
	/**
	 * Method that returns a view with all movies
	 * @return
	 */
	@GetMapping("/all")
	public ModelAndView getAllMovies() {
		LOG.info("Call: " + TAG + " getAllMovies()");
		ModelAndView mav = new ModelAndView(MOVIES_VIEW);
		mav.addObject(MOVIES_VIEW, moviesService.getAllMovies());
		return mav;
	}
	
	/**
	 * Method that returns the add view (HTML)
	 * @param movie
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("movie", new Movie());
		return ADD_VIEW;
	}
	
	/**
	 * Method that returns or redirects to the edit view with the id(HTML)
	 * @param id
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") int id) {
		LOG.info("Call: " + TAG + " editParam()");
		ModelAndView mav = new ModelAndView(EDIT_VIEW);
		mav.addObject("movie", moviesService.findById(id));
		return mav;
	}

	/**
	 * Method that returns or redirects to the remove view with the id(HTML)
	 * @param id
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/remove")
	public ModelAndView remove(@RequestParam(name = "id") int id) {
		LOG.info("Call: " + TAG + " removeParam()");
		ModelAndView mav = new ModelAndView(REMOVE_VIEW);
		mav.addObject("movie", moviesService.findById(id));
		return mav;
	}
	
	/**
	 * Method that adds a movie and redirects to the movies view(HTML)
	 * @param movie
	 * @return
	 */
	@PostMapping("/addMovie")
	public RedirectView addMovie(@ModelAttribute("movie") Movie movie) {
		LOG.info("Call: " + TAG + " addMovie()");
		movie.toString();
		moviesService.addMovie(movie);
		return new RedirectView(LIST_VIEW);
	}
	
	/**
	 * Method that edits a movie and redirects to the movies view(HTML)
	 * @param movie
	 * @return
	 */
	@PostMapping("/editMovie")
	public RedirectView editMovie(@ModelAttribute("movie") Movie movie) {
		LOG.info("Call: " + TAG + " editMovie()");
		moviesService.editMovie(movie);
		return new RedirectView(LIST_VIEW);
	}
	
	/**
	 * Method that removes a movie and redirects to the movies view(HTML)
	 * @param movie
	 * @return
	 */
	@GetMapping("/removeMovie")
	public RedirectView removeMovie(@RequestParam(name = "id") int id) {
		LOG.info("Call: " + TAG + " removeMovie()");
		moviesService.removeMovie(id);
		return new RedirectView(LIST_VIEW);
	}
}
