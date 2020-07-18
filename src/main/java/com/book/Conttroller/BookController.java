package com.book.Conttroller;

import com.book.entity.BookEntity;
import com.book.exceptions.BookServiceException;
import com.book.exceptions.ErrorMessages;
import com.book.model.BookCreateQueryModel;
import com.book.model.BookUpdateQueryModel;
import com.book.responseModel.BookResponseModel;
import com.book.responseModel.OperationStatusModel;
import com.book.service.BookService;
import com.book.book.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<BookResponseModel> getBooks(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<BookResponseModel> returnValue = new ArrayList<>();
        List<BookEntity> books = bookService.getBooks(page, limit);
        for (BookEntity book : books) {
            BookResponseModel bookResponseModel = new BookResponseModel();
            BeanUtils.copyProperties(book, bookResponseModel);
            returnValue.add(bookResponseModel);
        }
        return returnValue;
    }

    @GetMapping(path = "/{bookId}")
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseModel getBook(@PathVariable String bookId) {
        BookResponseModel bookResponseModel = new BookResponseModel();

        Book book = bookService.getBookByBookId(bookId);
        BeanUtils.copyProperties(book, bookResponseModel);
        return bookResponseModel;
    }

    @PostMapping
    public BookResponseModel createBook(@RequestBody BookCreateQueryModel bookCreateQueryModel) {
        if (bookCreateQueryModel.getBookTitle().isEmpty())
            throw new BookServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        BookResponseModel bookResponseModel = new BookResponseModel();
        Book createBook = bookService.createBook(bookCreateQueryModel);
        BeanUtils.copyProperties(createBook, bookResponseModel);
        return bookResponseModel;
    }

    @PutMapping(path = "/{bookId}")
    public BookResponseModel updateBook(@PathVariable String bookId, @RequestBody BookUpdateQueryModel bookUpdateQueryModel) {
        if (bookUpdateQueryModel.getBookTitle().isEmpty())
            throw new BookServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        BookResponseModel bookResponseModel = new BookResponseModel();
        Book updateBook = bookService.updateBook(bookId, bookUpdateQueryModel);
        BeanUtils.copyProperties(updateBook, bookResponseModel);
        return bookResponseModel;
    }

    @DeleteMapping(path = "/{bookId}")
    public OperationStatusModel deleteBook(@PathVariable String bookId) {
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName("Delete");
        bookService.deleteBook(bookId);
        returnValue.setOperationStatus("Done");
        return returnValue;
    }
}
