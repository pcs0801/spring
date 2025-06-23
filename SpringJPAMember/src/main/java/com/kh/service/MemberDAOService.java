package com.kh.service;

import java.util.List;

import com.kh.domain.Member;

public interface MemberDAOService {

	// 게시판 추가
	public void insert(Member member) throws Exception;

	// 게시판 출력(1개)
	public Member select(Member member) throws Exception;

	// 게시판 수정
	public void update(Member member) throws Exception;

	// 게시판 삭제
	public void delete(Member member) throws Exception;

	// 게시판 출력(전체)
	public List<Member> selectAll() throws Exception;

}