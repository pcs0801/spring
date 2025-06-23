package com.kh.service;

import java.util.List;

import com.kh.domain.Board;

public interface BoardDAOService {

	// 게시판 추가
	public void insert(Board board) throws Exception;

	// 게시판 출력(1개)
	public Board select(Board board) throws Exception;

	// 게시판 수정
	public void update(Board board) throws Exception;

	// 게시판 삭제
	public void delete(Board board) throws Exception;

	// 게시판 출력(전체)
	public List<Board> selectAll() throws Exception;

}