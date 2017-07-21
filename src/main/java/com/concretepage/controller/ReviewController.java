package com.concretepage.controller;

import com.concretepage.entity.Rating;
import com.concretepage.entity.Review;
import com.concretepage.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by mahmoudbarakat on 21.07.17.
 */


@Controller
@RequestMapping("api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("all-reviews")
    public ResponseEntity<List<Review>> getAllReviews(@RequestBody Rating rating){
        List<Review> list = reviewService.findAllByRating(rating);
        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }

    @PostMapping("review")
    public ResponseEntity<Void> createArticle(@RequestBody Review review, UriComponentsBuilder builder) {
        boolean flag = reviewService.createReview(review);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/review?id={id}").buildAndExpand(review.getReviewId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}
