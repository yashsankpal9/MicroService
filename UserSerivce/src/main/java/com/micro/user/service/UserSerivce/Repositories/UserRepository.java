package com.micro.user.service.UserSerivce.Repositories;

import com.micro.user.service.UserSerivce.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
