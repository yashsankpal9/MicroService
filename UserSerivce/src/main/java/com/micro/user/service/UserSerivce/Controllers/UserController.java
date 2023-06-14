package com.micro.user.service.UserSerivce.Controllers;

import com.micro.user.service.UserSerivce.Entites.User;
import com.micro.user.service.UserSerivce.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService us;

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User us = this.us.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(us);
    }

    int cnt = 1;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//    @Retry(name="ratingHotelRetry",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="userLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getAllUser(@PathVariable String userId){
//        logger.info(String.valueOf(cnt));
//        cnt++;
        User us = this.us.getUser(userId);
        return ResponseEntity.ok(us);
    }


    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
        User user = User.builder().userId("1234321").email("a@bb.com").about("Civil Engineer").name("Yash Sankpal").build();
        return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> Allus = this.us.getAllUser();
        return ResponseEntity.ok(Allus);
    }


}
