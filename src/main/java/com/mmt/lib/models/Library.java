package com.mmt.lib.models;

import java.util.HashMap;
import java.util.Map;

public class Library {
    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Book> books) {
        this.books = books;
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    //    account, book
    private Map<Integer, Book> books;
    private Map<Integer, Account> accounts;

    public Library() {
        books = new HashMap<Integer, Book>();
        accounts = new HashMap<Integer, Account>();

    }
}