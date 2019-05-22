package com.example.EasyToGive.service;

import com.example.EasyToGive.model.Application;
import com.example.EasyToGive.repository.AppRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements CrudService<Application> {
    @Autowired
    private AppRep appRep;

    @Override
    public List<Application> getAll() {
        return appRep.findAll();
    }

    @Override
    public Application findById(Long id) {
        return appRep.findById(id).get();
    }

    @Override
    public Application save(Application application) {
        return appRep.save(application);
    }

    @Override
    public Application update(Application application) {
        return appRep.save(application);
    }

    @Override
    public void deleteById(Long id) {
        appRep.deleteById(id);
    }

    @Override
    public void deleteAll() {
        appRep.deleteAll();
    }
}
