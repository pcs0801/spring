package com.kh.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kh.common.security.domain.CustomUser;
import com.kh.domain.Member;
import com.kh.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		log.info("Load User By UserId : " + userId);
		Member member = memberMapper.readByUserId(userId);
		log.info("queried by member mapper: " + member);
		return member == null ? null : new CustomUser(member);
	}
}