package com.example.EasyToGive.repository;

import com.example.EasyToGive.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRep  extends JpaRepository<Item, Long> {
}
