package com.book.address;

import com.book.book.Book;

public class Address {

    private long id;

    private String city;

    private String country;

    private String streetName;

    private String streetNumber;

    private String postCode;

    private Book bookDetails;

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

    public Book getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(Book bookDetails) {
        this.bookDetails = bookDetails;
    }
}
