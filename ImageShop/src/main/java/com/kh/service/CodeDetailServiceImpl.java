package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.CodeDetail;
import com.kh.mapper.CodeDetailMapper;

@Service
public class CodeDetailServiceImpl implements CodeDetailService {

	@Autowired
	private CodeDetailMapper mapper;

	@Override
	public void register(CodeDetail codeDetail) throws Exception {
		String groupCode = codeDetail.getGroupCode();
		int maxSortSeq = mapper.getMaxSortSeq(groupCode);
		System.out.println("groupCode : " + groupCode);
		System.out.println("maxSortSeq : " + maxSortSeq);
		codeDetail.setSortSeq(maxSortSeq + 1);
		System.out.println("codeDetail : " + codeDetail.toString());
		mapper.create(codeDetail);
	}

	@Override
	public List<CodeDetail> list() throws Exception {
		return mapper.list();
	}

	@Override
	public CodeDetail read(CodeDetail codeDetail) throws Exception {
		return mapper.read(codeDetail);
	}

	@Override
	public void modify(CodeDetail codeDetail) throws Exception {
		mapper.update(codeDetail);
	}

	@Override
	public void remove(CodeDetail codeDetail) throws Exception {
		mapper.delete(codeDetail);
	}
}
