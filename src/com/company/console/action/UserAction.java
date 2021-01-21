package com.company.console.action;

import com.company.console.ConsoleApplication;
import com.company.console.Session;
import com.company.console.validator.UserValidator;
import com.company.entity.*;
import com.company.service.AddressService;
import com.company.service.UserService;

import static com.company.console.util.ConsoleReader.*;
import static com.company.console.util.ConsoleWriter.*;

public class UserAction {

    private UserService userService = new UserService();
    private AddressService addressService = new AddressService();

    public void save() {
        User user = getUser(Role.ADMIN);
        userService.save(user);
    }

    public void logout(){
        ConsoleApplication.session = null;
    }

    private User getUser(Role role) {
        write("Please write User name ");
        String name = readString();
        write("Please create user login");
        String login = readString();
        write("Please create new password");
        String password = readString();
        write("Please indicate User age");
        int age = readInt();
        write("Please write street");
        String street = readString();
        write("Please write home number");
        int homeNumber = readInt();
        Address address = new Address(street,homeNumber);
        addressService.save(address);
        return new User(name, login, password, address, age, role);
    }

    public void registration(){
        User user = getUser(Role.USER);
        userService.save(user);
    }

    public void authorization(){
        write("Please insert login");
        String login = readString();
        if (!UserValidator.loginValid(login)){
            write("Invalid login");
            return;
        }
        write("Please insert password");
        String password = readString();
        if (!UserValidator.passwordValid(password)){
            write("Invalid password");
            return;
        }

        User byLogin = userService.getByLogin(login);
        if (byLogin != null){
            if (byLogin.getPassword().equals(password)) {
                ConsoleApplication.session = new Session(byLogin);
            } else {
                write("Password is wrong");
            }
        } else {
            write("User not found");
        }
    }


    public void updateName() {
        write("Please write User id");
        int id = readInt();
        write("Please indicate new Name");
        String newName = readString();
        userService.updateName(id,newName);
    }

    public void updateNameForUser(){
        write("Please indicate new Name");
        String newName = readString();
        userService.updateName(ConsoleApplication.session.getUser().getId(),newName);
    }

    public void updatePasswordForUser(){
        write("Please create new password");
        String newPassword = readString();
        userService.updatePassword(ConsoleApplication.session.getUser().getId(),newPassword);
    }

    public void updatePassword() {
        write("Please write User id");
        int id = readInt();
        write("Please create new password");
        String newPassword = readString();
        userService.updatePassword(id,newPassword);
    }


    public void updateAddress() {
        write("Please write User id");
        int id = readInt();
        write("Please indicate new Street");
        String newStreet = readString();
        write("Please indicate new home number");
        int newHomeNumb = readInt();
        userService.updateAddress(id,new Address(newStreet,newHomeNumb));
    }


    public void updateAge() {
        write("Please write User id");
        int id = readInt();
        write("Please write correct age");
        int newAge = readInt();
        userService.updateAge(id,newAge);
    }


    public void deleteById() {
        write("Please write User id which would you like to delete");
        int id = readInt();
        userService.delete(id);
    }


    public void deleteByLogin() {
        write("Please write User login which would you like to delete");
        String login = readString();
        userService.delete(login);

    }


    public void getAll() {
        User [] users = userService.getAll();
        for (int i = 0; i <users.length ; i++) {
            write("Name: " +users[i].getName() + " Login: " + users[i].getLogin() + " Age: " + users[i].getAge() + " Street: " + users[i].getAddress().getStreet() + " Home: " + users[i].getAddress().getHome());
        }
    }


    public void getAllByName() {
        write("Please write User name to check");
        String byName = readString();
        User[] users = userService.getAll();
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName().equals(byName)) {
                write("Name: " + users[i].getName() + " Login: " + users[i].getLogin() + " Age: " + users[i].getAge() + " Street: " + users[i].getAddress().getStreet() + " Home: " + users[i].getAddress().getHome());
            }
        }
    }


    public void getById() {
        write("Please write User id");
        int id = readInt();
        User byIdUser = userService.getById(id);
        write("Name: " +byIdUser.getName() + " Login: " + byIdUser.getLogin() + " Age: " + byIdUser.getAge() + " Street: " + byIdUser.getAddress().getStreet() + " Home: " + byIdUser.getAddress().getHome());

    }


    public void getByLogin() {
        write("Please write User Login");
       String login = readString();
        User byLoginUser = userService.getByLogin(login);
        write("Name: " +byLoginUser.getName() + " Login: " + byLoginUser.getLogin() + " Age: " + byLoginUser.getAge() + " Street: " + byLoginUser.getAddress().getStreet() + " Home: " + byLoginUser.getAddress().getHome());

    }




    public void getByAddress() {

        write("Please select Users Address to get information about him");
        Address[] addresses = addressService.getAll();
        for (int i = 0; i < addresses.length; i++) {
            write((i + 1) + " Street: " + addresses[i].getStreet() + " Home number: " + addresses[i].getHome());
        }
        int i = readInt() - 1;
        Address address = addresses[i];

        User userByAddress = userService.getByAddress(address);
        write("Name: " +userByAddress.getName() + " Login: " + userByAddress.getLogin() + " Age: " + userByAddress.getAge() + " Street: " + userByAddress.getAddress().getStreet() + " Home: " + userByAddress.getAddress().getHome());
    }
}