package com.company.storage.inmemory;

import com.company.entity.*;
import com.company.storage.OrderStorage;

import java.util.Arrays;

public class InMemoryOrderStorage implements OrderStorage {

    private int incId = 1;
    private Order[] orders = new Order[10];


    @Override
    public void save(Order order) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                orders[i].setId(incId);
                orders[i] = order;
                incId++;
                break;
            }
        }
    }

    @Override
    public void updateAddress(int id, Address address) {
        for (int i = 0; i < orders.length ; i++) {
            if (orders[i].getId() == id){
                orders[i].setAddress(address);
                break;
            }
        }
    }

    @Override
    public void updateStore(int id, Store store) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId() == id){
                orders[i].setStore(store);
                break;
            }
        }
    }

    @Override
    public void updateStatus(int id, Status status) {
        for (int i = 0; i < orders.length ; i++) {
            if (orders[i].getId() == id){
                orders[i].setStatus(status);
                break;
            }
        }
    }

    @Override
    public void updateType(int id, Type type) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId() == id){
                orders[i].setType(type);
                break;
            }
        }
    }

    @Override
    public void updateBooks(int id, Book[] books) {
        for (int i = 0; i < orders.length ; i++) {
            if (orders[i].getId() == id){
                orders[i].setBooks(books);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < orders.length ; i++) {
            if (orders[i] == null)break;
            if (orders[i].getId() == id){
                for (int j = i; j < orders.length - 1 ; j++) {
                    orders[j] = orders[j+1];
                }
                break;
            }
        }
    }

    @Override
    public void delete(Order order) {
        for (int i = 0; i < orders.length ; i++) {
            if (orders[i] == null)break;
            if (orders[i].equals(order)){
                for (int j = i; j < orders.length - 1; j++) {
                    orders[j] = orders[j+1];
                }
                break;
            }
        }
    }

    @Override
    public Order[] getAll() {
        int count = 0;
        for (int i = 0; i < orders.length ; i++) {
            if (orders[i] != null){
                count++;
            }
        }
        return Arrays.copyOf(orders,count);
    }

    @Override
    public Order[] getAllByUser(User user) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null)break;
            if (orders[i].getUser().equals(user)){
                count++;

            }
        }
        Order[] orders2 = new Order[count];
        for (int i = 0, j = 0; i < orders.length; i++) {
            if (orders[i] == null)break;
            if (orders[i].getUser().equals(user)){
                orders2[j++] = orders[i];
            }
        }
        return  orders2;
    }

    @Override
    public Order[] getAllByStore(Store store) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null)break;
            if (orders[i].getStore().equals(store)){
                count++;

            }
        }
        Order[] orders2 = new Order[count];
        for (int i = 0, j = 0; i < orders.length; i++) {
            if (orders[i] == null)break;
            if (orders[i].getStore().equals(store)){
                orders2[j++] = orders[i];
            }
        }
        return  orders2;
    }

    @Override
    public Order[] getAllByAddress(Address address) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null)break;
            if (orders[i].getAddress().equals(address)){
                count++;

            }
        }
        Order[] orders2 = new Order[count];
        for (int i = 0, j = 0; i < orders.length; i++) {
            if (orders[i] == null)break;
            if (orders[i].getAddress().equals(address)){
                orders2[j++] = orders[i];
            }
        }
        return  orders2;
    }

    @Override
    public Order[] getAllByType(Type type) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null)break;
            if (orders[i].getType().equals(type)){
                count++;

            }
        }
        Order[] orders2 = new Order[count];
        for (int i = 0, j = 0; i < orders.length; i++) {
            if (orders[i] == null)break;
            if (orders[i].getType().equals(type)){
                orders2[j++] = orders[i];
            }
        }
        return  orders2;
    }

    @Override
    public Order[] getAllByStatus(Status status) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null)break;
            if (orders[i].getStatus().equals(status)){
                count++;

            }
        }
        Order[] orders2 = new Order[count];
        for (int i = 0, j = 0; i < orders.length; i++) {
            if (orders[i] == null)break;
            if (orders[i].getStatus().equals(status)){
                orders2[j++] = orders[i];
            }
        }
        return  orders2;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < orders.length ; i++) {
            if (orders[i] == null)break;
            if (orders[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Order order) {
        for (int i = 0; i < orders.length ; i++) {
            if (orders[i] == null)break;
            if (orders[i].equals(order)){
                return true;
            }
        }
        return false;
    }
}
