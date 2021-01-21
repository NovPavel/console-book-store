package com.company.storage;

import com.company.entity.Author;

public interface AuthorStorage {
    void save(Author author);

    void updateName(int id, String name);

    void updateDescription(int id, String description);

    void delete(int id);

    void delete(String name);

    Author getById(int id);

    Author getByName(String name);

    Author[] getAll();

    boolean contains(String name);

    boolean contains(int id);

    public void autoIncId();
}
