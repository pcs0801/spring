package com.zeus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.CheckBoxLabelValue;
import com.zeus.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/registerForm")
	public String registerForm(Model model) {
		log.info("registerForm");
		User user = new User();
		user.setUserId("텔레토비");
		user.setUserName("보라돌이");
		user.setUserPassword("1234");
		user.setIntroduction("소개글");
		ArrayList<CheckBoxLabelValue> cbList = new ArrayList<>();
		cbList.add(new CheckBoxLabelValue("Teemo","01"));
		cbList.add(new CheckBoxLabelValue("So","02"));
		cbList.add(new CheckBoxLabelValue("Cute","03"));
		model.addAttribute("cbArrayList",cbList);
		
		model.addAttribute("user", user);
		return "user/registerForm";
	}

	@PostMapping(value = "/register")
    public String register(User user) {
        log.info("register");
        log.info("userId =" + user.getUserId());
        log.info("userName =" + user.getUserName());
        log.info("userPassword =" + user.getUserPassword());
        log.info("introdution =" + user.getIntroduction());

        List<String> checkBoxList = user.getCbList();
        if (checkBoxList != null) {
            log.info("hobbyList != null = " + checkBoxList.size());

            for (int i = 0; i < checkBoxList.size(); i++) {
                log.info("checkBoxList(" + i + ") = " + checkBoxList.get(i));
            }
        } else {
            log.info("checkBoxList == null");
        }

        return "user/resultForm";
    }
}
