package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/views")
@Controller
public class HelloController {

	@GetMapping("/input")
	public void input() {
		log.info("input.jsp 호출(화면출력)");
	}
	
	@PostMapping("/info")
	public String result(String name, int age, String email, Model model) {
		
		User user = new User();
		
		user.setName(name);
		user.setAge(age);
		user.setEmail(email);
		
		model.addAttribute("mName",user.getName());
		model.addAttribute("mAge",user.getAge());
		model.addAttribute("mEmail",user.getEmail());
		
		return "/views/result";
	}
}