package com.concretepage.service;

import com.concretepage.dao.RatingRepository;
import com.concretepage.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mahmoudbarakat on 20.07.17.
 */
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository ;

    @Override
    public Rating findById(Long id) {
        return ratingRepository.findOne(id);
    }

    @Override
    public Rating findByNameOfRat(String nameOfRat) {
        return ratingRepository.findByNameOfRat(nameOfRat);
    }

    @Override
    public boolean createRating(Rating rating) {
         ratingRepository.save(rating);
        return true;
    }

    @Override
    public boolean updateRating(Rating rating) {
        ratingRepository.save(rating);
        return true;
    }

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public void deleteRating(Long id) {
        ratingRepository.delete(id);
    }
}
