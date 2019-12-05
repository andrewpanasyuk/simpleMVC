package com.example.simpleApp.repos;

import com.example.simpleApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByUserName(String userName);
}
