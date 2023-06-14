package com.micro.hotel.service.HotelSerivce.Payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String msg;
    private boolean success;
    private HttpStatus status;
}
