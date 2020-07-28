package com.member.address;

import com.member.member.Member;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "addresses")
public class Address implements Serializable {

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
    @JoinColumn(name = "member_id")
    private Member memberDetails;

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

    public Member getMemberDetails() {
        return memberDetails;
    }

    public void setMemberDetails(Member memberDetails) {
        this.memberDetails = memberDetails;
    }
}
