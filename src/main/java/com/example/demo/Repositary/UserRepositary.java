package com.example.demo.Repositary;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositary extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
