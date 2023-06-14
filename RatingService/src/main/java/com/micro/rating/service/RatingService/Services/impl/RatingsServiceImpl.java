package com.micro.rating.service.RatingService.Services.impl;

import com.micro.rating.service.RatingService.Entities.Rating;
import com.micro.rating.service.RatingService.Repositories.RatingRepository;
import com.micro.rating.service.RatingService.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RatingsServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    public Rating updateRating(String ratingId,String feedback){
        Rating rating = ratingRepository.findById(ratingId).orElseThrow(()->new RuntimeException("Error !!!"));
        rating.setFeedback(feedback);
        return ratingRepository.save(rating);
    }
}
