package com.example.library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public String author;

    public Book(){
    }
    public Book (int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
