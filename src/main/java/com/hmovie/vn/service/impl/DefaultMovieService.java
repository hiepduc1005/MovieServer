package com.hmovie.vn.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.exception.ActorException;
import com.hmovie.vn.exception.MovieException;
import com.hmovie.vn.repository.MovieRepository;
import com.hmovie.vn.service.MovieService;

@Service
public class DefaultMovieService implements MovieService {

    @Autowired
    public MovieRepository movieRepository;

    @Override
    @Transactional
    public Movie createMovie(Movie movie) {
        if (movie.getId() != null) {
            throw new MovieException("Movie already exist!");
        }

        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public void deleteMovie(Integer movieId) {
        if (movieId == null || movieId < 0) {
            throw new MovieException("Movie id must be type int and greater than 0");
        }
        movieRepository.deleteById(movieId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> getMovieByActor(Integer actorId) {
        if (actorId == null || actorId < 0) {
            throw new ActorException("Actor id must be type int and greater than 0");
        }
        return movieRepository.findByActorsId(actorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> getMovieByDirector(Integer directorId) {
        if (directorId == null || directorId < 0) {
            throw new RuntimeException("Director id must be type int and greater than 0");
        }
        return movieRepository.findByDirectorsId(directorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> getMovieByGenre(Integer genreId) {
        if (genreId == null || genreId < 0) {
            throw new RuntimeException("Genre id must be type int and greater than 0");
        }
        return movieRepository.findByGenresId(genreId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> getMovieByTrailer(Integer trailerId) {
        if (trailerId == null || trailerId < 0) {
            throw new RuntimeException("Trailer id must be type int and greater than 0");
        }
        return movieRepository.findByTrailerId(trailerId);
    }

    @Override
    @Transactional
    public Movie updateMovie(Movie movieUpdate) {
        if (movieUpdate.getId() == null) {
            throw new MovieException("Movie is not exist");
        }
        return movieRepository.save(movieUpdate);
    }

    @Override
    @Transactional
    public void deleteMovieByImdbId(String imdbId) {
        if (imdbId.isEmpty() || imdbId == null) {
            throw new RuntimeException("ImdbId must not be empty!");
        }

        movieRepository.deleteByImdbId(imdbId);
    }

    @Override
    @Transactional(readOnly = true)
    public Movie getMovieByImdbId(String imdbId) {
        if (imdbId.isEmpty() || imdbId == null) {
            throw new RuntimeException("ImdbId must not be empty!");
        }

        return movieRepository.findByImdbId(imdbId);
    }

	@Override
	@Transactional(readOnly = true)
	public List<Movie> get5MovieMostRatedNotAnime() {
		List<Movie> movies = movieRepository.findAll();
		movies = movies.stream()
		            .filter(movie -> !movie.getGenres().stream()
		                    .anyMatch(genre -> genre.getName().equalsIgnoreCase("anime")))
		            .sorted((m1, m2) -> Double.compare(m2.getRating().doubleValue(), m1.getRating().doubleValue())) 
		            .limit(5) 
		            .collect(Collectors.toList());
		
		
		return movies;
	}

}
