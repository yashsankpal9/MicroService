package com.micro.hotel.service.HotelSerivce.Repositories;

import com.micro.hotel.service.HotelSerivce.Entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String> {
}
