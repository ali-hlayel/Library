package com.book.Conttroller;

import com.book.exceptions.BookServiceException;
import com.book.exceptions.ErrorMessages;
import com.book.model.BookCreateQueryModel;
import com.book.responseModel.BookResponseModel;
import com.book.service.BookService;
import com.book.book.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(path = "/{bookId}")
    public BookResponseModel getBook(@PathVariable String bookId){
        BookResponseModel bookResponseModel = new BookResponseModel();

        Book book = bookService.getBookByBookId(bookId);
        BeanUtils.copyProperties(book, bookResponseModel);
        return bookResponseModel;
    }

    @PostMapping
    public BookResponseModel createBook(@RequestBody BookCreateQueryModel bookCreateQueryModel) {
        if(bookCreateQueryModel.getBookTitle().isEmpty()) throw new BookServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        BookResponseModel bookResponseModel = new BookResponseModel();
        Book book = new Book();
        BeanUtils.copyProperties(bookCreateQueryModel, book);
        Book createBook = bookService.createBook(book);
        BeanUtils.copyProperties(createBook, bookResponseModel);
        return bookResponseModel;
    }

    @PutMapping
    public String updateBook() {
        return "Update book was called";
    }

    @DeleteMapping
    public String deleteBok() {
        return "Delete book was called";
    }

}
