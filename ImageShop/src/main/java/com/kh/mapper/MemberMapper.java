package com.kh.mapper;

import java.util.List;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;

public interface MemberMapper {

	public void create(Member member) throws Exception;

	public void createAuth(MemberAuth memberAuth) throws Exception;

	public List<Member> list() throws Exception;

	public Member read(int userNo) throws Exception;

	public void modifyAuth(MemberAuth memberAuth) throws Exception;

	public void update(Member member) throws Exception;

	public void delete(int userNo) throws Exception;

	public void deleteAuth(int userNo) throws Exception;

	public int countAll() throws Exception;

	public Member readByUserId(String userId);
	
}
