package com.example.EasyToGive.bootstrap;

import com.example.EasyToGive.model.*;
import com.example.EasyToGive.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private CrudService<User> userCrudService;
    @Autowired
    private CrudService<Category> categoryCrudService;
    @Autowired
    private CrudService<Application> applicationCrudService;
    @Autowired
    private CrudService<Item> itemCrudService;
//    @Autowired
//    private CrudService<Comment> commentCrudService;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User();
        u1.setName("Aigerim Samidinova");
        u1.setEmail("aigerimsamidinovaa@gmail.com");
        userCrudService.save(u1);
        User u2 = new User();
        u2.setName("Kanat Subanov");
        u2.setEmail("subanov@gmail.com");
        userCrudService.save(u2);

        Category c1 = new Category();
        c1.setName("BD");
        categoryCrudService.save(c1);

        Category c2 = new Category();
        c2.setName("Married");
        categoryCrudService.save(c2);

        Item i1 = new Item();
        i1.setName("Iphone");
        i1.setPrice(70000);
        i1.setLink("www.link.com");
        itemCrudService.save(i1);

        Item i2 = new Item();
        i2.setName("Iphone");
        i2.setPrice(70000);
        i2.setLink("www.link.com");
        itemCrudService.save(i2);

        Item i3 = new Item();
        i3.setName("Iphone");
        i3.setPrice(70000);
        i3.setLink("www.link.com");
        itemCrudService.save(i3);

        List<Item> items = new ArrayList<>();
        items.add(i1);
        items.add(i2);
        items.add(i3);

        Application app1 = new Application();
        app1.setCategory(c1);
        app1.setHeadLine("  ");
        app1.setItems(items);
        app1.setUser(u1);
        applicationCrudService.save(app1);

    }
}
