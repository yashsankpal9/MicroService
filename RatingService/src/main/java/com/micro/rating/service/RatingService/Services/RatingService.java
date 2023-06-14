package com.micro.rating.service.RatingService.Services;


import com.micro.rating.service.RatingService.Entities.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getRating();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);

    Rating updateRating(String ratingId,String feedback);
}
