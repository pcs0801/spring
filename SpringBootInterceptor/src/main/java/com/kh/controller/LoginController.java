package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@GetMapping("/login")
	public String loginForm(Model model) {
		log.info("[LOGIN_CONTROLLER] LOGINFORM START");

		return "login/loginForm";
	}

	@PostMapping("/login")
	public void login(Member member, Model model) {
		log.info("login");
		log.info("login userId = " + member.getUserId());
		log.info("login userPw = " + member.getUserPw());
		model.addAttribute("result", "로그인 되었습니다.");

		member.setUserName("제우스");
		member.setEmail("zeus@zeus.com");
		model.addAttribute("user", member);
	}
}
