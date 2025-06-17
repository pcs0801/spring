package com.board.service;

import java.util.List;

import com.board.domain.Board;

public interface BoardService {

	// 게시판 추가
	void insert(Board board) throws Exception;

	// 게시판 출력(1개)
	Board select(Board board) throws Exception;

	// 게시판 수정
	void update(Board board) throws Exception;

	// 게시판 삭제
	void delete(Board board) throws Exception;

	// 게시판 출력(전체)
	List<Board> selectAll() throws Exception;

}