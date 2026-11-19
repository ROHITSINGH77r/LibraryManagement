package com.example.library;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    // ArrayList to store book records in-memory
    private List<Book> bookList = new ArrayList<>();

    // Retrieve all books
    public List<Book> getAllBooks() {
        return bookList;
    }

    // Retrieve a book by its ID using a simple loop
    public Book getBookById(Integer id) {
        for (Book book : bookList) {
            if (book.getId() != null && book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    // Add a book to the collection, preventing duplicate book IDs
    public boolean addBook(Book book) {
        if (book.getId() == null || getBookById(book.getId()) != null) {
            return false;
        }
        bookList.add(book);
        return true;
    }

    // Update an existing book's details without changing its ID
    public Book updateBook(Integer id, Book updatedBook) {
        Book existingBook = getBookById(id);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setCategory(updatedBook.getCategory());
            existingBook.setAvailableCopies(updatedBook.getAvailableCopies());
            return existingBook;
        }
        return null;
    }

    // Delete a book from the collection by its ID
    public boolean deleteBook(Integer id) {
        Book existingBook = getBookById(id);
        if (existingBook != null) {
            bookList.remove(existingBook);
            return true;
        }
        return false;
    }
}
