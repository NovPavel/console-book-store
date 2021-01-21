package com.company.console.action;

import com.company.console.validator.AddressValidator;
import com.company.entity.Address;
import com.company.entity.Author;
import com.company.service.AddressService;

import static com.company.console.util.ConsoleReader.readInt;
import static com.company.console.util.ConsoleReader.readString;
import static com.company.console.util.ConsoleWriter.write;

public class AddressAction {

    private AddressService addressService = new AddressService();


    public void save() {
        write("Please write street");
        String street = readString();

        if (!AddressValidator.validStreet(street)) {
            write("Invalid street");
            return;
        }

        write("Please write home number");
        int homeNumber = readInt();

        if (!AddressValidator.validHome(homeNumber)){
            write("Invalid home");
            return;
        }

        addressService.save(new Address(street,homeNumber));
    }

    private Address getAddress (){
        Address [] addresses = addressService.getAll();
        for (int i = 0; i < addresses.length; i++) {
            write((i+1) + " Street: " + addresses[i].getStreet() + " Home: " + addresses[i].getHome());
        }
        write("Select right address");
        int i = readInt() - 1;
        return addresses[i];
    }


    public void delete() {
        Address address = getAddress();
        addressService.delete(address.getId());
    }


    public void update() {
        Address address = getAddress();
        write("Please write new Street");
        String street = readString();
        write("Please write new home number");
        int homeNumber = readInt();
        addressService.update(address.getId(),street,homeNumber);
    }


    public void getAll() {
        Address [] all = addressService.getAll();
        for (int i = 0; i <all.length ; i++) {
            write((i+1) + " Street: " + all[i].getStreet() + " home: " + all[i].getHome());
        }
    }


    public void getByID() {
        write("Please write id Address");
        int id = readInt();
        if (!AddressValidator.validId(id)){
            write("Address ID is not correct");
            return;
        }
        Address byID = addressService.getByID(id);
        write("Street: " + byID.getStreet() + " home: " + byID.getHome());
    }
}
