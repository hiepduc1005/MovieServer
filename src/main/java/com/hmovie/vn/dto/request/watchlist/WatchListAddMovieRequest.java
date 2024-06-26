package com.hmovie.vn.dto.request.watchlist;

public class WatchListAddMovieRequest {
	private Integer watchlistId;
	private Integer movieId;
	public Integer getWatchlistId() {
		return watchlistId;
	}
	public void setWatchlistId(Integer watchlistId) {
		this.watchlistId = watchlistId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	
	
}
