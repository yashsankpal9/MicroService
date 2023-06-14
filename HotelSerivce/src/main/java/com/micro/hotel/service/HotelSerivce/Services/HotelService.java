package com.micro.hotel.service.HotelSerivce.Services;

import com.micro.hotel.service.HotelSerivce.Entites.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel getById(String hotelId);
}
