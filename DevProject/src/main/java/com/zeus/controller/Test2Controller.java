package com.zeus.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.domain.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Test2Controller {
	// /gohome06 URL을 입력받으면 DB연동 처리 후 /gohome05 으로 redirect 처리.
	// /gohome05 URL을 입력받으면 /gohome07(view resolver)을 화면에 출력.

	@GetMapping("/sub/gohome06")
	public String gohome06() {
		log.info("this is /sub/gohome06");
		return "redirect:/sub/gohome05";
	}

	@GetMapping("/sub/gohome05")
	public String gohome05() {
		log.info("this is /sub/gohome05 and redirected");
		return "/sub/gohome07";
	}

	@GetMapping("/sub/gohome07")
	public void gohome07() {
		log.info("this is the destination");
	}

	@ResponseBody
	@GetMapping(value = "/gohome08")
	public Map<String, Board> home08(Model model) {
		log.info("자바빈즈 클래스 타입 home08");
		Map<String, Board> map = new HashMap<>();
		Board board = new Board();
		board.setBoardNo(20);
		map.put("key1", board);
		
		Board board2 = new Board();
		board2.setBoardNo(30);
		map.put("key2", board2);
		
		return map;
	}
}
