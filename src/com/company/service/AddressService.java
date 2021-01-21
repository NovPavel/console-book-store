package com.company.service;

import com.company.entity.Address;
import com.company.storage.AddressStorage;
import com.company.storage.inmemory.InMemoryAddressStorage;

import java.util.Arrays;

public class AddressService {

    private AddressStorage addressStorage = new InMemoryAddressStorage();

    public boolean save(Address address) {
        if (addressStorage.contains(address)) {
            return false;
        }
        addressStorage.save(address);
        return true;
    }


    public void delete(int id) {
        if (addressStorage.contains(id)){
            addressStorage.delete(id);
        }
    }


    public void update(int id, String street, int home) {
        if (addressStorage.contains(id)){
            addressStorage.update(id,street,home);
        }
    }


    public Address[] getAll() {
        return addressStorage.getAll();
    }


    public Address getByID(int id) {
        if (addressStorage.contains(id)) {
            return addressStorage.getByID(id);
        }
        return null;
    }
}
