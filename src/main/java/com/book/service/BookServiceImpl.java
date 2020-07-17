package com.book.service;

import com.book.entity.BookEntity;
import com.book.repository.BookRepository;
import com.book.sharedDto.BookDto;
import com.book.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Autowired
    Utils utils;

    @Override
    public BookDto createBook(BookDto book) {
        if(bookRepository.findByBookTitle(book.getBookTitle()) != null) throw new RuntimeException("Book already Exist");
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(utils.generateBookId(15));
        BeanUtils.copyProperties(book, bookEntity);
        BookEntity savedBookDetails = bookRepository.save(bookEntity);
        BookDto returnValue = new BookDto();
        BeanUtils.copyProperties(savedBookDetails, returnValue);
        return returnValue;
    }

    @Override
    public BookDto getBookByBookId(String bookId) {
        BookDto returnValue = new BookDto();
        BookEntity bookEntity = bookRepository.findByBookId(bookId);
        BeanUtils.copyProperties(bookEntity, returnValue);
        return returnValue;
    }

}
