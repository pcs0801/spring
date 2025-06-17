package com.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.board.domain.Board;

@Repository
public class BoardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String insertBoard = "INSERT INTO BOARD(BOARD_NO, TITLE, CONTENT, WRITER) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?)";
	private String selectBoard = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, REG_DATE FROM BOARD WHERE BOARD_NO = ?";
	private String updateBoard = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE BOARD_NO = ?";
	private String deleteBoard = "DELETE FROM BOARD WHERE BOARD_NO = ?";
	private String selectAllBoard = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, REG_DATE FROM BOARD WHERE BOARD_NO > 0 ORDER BY BOARD_NO DESC, REG_DATE DESC";

	// 게시판 추가
	public void insert(Board board) throws Exception {
		jdbcTemplate.update(insertBoard, board.getTitle(), board.getContent(), board.getWriter());
	}

	// 게시판 출력(1개)
	public Board select(Board board) throws Exception {
		List<Board> results = jdbcTemplate.query(selectBoard, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER"));
				board.setRegDate(rs.getDate("REG_DATE"));

				return board;
			}
		}, board.getBoardNo());

		return results.isEmpty() ? null : results.get(0);
	}

	// 게시판 수정
	public void update(Board board) throws Exception {

		jdbcTemplate.update(updateBoard, board.getTitle(), board.getContent(),

				board.getBoardNo());
	}

	// 게시판 삭제
	public void delete(Board board) throws Exception {
		jdbcTemplate.update(deleteBoard, board.getBoardNo());
	}

	// 게시판 출력(전체)
	public List<Board> selectAll() throws Exception {
		List<Board> results = jdbcTemplate.query(selectAllBoard, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

				Board board = new Board();

				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER"));
				board.setRegDate(rs.getDate("REG_DATE"));
				return board;
			}
		});
		return results.isEmpty() ? null : results;

	}

}
