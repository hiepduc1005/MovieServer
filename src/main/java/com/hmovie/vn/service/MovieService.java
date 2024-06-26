package com.hmovie.vn.service;

import java.util.List;

import org.springframework.data.domain.Page;

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
	
	List<Movie> getTop14MovieRate();

	List<Movie> getTop10MovieRate();
	
	List<Movie> getAnimeMovies();
	
	List<Movie> getActionMovies();
	
	List<Movie> getSciFiMovie();
	
	List<Movie> getDramaMovie();
	
	List<Movie> getComedyMovie();
	
	List<Movie> getMost5ByGenre(String genre);
	
	List<Movie> getMoviesByGenre(String genre);
	
	Movie getMovieBySlug(String slug);
	
	Movie findById(Integer id);
	
	Page<Movie> findMovieByQueryWithPaginate(String query,Integer page,Integer limit);
}
