package com.company.storage.inmemory;

import com.company.entity.Address;
import com.company.storage.AddressStorage;

import java.util.Arrays;

public class InMemoryAddressStorage implements AddressStorage {

    private int incId = 1;
    private Address[] addresses = new Address[10];

    {
        save(new Address("lenina", 125));
        save(new Address("Kazinca", 13));
        save(new Address("Kamennogorskaya", 24));
        save(new Address("Moskovskaya", 112));
        save(new Address("Brilya", 11));
    }


    @Override
    public void save(Address address) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) {
                address.setId(incId);
                addresses[i] = address;
                incId++;
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getId() == id) {
                for (int j = i; j < addresses.length - 1; j++) {
                    addresses[j] = addresses[j + 1];
                }
                break;
            }
        }
    }

    @Override
    public void update(int id, String street, int home) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].getId() == id) {
                addresses[i].setStreet(street);
                addresses[i].setHome(home);
                break;
            }
        }
    }

    @Override
    public Address[] getAll() {
        int count = 0;
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] != null){
                count++;
            }
        }
        return Arrays.copyOf(addresses, count);
    }

    @Override
    public Address getByID(int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getId()==id){
                return addresses [i];
            }
        }
        return null;
    }

    @Override
    public boolean contains(int id) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Address address) {
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == null) break;
            if (addresses[i].equals(address)){
                return true;
            }
        }
        return false;
    }
}
