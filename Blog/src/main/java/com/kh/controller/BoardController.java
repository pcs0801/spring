package com.kh.controller;

import com.kh.dto.BoardDTO;
import com.kh.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	// 게시글 등록
	@PostMapping
	public ResponseEntity<Long> register(@RequestBody BoardDTO boardDTO) {
		Long boardId = boardService.register(boardDTO);
		return ResponseEntity.ok(boardId);
	}

	// 게시글 조회
	@GetMapping("/{id}")
	public ResponseEntity<BoardDTO> read(@PathVariable("id") Long boardId) {
		BoardDTO dto = boardService.read(boardId);
		return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}

	// 게시글 수정
	@PutMapping("/{id}")
	public ResponseEntity<Void> modify(@PathVariable("id") Long boardId, @RequestBody BoardDTO boardDTO) {
		boardDTO.setBoardId(boardId);
		boardService.modify(boardDTO);
		return ResponseEntity.ok().build();
	}

	// 게시글 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable("id") Long boardId) {
		boardService.remove(boardId);
		return ResponseEntity.ok().build();
	}

	// 제목으로 게시글 검색
	@GetMapping("/search")
	public ResponseEntity<List<BoardDTO>> searchByTitle(@RequestParam("title") String title) {
		List<BoardDTO> results = boardService.findByTitle(title);
		return ResponseEntity.ok(results);
	}
}
