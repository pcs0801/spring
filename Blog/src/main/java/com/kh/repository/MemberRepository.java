package com.kh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByEmail(String email);

	Member findByEmailAndPassword(String email, String password);

	boolean existsByEmail(String email);
}
