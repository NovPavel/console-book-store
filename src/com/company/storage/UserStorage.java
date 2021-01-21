package com.company.storage;

import com.company.entity.Address;
import com.company.entity.User;

public interface UserStorage {
    void save(User user);

    void updateName(int id, String name);

    void updatePassword(int id, String password);

    void updateAddress(int id, Address address);

    void updateAge(int id, int age);

    void delete(int id);

    void delete(String login);

    User[] getAll();

    User[] getAllByName(String name);

    User getById(int id);

    User getByLogin(String login);

    User getByAddress(Address address);

    boolean contains(int id);

    boolean contains(String login);

    boolean contains (Address address);
}
