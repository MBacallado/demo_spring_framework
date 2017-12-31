package com.mbacallado.springFramework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue
	@Column(name="movie_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="year")
	private int year;
	
	@Column(name="director")
	private String director;
	
	@Column(name="actors")
	private String actors;
	
	@Column(name="sinopsis")
	private String sinopsis;
	
	public Movie() {
		
	}

	public Movie(int id, String name, String genre, int duration, int year, String director, String actors,
			String sinopsis) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.duration = duration;
		this.year = year;
		this.director = director;
		this.actors = actors;
		this.sinopsis = sinopsis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genre=" + genre + ", duration=" + duration + ", year=" + year
				+ ", director=" + director + ", actors=" + actors + ", sinopsis=" + sinopsis + "]";
	}

}
