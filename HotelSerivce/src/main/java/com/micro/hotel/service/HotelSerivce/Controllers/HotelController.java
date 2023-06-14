package com.micro.hotel.service.HotelSerivce.Controllers;

import com.micro.hotel.service.HotelSerivce.Entites.Hotel;
import com.micro.hotel.service.HotelSerivce.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);

        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping
    public  ResponseEntity<List<Hotel>> getHotelList(){
        List<Hotel> hotels = hotelService.getAllHotel();
        return ResponseEntity.ok(hotels);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        Hotel hotel = hotelService.getById(hotelId);
        return ResponseEntity.ok(hotel);
    }

}
