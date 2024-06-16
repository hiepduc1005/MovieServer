package com.hmovie.vn.service;

import java.util.List;

import com.hmovie.vn.entity.Review;

public interface ReviewService {
	
	Review createReview(Review review);
	
	void deleteReview(Integer reviewId);
	
	List<Review> getReviewsByMovieImdbId(String imdbId);
	
}
