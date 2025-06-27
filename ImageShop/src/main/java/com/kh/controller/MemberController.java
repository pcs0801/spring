package com.kh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.common.CodeLabelValue;
import com.kh.domain.Member;
import com.kh.service.CodeService;
import com.kh.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
public class MemberController {

	@Autowired
	private MemberService service;

	@Autowired
	private CodeService codeService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/register")
	public void registerForm(Member member, Model model) throws Exception {
		String groupCode = "A00";
		List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
		model.addAttribute("jobList", jobList);
	}

	@PostMapping("/register")
	public String register(@Validated Member member, BindingResult result, Model model, RedirectAttributes rttr)
			throws Exception {
		if (result.hasErrors()) {
			String groupCode = "A00";
			List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);

			model.addAttribute("jobList", jobList);

			return "user/register";
		}

		String inputPassword = member.getUserPw();
		member.setUserPw(passwordEncoder.encode(inputPassword));
		service.register(member);
		rttr.addFlashAttribute("userName", member.getUserName());
		return "redirect:/user/registerSuccess";
	}

	@GetMapping("/registerSuccess")
	public void registerSuccess(Model model) throws Exception {
	}

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.list());
	}

	@GetMapping("/read")
	public void read(int userNo, Model model) throws Exception {
		// 직업코드 목록을 조회하여 뷰에 전달
		String groupCode = "A00";
		List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
		model.addAttribute("jobList", jobList);
		model.addAttribute(service.read(userNo));
	}

	@GetMapping("/modify")
	public void modifyForm(int userNo, Model model) throws Exception {
		String groupCode = "A00";
		List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
		model.addAttribute("jobList", jobList);
		model.addAttribute(service.read(userNo));
	}

	@PostMapping("/modify")
	public String modify(Member member, RedirectAttributes rttr) throws Exception {
		service.modify(member);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/user/list";
	}

	@PostMapping("/remove")
	public String remove(int userNo, RedirectAttributes rttr) throws Exception {
		service.remove(userNo);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/user/list";
	}
}