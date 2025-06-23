package com.kh.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.domain.AOPMember;
import com.kh.service.MemberDAOService;

@Controller
@RequestMapping("/member")
@MapperScan(basePackages = "com.kh.mapper")
public class MemberController {
	@Autowired
	private MemberDAOService memberDAOservice;

	@GetMapping("/register")
	public String registerForm(AOPMember member, Model model) throws Exception {
		model.addAttribute("member", member);
		return "member/register";
	}

	@PostMapping("/register")
	public String register(AOPMember member, Model model) throws Exception {
		memberDAOservice.insert(member);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "member/success";
	}

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("list", memberDAOservice.selectAll());
	}

	@GetMapping("/read")
	public void read(AOPMember member, Model model) throws Exception {
		model.addAttribute("member", memberDAOservice.select(member));
	}

	@PostMapping("/remove")
	public String remove(AOPMember member, Model model) throws Exception {
		memberDAOservice.delete(member);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "member/success";
	}

	@GetMapping("/modify")
	public void modifyForm(AOPMember member, Model model) throws Exception {
		model.addAttribute("member", memberDAOservice.select(member));
	}

	@PostMapping("/modify")
	public String modify(AOPMember member, Model model) throws Exception {
		memberDAOservice.update(member);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "member/success";
	}
}
