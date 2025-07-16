package com.kh.service;

import java.util.List;

import com.kh.common.domain.PageRequest;
import com.kh.domain.Board;

public interface BoardService {

	public void register(Board board) throws Exception;

	public List<Board> list(PageRequest pageRequest) throws Exception;

	public Board read(Integer boardNo) throws Exception;

	public void modify(Board board) throws Exception;

	public void remove(Integer boardNo) throws Exception;
	
	public int count(PageRequest pageRequest) throws Exception;
}