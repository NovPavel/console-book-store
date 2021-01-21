package com.company.storage;
import com.company.entity.Book;


public interface BookStorage {

    void save(Book book);

    void updateName(int id, String name);

    void updateDescription(int id, String description);

    void delete(int id);

    void delete(String name);

    Book getById(int id);

    Book getByName(String name);

    Book[] getAll();

    boolean contains(String name);

    boolean contains(int id);
}
