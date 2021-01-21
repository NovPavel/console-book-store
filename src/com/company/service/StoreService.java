package com.company.service;

import com.company.entity.Address;
import com.company.entity.Store;
import com.company.storage.StoreStorage;
import com.company.storage.inmemory.InMemoryStoreStorage;

import java.util.Arrays;

public class StoreService {

    private StoreStorage storeStorage = new InMemoryStoreStorage();

    public static void main(String[] args) {
        StoreService storeService = new StoreService();


        storeService.save(new Store("First", new Address("kamennaya gorka", 24)));
        storeService.save(new Store("Second", new Address("pushkina", 10)));
        storeService.save(new Store("Third", new Address("lenina", 17)));
        storeService.deleteTitle("Second");

        System.out.println(Arrays.toString(storeService.getAll()));

    }

    public boolean save(Store store){
        if (storeStorage.contains(store.getTitle())) {
            return false;
        }
        storeStorage.save(store);
        return true;
    }

    public void updateTitle(int id, String title){
        if (storeStorage.contains(id)){
            storeStorage.updateTitle(id,title);
        }
    }

    public void updateAddress(int id, Address address){
        if (storeStorage.contains(id)){
            storeStorage.updateAddress(id, address);
        }
    }

    public void delete(int id){
        if (storeStorage.contains(id)){
            storeStorage.delete(id);
        }
    }

    public void deleteTitle(String title){
        if (storeStorage.contains(title)){
            storeStorage.deleteTitle(title);
        }
    }

    public Store[] getAll(){
        return storeStorage.getAll();
    }

    public Store getById(int id){
        if (storeStorage.contains(id)){
            return storeStorage.getById(id);
        }
        return null;
    }

    public Store getByTitle(String title){
        if (storeStorage.contains(title)){
            return storeStorage.getByTitle(title);
        }
        return null;
    }
}
