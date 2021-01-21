package com.company.storage;

import com.company.entity.Address;

public interface AddressStorage {

    void save(Address address);

    void delete(int id);

    void update(int id, String street, int home);

    Address[] getAll();

    Address getByID(int id);

    boolean contains(int id);

    boolean contains(Address address);

}
