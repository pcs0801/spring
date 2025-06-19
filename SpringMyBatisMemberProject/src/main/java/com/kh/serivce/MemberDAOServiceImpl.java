package com.kh.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.MyBatisMember;
import com.kh.mapper.MemberDAO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void insert(MyBatisMember member) throws Exception {
		memberDAO.insert(member);
	}
	
	@Override
	public MyBatisMember select(MyBatisMember member) throws Exception {
		return memberDAO.select(member);
	}

	@Override
	public void update(MyBatisMember member) throws Exception {
		memberDAO.update(member);
	}

	@Override
	public void delete(MyBatisMember member) throws Exception {
		memberDAO.delete(member);
	}

	@Override
	public List<MyBatisMember> selectAll() throws Exception {
		return memberDAO.selectAll();
	}

}
