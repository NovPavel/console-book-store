package com.company.entity;

import java.util.Objects;

public class Book {

    private int id;
    private String name;
    private Author authorBook;
    private int pages;
    private int price;
    private String description;

    public Book() {
    }

    public Book(String name, Author authorBook, int pages, int price, String description) {
        this.name = name;
        this.authorBook = authorBook;
        this.pages = pages;
        this.price = price;
        this.description = description;
    }

    public Book(int id, String name, Author authorBook, int pages, int price, String description) {
        this.id = id;
        this.name = name;
        this.authorBook = authorBook;
        this.pages = pages;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(Author authorBook) {
        this.authorBook = authorBook;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorBook=" + authorBook +
                ", pages=" + pages +
                ", description='" + description + '\'' +
                '}';
    }
}
