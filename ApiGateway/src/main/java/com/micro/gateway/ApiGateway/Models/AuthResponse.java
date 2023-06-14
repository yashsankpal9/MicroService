package com.micro.gateway.ApiGateway.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String userId;
//    private String email;
    private String accessToken;
    private String refreshToken;
    private long expireAt;
    private Collection<String> authorities;

//    Set<Integer> set = new HashSet<>();
//
//    public static void main(String[] args) {
//        String s;
//        s.split(" ");
//
//        Arrays.stream(s.split(" ")).filter(e->!e.contains("")).collect(Collectors.toList());
//    }
}
