package com.zeus.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@ResponseBody
	@PostMapping("/registerFileUpload")
	public String registerFileUpload(MultipartFile image) throws IllegalStateException, IOException {
		log.info("originalName: " + image.getOriginalFilename());
		log.info("serverImgName: " + image.getName());
		log.info("size: " + image.getSize());
		log.info("contentType: " + image.getContentType());
		image.transferTo(new File("E:/SpingBootUploadFile/" + image.getOriginalFilename()));
		return "성공";
	}

	@GetMapping("/form")
	public String form() {
		log.info("form");
		return "member/form";
	}

	@PostMapping("/submit")
	public String submit(@RequestParam String name, RedirectAttributes rttr, Model model) {
		log.info("submit name : " + name);

		rttr.addFlashAttribute("msg", "뭘봐웅 " + name + " 두둥등장");
		model.addAttribute("name", name);
		return "redirect:/member/result";
	}

	@GetMapping("/result")
	public String result() {
		log.info("result");
		return "member/result";
	}
}