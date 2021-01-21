package com.company.storage.inmemory;

import com.company.entity.Author;
import com.company.storage.AuthorStorage;

import java.util.Arrays;

public class InMemoryAuthorStorage implements AuthorStorage {
    private int incId = 0;
    private static Author[] authors = new Author[10];

    static {
        authors[0] = new Author("Tolstoy", "russian writer");
        authors[1] = new Author("Lermontov", "young");
        authors[2] = new Author("Den Braun", "foreign writer");
    }

    @Override
    public void save(Author author) {
        for (int i = 0; i < authors.length; i++) {
             if (authors[i] == null){
                 authors[i] = author;
                 autoIncId();
                 break;
             }
        }
    }

    @Override
    public void updateName(int id, String name) {
        for (int i = 0; i < authors.length ; i++) {
            if (authors[i] == null) break;
            if( authors[i].getId() == id){
                authors[i].setName(name);
                break;
            }
        }
    }

    @Override
    public void updateDescription(int id, String description) {
        for (int i = 0; i < authors.length ; i++) {
            if (authors[i] == null) break;
            if (authors[i].getId() == id){
                authors[i].setDescription(description);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getId() == id) {
                for (int i1 = i; i1 < authors.length - 1; i1++) {
                    authors[i1] = authors[i1 + 1];
                }
                break;
            }
        }
    }

    @Override
    public void delete(String name) {
        for (int i = 0; i < authors.length ; i++) {
            if (authors[i] == null) break;
            if (authors[i].getName().equals(name)) {
                for (int i1 = i; i1 < authors.length - 1; i1++) {
                    authors[i1] = authors[i1 + 1];
                }
                break;
            }
        }
    }

    @Override
    public Author getById(int id) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getId() == id){
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public Author getByName(String name) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getName().equals(name)){
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public Author[] getAll() {
        int count = 0;
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] != null){
                count++;
            }
        }
        return Arrays.copyOf(authors, count);
    }

    @Override
    public boolean contains(String name) {
        for (int i = 0; i < authors.length ; i++) {
            if (authors[i] == null) break;
            if (authors[i].getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < authors.length ; i++) {
            if (authors[i] == null) break;
            if (authors[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public void autoIncId() {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) break;
            if (authors[i].getId() == 0){
                authors[i].setId(incId);
                incId++;
            }
        }
    }
}
