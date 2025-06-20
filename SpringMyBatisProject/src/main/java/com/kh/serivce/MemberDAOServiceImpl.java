package com.kh.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;
import com.kh.mapper.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	@Transactional
	public void insert(Member member) throws Exception {
		// 유저 입력
		memberDAO.insert(member);

		// 유저 권한 객체 생성
		MemberAuth memberAuth = new MemberAuth();

		// 유저 권한 설정
		memberAuth.setNo(member.getNo());
		memberAuth.setAuth("ROLE_USER");

		// 유저 권한 입력
		memberDAO.insertAuth(memberAuth);
	}

	@Override
	@Transactional
	public void insertAuth(MemberAuth memberAuth) throws Exception {
		memberDAO.insertAuth(memberAuth);
	}

	@Override
	public List<Member> selectAll() throws Exception {
		return memberDAO.selectAll();
	}

	@Override
	public Member selectJoin(Member member) throws Exception {
		return memberDAO.selectJoin(member);
	}

	@Override
	@Transactional
	public void update(Member member) throws Exception {
		memberDAO.update(member);

		int no = member.getNo();
		memberDAO.deleteAuth(member);
		List<MemberAuth> authList = member.getAuthList();
		for (int i = 0; i < authList.size(); i++) {
			MemberAuth memberAuth = authList.get(i);
			String auth = memberAuth.getAuth();
			if (auth == null) {
				continue;
			}
			if (auth.trim().length() == 0) {
				continue;
			}
			memberAuth.setNo(member.getNo());
			memberDAO.insertAuth(memberAuth);
		}
	}

	@Override
	@Transactional
	public void delete(Member member) throws Exception {
		memberDAO.deleteAuth(member);
		memberDAO.delete(member);

	}

	@Override
	@Transactional
	public void deleteAuth(Member member) throws Exception {
		memberDAO.deleteAuth(member);

	}

}
