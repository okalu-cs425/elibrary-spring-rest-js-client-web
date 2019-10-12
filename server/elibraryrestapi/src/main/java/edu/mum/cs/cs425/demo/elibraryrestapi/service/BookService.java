package edu.mum.cs.cs425.demo.elibraryrestapi.service;

import edu.mum.cs.cs425.demo.elibraryrestapi.model.Book;

import java.util.List;

public interface BookService {

    public abstract List<Book> getAllBooks();
    public abstract Book addNewBook(Book newBook);
    public abstract Book getBookById(Integer bookId);
    public abstract Book updateBookById(Book editedBook, Integer bookId);
    public abstract void deleteBookById(Integer bookId);

}
