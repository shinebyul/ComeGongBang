package com.synergy.backend.domain.member.repository;

import com.synergy.backend.domain.member.model.entity.Member;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);


    List<Member>
}
