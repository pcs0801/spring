package com.kh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@RequestMapping("/board")
@Controller
public class BoardController {
	@GetMapping("/list")
	public void list() {
		log.info("list : 모두가 접근 가능");
	}

// 회원권한을 가진 사용자만 접근이 가능하다. 
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	@GetMapping("/register")
	public void registerForm() {
		log.info("registerForm : 로그인한 회원만 접근 가능");
	}

// 로그인한 사용자먼 접근이 가능하다. 
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/read")
	public void read() {
		log.info("read : 인증된 사용자만 접근 가능");
	}

// 관리자나 회원권한을 가진 사용자만 접근이 가능하다. 
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
	@GetMapping("/modify")
	public void modifyForm() {
		log.info("modifyForm : 회원 또는 관리자만 접근 가능");
	}
}