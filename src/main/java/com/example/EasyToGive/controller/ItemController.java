package com.example.EasyToGive.controller;

import com.example.EasyToGive.model.Item;

import com.example.EasyToGive.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private CrudService<Item> itemCrudService;

    @GetMapping("/getAll")
    public List<Item> getItems() {
        return itemCrudService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = this.itemCrudService.findById(id);
        try {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Item> saveItem(@RequestBody Item c) {
        Item item = this.itemCrudService.save(c);
        try {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Item> updateItem(@RequestBody Item c) {
        Item item = this.itemCrudService.update(c);
        try {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable Long id) {
        try {
            this.itemCrudService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllItems() {
        try {
            this.itemCrudService.deleteAll();
            return new ResponseEntity<>("All Items deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }
}