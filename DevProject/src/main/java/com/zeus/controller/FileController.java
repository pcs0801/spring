package com.zeus.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class FileController {
	@GetMapping("/registerAjaxFileUpForm")
	public String registerAjaxFileUpForm() {
		log.info("registerAjaxFileUpForm");
		return "member/registerAjaxFileUpForm";
	}
	
	@PostMapping(value = "/uploadAjax", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception
	{ String originalFilename = file.getOriginalFilename();
	log.info("originalName: " + originalFilename);
	ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD SUCCESS " + originalFilename, HttpStatus.OK);
	return entity;
	}
}