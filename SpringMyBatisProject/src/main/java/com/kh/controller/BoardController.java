package com.kh.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.domain.MyBatisBoard;
import com.kh.serivce.BoardDAOService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/board")
@MapperScan(basePackages = "com.kh.mapper")
public class BoardController {
	@Autowired
	private BoardDAOService boardDAOservice;

	@GetMapping("/register")
	public String registerForm(MyBatisBoard board, Model model) throws Exception {
		log.info("registerForm");
		model.addAttribute("board", board);
		return "board/register";
	}

	@PostMapping("/register")
	public String register(MyBatisBoard board, Model model) throws Exception {
		boardDAOservice.insert(board);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "board/success";
	}

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		log.info("list");
		model.addAttribute("list", boardDAOservice.selectAll());
	}

	@GetMapping("/read")
	public void read(MyBatisBoard board, Model model) throws Exception {
		model.addAttribute("board", boardDAOservice.select(board));
	}

	@PostMapping("/remove")
	public String remove(MyBatisBoard board, Model model) throws Exception {
		boardDAOservice.delete(board);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "board/success";
	}

	@GetMapping("/modify")
	public void modifyForm(MyBatisBoard board, Model model) throws Exception {
		model.addAttribute("board", boardDAOservice.select(board));
	}

	@PostMapping("/modify")
	public String modify(MyBatisBoard board, Model model) throws Exception {
		boardDAOservice.update(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "board/success";
	}
}
