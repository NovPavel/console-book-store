package com.company.storage;

import com.company.entity.Address;
import com.company.entity.Store;

public interface StoreStorage {
    void save(Store store);

    void updateTitle(int id, String title);

    void updateAddress(int id, Address address);

    void delete(int id);

    void deleteTitle(String title);

    Store[] getAll();

    Store getById(int id);

    Store getByTitle(String title);

    boolean contains(int id);

    boolean contains(String title);

    boolean contains(Store store);
}
