package com.member.repository;

import com.member.member.MemberEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends PagingAndSortingRepository<MemberEntity, Long> {

    MemberEntity findByFirstName(String firstName);

    MemberEntity findMemberByMemberId(String memberId);
}
