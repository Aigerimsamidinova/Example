package com.example.EasyToGive.controller;

import com.example.EasyToGive.model.Application;
import com.example.EasyToGive.model.Category;
import com.example.EasyToGive.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("application")
public class AppController {
    @Autowired
    private CrudService<Application> applicationCrudService;

    @GetMapping("/getAll")
    public List<Application> getAll() {
        return this.applicationCrudService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Application> getById(@PathVariable Long id) {
        Application Application = this.applicationCrudService.findById(id);
        try {
            return new ResponseEntity<>(Application, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Application> saveApplication(@RequestBody Application q) {
        Application Application = this.applicationCrudService.save(q);
        try {
            return new ResponseEntity<>(Application, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Application> updateApplication(@RequestBody Application q) {
        Application Application = this.applicationCrudService.update(q);
        try {
            return new ResponseEntity<>(Application, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteQuestonById(@PathVariable Long id) {
        try {
            this.applicationCrudService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllApplications() {
        try {
            this.applicationCrudService.deleteAll();
            return new ResponseEntity<>("All Applications deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }
}
