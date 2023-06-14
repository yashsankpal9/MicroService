package com.micro.user.service.UserSerivce.services.impl;

import com.micro.user.service.UserSerivce.Entites.Hotel;
import com.micro.user.service.UserSerivce.Entites.Rating;
import com.micro.user.service.UserSerivce.Entites.User;
import com.micro.user.service.UserSerivce.Exceptions.ResourceNotFoundExecption;
import com.micro.user.service.UserSerivce.ExternalService.HotelService;
import com.micro.user.service.UserSerivce.ExternalService.RatingService;
import com.micro.user.service.UserSerivce.Repositories.UserRepository;
import com.micro.user.service.UserSerivce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository up;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RatingService ratingService;
    
    @Autowired
    private HotelService hotelService;
    
    @Override
    public User saveUser(User user) {
        String rand_uuid = UUID.randomUUID().toString();
        user.setUserId(rand_uuid);
        return up.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> lsUser = up.findAll();

//        List<User>  newUsersData = lsUser.stream().map(user -> {
//            Rating[] data = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
//
//            List<Rating> newData = Arrays.stream(data).map(rating -> {
//                ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//                rating.setHotel(hotelResponseEntity.getBody());
//                return rating;
//            }).collect(Collectors.toList());
//
//            user.setRatings(newData);
//
//            return user;
//        }).collect(Collectors.toList());

        List<User> newUsersData = lsUser.stream().map(user -> {
            ResponseEntity<List<Rating>> temp = ratingService.getRatingByUserId(user.getUserId());
            List<Rating> newData = temp.getBody().stream().map(rating -> {
                ResponseEntity<Hotel> hotelResponseEntity = hotelService.getHotelById(rating.getHotelId());
                rating.setHotel(hotelResponseEntity.getBody());
                return rating;
            }).collect(Collectors.toList());

            user.setRatings(newData);

            return user;
        }).collect(Collectors.toList());
        return newUsersData;
    }

    @Override
    public User getUser(String userId) {
        User user =  up.findById(userId).orElseThrow(()-> new ResourceNotFoundExecption(userId+" not found"));

        // Get rating data from rating db
        //http://RATING_SERVICE/ratings/users/{userId}
//        Rating[] data = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
//
//        List<Rating> newData = Arrays.stream(data).map(rating -> {
//            ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//            rating.setHotel(hotelResponseEntity.getBody());
//            return rating;
//        }).collect(Collectors.toList());
//
//        user.setRatings(newData);
//
//        return user;

        ResponseEntity<List<Rating>> temp = ratingService.getRatingByUserId(user.getUserId());
        List<Rating> newData = temp.getBody().stream().map(rating -> {
            ResponseEntity<Hotel> hotelResponseEntity = hotelService.getHotelById(rating.getHotelId());
            rating.setHotel(hotelResponseEntity.getBody());
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(newData);

        return user;
    }
}
