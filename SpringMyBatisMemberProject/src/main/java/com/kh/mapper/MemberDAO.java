package com.kh.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.domain.MyBatisMember;

@Repository
public interface MemberDAO {
	
	// 게시판 추가
	public void insert(MyBatisMember member) throws Exception;

	// 게시판 출력(1개)
	public MyBatisMember select(MyBatisMember member) throws Exception;

	// 게시판 수정
	public void update(MyBatisMember member) throws Exception;

	// 게시판 삭제
	public void delete(MyBatisMember member) throws Exception;

	// 게시판 출력(전체)
	public List<MyBatisMember> selectAll() throws Exception;
}
