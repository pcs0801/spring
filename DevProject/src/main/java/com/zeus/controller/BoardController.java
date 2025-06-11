package com.zeus.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// 사용자 요청 받기(http://127.0.0.1:8080/home) > 해당되는 DB로 연동 > 결과값을 해당되는 View에 전달
@Slf4j
@Controller
@RequestMapping(value="/board")
public class BoardController {
	//http://~:8080/board/read/100 -> url 마지막 path값을 int boardNo로 입력하고, /board/read.jsp
	// model 전송하고 출력화면 전송
	@GetMapping("/read/{boardNo}")
	public String getRead(@PathVariable("boardNo") String boardNo, Model model) {
		log.info("게시굴번호 : " + boardNo);
		model.addAttribute("boardNo",boardNo);
		return "board/read";
	}
}
