package edu.mum.cs.cs425.demo.elibraryrestapi.controller;

import edu.mum.cs.cs425.demo.elibraryrestapi.model.Book;
import edu.mum.cs.cs425.demo.elibraryrestapi.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:81"}, allowedHeaders = "*")
@RequestMapping(value = "/elibrary/api/book", produces = {MediaType.APPLICATION_JSON_VALUE})
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"/list"})
    public List<Book> books() {
        return bookService.getAllBooks();
    }

    @PostMapping(value = "/add")
    public Book addNewBook(@Valid @RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    @GetMapping(value = "/get/{bookId}")
    public Book getBookById(@PathVariable Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping(value = "/update/{bookId}")
    public Book updateBook(@Valid @RequestBody Book editedBook, @PathVariable Integer bookId) {
        return bookService.updateBookById(editedBook, bookId);
    }

    @DeleteMapping(value = "/delete/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBookById(bookId);
    }

}
