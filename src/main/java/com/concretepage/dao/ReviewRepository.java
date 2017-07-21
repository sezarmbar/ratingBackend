package com.concretepage.dao;

import com.concretepage.entity.Rating;
import com.concretepage.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mahmoudbarakat on 21.07.17.
 */
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findAllByRating(Rating rating);
}
