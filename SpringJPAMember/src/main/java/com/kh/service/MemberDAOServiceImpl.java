package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Member;
import com.kh.persistence.MemberRepository;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {
	//의존성 주입
	@Autowired
	private MemberRepository memberRepository;

	@Override
	@Transactional
	public void insert(Member member) throws Exception {
		memberRepository.save(member);
	}

	@Override
	public Member select(Member member) throws Exception {
		return memberRepository.getReferenceById(member.getNo());
	}

	@Override
	@Transactional
	public void update(Member member) throws Exception {
		Member memberEntity = memberRepository.getReferenceById(member.getNo());
		memberEntity.setId(member.getId());
		memberEntity.setPw(member.getPw());
		memberEntity.setName(member.getName());
	}

	@Override
	@Transactional
	public void delete(Member member) throws Exception {
		memberRepository.deleteById(member.getNo());
	}

	@Override
	public List<Member> selectAll() throws Exception {
		return memberRepository.findAll(Sort.by(Direction.DESC,"no"));
	}

}
