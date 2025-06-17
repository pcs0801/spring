package com.kh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.domain.Member;
import com.kh.service.MemberService;

import lombok.extern.slf4j.Slf4j;

// 게시판에서 공통 주소는 /member 로 설정
// AJAX 방식인 경우, @RestController, 그렇지 않은 경우 @Controller
// DB 연동

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	// DB 연동
	@Autowired
	private MemberService memberService;

	// 유저 입력 화면 요청
	@GetMapping("/registerForm")
	public String registerForm(Member member) throws Exception {
		log.info("registerForm");
		return "member/insert";
	}

	// 게시판 내용 입력
	@PostMapping("/insert")
	public String register(Member member, Model model) throws Exception {
		log.info("유저 등록");
		memberService.insert(member);
		model.addAttribute("msg", "유저 등록이 완료되었습니다.");
		return "member/success";
	}

	// 유저 목록 전체 출력
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		log.info("유저 목록 전체 출력");
		model.addAttribute("list", memberService.selectAll());
	}

	// 유저 목록 1명 출력
	@GetMapping("/read")
	public void read(Member member, Model model) throws Exception {
		log.info("유저 정보(1명) 출력");
		model.addAttribute(memberService.select(member));
	}

	// 유저 삭제
	@PostMapping("/delete")
	public String remove(Member member, Model model) throws Exception {
		log.info("유저 삭제");
		memberService.delete(member);
		model.addAttribute("msg", "유저 삭제가 완료되었습니다.");
		return "member/success";
	}

	// 유저 수정 화면 요청
	@GetMapping("/update")
	public void modifyForm(Member member, Model model) throws Exception {
		log.info("유저 수정");
		model.addAttribute(memberService.select(member));
	}

	// 유저 수정 내용 저장
	@PostMapping("/update")
    public String modify(Member member, Model model) throws Exception {
        log.info("유저 수정");
        memberService.update(member);
        model.addAttribute("msg", "유저 수정이 완료되었습니다.");
        return "member/success";
    }
}