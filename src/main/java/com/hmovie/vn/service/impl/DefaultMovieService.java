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
    
    private static String toSlug(String title) {
	    return title.toLowerCase().replaceAll("[^a-z0-9]+", "-");
	}
	

    @Override
    @Transactional
    public Movie createMovie(Movie movie) {
        if (movie.getId() != null) {
            throw new MovieException("Movie already exist!");
        }
        String slug = toSlug(movie.getTitle() + " " + movie.getImdbId());
        movie.setSlug(slug);
        
        movie.getEpisode();

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
        movieUpdate.setSlug(toSlug(movieUpdate.getTitle() + " " + movieUpdate.getImdbId()));
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

	@Override
	@Transactional(readOnly = true)
	public List<Movie> getTop14MovieRate() {
		return movieRepository.findAll()
				.stream().sorted((m1, m2) -> Double.compare(m2.getRating().doubleValue(), m1.getRating().doubleValue()))
				.limit(14).toList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Movie> getTop10MovieRate() {
		return movieRepository.findAll()
				.stream().sorted((m1, m2) -> Double.compare(m2.getRating().doubleValue(), m1.getRating().doubleValue()))
				.limit(10).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> getAnimeMovies() {
		List<Movie> movies = movieRepository.findAll();
		movies = movies.stream()
		            .filter(movie -> movie.getGenres().stream()
		                    .anyMatch(genre -> genre.getName().equalsIgnoreCase("anime")))
		            .sorted((m1, m2) -> Double.compare(m2.getRating().doubleValue(), m1.getRating().doubleValue())) 
		            .limit(7) 
		            .collect(Collectors.toList());
		
		
		return movies;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> getActionMovies() {
		List<Movie> movies = movieRepository.findAll();
		movies = movies.stream()
		            .filter(movie -> movie.getGenres().stream()
		                    .anyMatch(genre -> genre.getName().equalsIgnoreCase("action")))
		            .sorted((m1, m2) -> Double.compare(m2.getRating().doubleValue(), m1.getRating().doubleValue())) 
		            .limit(7) 
		            .collect(Collectors.toList());
		
		
		return movies;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> getDramaMovie() {
		List<Movie> movies = movieRepository.findAll();
		movies = movies.stream()
		            .filter(movie -> movie.getGenres().stream()
		                    .anyMatch(genre -> genre.getName().equalsIgnoreCase("drama")))
		            .sorted((m1, m2) -> Double.compare(m2.getRating().doubleValue(), m1.getRating().doubleValue())) 
		            .limit(7) 
		            .collect(Collectors.toList());
		
		
		return movies;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> getSciFiMovie() {
		List<Movie> movies = movieRepository.findAll();
		movies = movies.stream()
		            .filter(movie -> movie.getGenres().stream()
		                    .anyMatch(genre -> genre.getName().equalsIgnoreCase("Sci-Fi")))
		            .sorted((m1, m2) -> Double.compare(m2.getRating().doubleValue(), m1.getRating().doubleValue())) 
		            .limit(7) 
		            .collect(Collectors.toList());
		
		
		return movies;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> getComedyMovie() {
		List<Movie> movies = movieRepository.findAll();
		movies = movies.stream()
		            .filter(movie -> movie.getGenres().stream()
		                    .anyMatch(genre -> genre.getName().equalsIgnoreCase("Comedy")))
		            .sorted((m1, m2) -> Double.compare(m2.getRating().doubleValue(), m1.getRating().doubleValue())) 
		            .limit(7) 
		            .collect(Collectors.toList());
		
		
		return movies;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> getMost5ByGenre(String genreName) {
		List<Movie> movies = movieRepository.findAll();
		movies = movies.stream()
		            .filter(movie -> movie.getGenres().stream()
		                    .anyMatch(genre -> genre.getName().equalsIgnoreCase(genreName)))
		            .sorted((m1, m2) -> Double.compare(m2.getRating().doubleValue(), m1.getRating().doubleValue())) 
		            .limit(5) 
		            .collect(Collectors.toList());
		
		
		return movies;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> getMoviesByGenre(String genreName) {
		List<Movie> movies = movieRepository.findAll();
		movies = movies.stream()
		            .filter(movie -> movie.getGenres().stream()
		                    .anyMatch(genre -> genre.getName().equalsIgnoreCase(genreName)))
		            .collect(Collectors.toList());
		
		
		return movies;
	}


	@Override
	@Transactional(readOnly = true)
	public Movie getMovieBySlug(String slug) {
		// TODO Auto-generated method stub
		return movieRepository.findBySlug(slug);
	}


	@Override
	public Movie findById(Integer id) {
		
		return movieRepository.findById(id).orElse(null);
	}

}
