package com.kh.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.MyBatisBoard;
import com.kh.mapper.BoardDAO;

@Service
public class BoardDAOServiceImpl implements BoardDAOService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void insert(MyBatisBoard board) throws Exception {
		boardDAO.insert(board);
	}
	
	@Override
	public MyBatisBoard select(MyBatisBoard board) throws Exception {
		return boardDAO.select(board);
	}

	@Override
	public void update(MyBatisBoard board) throws Exception {
		boardDAO.update(board);
	}

	@Override
	public void delete(MyBatisBoard board) throws Exception {
		boardDAO.delete(board);
	}

	@Override
	public List<MyBatisBoard> selectAll() throws Exception {
		return boardDAO.selectAll();
	}

}
