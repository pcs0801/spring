package com.kh.serivce;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;

@Repository
public interface MemberMapperService {

	// 유저 등록
	public void insert(Member member) throws Exception;

	// 유저 권한 부여
	public void insertAuth(MemberAuth memberAuth) throws Exception;

	// 유저 전체 목록
	public List<Member> selectAll() throws Exception;

	// 유저 정보(1명)
	public Member selectJoin(Member member) throws Exception;

	// 유저 정보 수정
	public void update(Member member) throws Exception;

	// 유저 정보 삭제
	public void delete(Member member) throws Exception;

	// 유저 권한 삭제
	public void deleteAuth(Member member) throws Exception;
}
