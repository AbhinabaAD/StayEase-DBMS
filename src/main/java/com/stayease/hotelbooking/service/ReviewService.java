package com.stayease.hotelbooking.service;

import com.stayease.hotelbooking.entity.Review;
import com.stayease.hotelbooking.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Integer id) {
        return reviewRepository.findById(id);
    }

    public Optional<Review> getReviewByBooking(Integer bookingId) {
        return reviewRepository.findByBooking_BookingId(bookingId);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }
}