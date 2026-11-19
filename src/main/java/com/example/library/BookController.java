package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // POST /books - Add a new book (Question B)
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        if (book.getId() == null) {
            return new ResponseEntity<>("Book ID must not be null.", HttpStatus.BAD_REQUEST);
        }
        boolean isAdded = bookService.addBook(book);
        if (isAdded) {
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Book with ID " + book.getId() + " already exists.", HttpStatus.CONFLICT);
        }
    }

    // GET /books - Retrieve all books (Question C)
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // GET /books/{id} - Retrieve a book by its ID (Question C)
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    // PUT /books/{id} - Update an existing book's details (Question D)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        if (updatedBook != null) {
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /books/{id} - Delete a book by its ID (Question E)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
        boolean isDeleted = bookService.deleteBook(id);
        if (isDeleted) {
            return new ResponseEntity<>("Book deleted successfully with ID: " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
