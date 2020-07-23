package com.member.responseModel;

public class MemberResponseModel {

    private long id ;

    private String memberId;

    private String firstName;

    private String lastName;

   // private List<AddressResponseModel> addresses;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookTitle() {
        return firstName;
    }

    public void setBookTitle(String bookTitle) {
        this.firstName = bookTitle;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
