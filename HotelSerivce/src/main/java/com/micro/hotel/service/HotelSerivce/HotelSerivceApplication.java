package com.micro.hotel.service.HotelSerivce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelSerivceApplication.class, args);
	}

}
