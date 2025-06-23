package com.kh.service;

import java.util.List;

import com.kh.domain.AOPBoard;

public interface BoardDAOService {

	// 게시판 추가
	public void insert(AOPBoard board) throws Exception;

	// 게시판 출력(1개)
	public AOPBoard select(AOPBoard board) throws Exception;

	// 게시판 수정
	public void update(AOPBoard board) throws Exception;

	// 게시판 삭제
	public void delete(AOPBoard board) throws Exception;

	// 게시판 출력(전체)
	public List<AOPBoard> selectAll() throws Exception;

}