package com.zeus.controller;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.Board;

import lombok.extern.slf4j.Slf4j;

// 사용자 요청 받기(http://127.0.0.1:8080/home) > 해당되는 DB로 연동 > 결과값을 해당되는 View에 전달
@Slf4j
@Controller
public class HomeController {
	@Autowired
	private MessageSource messageSource;

	// http://127.0.0.1:8080/home <- get 방식
	// Model(Request, Response, Session, Application)
	@GetMapping(value = "/home")
	public String home(Locale locale, Model model) {
		log.info("여기는 HomeController home() 함수 입니다." + locale.toString());
		log.info("여기는 HomeController home() 함수 입니다." + model.toString());
		// DB 연동은 하지 않음
		// View 호출(~ : view Resolver)
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formatDate = df.format(date);
		// Model(=Request)
		model.addAttribute("serverTime", formatDate);
		return "home01";
	}

	@GetMapping(value = "/sub")
	public String sub(Model model) {
		Board board = new Board(10, "게시판", "텔레토비", "PCS", new Date());
		model.addAttribute("board", board);
		return "home02";
	}

	@GetMapping(value = "/home03")
	public String home03() {
		return "home03";
	}

	@GetMapping(value = "/home04")
	public String home04(Locale locale, Model model) {
		// 문자열 배열, ArrayList => VO, DB
		String[] name = { "보라돌이", "뚜비", "나나" };
		List<String> nameList = Arrays.asList("보라돌이", "뚜비", "나나");
		model.addAttribute("name", name);
		model.addAttribute("nameList", nameList);
		return "home04";
	}

	@GetMapping(value = "/home05")
	public String home05(Model model) {
		// HashMap 생성 후 DB, 사용자로부터 전달받은 값을 화면으로 출력
		// Key = id, pwd, email, name, date
		Map mMap = new HashMap<>();
		mMap.put("id", "텔레토비");
		mMap.put("pwd", "보라돌이");
		mMap.put("email", "ddubi@nana.bbo");
		mMap.put("name", "햇님");
		mMap.put("date", new Date());
		model.addAttribute("mMap", mMap);

		return "home05";
	}

	@GetMapping("/home0303")
	public String home0303(Model model) {
		Board board = new Board();
		board.setTitle("1");
		model.addAttribute("board", board);
		return "home0303";
	}

	@GetMapping("/home0202")
	public String home0202(Model model) {
		Board board = new Board();
		board.setTitle("spring boot");
		model.addAttribute("board", board);
		return "home0202";
	}

	// WEB-INF/view/home0901.jsp, get
	@GetMapping("/home0901")
	public String home0901() {
		return "home0901";
	}

	// WEB-INF/view/home0901.jsp, get, parameter
	@RequestMapping("/boardjstl/search")
	public void search(Board board, String title, Model model) {
		log.info("search keyword = " + board);
		log.info("search keyword title = " + title);
		model.addAttribute("board", board);
	}

	@RequestMapping("/boardjstl/list")
	public void list() {
		log.info("/boardjstl/list");
	}

	@GetMapping("/home1101")
	public void home1101() {
		log.info("/home1101");
	}

	@GetMapping("/")
	public String home2(Locale locale, Model model) {
		log.info("환영합니다. 클라이언트 지역은 " + locale + "이다."); 
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		String[] args = {"첫번째 메세지","두번째 메세지"}; 
		// 스프링 프레임워크로부터 MessageSource를 주입 받은 다음 getMessage 메서드를 호출한다. 
		String message = messageSource.getMessage("welcome.message", args, Locale.KOREAN); 
		String message2 = messageSource.getMessage("welcome.message", args, Locale.ENGLISH); 
		log.info("Welcome message : " + message);
		log.info("Welcome message2 : " + message2);
		return "home"; // 뷰 파일명
	}
}
