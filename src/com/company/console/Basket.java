package com.company.console;

import com.company.entity.Book;

import java.util.Arrays;

public class Basket {
    private static Book[] books = new Book[10];
    private int size = 0;

    public void add(Book book){
        books[size++] = book;
    }

    public void remove(Book book){
        for (int i = 0; i < books.length ; i++) {
            if (books[i].equals(book)){
                for (int j = 0 ; j < books.length -1; j++) {
                    books[i] = books[j+1];
                }
                break;
            }
        }
    }

    public Book[] getAllBooks(){
        return Arrays.copyOf(books, size);
    }

    public int size(){
        return size;

    }

    public void clearBasket(){
        Arrays.fill(books, null);
    }

    public boolean isEmpty(){
      return size == 0;
    }

    public boolean isFull(){
        return size == books.length;
    }
}
