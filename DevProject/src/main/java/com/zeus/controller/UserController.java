package com.zeus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.CodeLabelValue;
import com.zeus.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

//	@GetMapping(value = "/registerForm")
//	public String registerForm(Model model) {
//		log.info("registerForm");
//		User user = new User();
//		user.setUserId("kimid");
//		user.setUserName("홍길동");
//		user.setUserPassword("123456");
//		user.setIntroduction("스프링부트입니다.");
//
//		ArrayList<CheckBoxLabelValue> checkBoxList = new ArrayList<CheckBoxLabelValue>();
//		checkBoxList.add(new CheckBoxLabelValue("스포츠", "sports"));
//		checkBoxList.add(new CheckBoxLabelValue("영화", "movie"));
//		checkBoxList.add(new CheckBoxLabelValue("음악", "music"));
//
//		model.addAttribute("hobbyBoxList", checkBoxList);
//		model.addAttribute("user", user);
//
//		return "user/registerForm";
//	}

	@PostMapping(value = "/register")
	public String register(@Validated  User user, BindingResult result) {
		log.info("register");
		
		if(result.hasErrors()) {
			return "user/registerSpringFormErrors";
		}

		return "user/resultForm";
	}

	@GetMapping(value = "/radiobuttons01")
	public String registerSpringFormRadiobuttons01(Model model) {
		log.info("Radiobuttons01");
		User user = new User(); 
		
		List<CodeLabelValue> nationalityCodeList = new ArrayList<CodeLabelValue>();
		nationalityCodeList.add(new CodeLabelValue("01", "Volvo"));
		nationalityCodeList.add(new CodeLabelValue("02", "Saab"));
		nationalityCodeList.add(new CodeLabelValue("03", "Opel"));

		model.addAttribute("nationalityCodeList", nationalityCodeList);
		user.setUserId("abc");
		model.addAttribute("user", user);

		return "user/radiobuttons01"; // 뷰 파일명
	}
	
	
	@GetMapping(value = "/registerSpringFormErrors")
	public String registerSpringFormErrors(Model model) {
	log.info("registerSpringFormErrors");

	User user = new User();
	user.setEmail("aaa@ccc.com"); 
	user.setUserName("홍길동");
	model.addAttribute("user", user);

	return "user/registerSpringFormErrors";	// 뷰 파일명
	}


}