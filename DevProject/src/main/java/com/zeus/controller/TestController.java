package com.zeus.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeus.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

	@ResponseBody
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam("name") String firstName) {
		return "hello" + firstName;
	}

	@GetMapping("/views/postTestPage")
	public String postTestPage() {
		return "/views/postTestPage";
	}

	@ResponseBody
	@PostMapping(value = "/postTest")
	public String postTest(String username) {
		return username + "님 안녕하세요";
	}

	@GetMapping("/views/nationalityTestPage")
	public String nationalityTestPage() {
		return "/views/nationalityTestPage";
	}

	@ResponseBody
	@PostMapping("/nationSelect")
	public String nationalityResult(Member member) {
		for (int i = 0; i < member.getNationality().size(); i++) {
			log.info("index : " + member.getNationality().get(i));
		}
		return "/views/nationalityTestPage";
	}

}
