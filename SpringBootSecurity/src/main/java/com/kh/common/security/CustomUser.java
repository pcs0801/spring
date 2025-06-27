package com.kh.common.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.kh.domain.Member;

public class CustomUser extends User {
	private Member member;

	// 생성자
	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	// 생성자
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	// 생성자
	public CustomUser(Member member) {
		// 사용자가 정의한 Member 타입을 스프링 시큐리티 UsersDetails 타입으로 변환한다.
		super(member.getId(), member.getPw(), member.getAuthList().stream().map((auth) -> {
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(auth.getAuth());
			return sga;
		}).collect(Collectors.toList()));
		this.member = member;
	}

	public Member getMember() {
		return member;
	}
}
