package com.member.service;

import com.member.member.MemberModel;
import com.member.member.Member;
import com.member.model.MemberUpdateQueryModel;

import java.util.List;

public interface MemberService {

    MemberModel createMember(MemberModel memberModel);

    Member getMemberById(long id);

    Member updateMember(long id, Member member);

    void deleteMember(long id);

    List<Member> getMembers(int page, int limit);

}
