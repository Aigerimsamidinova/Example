package com.example.EasyToGive.repository;

import com.example.EasyToGive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long> {
}
