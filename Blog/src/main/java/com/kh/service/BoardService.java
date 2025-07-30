package com.kh.service;

import java.util.List;

import com.kh.dto.BoardDTO;

public interface BoardService {
	Long register(BoardDTO boardDTO);

	BoardDTO read(Long boardId);

	void modify(BoardDTO boardDTO);

	void remove(Long boardId);

	List<BoardDTO> findByTitle(String title);

	List<BoardDTO> findByTitleAndContent(String title, String content);

	List<BoardDTO> findByMemberNickname(String nickname);
}