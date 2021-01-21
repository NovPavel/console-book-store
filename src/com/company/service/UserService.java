package com.company.service;

import com.company.entity.Address;
import com.company.entity.User;
import com.company.storage.UserStorage;
import com.company.storage.inmemory.InMemoryUserStorage;

import java.util.Arrays;

public class UserService {

    UserStorage userStorage = new InMemoryUserStorage();


    public boolean save(User user) {
        if (userStorage.contains(user.getId()) || userStorage.contains(user.getAddress())){
            return false;
        }
        userStorage.save(user);
        return true;
    }


    public void updateName(int id, String name) {
        if (userStorage.contains(id)){
            userStorage.updateName(id, name);
        }
    }


    public void updatePassword(int id, String password) {
        if (userStorage.contains(id)){
            userStorage.updatePassword(id, password);
        }
    }


    public void updateAddress(int id, Address address) {
        if (userStorage.contains(id) && !userStorage.contains(address)){
            userStorage.updateAddress(id, address);
        }
    }


    public void updateAge(int id, int age) {
       if (userStorage.contains(id)){
           userStorage.updateAge(id, age);
       }
    }


    public void delete(int id) {
        if (userStorage.contains(id)){
            userStorage.delete(id);
        }
    }


    public void delete(String login) {
        if (userStorage.contains(login)){
            userStorage.delete(login);
        }
    }


    public User[] getAll() {
        return userStorage.getAll();
    }


    public User[] getAllByName(String name) {
        return userStorage.getAllByName(name);
    }


    public User getById(int id) {
        if (userStorage.contains(id)){
            return userStorage.getById(id);
        }
        return null;
    }


    public User getByLogin(String login) {
        if (userStorage.contains(login)){
            return userStorage.getByLogin(login);
        }
        return null;
    }


    public User getByAddress(Address address) {
        if (userStorage.contains(address)){
            return userStorage.getByAddress(address);
        }
        return null;
    }

}
