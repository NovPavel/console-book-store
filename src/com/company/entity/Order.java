package com.company.entity;

import java.util.Arrays;
import java.util.Objects;

public class Order {
    private int id;
    private Address address;
    private Store store;
    private Type type;
    private Status status = Status.ACTIVE;
    private User user;
    private Book[] books;

    public Order(Store store, User user, Book[] books) {
        this.store = store;
        this.user = user;
        this.books = books;
        this.type = Type.PICKUP;
    }

    public Order(Address address, User user, Book[] books) {
        this.address = address;
        this.user = user;
        this.books = books;
        this.type = Type.DELIVERY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return status == order.status &&
                Objects.equals(user, order.user) &&
                Arrays.equals(books, order.books);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(status, user);
        result = 31 * result + Arrays.hashCode(books);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address=" + address +
                ", store=" + store +
                ", type=" + type +
                ", status=" + status +
                ", user=" + user +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
