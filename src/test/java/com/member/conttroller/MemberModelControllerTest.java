package com.member.conttroller;

import com.member.address.Address;
import com.member.member.Member;
import com.member.responseModel.MemberResponseModel;
import com.member.service.MemberService;
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
class MemberModelControllerTest {

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
    void getMembers() {

    }

    @Test
    void testGetMember() {
        Member member = createMember();
        when(memberService.getMemberById(any(Long.class))).thenReturn(member);
        MemberResponseModel memberResponseModel = memberController.getMember(1L);
    }

    @Test
    void testCreateMember() {
    }

    @Test
    void testUpdateMember() {
    }

    @Test
    void testDeleteMember() {
    }

    private static Member createMember() {
        Member member = new Member();
        member.setId(1L);
        member.setFirstName("Ali");
        member.setSerialNumber("123123");
        member.setMemberId("ali.hlayel");
        member.setLastName("Hlayel");
        member.setPassword("TestPass");
        member.setEmail("aliihlail@gmail.com");
        member.setBirthDate(LocalDate.of(2020,12,12));
        Address address = getAddress();
        address.setMemberDetails(member);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        member.setAddresses(addresses);
        return member;
    }

    private static Address getAddress() {
        Address address = new Address();
        address.setCity("Berlin");
        address.setCountry("Germany");
        address.setId(1L);
        address.setPostCode("13507");
        address.setStreetName("Schulstrasse");
        address.setStreetNumber("11-A");
        return address;
    }
}