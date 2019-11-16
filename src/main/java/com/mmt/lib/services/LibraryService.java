package com.mmt.lib.services;

import com.mmt.lib.models.Account;
import com.mmt.lib.models.Book;
import com.mmt.lib.models.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;


@Service
public class LibraryService {


    Library library;

    public Library init() {
        library = new Library();
        Account acc1 = new Account("owner_name1", 1);
        Account acc2 = new Account("owner_name2", 2);
        Account acc3 = new Account("owner_name3", 3);
        library.getAccounts().put(acc1.getId(), acc1);
        library.getAccounts().put(acc2.getId(), acc2);
        library.getAccounts().put(acc3.getId(), acc3);
        Book b1 = new Book("book_name1", 1);
        Book b2 = new Book("book_name2", 2);
        Book b3 = new Book("book_name3", 3);
        Book b4 = new Book("book_name4", 4);
        library.getBooks().put(b1.getId(), b1);
        library.getBooks().put(b2.getId(), b2);
        library.getBooks().put(b3.getId(), b3);
        library.getBooks().put(b4.getId(), b4);
        return library;
    }

    public Map<Integer, Book> getBooks() {
        return library.getBooks();
    }

    public Map<Integer, Account> getAccounts() {
        return library.getAccounts();
    }

    public Account createAccount(String name, Integer id) {
        Account acc = new Account(name, id);
        library.getAccounts().put(acc.getId(), acc);
        return acc;
    }

    public Book createBook(String name, Integer id) {
        Book b = new Book(name, id);
        library.getBooks().put(b.getId(), b);
        return b;
    }

    public Account getAccount(Integer id) {
        return library.getAccounts().get(id);
    }

    public Book getBook(Integer id) {
        return library.getBooks().get(id);
    }

    public void reserveBook(Account acc, Book b) {
        b.setReserved(true);
        acc.addToReservedBooks(b);
    }

    public void unReserveBook(Account acc, Book b) {
        b.setReserved(false);
        acc.removeFromReservedBooks(b);
    }

    public void issueBook(Account acc, Book b) {
        b.setIssued(true);
        acc.addToIssuedBooks(b);
        b.setIssuedOn(new Date());
    }

    public void returnBook(Account acc, Book b) {
        b.setIssued(false);
        acc.removeFromIssuedBooks(b);
        b.setIssuedOn(null);
    }

}
