package com.kh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByTitle(String title);

	List<Board> findByTitleAndContent(String title, String content);
	
	List<Board> findByMemberNickname(String nickname);
}
