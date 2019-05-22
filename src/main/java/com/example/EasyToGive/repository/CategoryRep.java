package com.example.EasyToGive.repository;

import com.example.EasyToGive.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRep
        extends JpaRepository<Category, Long> {

}
