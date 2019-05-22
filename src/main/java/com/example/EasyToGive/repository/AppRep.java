package com.example.EasyToGive.repository;

import com.example.EasyToGive.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRep extends JpaRepository<Application, Long> {
}
