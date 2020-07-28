package com.member.repositories;

import com.member.address.Address;
import com.member.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    final void testFindMemberByFirstNameAndLastName() {
        Member member = createMember();
        memberRepository.save(member);
        List<Member> result = memberRepository.findAllMembersByFirstName("Ali");
      //  assertEquals("Ali",result.get(0).getFirstName());
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