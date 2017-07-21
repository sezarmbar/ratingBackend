package com.concretepage.service;

import com.concretepage.entity.Rating;
import com.concretepage.entity.Review;

import java.util.List;

/**
 * Created by mahmoudbarakat on 21.07.17.
 */
public interface ReviewService {
    public List<Review> findAll ();
    public boolean createReview(Review review);
    public  List<Review> findAllByRating(Rating rating);

}
