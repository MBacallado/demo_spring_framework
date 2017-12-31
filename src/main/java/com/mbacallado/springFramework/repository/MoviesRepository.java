package com.mbacallado.springFramework.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbacallado.springFramework.entity.Movie;

@Repository("moviesRepository")
public interface MoviesRepository extends JpaRepository<Movie, Serializable> {

}
