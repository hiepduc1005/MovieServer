package com.hmovie.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.request.Movie.MovieCreateRequest;
import com.hmovie.vn.dto.request.Movie.MovieUpdateRequest;
import com.hmovie.vn.dto.response.MovieResponse;
import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.service.MovieService;
import com.hmovie.vn.service.convert.MovieConvert;

@RestController
@RequestMapping("api/v1/movie")
public class MovieController {

    @Autowired
    public MovieService movieService;

    @Autowired
    public MovieConvert movieConvert;

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@RequestBody MovieCreateRequest movieCreateRequest) {
        Movie movie = movieConvert.movieCreateRequestConverToMovie(movieCreateRequest);
        movie = movieService.createMovie(movie);

        MovieResponse movieResponse = movieConvert.movieConvertToMovieResponse(movie);

        return ResponseEntity.ok(movieResponse);
    }

    @PutMapping
    public ResponseEntity<MovieResponse> updateMovie(@RequestBody MovieUpdateRequest movieUpdateRequest) {
        Movie movie = movieConvert.movieUpdateRequestConvertToMovie(movieUpdateRequest);
        movie = movieService.updateMovie(movie);

        MovieResponse movieResponse = movieConvert.movieConvertToMovieResponse(movie);

        return ResponseEntity.ok(movieResponse);
    }

    @DeleteMapping("/{imdbId}")
    public ResponseEntity<String> deleteMovie(@PathVariable String imdbId) {
        movieService.deleteMovieByImdbId(imdbId);

        return ResponseEntity.ok("Delete movie with imdbId : " + imdbId + " success!");
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<MovieResponse> getMovieByImdbId(@PathVariable String imdbId) {
        Movie movie = movieService.getMovieByImdbId(imdbId);

        MovieResponse movieResponse = movieConvert.movieConvertToMovieResponse(movie);

        return ResponseEntity.ok(movieResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovie();

        List<MovieResponse> movieResponses = movieConvert.moviesConvertToMovieResponses(movies);
        return ResponseEntity.ok(movieResponses);
    }

    @GetMapping("/actor/{actorId}")
    public ResponseEntity<List<MovieResponse>> getMoviesByActor(@PathVariable Integer actorId) {
        List<Movie> movies = movieService.getMovieByActor(actorId);

        List<MovieResponse> movieResponses = movieConvert.moviesConvertToMovieResponses(movies);
        return ResponseEntity.ok(movieResponses);
    }

    @GetMapping("/director/{directorId}")
    public ResponseEntity<List<MovieResponse>> getMoviesByDirector(@PathVariable Integer directorId) {
        List<Movie> movies = movieService.getMovieByDirector(directorId);
        List<MovieResponse> movieResponses = movieConvert.moviesConvertToMovieResponses(movies);
        return ResponseEntity.ok(movieResponses);
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<List<MovieResponse>> getMoviesByGenre(@PathVariable Integer genreId) {
        List<Movie> movies = movieService.getMovieByGenre(genreId);
        List<MovieResponse> movieResponses = movieConvert.moviesConvertToMovieResponses(movies);
        return ResponseEntity.ok(movieResponses);
    }

    @GetMapping("/trailer/{trailerId}")
    public ResponseEntity<List<MovieResponse>> getMoviesByTrailer(@PathVariable Integer trailerId) {
        List<Movie> movies = movieService.getMovieByTrailer(trailerId);
        List<MovieResponse> movieResponses = movieConvert.moviesConvertToMovieResponses(movies);
        return ResponseEntity.ok(movieResponses);
    }
    
    @GetMapping("/top5")
    public ResponseEntity<List<MovieResponse>> get5MoviesMostRated() {
        List<Movie> movies = movieService.get5MovieMostRatedNotAnime();
        List<MovieResponse> movieResponses = movieConvert.moviesConvertToMovieResponses(movies);
        return ResponseEntity.ok(movieResponses);
    }

}