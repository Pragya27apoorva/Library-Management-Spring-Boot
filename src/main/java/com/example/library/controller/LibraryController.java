package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.Loan;
import com.example.library.model.Member;
import com.example.library.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return libraryService.getAllBooks();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @GetMapping("/members")
    public List<Member> getMembers() {
        return libraryService.getAllMembers();
    }

    @PostMapping("/members")
    public Member addMember(@RequestBody Member member) {
        return libraryService.addMember(member);
    }

    @PostMapping("/borrow")
    public Loan borrowBook(@RequestParam Long bookId,
                           @RequestParam Long memberId) {
        return libraryService.borrowBook(bookId, memberId);
    }

    @PostMapping("/return")
    public Loan returnBook(@RequestParam Long loanId) {
        return libraryService.returnBook(loanId);
    }
}
