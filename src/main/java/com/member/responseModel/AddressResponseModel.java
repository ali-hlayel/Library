package com.member.responseModel;

import com.member.member.MemberModel;

public class AddressResponseModel {

    private String city;

    private String country;

    private String streetName;

    private String streetNumber;

    private String postCode;

    private MemberModel memberModelDetails;

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

    public MemberModel getMemberModelDetails() {
        return memberModelDetails;
    }

    public void setMemberModelDetails(MemberModel memberModelDetails) {
        this.memberModelDetails = memberModelDetails;
    }
}
