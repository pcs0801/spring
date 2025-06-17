package com.kh.service;

import java.util.List;

import com.kh.domain.Member;

public interface MemberService {

	// 멤버 추가
	void insert(Member member) throws Exception;

	// 유저 출력(1명)
	Member select(Member member) throws Exception;

	// 유저 수정
	void update(Member member) throws Exception;

	// 유저 삭제
	void delete(Member member) throws Exception;

	// 유저 출력(전체)
	List<Member> selectAll() throws Exception;

}