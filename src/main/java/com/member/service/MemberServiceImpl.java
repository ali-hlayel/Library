package com.member.service;

import com.member.address.AddressModel;
import com.member.member.MemberModel;
import com.member.member.Member;
import com.member.exceptions.MemberServiceException;
import com.member.exceptions.ErrorMessages;
import com.member.model.MemberUpdateQueryModel;
import com.member.repositories.MemberRepository;
import com.member.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    Utils utils;

    @Override
    public List<Member> getMembers(int page, int limit) {
        List<Member> returnValue = new ArrayList<>();
        PageRequest pageableRequest = PageRequest.of(page, limit);
        Page<Member> memberPage = memberRepository.findAll(pageableRequest);
        List<Member> members = memberPage.getContent();

        for (Member member: members) {
            Member Member = new Member();
            copyProperties(member, Member);
            returnValue.add(Member);
        }

        return returnValue;
    }

    @Override
    public MemberModel createMember(MemberModel memberModel) {
        if(memberRepository.findByFirstName(memberModel.getEmail()) != null) throw new RuntimeException("member already Exist");

        for(AddressModel addressModel : memberModel.getAddressModels()) {
            addressModel.setMemberModelDetails(memberModel);
        }

        ModelMapper modelMapper = new ModelMapper();
        Member member;
        member = modelMapper.map(memberModel, Member.class);
        Member savedBookDetails = memberRepository.save(member);
        MemberModel returnValue = modelMapper.map(savedBookDetails, MemberModel.class);
        return returnValue;
    }

    @Override
    public Member getMemberById(long id) throws NoResultException{
        Member returnValue = new Member();
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new NoResultException(ErrorMessages.MEMBER_IS_NOT_FOUND.getErrorMessage() + id)
        );
        copyProperties(member, returnValue);
        return returnValue;
    }

    @Override
    public Member updateMember(long id, Member updateMember) throws MemberServiceException {
        Member existingMember = memberRepository.findById(id).orElseThrow(
                () -> new NoResultException(ErrorMessages.MEMBER_IS_NOT_FOUND.getErrorMessage() + id)
        );
       copyProperties(updateMember, existingMember);
        Member result = memberRepository.save(existingMember);
        return result;
    }

    @Override
    public void deleteMember(long id) {
        Member result = memberRepository.findById(id).orElseThrow(
                () -> new NoResultException(ErrorMessages.MEMBER_IS_NOT_FOUND.getErrorMessage() + id)
        );
        memberRepository.delete(result);
    }

}
