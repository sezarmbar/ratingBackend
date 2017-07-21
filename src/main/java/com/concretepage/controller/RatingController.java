package com.concretepage.controller;

import com.concretepage.entity.Rating;
import com.concretepage.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by mahmoudbarakat on 20.07.17.
 */


@Controller
@RequestMapping("api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RatingController {

    @Autowired
    RatingService ratingService;


    @GetMapping("all-rating")
    public ResponseEntity<List<Rating>> getAllArticles() {
        List<Rating> list = ratingService.findAll();
        return new ResponseEntity<List<Rating>>(list, HttpStatus.OK);
    }

    @GetMapping("rating")
    public ResponseEntity<Rating> getArticle(@RequestParam Long id, Model model) {
        System.out.println(id);
        Rating rating = ratingService.findById(id);
        return new ResponseEntity<Rating>(rating, HttpStatus.OK);
    }

    @PostMapping("rating")
    public ResponseEntity<Void> createArticle(@RequestBody Rating rating, UriComponentsBuilder builder) {
        System.out.println(rating.toString());
        boolean flag = ratingService.createRating(rating);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/rating?id={id}").buildAndExpand(rating.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("rating")
    public ResponseEntity<Void> deleteRating(@RequestParam("id") String id) {
        ratingService.deleteRating(Long.parseLong(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
