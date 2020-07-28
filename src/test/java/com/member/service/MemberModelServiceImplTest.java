package com.member.service;

import com.member.address.Address;
import com.member.member.Member;
import com.member.model.MemberUpdateQueryModel;
import com.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberModelServiceImplTest {

    @InjectMocks
    MemberServiceImpl memberService;

    @Mock
    MemberRepository memberRepository;

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testGetMembers() {
    }

    @Test
    void testCreateMember() {
    }

    @Test
    void testGetMemberById() {
        Member memberEntity =  createMember();
        String firstName = "Ali";
        when(memberRepository.findById(any(Long.class))).thenReturn(Optional.of(memberEntity));
        Member member = memberService.getMemberById(1L);
        assertEquals(firstName, member.getFirstName());

    }

    @Test
    void testUpdateMember() {
        Member existingMember =  createMember();
        Member updatedMember = createMember();
        updatedMember.setFirstName("Ahmad");
        updatedMember.setLastName("Ihlail");
        updatedMember.setSerialNumber("123123132");
        when(memberRepository.findById(any(Long.class))).thenReturn(Optional.of(existingMember));
        when(memberRepository.save(any(Member.class))).thenReturn(existingMember);

        Member member = memberService.updateMember(1L, updatedMember);
        assertEquals("Ahmad", member.getFirstName());
        assertEquals("123123132", member.getSerialNumber());
        verify(memberRepository).save(existingMember);

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

    private static MemberUpdateQueryModel updateModel() {
        MemberUpdateQueryModel memberUpdateQueryModel = new MemberUpdateQueryModel();
        memberUpdateQueryModel.setFirstName("Ahmad");
        memberUpdateQueryModel.setLastName("Saleem");
        memberUpdateQueryModel.setSerialNumber("123123123");
        return memberUpdateQueryModel;
    }
}