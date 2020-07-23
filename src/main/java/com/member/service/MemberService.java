package com.member.service;

import com.member.member.Member;
import com.member.member.MemberEntity;
import com.member.model.MemberUpdateQueryModel;

import java.util.List;

public interface MemberService {

    Member createMember(Member member);

    Member getMemberById(long id);

    Member updateMember(long id, MemberUpdateQueryModel book);

    void deleteMember(long id);

    List<MemberEntity> getMembers(int page, int limit);

}
