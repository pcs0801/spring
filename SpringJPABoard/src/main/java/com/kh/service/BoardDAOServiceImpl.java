package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Board;
import com.kh.persistence.BoardRepository;

@Service
public class BoardDAOServiceImpl implements BoardDAOService {
	//의존성 주입
	@Autowired
	private BoardRepository boardRepository;

	@Override
	@Transactional
	public void insert(Board board) throws Exception {
		boardRepository.save(board);
	}

	@Override
	public Board select(Board board) throws Exception {
		return boardRepository.getReferenceById(board.getNo());
	}

	@Override
	@Transactional
	public void update(Board board) throws Exception {
		Board boardEntity = boardRepository.getReferenceById(board.getNo());
		boardEntity.setContent(board.getContent());
		boardEntity.setTitle(board.getTitle());
		boardEntity.setWriter(board.getWriter());
	}

	@Override
	@Transactional
	public void delete(Board board) throws Exception {
		boardRepository.deleteById(board.getNo());
	}

	@Override
	public List<Board> selectAll() throws Exception {
		return boardRepository.findAll(Sort.by(Direction.DESC,"no"));
	}

}
