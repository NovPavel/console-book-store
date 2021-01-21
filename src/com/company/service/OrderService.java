package com.company.service;

import com.company.entity.*;
import com.company.storage.OrderStorage;
import com.company.storage.inmemory.InMemoryOrderStorage;

public class OrderService {

    OrderStorage orderStorage =  new InMemoryOrderStorage();


    public boolean save(Order order) {
        if (orderStorage.contains(order)){
            return false;
        }
        orderStorage.save(order);
        return true;
    }

    public void updateAddress(int id, Address address) {
        if (orderStorage.contains(id)){
            orderStorage.updateAddress(id, address);
        }
    }

    public void updateStore(int id, Store store) {
        if (orderStorage.contains(id)){
            orderStorage.updateStore(id, store);
        }
    }

    public void updateStatus(int id, Status status) {
        if (orderStorage.contains(id)){
            orderStorage.updateStatus(id, status);
        }
    }

    public void updateType(int id, Type type) {
        if (orderStorage.contains(id)){
            orderStorage.updateType(id, type);
        }
    }

    public void updateBooks(int id, Book[] books) {
        if (orderStorage.contains(id)){
            orderStorage.updateBooks(id, books);
        }
    }

    public void delete(int id) {
        if (orderStorage.contains(id)){
            orderStorage.delete(id);
        }
    }


    public void delete(Order order) {
        if (orderStorage.contains(order)){
            orderStorage.delete(order);
        }
    }

    public Order[] getAll() {
        return orderStorage.getAll();
    }

    public Order[] getAllByUser(User user) {
        return orderStorage.getAllByUser(user);
    }

    public Order[] getAllByStore(Store store) {
        return orderStorage.getAllByStore(store);
    }


    public Order[] getAllByAddress(Address address) {
        return orderStorage.getAllByAddress(address);
    }


    public Order[] getAllByType(Type type) {
        return orderStorage.getAllByType(type);
    }

    public Order[] getAllByStatus(Status status) {
        return orderStorage.getAllByStatus(status);

    }
}
