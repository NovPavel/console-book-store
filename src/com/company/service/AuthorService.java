package com.company.service;

import com.company.entity.Author;
import com.company.storage.AuthorStorage;
import com.company.storage.inmemory.InMemoryAuthorStorage;

import java.util.Arrays;

public class AuthorService {

    private AuthorStorage authorStorage = new InMemoryAuthorStorage();

    public static void main(String[] args) {
        AuthorService authorService = new AuthorService();
        authorService.save(new Author("Test1", "book"));
        authorService.save(new Author("Test2", "peter"));
        authorService.save(new Author("Test3", "voice"));
        authorService.save(new Author("Test4","fight"));
        authorService.delete("Test2");
        authorService.delete(3);
        authorService.save(new Author("Test5", "blabla"));
        authorService.save(new Author("Test6","ulala"));



        System.out.println(Arrays.toString(authorService.getAll()));
    }

    public boolean save(Author author) {
        if (authorStorage.contains(author.getName())){
           return false;
        }
        authorStorage.save(author);
        return true;
    }

    public void updateName(int id, String name) {
        if (authorStorage.contains(id) && !authorStorage.contains(name)){
            authorStorage.updateName(id,name);
        }
    }

    public void updateDescription(int id, String description) {
        if (authorStorage.contains(id)){
            authorStorage.updateDescription(id, description);
        }
    }

    public void delete(int id) {
        if (authorStorage.contains(id)){
            authorStorage.delete(id);
        }
    }

    public void delete(String name) {
        if (authorStorage.contains(name)){
            authorStorage.delete(name);
        }
    }

    public Author getById(int id) {
        if (authorStorage.contains(id)){
            return authorStorage.getById(id);
        }
        return null;
    }

    public Author getByName(String name) {
        if (authorStorage.contains(name)){
            authorStorage.getByName(name);
        }
        return null;
    }

    public Author[] getAll() {
        return authorStorage.getAll();
    }
}
