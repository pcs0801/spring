package com.kh.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.domain.Member;

@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String insertSQL = "INSERT INTO MEMBER(NO, ID, PWD, NAME) VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?)";
	private String selectSQL = "SELECT NO, ID, PWD, NAME, REG_DATE FROM MEMBER WHERE NO = ?";
	private String updateSQL = "UPDATE MEMBER SET ID = ?, PWD = ?, NAME = ? WHERE NO = ?";
	private String deleteSQL = "DELETE FROM MEMBER WHERE NO = ?";
	private String selectAllSQL = "SELECT NO, ID, PWD, NAME, REG_DATE FROM MEMBER WHERE NO > 0 ORDER BY NO DESC, REG_DATE DESC";

	// 멤버 추가
	public void insert(Member member) throws Exception {
		jdbcTemplate.update(insertSQL, member.getId(), member.getPwd(), member.getName());
	}

	// 유저 출력(1명)
	public Member select(Member member) throws Exception {
		List<Member> results = jdbcTemplate.query(selectSQL, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setNo(rs.getInt("NO"));
				member.setId(rs.getString("ID"));
				member.setPwd(rs.getString("PWD"));
				member.setName(rs.getString("NAME"));
				member.setRegDate(rs.getDate("REG_DATE"));

				return member;
			}
		}, member.getNo());

		return results.isEmpty() ? null : results.get(0);
	}

	// 유저 수정
	public void update(Member member) throws Exception {
		jdbcTemplate.update(updateSQL, member.getId(), member.getPwd(), member.getName(), member.getNo());
	}

	// 유저 삭제
	public void delete(Member member) throws Exception {
		jdbcTemplate.update(deleteSQL, member.getNo());
	}

	// 유저 출력(전체)
	public List<Member> selectAll() throws Exception {
		List<Member> results = jdbcTemplate.query(selectAllSQL, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

				Member member = new Member();

				member.setNo(rs.getInt("NO"));
				member.setId(rs.getString("ID"));
				member.setPwd(rs.getString("PWD"));
				member.setName(rs.getString("NAME"));
				member.setRegDate(rs.getDate("REG_DATE"));
				return member;
			}
		});
		return results.isEmpty() ? null : results;

	}

}
