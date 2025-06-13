package com.zeus.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeus.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		log.info("registerForm");
		return "/member/registerForm";
	}

	@ResponseBody
	@PostMapping("/member/register")
	public String registerPost(Member member) {
		log.info("register");
		log.info("userId = " + member.getUserId());
		log.info("password = " + member.getPassword());
		log.info("dateOfBirth = " + member.getDateOfBirth());
		return "환영합니다, " + member.getUserId() + "님!";
	}

	@ResponseBody
	@PostMapping("/registerBoard")
	public String registerBoard(Member member) {
		log.info("registerBoard");
		log.info("Member/userId = " + member.getUserId());
		log.info("Member/password = " + member.getPassword());
		log.info("Member/dateOfBirth = " + member.getDateOfBirth());
		log.info("Board/boardNo = " + member.getBoard().getBoardNo());
		return "환영합니다, " + member.getUserId() + "님! " + "게시판 번호는 " + member.getBoard().getBoardNo() + " 입니다.";
	}
}