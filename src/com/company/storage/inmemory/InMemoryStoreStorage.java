package com.company.storage.inmemory;

import com.company.entity.Address;
import com.company.entity.Store;
import com.company.storage.StoreStorage;

import java.util.Arrays;

public class InMemoryStoreStorage implements StoreStorage {

    private Store[] stores = new Store[10];
    private int incId = 1;

    @Override
    public void save(Store store) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) {
                stores[i] = store;
                stores[i].setId(incId);
                incId++;
                break;
            }
        }
    }

    @Override
    public void updateTitle(int id, String title) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) break;
            if (stores[i].getId() == id) {
                stores[i].setTitle(title);
                break;
            }
        }
    }

    @Override
    public void updateAddress(int id, Address address) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) break;
            if (stores[i].getId() == id) {
                stores[i].setAddress(address);
                break;
            }
        }

    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) break;
            if (stores[i].getId() == id) {
                for (int j = i; j < stores.length - 1; j++) {
                    stores[j] = stores[j + 1];
                }
                break;
            }
        }
    }

    @Override
    public void deleteTitle(String title) {

        for (int i = 0; i < stores.length; i++) {
            if (stores[i] == null) break;
            if (stores[i].getTitle().equals(title)){
                for (int j = i; j < stores.length - 1; j++) {
                    stores [j] = stores [j+1];
                }
                break;
            }
        }

    }

    @Override
    public Store[] getAll() {
        int count = 0;
        for (int i = 0; i < stores.length ; i++) {
            if (stores[i] != null){
                count++;
            }
        }
        return Arrays.copyOf(stores, count);
    }

    @Override
    public Store getById(int id) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i].getId() == id){
                return stores [i];
            }
        }
        return null;
    }

    @Override
    public Store getByTitle(String title) {
        for (int i = 0; i < stores.length ; i++) {
            if (stores[i].getTitle().equals(title)){
                return stores [i];
            }
        }
        return null;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < stores.length ; i++) {
            if (stores[i] == null) break;
            if (stores[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String title) {
        for (int i = 0; i < stores.length ; i++) {
            if (stores[i] == null) break;
            if (stores[i].getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Store store) {
        for (int i = 0; i < stores.length; i++) {
            if (stores[i].equals(store)){
                return true;
            }
        }
        return false;
    }
}
