package com.company.storage.inmemory;

import com.company.entity.Address;
import com.company.entity.Role;
import com.company.entity.User;
import com.company.storage.UserStorage;

import java.util.Arrays;

public class InMemoryUserStorage implements UserStorage {

    private static User[] users = new User[10];
    private int incId = 1;

    {
        save(new User("Admin", "admin", "admin", new Address("admin", 22), 22, Role.ADMIN));
        save(new User("User", "user", "user", new Address("user", 22), 22, Role.USER));
    }

    @Override
    public void save(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                users[i].setId(incId);
                incId++;
                break;
            }
        }
    }

    @Override
    public void updateName(int id, String name) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getId() == id) {
                users[i].setName(name);
                break;
            }
        }
    }

    @Override
    public void updatePassword(int id, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getId() == id) {
                users[i].setPassword(password);
                break;
            }
        }
    }

    @Override
    public void updateAddress(int id, Address address) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getId() == id) {
                users[i].setAddress(address);
                break;
            }
        }
    }

    @Override
    public void updateAge(int id, int age) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getId() == id) {
                users[i].setAge(age);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getId() == id) {
                for (int j = i; j < users.length - 1; j++) {
                    users[j] = users[j + 1];
                }
                break;
            }
        }
    }

    @Override
    public void delete(String login) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getLogin().equals(login)) {
                for (int j = i; j < users.length - 1; j++) {
                    users[j] = users[j + 1];
                }
                break;
            }
        }
    }

    @Override
    public User[] getAll() {
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                count++;
            }
        }
        return Arrays.copyOf(users, count);
    }

    @Override
    public User[] getAllByName(String name) {
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getName().equals(name)) {
                count++;
            }
        }
        User[] users2 = new User[count];
        for (int i = 0, j = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getName().equals(name)) {
                users2[j++] = users[i];
            }
        }
        return users2;
    }

    @Override
    public User getById(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        return null;
    }

    @Override
    public User getByLogin(String login) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getLogin().equals(login)) {
                return users[i];
            }
        }
        return null;
    }

    @Override
    public User getByAddress(Address address) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getAddress().equals(address)) {
                return users[i];
            }
        }
        return null;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String login) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Address address) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) break;
            if (users[i].getAddress().equals(address)) {
                return true;
            }
        }
        return false;
    }


}
