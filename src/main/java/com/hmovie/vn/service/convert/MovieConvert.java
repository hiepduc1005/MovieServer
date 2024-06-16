package com.hmovie.vn.service.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmovie.vn.dto.request.Movie.MovieCreateRequest;
import com.hmovie.vn.dto.request.Movie.MovieUpdateRequest;
import com.hmovie.vn.dto.response.MovieResponse;
import com.hmovie.vn.entity.Actor;
import com.hmovie.vn.entity.Director;
import com.hmovie.vn.entity.Genre;
import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.entity.Trailer;
import com.hmovie.vn.repository.ActorRepository;
import com.hmovie.vn.repository.DirectorRepository;
import com.hmovie.vn.repository.GenreRepository;
import com.hmovie.vn.repository.TrailerRepository;

@Service
public class MovieConvert {

    @Autowired
    public ActorRepository actorRepository;

    @Autowired
    public GenreRepository genreRepository;

    @Autowired
    public DirectorRepository directorRepository;

    @Autowired
    public TrailerRepository trailerRepository;

    public Movie movieCreateRequestConverToMovie(MovieCreateRequest movieCreateRequest) {

        if (movieCreateRequest == null) {
            return null;
        }

        Movie movie = createMovieFromRequest(movieCreateRequest);

        return movie;

    }

    public Movie movieUpdateRequestConvertToMovie(MovieUpdateRequest movieUpdateRequest) {
        if (movieUpdateRequest == null) {
            return null;
        }

        Movie movie = createMovieFromRequest(movieUpdateRequest);

        return movie;
    }

    public Movie createMovieFromRequest(Object request) {
        Movie movie = new Movie();

        if (request instanceof MovieCreateRequest) {
            MovieCreateRequest movieCreateRequest = (MovieCreateRequest) request;
            movie.setImdbId(movieCreateRequest.getImdbId());
            movie.setPostUrl(movieCreateRequest.getPostUrl());
            movie.setBackDropUrl(movieCreateRequest.getBackDropUrl());
            movie.setDuration(movieCreateRequest.getDuration());
            movie.setRating(movieCreateRequest.getRating());
            movie.setTitle(movieCreateRequest.getTitle());
            movie.setDescription(movieCreateRequest.getDescription());
            movie.setReleaseDate(movieCreateRequest.getReleaseDate());

            Integer trailerId = movieCreateRequest.getTrailerId();
            if (trailerId > 0 && trailerId != null) {
                Trailer trailer = trailerRepository.findById(trailerId).orElse(null);
                if (trailer != null) {
                    movie.setTrailer(trailer);
                }
            }

            List<Actor> actors = actorRepository.findAllById(movieCreateRequest.getActorsId());
            List<Genre> genres = genreRepository.findAllById(movieCreateRequest.getGenresId());
            List<Director> directors = directorRepository.findAllById(movieCreateRequest.getDirectorIds());

            movie.setActors(actors);
            movie.setGenres(genres);
            movie.setDirectors(directors);
        } else if (request instanceof MovieUpdateRequest) {
            MovieUpdateRequest movieUpdateRequest = (MovieUpdateRequest) request;

            movie.setImdbId(movieUpdateRequest.getImdbId());
            movie.setPostUrl(movieUpdateRequest.getPostUrl());
            movie.setBackDropUrl(movieUpdateRequest.getBackDropUrl());
            movie.setDuration(movieUpdateRequest.getDuration());
            movie.setRating(movieUpdateRequest.getRating());
            movie.setTitle(movieUpdateRequest.getTitle());
            movie.setDescription(movieUpdateRequest.getDescription());
            movie.setReleaseDate(movieUpdateRequest.getReleaseDate());

            Integer trailerId = movieUpdateRequest.getTrailerId();
            if (trailerId > 0 && trailerId != null) {
                Trailer trailer = trailerRepository.findById(trailerId).orElse(null);
                if (trailer != null) {
                    movie.setTrailer(trailer);
                }
            }

            List<Actor> actors = actorRepository.findAllById(movieUpdateRequest.getActorsId());
            List<Genre> genres = genreRepository.findAllById(movieUpdateRequest.getGenresId());
            List<Director> directors = directorRepository.findAllById(movieUpdateRequest.getDirectorIds());

            movie.setActors(actors);
            movie.setGenres(genres);
            movie.setDirectors(directors);
        }

        return movie;
    }

    public MovieResponse movieConvertToMovieResponse(Movie movie) {
        if (movie == null) {
            return null;
        }

        List<String> genres = movie.getGenres().stream()
                .map(Genre::getName)
                .collect(Collectors.toList());

        List<String> actors = movie.getActors().stream()
                .map(Actor::getName)
                .collect(Collectors.toList());

        List<String> directors = movie.getDirectors().stream()
                .map(Director::getName)
                .collect(Collectors.toList());

        String trailerUrl = movie.getTrailer() != null ? movie.getTrailer().getTrailerUrl() : null;

        return new MovieResponse(
                movie.getId(),
                movie.getImdbId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getReleaseDate(),
                movie.getPostUrl(),
                movie.getBackDropUrl(),
                movie.getDuration(),
                movie.getRating(),
                genres,
                actors,
                directors,
                trailerUrl);
    }

    public List<MovieResponse> moviesConvertToMovieResponses(List<Movie> movies) {
        return movies.stream()
                .map(this::movieConvertToMovieResponse)
                .collect(Collectors.toList());
    }
}
