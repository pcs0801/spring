package com.kh.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Board;
import com.kh.domain.Member;
import com.kh.dto.BoardDTO;
import com.kh.dto.MemberDTO;
import com.kh.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;

	// 게시글 등록
	@Override
	@Transactional
	public Long register(BoardDTO boardDTO) {
		Board board = dtoToEntity(boardDTO);
		boardRepository.save(board);
		return board.getBoardId();
	}

	// 게시글 조회
	@Override
	public BoardDTO read(Long boardId) {
		Board board = boardRepository.findById(boardId).orElse(null);
		return board != null ? entityToDTO(board) : null;
	}

	// 게시글 수정
	@Override
	@Transactional
	public void modify(BoardDTO boardDTO) {
		Board board = boardRepository.findById(boardDTO.getBoardId()).orElse(null);
		if (board != null) {
			board.setTitle(boardDTO.getTitle());
			board.setContent(boardDTO.getContent());
			board.setUpdatedDate(boardDTO.getUpdatedDate());
			boardRepository.save(board);
		}
	}

	// 게시글 삭제
	@Override
	@Transactional
	public void remove(Long boardId) {
		boardRepository.deleteById(boardId);
	}

	// 제목 검색
	@Override
	public List<BoardDTO> findByTitle(String title) {
		List<Board> result = boardRepository.findByTitle(title);
		return result.stream().map(this::entityToDTO).collect(Collectors.toList());
	}

	// 제목 + 내용 검색
	@Override
	public List<BoardDTO> findByTitleAndContent(String title, String content) {
		List<Board> result = boardRepository.findByTitleAndContent(title, content);
		return result.stream().map(this::entityToDTO).collect(Collectors.toList());
	}

	// 작성자 닉네임 검색
	@Override
	public List<BoardDTO> findByMemberNickname(String nickname) {
		List<Board> result = boardRepository.findByMemberNickname(nickname);
		return result.stream().map(this::entityToDTO).collect(Collectors.toList());
	}

	// DTO → Entity
	private Board dtoToEntity(BoardDTO dto) {
		return Board.builder().boardId(dto.getBoardId()).title(dto.getTitle()).content(dto.getContent())
				.writingDate(dto.getWritingDate()).updatedDate(dto.getUpdatedDate()).member(Member.builder()
						.nickname(dto.getMember().getNickname()).email(dto.getMember().getEmail()).build())
				.build();
	}

	// Entity → DTO
	private BoardDTO entityToDTO(Board board) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setEmail(board.getMember().getEmail());
		memberDTO.setNickname(board.getMember().getNickname());
		memberDTO.setRole(board.getMember().getRole());
		memberDTO.setRegDate(board.getMember().getRegDate());

		BoardDTO dto = new BoardDTO();
		dto.setBoardId(board.getBoardId());
		dto.setTitle(board.getTitle());
		dto.setContent(board.getContent());
		dto.setWritingDate(board.getWritingDate());
		dto.setUpdatedDate(board.getUpdatedDate());
		dto.setMember(memberDTO);

		return dto;
	}

}
