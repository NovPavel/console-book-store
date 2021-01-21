package com.company.storage;

import com.company.entity.*;

public interface OrderStorage {
    void save(Order order);

    void updateAddress(int id, Address address);

    void updateStore(int id, Store store);

    void updateStatus(int id, Status status);

    void updateType(int id, Type type);

    void updateBooks(int id, Book[] books);

    void delete(int id);

    void delete(Order order);

    Order[] getAll();

    Order[] getAllByUser(User user);

    Order[] getAllByStore(Store store);

    Order[] getAllByAddress(Address address);

    Order[] getAllByType(Type type);

    Order[] getAllByStatus(Status status);

    boolean contains(int id);

    boolean contains(Order order);

}
