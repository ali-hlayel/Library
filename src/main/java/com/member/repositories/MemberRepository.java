package com.member.repositories;

import com.member.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {

    Member findByFirstName(String firstName);

    //here is by using the position
    @Query(value = "select * from members m where m.first_name = ?1", nativeQuery = true)
    List<Member> findAllMembersByFirstName(String firstName);

    @Query(value = "select * from members m where m.last_name = :lastName", nativeQuery = true)
    List<Member> findAllMembersByLastName(@Param("lastName") String lastName);

    @Query(value = "select * from members m where m.last_name LIKE %:keyword% or last_name LIKE %:keyword%", nativeQuery = true)
    List<Member> findAllMembersByKeyword(@Param("keyword") String keyword);
}
