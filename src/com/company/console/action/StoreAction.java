package com.company.console.action;

import com.company.console.validator.StoreValidator;
import com.company.entity.Address;
import com.company.entity.Book;
import com.company.entity.Store;
import com.company.service.AddressService;
import com.company.service.StoreService;

import static com.company.console.util.ConsoleReader.*;
import static com.company.console.util.ConsoleWriter.*;

public class StoreAction {

    private StoreService storeService = new StoreService();
    private AddressService addressService = new AddressService();

    public void save(){
        write("Please give a name to the store");
        String nameTitle = readString();
        if (!StoreValidator.validTitle(nameTitle)){
            write("Title is not correct");
            return;
        }
        Address address = getAddress();
        storeService.save(new Store(nameTitle, address));
    }

    private Address getAddress() {
        Address[] all = addressService.getAll();
        for (int i = 0; i < all.length; i++) {
            write((i + 1) + " Address: " + all[i].getStreet() + ", home: " + all[i].getHome());
        }
        write("Choose address");
        int i = readInt() - 1;
        return all[i];
    }

    private Store getStores(){
        Store [] stores = storeService.getAll();
        for (int i = 0; i < stores.length; i++) {
            write((i+1) + "Title " + stores[i].getTitle());

        }
         write("Choose right title ");
         int i = readInt() - 1;
         return stores[i];
    }

    public void updateTitle(){
        Store stores = getStores();
        write("Please indicate new store Title which would you like to change");
        String newTitle = readString();
        if (!StoreValidator.validTitle(newTitle)){
            write("Title is not correct");
            return;
        }
        storeService.updateTitle(stores.getId(), newTitle);
    }

    public void updateAddress(){
        Store store = getStores();
        storeService.updateAddress(store.getId(), getAddress());
    }

    public void deleteById(){
        Store stores = getStores();
        storeService.delete(stores.getId());
    }

    public void deleteTitle(){
        write("Please write Store Title which would you like to delete");
        String title = readString();
        if (!StoreValidator.validTitle(title))
        storeService.deleteTitle(title);
    }

    public void getAll(){
        Store [] stores = storeService.getAll();
        for (int i = 0; i <stores.length ; i++) {
            write("Store Title: " + stores[i].getTitle() + " Address: " + stores[i].getAddress());
        }
    }

    public void getById(){
        write("Please write Store id which would you like to get see");
        int id = readInt();
        if (!StoreValidator.validId(id)){
            write("Store id is not correct");
            return;
        }
        write("Store Title: " + storeService.getById(id).getTitle() + " Address: " + storeService.getById(id).getAddress().getStreet());
    }

    public void getByTitle(){
        write("Please write Store title which would you like to get see");
        String title = readString();
        if (!StoreValidator.validTitle(title)){
            write("Title is not correct");
            return;
        }
        write("Store Title: " + storeService.getByTitle(title).getTitle() + " Address: " + storeService.getByTitle(title).getAddress().getStreet());
    }
}
