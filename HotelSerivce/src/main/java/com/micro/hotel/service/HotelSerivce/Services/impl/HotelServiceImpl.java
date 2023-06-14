package com.micro.hotel.service.HotelSerivce.Services.impl;

import com.micro.hotel.service.HotelSerivce.Entites.Hotel;
import com.micro.hotel.service.HotelSerivce.Exceptions.ResourceNotFoundExecption;
import com.micro.hotel.service.HotelSerivce.Repositories.HotelRepository;
import com.micro.hotel.service.HotelSerivce.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;


    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundExecption(hotelId+":Hotel_ID not found"));
    }
}
