package com.member.conttroller;

import com.member.address.Address;
import com.member.member.Member;
import com.member.responseModel.MemberResponseModel;
import com.member.service.MemberService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
class MemberControllerTest {

    @InjectMocks
    MemberController memberController;

    @Mock
    MemberService memberService;

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @BeforeEach
    void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getBooks() {

    }

    @Test
    void testGetBook() {
        Member member = createMember();
        when(memberService.getMemberById(any(Long.class))).thenReturn(member);
        MemberResponseModel memberResponseModel = memberController.getBook(1L);

    }

    @Test
    void testCreateBook() {
    }

    @Test
    void testUpdateBook() {
    }

    @Test
    void testDeleteBook() {
    }

    private static Member createMember() {
        Member member = new Member();
        member.setId(1L);
        member.setFirstName("Ali");
        member.setSerialNumber("123123");
        member.setMemberId("ali.hlayel");
        member.setLastName("Hlayel");
        member.setBirthDate(LocalDate.of(2020,12,12));
        member.setAddresses(getAddress());
        return member;
    }

    private static List<Address> getAddress() {
        Address address = new Address();
        List<Address> addresses = new ArrayList<>();
        address.setCity("Berlin");
        address.setCountry("Germany");
        address.setId(1L);
        address.setPostCode("13507");
        address.setStreetName("Schulstrasse");
        address.setStreetNumber("11-A");
        addresses.add(address);
        return addresses;
    }
}