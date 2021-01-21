package com.company.console.action;

import com.company.console.ConsoleApplication;
import com.company.console.Session;
import com.company.console.validator.BookValidator;
import com.company.entity.Address;
import com.company.entity.Author;
import com.company.entity.Book;
import com.company.service.AuthorService;
import com.company.service.BookService;

import static com.company.console.util.ConsoleReader.*;
import static com.company.console.util.ConsoleWriter.*;

public class BookAction {

    private BookService bookService = new BookService();
    private AuthorService authorService = new AuthorService();

    public void save(){

        write("Please write Book name");
        String name = readString();
        if (!BookValidator.validName(name)){
            write("Name is not correct");
        }
        write("Please write quantity of all pages");
        int pages = readInt();
        if (!BookValidator.validPages(pages)){
            write("The number of pages is incorrect");
        }
        write("Please indicate book price");
        int price = readInt();
        if (!BookValidator.validPrice(price)){
            write("Price is not correct");
        }
        write("Please write book description");
        String description = readString();
        if (!BookValidator.validDescription(description)){
            write("Description has small size, min 4 symbols");
        }
        write("Please select Author");
        Author[] all = authorService.getAll();
        for (int i = 0; i < all.length; i++) {
            write((i + 1) + " Author: " + all[i].getName());
        }
        int i = readInt() - 1;
        Author author = all[i];
        bookService.save(new Book(name,author,pages, price, description ));
    }

    public void updateName() {
        write("Please write Book id");
        int id = readInt();
        write("Please write new Book name");
        String newName = readString();
        if (!BookValidator.validName(newName)){
            write("New name is not correct");
        }
        bookService.updateName(id, newName);
    }


    public void updateDescription() {
        write("Please write Book id");
        int id = readInt();
        write("Please write new Book description");
        String newDescription = readString();
        if (!BookValidator.validDescription(newDescription)){
            write("Description has small size, min 4 symbols");
        }
        bookService.updateName(id, newDescription);
    }


    public void deleteById() {
        write("Please write Book id what you want to delete");
        int id = readInt();
        if (BookValidator.validId(id)){
            bookService.delete(id);
        }
        else {
            write("ID is not correct or not exist");
        }

    }


    public void deleteByName() {
        write("Please write Book Name what you want to delete");
        String name = readString();
        if (BookValidator.validName(name)){
        bookService.delete(name);
        }
        else {
            write("Name is not correct");
        }
    }

    public void getById() {
        write("Please write Book id");
        int id = readInt();
        if (BookValidator.validId(id)) {
            Book byId = bookService.getById(id);
            write("Book Name: " + byId.getName() + "Author: " + byId.getAuthorBook().getName() + " Description: " + byId.getDescription() + " Pages: " + byId.getPages() + " Price: " + byId.getPrice());
        }
        else{
            write("ID is not correct or not exist");
        }
    }

    public void getByName(){
        write("Please write Book Name");
        String name = readString();
        if(BookValidator.validName(name)) {
            Book byId = bookService.getByName(name);
            write("Book Name: " + byId.getName() + "Author: " + byId.getAuthorBook().getName() + " Description: " + byId.getDescription() + " Pages: " + byId.getPages() + " Price: " + byId.getPrice());
            write("Choose next correct operation");
            write(" 0: Add book in basket");
            write(" 1: Continue");
            switch (readInt()) {
                case 0:
                    ConsoleApplication.session.getBasket().add(byId);
                    break;
                case 1:
            }
        }
        else {
            write("Name is not correct or not exist");
        }
    }

    public void getAll() {
        Book[] all = bookService.getAll();
        for (int i = 0; i <all.length ; i++) {
            write((i + 1) + " Book Name: " + all[i].getName() + " Author: " + all[i].getAuthorBook().getName() + " Description: " + all[i].getDescription() + " Pages: " + all[i].getPages() + " Price: " + all[i].getPrice());

        }
        write("Choose book");
        int i = readInt() -1;
        Book book = all[i];
        write("Select next operation");
        write( " 0 - Continue");
        write( " 1 - Add book in basket");
        switch (readInt()){
            case 0:
                break;
            case 1:
                ConsoleApplication.session.getBasket().add(book);
                break;
        }
    }
}
