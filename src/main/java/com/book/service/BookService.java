package com.book.service;

import com.book.book.Book;

public interface BookService {

    Book createBook(Book book);

    Book getBookByBookId(String BookId);
}
