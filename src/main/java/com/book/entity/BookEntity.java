package com.book.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="books")
public class BookEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String bookId;

    @Column(length = 100, unique = true)
    @NotNull
    private String bookTitle;

    @Column(length = 50)
    @NotNull
    private String bookAuthor;

    @Column(length = 70)
    @NotNull
    private String serialNumber;

    @OneToMany(mappedBy = "bookDetails", cascade = CascadeType.ALL)
    private List<AddressEntity> addresses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }
}
