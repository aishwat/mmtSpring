package com.mmt.lib.models;

import java.util.Date;
import java.util.LinkedList;

public class Account {
    String name;
    Integer id;
    LinkedList<Book> reservedBooks;
    LinkedList<Book> issuedBooks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LinkedList<Book> getReservedBooks() {
        return reservedBooks;
    }

    public void addToReservedBooks(Book reservedBook) {
        this.reservedBooks.add(reservedBook);
    }

    public void removeFromReservedBooks(Book reservedBook) {
        this.reservedBooks.remove(reservedBook);
    }

    public LinkedList<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void addToIssuedBooks(Book issuedBook) {
        this.issuedBooks.add(issuedBook);
    }

    public void removeFromIssuedBooks(Book issuedBook) {
        this.issuedBooks.remove(issuedBook);
    }


    public Account(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.reservedBooks = new LinkedList<>();
        this.issuedBooks = new LinkedList<>();
    }

}
