package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    @Test
    void addsBookAndRejectsDuplicateIsbn() {
        Library library = new Library();
        Book book = new Book("978-0132350884", "Clean Code", "Robert C. Martin");

        library.addBook(book);

        assertEquals(book, library.findBookByIsbn("978-0132350884").orElseThrow());
        assertThrows(IllegalArgumentException.class, () -> library.addBook(book));
    }

    @Test
    void searchesForBookByIsbnAndReturnsEmptyWhenMissing() {
        Library library = new Library();
        Book book = new Book("978-0132350884", "Clean Code", "Robert C. Martin");
        library.addBook(book);

        assertEquals(book, library.findBookByIsbn("978-0132350884").orElseThrow());
        assertTrue(library.findBookByIsbn("978-0000000000").isEmpty());
        assertThrows(IllegalArgumentException.class, () -> library.findBookByIsbn(" "));
    }

    @Test
    void borrowsAvailableBookAndRejectsUnavailableOrUnknownBooks() {
        Library library = new Library();
        Book book = new Book("978-0132350884", "Clean Code", "Robert C. Martin");
        library.addBook(book);

        assertEquals(book, library.borrowBook("978-0132350884"));
        assertTrue(library.isBorrowed("978-0132350884"));
        assertThrows(IllegalStateException.class, () -> library.borrowBook("978-0132350884"));
        assertThrows(IllegalArgumentException.class, () -> library.borrowBook("978-0000000000"));

        library.returnBook("978-0132350884");
        assertFalse(library.isBorrowed("978-0132350884"));
    }

    @Test
    void bookRequiresNonBlankDetails() {
        assertThrows(IllegalArgumentException.class, () -> new Book("", "Title", "Author"));
        assertThrows(IllegalArgumentException.class, () -> new Book("123", " ", "Author"));
        assertThrows(IllegalArgumentException.class, () -> new Book("123", "Title", null));
    }
}
