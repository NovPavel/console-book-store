package com.company.storage.inmemory;
import com.company.entity.Book;
import com.company.storage.BookStorage;
import java.util.Arrays;

public class InMemoryBookStorage implements BookStorage {

    private int incId = 1;
    private Book [] books = new Book[10];



    @Override
    public void save(Book book) {
        for (int i = 0; i < books.length ; i++) {
            if (books[i] == null){
                books[i] = book;
                books[i].setId(incId);
                incId++;
                break;
            }
        }
    }

    @Override
    public void updateName(int id, String name) {
        for (int i = 0; i < books.length; i++) {
            if (books [i]== null) break;
            if (books[i].getId() == id){
                books[i].setName(name);
                break;
            }
        }
    }

    @Override
    public void updateDescription(int id, String description) {
        for (int i = 0; i < books.length ; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id){
                books[i].setDescription(description);
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id) {
                for (int i1 = i; i1 < books.length - 1; i1++) {
                    books[i1] = books[i1 + 1];
                }
                break;
            }
        }
    }

    @Override
    public void delete(String name) {
        for (int i = 0; i < books.length ; i++) {
            if (books[i] == null) break;
            if (books[i].getName().equals(name)) {
                for (int i1 = i; i1 < books.length - 1; i1++) {
                    books[i1] = books[i1 + 1];
                }
                break;
            }
        }
    }

    @Override
    public Book getById(int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id){
                return books[i];
            }
        }
        return null;
    }

    @Override
    public Book getByName(String name) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getName().equals(name)){
                return books[i];
            }
        }
        return null;
    }

    @Override
    public Book[] getAll() {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null){
                count++;
            }
        }
        Book[] books = Arrays.copyOf(this.books, count);
        return books;
    }

    @Override
    public boolean contains(String name) {
        for (int i = 0; i < books.length ; i++) {
            if (books[i] == null) break;
            if (books[i].getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < books.length ; i++) {
            if (books[i] == null) break;
            if (books[i].getId() == id){
                return true;
            }
        }
        return false;
    }
}
