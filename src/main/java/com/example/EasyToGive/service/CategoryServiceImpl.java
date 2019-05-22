package com.example.EasyToGive.service;

import com.example.EasyToGive.model.Category;
import com.example.EasyToGive.repository.CategoryRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CrudService<Category> {
    @Autowired
    private CategoryRep categoryCrudService;
    @Override
    public List<Category> getAll() {
        return categoryCrudService.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryCrudService.findById(id).get();
    }

    @Override
    public Category save(Category category) {
        return this.categoryCrudService.save(category);
    }


    @Override
    public Category update(Category category) {
        return categoryCrudService.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryCrudService.deleteById(id);
    }

    @Override
    public void deleteAll() {
        categoryCrudService.deleteAll();
    }
}
