package com.hmovie.vn.service;

import java.util.List;

import com.hmovie.vn.entity.Movie;

public interface MovieService {

	Movie createMovie(Movie movie);

	Movie updateMovie(Movie movieUpdate);

	void deleteMovie(Integer movieId);

	void deleteMovieByImdbId(String imdbId);

	Movie getMovieByImdbId(String imdbId);

	List<Movie> getAllMovie();

	List<Movie> getMovieByGenre(Integer genreId);

	List<Movie> getMovieByDirector(Integer directorId);

	List<Movie> getMovieByActor(Integer actorId);

	List<Movie> getMovieByTrailer(Integer trailerId);
	
	List<Movie> get5MovieMostRatedNotAnime();

}
