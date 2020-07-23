package com.member.responseModel;

import org.springframework.hateoas.RepresentationModel;

public class MemberResponseModel extends RepresentationModel {

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
}
