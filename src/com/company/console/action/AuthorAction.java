package com.company.console.action;

import com.company.console.validator.AuthorValidator;
import com.company.entity.Author;
import com.company.service.AuthorService;

import static com.company.console.util.ConsoleReader.readInt;
import static com.company.console.util.ConsoleReader.readString;
import static com.company.console.util.ConsoleWriter.write;

public class AuthorAction {

    private final AuthorService authorService = new AuthorService();

    public void save() {
        write("Enter author name");
        String authorName = readString();
        if (!AuthorValidator.validName(authorName)) {
            write("Name is not correct");
            return;
        }
        write("Enter author description");
        String authorDescription = readString();
        if (!AuthorValidator.validDescription(authorDescription)) {
            write("Description is not correct");
            return;
        }
        authorService.save(new Author(authorName, authorDescription));
    }

    private Author selectAuthor() {
        Author[] authors = authorService.getAll();
        for (int i = 0; i < authors.length; i++) {
            write((i + 1) + " Author: " + authors[i].getName());
        }
        write("Choose right author");
        int i = readInt() - 1;
        return authors[i];
    }

    public void updateName() {
        Author author = selectAuthor();
        write("Enter new User Name");
        String newAuthorName = readString();
        if (AuthorValidator.validName(newAuthorName)) {
            authorService.updateName(author.getId(), newAuthorName);
        } else {
            write("");
        }
    }

    public void updateDescription() {
        Author author = selectAuthor();
        write("Enter new User Description");
        String newAuthorDescription = readString();
        if (AuthorValidator.validDescription(newAuthorDescription)) {
            authorService.updateDescription(author.getId(), newAuthorDescription);
        } else {
            write("");
        }
    }


    public void delete() {
        Author author = selectAuthor();
        authorService.delete(author.getId());
    }

    public void deleteByName() {
        write("Please enter User name");
        String authorName = readString();
        if (AuthorValidator.validName(authorName)) {
            authorService.delete(authorName);
        } else {
            write("");
        }
    }

    public void getById() {
        Author author = selectAuthor();
        write("Author: " + author.getName() + " " + author.getDescription());
    }

    public void getByName() {
        write("Please enter User Name");
        String authorName = readString();
        if (AuthorValidator.validName(authorName)) {
            Author byName = authorService.getByName(authorName);
            write("Author: " + byName.getName() + " " + byName.getDescription());
        } else {
            write("");
        }
    }

    public void getAll() {
        Author[] all = authorService.getAll();
        for (int i = 0; i < all.length; i++) {
            write((i + 1) + " Author: " + all[i].getName() + " " + all[i].getDescription());
        }
    }
}
