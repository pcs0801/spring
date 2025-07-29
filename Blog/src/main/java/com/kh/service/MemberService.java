package com.kh.service;

import com.kh.dto.MemberDTO;

public interface MemberService {
	Long register(MemberDTO memberDTO);

	MemberDTO read(String email);

	void modify(MemberDTO memberDTO);

	void remove(String email);

	boolean existsByEmail(String email);

	MemberDTO login(String email, String pw);
}