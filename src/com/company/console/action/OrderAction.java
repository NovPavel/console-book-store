package com.company.console.action;

import com.company.console.Basket;
import com.company.console.ConsoleApplication;
import com.company.console.validator.AddressValidator;
import com.company.entity.*;
import com.company.service.*;

import java.util.Arrays;

import static com.company.console.util.ConsoleReader.readInt;
import static com.company.console.util.ConsoleReader.readString;
import static com.company.console.util.ConsoleWriter.write;

public class OrderAction {

    AddressService addressService = new AddressService();
    StoreService storeService = new StoreService();
    BookService bookService = new BookService();
    UserService userService = new UserService();
    OrderService orderService = new OrderService();



    private Address selectAddress() {
        Address[] addresses = addressService.getAll();
        for (int i = 0; i < addresses.length; i++) {
            write((i + 1) + " Street: " + addresses[i].getStreet() + " Home: " + addresses[i].getHome());
        }
        write("Select right address");
        int i = readInt() - 1;
        return addresses[i];
    }

    private Store selectStore() {
        Store[] stores = storeService.getAll();
        for (int i = 0; i < stores.length; i++) {
            write((i + 1) + " Title " + stores[i].getTitle());

        }
        write("Choose right title ");
        int i = readInt() - 1;
        return stores[i];
    }

    private Type selectType() {
        write("Please choose the shipping method");
        Type[] t = new Type[]{Type.DELIVERY, Type.PICKUP};
        for (int i = 0; i < t.length; i++) {
            write((i + 1) + " " + t[i].name() + " Shipping method");
        }
        int i = readInt() - 1;
        return t[i];
    }

    private User selectUser() {
        write("Choose necessary user");
        User[] users = userService.getAll();
        for (int i = 0; i < users.length; i++) {
            write((i + 1) + " User name: " + users[i].getName() + " Address: " + users[i].getAddress().getStreet() + users[i].getAddress().getHome());
        }
        int i = readInt() - 1;
        return users[i];
    }

    private Book[] selectBooks() {
        write("Select necessary book");
        Book[] books = bookService.getAll();
        for (int i = 0; i < books.length; i++) {
            write((i + 1) + " Book: " + books[i].getName() + " Author: " + books[i].getAuthorBook() + " Price: " + books[i].getPrice());
        }
        Book[] orderBooks = new Book[books.length];
        int f = 0;
        int i = readInt() - 1;
        books[i] = orderBooks[f];
        f++;
        write("Do you want to add another book");
        return null;
    }

    private Order selectOrder() {
        write("Please choose order which you want to delete");
        Order[] orders = orderService.getAll();
        for (int i = 0; i < orders.length; i++) {
            write((i+1) + " " + orders[i].getUser() + " Street: " + orders[i].getAddress().getHome() + " Home: " + orders[i].getBooks());
        }
        int i = readInt() - 1;
        return orders[i];
    }

    public void save() {
        Type typeSelected = selectType();
        User user = ConsoleApplication.session.getUser();
        Basket basket = ConsoleApplication.session.getBasket();
        switch (typeSelected) {
            case PICKUP:
                Store storeSelected = selectStore();
                orderService.save(new Order(storeSelected, user, basket.getAllBooks()));
                break;
            case DELIVERY:
                Address address = ConsoleApplication.session.getUser().getAddress();
                orderService.save(new Order(address, user, basket.getAllBooks()));
                break;
        }
        basket.clearBasket();
    }

    public void updateAddress() {
        write("Choose order which address you want to change");
        Order[] allByType = orderService.getAllByType(Type.DELIVERY);
        for (int i = 0; i < allByType.length; i++) {
            write((i + 1) + " " + allByType[i].getUser() + allByType[i].getAddress());
        }
        int i = readInt() - 1;
        Order order = allByType[i];
        write("Please write new street");
        String newStreet = readString();
        if (!AddressValidator.validStreet(newStreet)) {
            write("Street is not correct");
            return;
        }
        write("Write new home number");
        int newHome = readInt();
        if (!AddressValidator.validHome(newHome)) {
            write("Home is not correct");
            return;
        }
        Address address = new Address(newStreet, newHome);
        orderService.updateAddress(order.getId(), address);
        addressService.save(address);
    }

