package com.kh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.dto.MemberDTO;
import com.kh.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	// 회원 등록 (가입)
	@PostMapping("/register")
	public ResponseEntity<Long> register(@RequestBody MemberDTO memberDTO) {
		Long memberId = memberService.register(memberDTO);
		return ResponseEntity.ok(memberId);
	}

	// 회원 조회 (이메일 기준)
	@GetMapping("/{email}")
	public ResponseEntity<MemberDTO> read(@PathVariable String email) {
		MemberDTO dto = memberService.read(email);
		return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}

	// 회원 수정
	@PutMapping("/{email}")
	public ResponseEntity<Void> modify(@PathVariable String email, @RequestBody MemberDTO memberDTO) {
		memberDTO.setEmail(email);
		memberService.modify(memberDTO);
		return ResponseEntity.ok().build();
	}

	// 회원 삭제
	@DeleteMapping("/{email}")
	public ResponseEntity<Void> remove(@PathVariable String email) {
		memberService.remove(email);
		return ResponseEntity.ok().build();
	}

	// 이메일 중복 체크
	@GetMapping("/exists/{email}")
	public ResponseEntity<Boolean> exists(@PathVariable String email) {
		boolean result = memberService.existsByEmail(email);
		return ResponseEntity.ok(result);
	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<MemberDTO> login(@RequestBody MemberDTO memberDTO) {
		MemberDTO dto = memberService.login(memberDTO.getEmail(), memberDTO.getPassword());
		return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.status(401).build();
	}
}
