package com.book.Conttroller;

import com.book.model.BookCreateQueryModel;
import com.book.responseModel.BookResponseModel;
import com.book.service.BookService;
import com.book.sharedDto.BookDto;
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

        BookDto bookDto = bookService.getBookByBookId(bookId);
        BeanUtils.copyProperties(bookDto, bookResponseModel);
        return bookResponseModel;
    }

    @PostMapping
    public BookResponseModel createBook(@RequestBody BookCreateQueryModel bookCreateQueryModel) {
        BookResponseModel bookResponseModel = new BookResponseModel();
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(bookCreateQueryModel, bookDto);
        BookDto createBook = bookService.createBook(bookDto);
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
