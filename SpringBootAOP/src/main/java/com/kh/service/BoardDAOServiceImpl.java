package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.AOPBoard;
import com.kh.mapper.BoardDAO;

@Service
public class BoardDAOServiceImpl implements BoardDAOService {
	//의존성 주입
	@Autowired
	private BoardDAO boardDAO;

	@Override
	@Transactional
	public void insert(AOPBoard board) throws Exception {
		boardDAO.insert(board);
	}

	@Override
	public AOPBoard select(AOPBoard board) throws Exception {
		return boardDAO.select(board);
	}

	@Override
	@Transactional
	public void update(AOPBoard board) throws Exception {
		boardDAO.update(board);
	}

	@Override
	@Transactional
	public void delete(AOPBoard board) throws Exception {
		boardDAO.delete(board);
	}

	@Override
	public List<AOPBoard> selectAll() throws Exception {
		return boardDAO.selectAll();
	}

}
