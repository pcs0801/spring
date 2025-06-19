package com.kh.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.domain.MyBatisBoard;

@Repository
public interface BoardDAO {
	
	// 게시판 추가
	public void insert(MyBatisBoard board) throws Exception;

	// 게시판 출력(1개)
	public MyBatisBoard select(MyBatisBoard board) throws Exception;

	// 게시판 수정
	public void update(MyBatisBoard board) throws Exception;

	// 게시판 삭제
	public void delete(MyBatisBoard board) throws Exception;

	// 게시판 출력(전체)
	public List<MyBatisBoard> selectAll() throws Exception;
}
