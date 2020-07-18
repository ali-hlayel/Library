package com.book.service;

import com.book.book.Book;
import com.book.entity.BookEntity;
import com.book.model.BookCreateQueryModel;
import com.book.model.BookUpdateQueryModel;

import java.util.List;

public interface BookService {

    Book createBook(BookCreateQueryModel book);

    Book getBookByBookId(String BookId);

    Book updateBook(String bookId, BookUpdateQueryModel book);

    void deleteBook(String bookId);

    List<BookEntity>  getBooks(int page, int limit);

}
