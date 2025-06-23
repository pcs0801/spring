package com.kh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.domain.Board;
import com.kh.service.BoardDAOService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDAOService boardDAOservice;

	@GetMapping("/register")
	public String registerForm(Board board, Model model) throws Exception {
		model.addAttribute("board", board);
		return "board/register";
	}

	@PostMapping("/register")
	public String register(Board board, Model model) throws Exception {
		boardDAOservice.insert(board);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "board/success";
	}

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("list", boardDAOservice.selectAll());
	}

	@GetMapping("/read")
	public void read(Board board, Model model) throws Exception {
		model.addAttribute("board", boardDAOservice.select(board));
	}

	@PostMapping("/remove")
	public String remove(Board board, Model model) throws Exception {
		boardDAOservice.delete(board);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "board/success";
	}

	@GetMapping("/modify")
	public void modifyForm(Board board, Model model) throws Exception {
		model.addAttribute("board", boardDAOservice.select(board));
	}

	@PostMapping("/modify")
	public String modify(Board board, Model model) throws Exception {
		boardDAOservice.update(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "board/success";
	}
}
