package edu.mum.cs.cs425.demo.elibraryrestapi.service.impl;

import edu.mum.cs.cs425.demo.elibraryrestapi.model.Book;
import edu.mum.cs.cs425.demo.elibraryrestapi.repository.BookRepository;
import edu.mum.cs.cs425.demo.elibraryrestapi.service.BookService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll(Sort.by("title"));
    }

    @Override
    public Book addNewBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public Book updateBookById(Book editedBook, Integer bookId) {
        return bookRepository.findById(bookId)
            .map(bookToUpdate -> {
                bookToUpdate.setDatePublished(editedBook.getDatePublished());
                bookToUpdate.setIsbn(editedBook.getIsbn());
                bookToUpdate.setOverdueFee(editedBook.getOverdueFee());
                bookToUpdate.setPublisher(editedBook.getPublisher());
                bookToUpdate.setTitle(editedBook.getTitle());
                return bookRepository.save(bookToUpdate);
            }).orElseGet(() -> {
                return bookRepository.save(editedBook);
            });
    }

    @Override
    public void deleteBookById(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

}
