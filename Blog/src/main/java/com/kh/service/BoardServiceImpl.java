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
import com.kh.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	private final MemberRepository memberRepository;

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

	@Override
	public List<BoardDTO> findAll() {
	    List<Board> result = boardRepository.findAll();
	    return result.stream().map(this::entityToDTO).collect(Collectors.toList());
	}
	
	private Board dtoToEntity(BoardDTO dto) {
		// 이메일로 DB에서 Member 엔티티 조회
		Member member = memberRepository.findByEmail(dto.getMember().getEmail());
		if (member == null) {
			throw new RuntimeException("해당 이메일의 회원이 존재하지 않습니다: " + dto.getMember().getEmail());
		}

		return Board.builder().boardId(dto.getBoardId()).title(dto.getTitle()).content(dto.getContent())
				.writingDate(dto.getWritingDate()) // 일반적으로 생략해도 됨 (DB에서 자동 생성)
				.updatedDate(dto.getUpdatedDate()) // 마찬가지로 생략 가능
				.member(member) // 실제 존재하는 Member 엔티티 연결
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
