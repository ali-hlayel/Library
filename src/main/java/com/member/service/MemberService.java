package com.member.service;

import com.member.member.Member;
import com.member.member.MemberEntity;
import com.member.model.MemberUpdateQueryModel;

import java.util.List;

public interface MemberService {

    Member createMember(Member member);

    Member getMemberByMemberId(String BookId);

    Member updateMember(String bookId, MemberUpdateQueryModel book);

    void deleteMember(String bookId);

    List<MemberEntity> getMembers(int page, int limit);

}
