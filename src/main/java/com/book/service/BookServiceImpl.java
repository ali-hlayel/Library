package com.book.service;

import com.book.address.Address;
import com.book.entity.BookEntity;
import com.book.exceptions.BookServiceException;
import com.book.exceptions.ErrorMessages;
import com.book.model.BookUpdateQueryModel;
import com.book.repository.BookRepository;
import com.book.book.Book;
import com.book.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Autowired
    Utils utils;

    @Override
    public List<BookEntity> getBooks(int page, int limit) {
        List<BookEntity> returnValue = new ArrayList<>();
        PageRequest pageableRequest = PageRequest.of(page, limit);
        Page<BookEntity> bookPage = bookRepository.findAll(pageableRequest);
        List<BookEntity> books = bookPage.getContent();

        for (BookEntity book: books) {
            BookEntity bookEntity = new BookEntity();
            BeanUtils.copyProperties(book, bookEntity);
            returnValue.add(bookEntity);
        }

        return returnValue;
    }

    @Override
    public Book createBook(Book book) {
        if(bookRepository.findByBookTitle(book.getBookTitle()) != null) throw new RuntimeException("Book already Exist");

        for(Address address: book.getAddresses()) {
            address.setBookDetails(book);
        }

        ModelMapper modelMapper = new ModelMapper();
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(utils.generateBookId(15));
        bookEntity = modelMapper.map(book, BookEntity.class);
        BookEntity savedBookDetails = bookRepository.save(bookEntity);
        Book returnValue = modelMapper.map(savedBookDetails, Book.class);
        return returnValue;
    }

    @Override
    public Book getBookByBookId(String bookId) throws NoResultException{
          Book returnValue = new Book();
        BookEntity bookEntity = bookRepository.findByBookId(bookId);
        BeanUtils.copyProperties(bookEntity, returnValue);
        return returnValue;
    }

    @Override
    public Book updateBook(String bookId, BookUpdateQueryModel book) throws BookServiceException {
        Book returnValue = new Book();
        BookEntity result = bookRepository.findByBookId(bookId);
        if(result == null) throw new BookServiceException(ErrorMessages.BOOK_IS_NOT_FOUND.getErrorMessage());
       result.setBookTitle(book.getBookTitle());
       result.setBookAuthor(book.getBookAuthor());
       result.setSerialNumber(book.getSerialNumber());
       BeanUtils.copyProperties(result, returnValue);
        return returnValue;
    }

    @Override
    public void deleteBook(String bookId) {
        BookEntity result = bookRepository.findByBookId(bookId);
        if(result == null) throw new BookServiceException(ErrorMessages.BOOK_IS_NOT_FOUND.getErrorMessage());
        bookRepository.delete(result);
    }
}
