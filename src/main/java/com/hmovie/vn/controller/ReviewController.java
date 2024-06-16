package com.hmovie.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.request.Review.ReviewCreateRequest;
import com.hmovie.vn.dto.response.ReviewResponse;
import com.hmovie.vn.entity.Review;
import com.hmovie.vn.service.ReviewService;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponse> createReview(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        Review review = new Review();
        review.setComment(reviewCreateRequest.getComment());

        reviewService.createReview(review);

        ReviewResponse reviewResponse = new ReviewResponse(
                review.getId(),
                review.getComment(),
                review.getCreateAt());

        return ResponseEntity.ok(reviewResponse);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Integer reviewId) {
        reviewService.deleteReview(reviewId);

        return ResponseEntity.ok("Delete review with id: " + reviewId + " success!");
    }
}
