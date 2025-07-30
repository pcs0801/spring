package com.kh.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Member;
import com.kh.dto.MemberDTO;
import com.kh.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	// 회원가입
	@Override
	@Transactional
	public Long register(MemberDTO memberDTO) {
		Member member = dtoToEntity(memberDTO);
		memberRepository.save(member);
		return member.getMemberId();
	}

	// 회원 조회 (이메일 기준)
	@Override
	public MemberDTO read(String email) {
		Member member = memberRepository.findByEmail(email);
		return member != null ? entityToDTO(member) : null;
	}

	// 회원 정보 수정
	@Override
	@Transactional
	public void modify(MemberDTO memberDTO) {
		Member member = memberRepository.findByEmail(memberDTO.getEmail());
		if (member != null) {
			member.setPassword(memberDTO.getPassword());
			member.setNickname(memberDTO.getNickname());
			memberRepository.save(member);
		}
	}

	// 회원 삭제
	@Override
	@Transactional
	public void remove(String email) {
		Member member = memberRepository.findByEmail(email);
		if (member != null) {
			memberRepository.delete(member);
		}
	}

	// 이메일 중복 체크
	@Override
	public boolean existsByEmail(String email) {
		return memberRepository.existsByEmail(email);
	}

	// 로그인 (이메일 + 비밀번호 확인)
	@Override
	public MemberDTO login(String email, String password) {
		Member member = memberRepository.findByEmail(email);
		if (member != null && member.getPassword().equals(password)) {
			return entityToDTO(member);
		}
		return null;
	}

	// DTO → Entity 변환
	private Member dtoToEntity(MemberDTO dto) {
		return Member.builder().email(dto.getEmail()).password(dto.getPassword()).nickname(dto.getNickname())
				.name(dto.getName()).role(dto.getRole()).build();
	}

	// Entity → DTO 변환
	private MemberDTO entityToDTO(Member member) {
		MemberDTO dto = new MemberDTO();
		dto.setEmail(member.getEmail());
		dto.setPassword(member.getPassword());
		dto.setNickname(member.getNickname());
		return dto;
	}
}