    public void updateStore() {
        write("Select order where you want to change address for pickup");
        Order[] allPickup = orderService.getAllByType(Type.PICKUP);
        for (int i = 0; i < allPickup.length; i++) {
            write((i + 1) + " " + allPickup[i].getUser() + allPickup[i].getAddress());
        }
        int i = readInt() - 1;
        Order order = allPickup[i];
        Store store = selectStore();
        orderService.updateStore(order.getId(), store);
    }

    public void updateStatus() {
        Order[] allOrders = orderService.getAll();
        for (int i = 0; i < allOrders.length; i++) {
            write((i + 1) + " " + allOrders[i].getUser() + allOrders[i].getAddress() + allOrders[i].getStatus());
        }
        int i = readInt() - 1;
        Order allOrder = allOrders[i];
        write("Choose new  status");
        write("1 - Active");
        write("2 - Close");
        switch (readInt()) {
            case 1:
                orderService.updateStatus(allOrder.getId(), Status.ACTIVE);
                break;
            case 2:
                orderService.updateStatus(allOrder.getId(), Status.CLOSE);
                break;
        }
    }

    public void updateType() {
        Order[] allOrders = orderService.getAll();
        for (int i = 0; i < allOrders.length; i++) {
            write((i + 1) + " " + allOrders[i].getUser() + allOrders[i].getAddress() + allOrders[i].getType());
        }
        int i = readInt() - 1;
        Order order = allOrders[i];
        write("Choose new type of delivery");
        write("1 - Delivery");
        write("2 - Pickup");
        switch (readInt()) {
            case 1:
                orderService.updateType(order.getId(), Type.DELIVERY);
                break;
            case 2:
                orderService.updateType(order.getId(), Type.PICKUP);
                break;
        }
    }

    public void updateBooks() {
        write("Choose right order which you want update");

        Order[] orders = orderService.getAll();
        for (int i = 0; i < orders.length; i++) {
            write((i + 1) + " " + orders[i].getUser());
        }
        int i = readInt() - 1;
        Order order = orders[i];
        Book[] books = order.getBooks();
        write("What you want to do");
        write("1 - Delete book");
        write("2 - Add book");

        switch (readInt()) {
            case 1:
                write("What book you want to delete");
                for (int j = 0; j < books.length; j++) {
                    write((i + 1) + " " + books[i].getName() + books[i].getAuthorBook());
                }
                int y = readInt() - 1;
                for (int j = y; j < books.length - 1; j++) {
                    books[j] = books[j + 1];
                }
                break;
            case 2:
                write("Choose book which you want to add");
                Book[] all = bookService.getAll();
                for (int j = 0; j < all.length; j++) {
                    write((i + 1) + " " + all[i].getName() + all[i].getAuthorBook());
                }
                int z = readInt() - 1;
                Book[] books1 = Arrays.copyOf(books, books.length + 1);
                books1[books1.length - 1] = all[z];
                order.setBooks(books1);
                break;
        }

    }

    public void deleteById() {
        Order deleteById = selectOrder();
        orderService.delete(deleteById.getId());
    }


    public void deleteByOrder() {
        Order  deleteByOrder = selectOrder();
        orderService.delete(deleteByOrder);
    }

    public void getAll() {
        write("List of all orders: ");
        orderService.getAll();
    }

    public void getAllByUser() {
        write("Please select the User whose orders you want to see");
        User getByUser = selectUser();
        orderService.getAllByUser(getByUser);
    }

    public void getAllByStore() {
        write("Please select the Store, whose orders you want to see");
        Store getAllByStore = selectStore();
        orderService.getAllByStore(getAllByStore);
    }


    public void getAllByAddress() {
        write("Please select the Address, whose orders you want to see");
        Address getAllByAddress = selectAddress();
        orderService.getAllByAddress(getAllByAddress);
    }


    public void getAllByType() {
        Type getAllByType = selectType();
        orderService.getAllByType(getAllByType);
    }

    public void getAllByStatus() {
        write("Select the status whose orders you want to see");
        write("1 - ACTIVE");
        write("2 - CLOSE");
        switch (readInt()){
            case 1:
                orderService.getAllByStatus(Status.ACTIVE);
                break;
            case 2:
                orderService.getAllByStatus(Status.CLOSE);
                break;
        }
    }
}
