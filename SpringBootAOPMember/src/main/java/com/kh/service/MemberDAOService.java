package com.kh.service;

import java.util.List;

import com.kh.domain.AOPMember;

public interface MemberDAOService {

	// 게시판 추가
	public void insert(AOPMember member) throws Exception;

	// 게시판 출력(1개)
	public AOPMember select(AOPMember member) throws Exception;

	// 게시판 수정
	public void update(AOPMember member) throws Exception;

	// 게시판 삭제
	public void delete(AOPMember member) throws Exception;

	// 게시판 출력(전체)
	public List<AOPMember> selectAll() throws Exception;

}