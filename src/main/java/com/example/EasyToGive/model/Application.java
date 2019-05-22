package com.example.EasyToGive.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String headLine;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
   @JoinColumn(name =  "user_id")
    private  User user;
    @OneToMany
    private List<Comment> comments;
    @OneToMany
    private List<Item> items;

    public Application() {
    }

    public Application(String headLine, Category category, User user, List<Comment> comments, List<Item> items) {
        this.headLine = headLine;
        this.category = category;
        this.user = user;
        this.comments = comments;
        this.items = items;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
