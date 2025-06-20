package com.kh.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.domain.Member;
import com.kh.serivce.MemberDAOService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
@MapperScan(basePackages = "com.kh.mapper")
public class MemberController {
	@Autowired
	private MemberDAOService memberDAOservice;

	// 유저 입력 화면 요청
	@GetMapping("/register")
	public String registerForm(Member member, Model model) throws Exception {
		log.info("UserRegisterForm");
		return "member/register";
	}

	// 유저 입력 처리 요청
	@PostMapping("/register")
	public String register(@Valid Member member, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "member/register";
		}
		memberDAOservice.insert(member);
		model.addAttribute("msg", "등록 완료");
		return "member/success";
	}

	@GetMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", memberDAOservice.selectAll());
		return "member/list";
	}

	@GetMapping("/read")
	public String read(Member member, Model model) throws Exception {
		model.addAttribute(memberDAOservice.selectJoin(member));
		return "member/read";
	}

	@PostMapping("/remove")
	public String remove(Member member, Model model) throws Exception {
		memberDAOservice.delete(member);
		model.addAttribute("msg", "삭제 완료");
		return "member/success";
	}

	@GetMapping("/modify")
	public String modifyForm(Member member, Model model) throws Exception {
		model.addAttribute(memberDAOservice.selectJoin(member));
		return "member/modify";
	}

	@PostMapping("/modify")
	public String modify(@Valid Member member, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "member/modify";
		}
		memberDAOservice.update(member);
		model.addAttribute("msg", "수정 완료");
		return "member/success";
	}

}
