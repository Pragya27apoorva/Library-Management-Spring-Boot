package com.example.library;

import com.example.library.model.Book;
import com.example.library.model.Member;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.MemberRepository;
import com.example.library.service.LibraryService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryServiceTest {

    @Test
    void shouldNotAllowBorrowingUnavailableBook() {
        BookRepository bookRepository = mock(BookRepository.class);
        MemberRepository memberRepository = mock(MemberRepository.class);
        LoanRepository loanRepository = mock(LoanRepository.class);

        LibraryService service =
                new LibraryService(bookRepository, memberRepository, loanRepository);

        Book book = new Book("The Alchemist", "Paulo Coelho");
        book.setAvailable(false);

        Member member = new Member("Pragya", "pragya@example.com");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.borrowBook(1L, 1L)
        );

        assertEquals("Book is already borrowed", exception.getMessage());
    }
}
