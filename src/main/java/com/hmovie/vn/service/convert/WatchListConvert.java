package com.hmovie.vn.service.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hmovie.vn.dto.response.MovieWatchListResponse;
import com.hmovie.vn.dto.response.WatchListResponse;
import com.hmovie.vn.entity.Genre;
import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.entity.WatchList;

@Service
public class WatchListConvert {
	
	public MovieWatchListResponse movieConvertToMovieWatchListResponse(Movie movie) {
		 if (movie == null) {
	            return null;
	        }

	        List<String> genres = movie.getGenres().stream()
	                .map(Genre::getName)
	                .collect(Collectors.toList());

	        return new MovieWatchListResponse(
	                movie.getId(),
	                movie.getImdbId(),
	                movie.getTitle(),
	                movie.getDescription(),
	                movie.getReleaseDate(),
	                movie.getPostUrl(),
	                movie.getBackDropUrl(),
	                movie.getSlug(),
	                movie.getDuration(),
	                movie.getRating(),
	                genres
	                );
	        
	}
	
	public WatchListResponse watchListConvertToWatchListResponse(WatchList watchList) {
		return new WatchListResponse(
				watchList.getId(),
				watchList.getMovies().stream().map(this::movieConvertToMovieWatchListResponse).toList()
				);
	}
}
