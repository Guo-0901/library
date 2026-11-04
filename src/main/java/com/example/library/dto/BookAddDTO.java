package com.example.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookAddDTO {
    @NotBlank(message = "书名不能为空")
    @Size(max = 50, message = "书名最多50个字符")
    private String name;

    @NotBlank(message = "作者名不能为空")
    @Size(max = 50, message = "作者名最多50个字符")
    private String author;

    public BookAddDTO(){}

    public BookAddDTO(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName () {
        return this.name;
    }
    public void setName (String name) {
        this.name = name;
    }

    public String getAuthor () {
        return this.author;
    }
    public void setAuthor (String author) {
        this.author = author;
    }
}
