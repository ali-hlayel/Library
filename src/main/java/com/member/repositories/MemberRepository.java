package com.member.repositories;

import com.member.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {

    Member findByFirstName(String firstName);

    Member findByEmail(String email);

    @Query(value = "select * from members m where m.first_name = ?1", nativeQuery = true)
    List<Member> findAllMembersByFirstName(String firstName);
}
