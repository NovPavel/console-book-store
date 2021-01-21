package com.company.service;

import com.company.entity.Author;
import com.company.entity.Book;
import com.company.storage.BookStorage;
import com.company.storage.inmemory.InMemoryBookStorage;

import java.util.Arrays;

public class BookService {

    private BookStorage bookStorage = new InMemoryBookStorage();


    public boolean save(Book book) {
        if (bookStorage.contains(book.getName())) {
            return false;
        }
        bookStorage.save(book);
        return true;
    }


    public void updateName(int id, String name) {
        if (bookStorage.contains(id)) {
            bookStorage.updateName(id, name);
        }
    }


    public void updateDescription(int id, String description) {
        if (bookStorage.contains(id)) {
            bookStorage.updateDescription(id, description);
        }
    }


    public void delete(int id) {
        if (bookStorage.contains(id)) {
            bookStorage.delete(id);
        }
    }


    public void delete(String name) {
        if (bookStorage.contains(name)) {
            bookStorage.delete(name);
        }
    }

    public Book getById(int id) {
        if (bookStorage.contains(id)){
            return bookStorage.getById(id);
        }
        return null;
    }

    public Book getByName(String name){
        if (bookStorage.contains(name)){
            return bookStorage.getByName(name);
        }
        return null;
    }

    public Book[] getAll() {
        return bookStorage.getAll();
    }
}