package com.example.library.server;

import com.example.library.model.Book;
import com.example.library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;


@Service
public class LibraryServer {
    private final LibraryRepository repository;

    public LibraryServer(LibraryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Book> findAll () {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Book> findById (int id) {
        return repository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Book add (Book book) {
        return repository.save(book);
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<Book> update (int id, Book book) {
        if (!repository.existsById(id)) return Optional.empty();
        Book newBook = new Book (id, book.name, book.author);
        return Optional.of(repository.save(newBook));
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean delete (int id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}



