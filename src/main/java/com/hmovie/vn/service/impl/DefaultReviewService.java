package com.hmovie.vn.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmovie.vn.entity.Review;
import com.hmovie.vn.repository.ReviewRepository;
import com.hmovie.vn.service.ReviewService;

@Service
public class DefaultReviewService implements ReviewService {

    @Autowired
    public ReviewRepository reviewRepository;

    public static String getCurrenDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return now.format(dateTimeFormatter);
    }

    @Override
    @Transactional
    public Review createReview(Review review) {
        if (review.getId() != null) {
            throw new RuntimeException("Review already exist");
        }

        review.setCreateAt(getCurrenDateTime());

        return reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void deleteReview(Integer reviewId) {
        if (reviewId == null || reviewId <= 0) {
            throw new RuntimeException("Review id must not be null and must be positive");
        }

        reviewRepository.deleteById(reviewId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Review> getReviewsByMovieImdbId(String imdbId) {
        if (imdbId.isEmpty()) {
            throw new RuntimeException("ImdbId must not be empty!");
        }
        return reviewRepository.findByMovieImdbId(imdbId);
    }

}
