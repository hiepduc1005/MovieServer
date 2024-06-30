package com.hmovie.vn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.entity.WatchList;
import com.hmovie.vn.repository.MovieRepository;
import com.hmovie.vn.repository.WatchListRepository;
import com.hmovie.vn.service.WatchListService;

@Service
public class DefaultWatchListService implements WatchListService {

    @Autowired
    public WatchListRepository watchListRepository;
    
    @Autowired
    public MovieRepository movieRepository;

    @Override
    @Transactional
    public WatchList createWatchList() {
        WatchList watchList = new WatchList();
        return watchListRepository.save(watchList);
    }

	@Override
	public void addMovieToWatchList(Integer watchlistId, Integer movieId) {
		if(watchlistId == null || watchlistId < 0) {
			throw new RuntimeException("WatchList id must not be null and must be positive");
		}
		if(movieId == null || movieId < 0) {
			throw new RuntimeException("Movie id must not be null and must be positive");
		}
		
		WatchList watchList = watchListRepository.findById(watchlistId).orElse(null);
		if(watchList == null) {
			throw new RuntimeException("Cant not found watch list with id:" + watchlistId);
		}
		
		Movie movie = movieRepository.findById(movieId).orElse(null);
		if(movie == null) {
			throw new RuntimeException("Cant not found movie with id:" + movieId);
		}
		
		List<Movie> newMovies = watchList.getMovies();
		
		if(newMovies.contains(movie)) {
			newMovies.remove(movie);
		}
		else newMovies.add(movie);
		
		
		watchListRepository.save(watchList);
	}

	@Override
	public boolean checkMovieInWatchList(Integer watchlistId, Integer movieId) {
		if(watchlistId == null || watchlistId < 0) {
			throw new RuntimeException("WatchList id must not be null and must be positive");
		}
		if(movieId == null || movieId < 0) {
			throw new RuntimeException("Movie id must not be null and must be positive");
		}
		
		WatchList watchList = watchListRepository.findById(watchlistId).orElse(null);
		if(watchList == null) {
			throw new RuntimeException("Cant not found watch list with id:" + watchlistId);
		}
		
		Movie movie = movieRepository.findById(movieId).orElse(null);
		if(movie == null) {
			throw new RuntimeException("Cant not found movie with id:" + movieId);
		}
		
		
		return watchList.getMovies().contains(movie);
	}

}
