package com.book.repository;

import com.book.entity.BookEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity, Long> {
    BookEntity findByBookTitle(String bookTitle);

    BookEntity findByBookId(String bookId);
}
