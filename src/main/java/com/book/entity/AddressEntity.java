package com.book.entity;

import com.book.book.Book;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "addresses")
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    private String streetName;

    @NotNull
    private String streetNumber;

    @NotNull
    private String postCode;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookDetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public BookEntity getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookEntity bookDetails) {
        this.bookDetails = bookDetails;
    }
}
