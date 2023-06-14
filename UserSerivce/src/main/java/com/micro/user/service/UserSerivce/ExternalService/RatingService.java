package com.micro.user.service.UserSerivce.ExternalService;

import com.micro.user.service.UserSerivce.Entites.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/users/{id}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("id") String userId );


}
