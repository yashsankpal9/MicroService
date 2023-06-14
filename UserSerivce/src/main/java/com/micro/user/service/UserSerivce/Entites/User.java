package com.micro.user.service.UserSerivce.Entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private  String userId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private  String email;
    @Column(name = "about")
    private  String about;

    transient
    private List<Rating> ratings;
}
