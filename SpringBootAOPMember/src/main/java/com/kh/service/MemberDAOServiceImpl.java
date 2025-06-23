package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.AOPMember;
import com.kh.mapper.MemberDAO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {
	//의존성 주입
	@Autowired
	private MemberDAO memberDAO;

	@Override
	@Transactional
	public void insert(AOPMember member) throws Exception {
		memberDAO.insert(member);
	}

	@Override
	public AOPMember select(AOPMember member) throws Exception {
		return memberDAO.select(member);
	}

	@Override
	@Transactional
	public void update(AOPMember member) throws Exception {
		memberDAO.update(member);
	}

	@Override
	@Transactional
	public void delete(AOPMember member) throws Exception {
		memberDAO.delete(member);
	}

	@Override
	public List<AOPMember> selectAll() throws Exception {
		return memberDAO.selectAll();
	}

}
