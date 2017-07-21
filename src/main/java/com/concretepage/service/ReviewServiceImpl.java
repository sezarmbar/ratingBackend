package com.concretepage.service;

import com.concretepage.dao.ReviewRepository;
import com.concretepage.entity.Rating;
import com.concretepage.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mahmoudbarakat on 21.07.17.
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean createReview(Review review) {
        reviewRepository.save(review);
        return true;
    }
    @Override
    public  List<Review> findAllByRating(Rating rating){return reviewRepository.findAllByRating(rating);}
}
