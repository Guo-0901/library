package com.example.library.controller;

import com.example.library.common.Result;
import com.example.library.dto.BookAddDTO;
import com.example.library.model.Book;
import com.example.library.server.LibraryServer;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class LibraryController {

    private final LibraryServer server;

    public LibraryController(LibraryServer server) {
        this.server = server;
    }

    @GetMapping("/library")
    public Result getBook () {
        List<Book> books = server.findAll();
        return Result.ok(books);
    }

    @GetMapping("/library/{id}")
    public Result getById (@PathVariable int id) {
        Optional<Book> book = server.findById(id);
        if (book.isEmpty()) {
            return Result.fail(404, "书不存在");
        }
        return Result.ok(book.get());
    }

    @PostMapping("/library")
    public Result addBook (@RequestBody @Valid BookAddDTO book) {
        Book newbook = new Book();
        newbook.author = book.getAuthor();
        newbook.name = book.getName();
        return Result.ok(server.add(newbook));
    }

    @PutMapping("/library/{id}")
    public Result updateBook (@RequestBody @Valid BookAddDTO book, @PathVariable int id) {
        Book newbook = new Book(id, book.getName(), book.getAuthor());
        Optional<Book> update = server.update(id, newbook);
        if (update.isEmpty()) {
            return Result.fail(404, "书不存在");
        }
        return Result.ok(update.get());
    }

    @DeleteMapping("/library/{id}")
    public Result deleteBook (@PathVariable int id) {
        boolean deleted = server.delete(id);
        if (!deleted) return Result.fail(404, "书不存在");
        return Result.ok(null);
    }
}
