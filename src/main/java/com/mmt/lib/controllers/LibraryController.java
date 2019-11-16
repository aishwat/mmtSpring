package com.mmt.lib.controllers;

import com.mmt.lib.models.Account;
import com.mmt.lib.models.Book;
import com.mmt.lib.models.Library;
import com.mmt.lib.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LibraryController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    LibraryService libraryService;

    @RequestMapping("/init")
    public Library init() {
        return libraryService.init();
    }

    @RequestMapping("/createAccount")
    public Account createAccount(@RequestParam(value = "name") String name) {
        return libraryService.createAccount(name, (int) counter.incrementAndGet());
    }

    @RequestMapping("/reserveBook")
    public Account reserveBook(@RequestParam(value = "bookid") Integer bookid, @RequestParam(value = "accid") Integer accid) {
        Book b = libraryService.getBook(bookid);
        Account acc = libraryService.getAccount(accid);
        libraryService.reserveBook(acc, b);
        return acc;
    }

    @RequestMapping("/unreserveBook")
    public Account unreserveBook(@RequestParam(value = "bookid") Integer bookid, @RequestParam(value = "accid") Integer accid) {
        Book b = libraryService.getBook(bookid);
        Account acc = libraryService.getAccount(accid);
        libraryService.unReserveBook(acc, b);
        return acc;
    }

    @RequestMapping("/issueBook")
    public Account issueBook(@RequestParam(value = "bookid") Integer bookid, @RequestParam(value = "accid") Integer accid) {
        Book b = libraryService.getBook(bookid);
        Account acc = libraryService.getAccount(accid);
        libraryService.issueBook(acc, b);
        return acc;
    }

    @RequestMapping("/returnBook")
    public Account returnBook(@RequestParam(value = "bookid") Integer bookid, @RequestParam(value = "accid") Integer accid) {
        Book b = libraryService.getBook(bookid);
        Account acc = libraryService.getAccount(accid);
        libraryService.returnBook(acc, b);
        return acc;
    }

    @RequestMapping("/getAvailableBooks")
    public LinkedList<Book> getAvailableBooks() {
        LinkedList<Book> availableBooks = new LinkedList<>();
        for (Book book : libraryService.getBooks().values()) {
            if (!book.getIssued() && !book.getReserved())
                availableBooks.add(book);
        }
        return availableBooks;
    }


}
