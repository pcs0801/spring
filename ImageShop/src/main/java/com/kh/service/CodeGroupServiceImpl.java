package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.CodeGroup;
import com.kh.mapper.CodeGroupMapper;

@Service
public class CodeGroupServiceImpl implements CodeGroupService {

	@Autowired
	private CodeGroupMapper mapper;

	public void register(CodeGroup codeGroup) throws Exception {
		mapper.create(codeGroup);
	}

	@Override
	public List<CodeGroup> list() throws Exception {
		return mapper.list();
	}

	@Override
	public CodeGroup read(String groupCode) throws Exception {
		return mapper.read(groupCode);
	}

	@Override
	public void modify(CodeGroup codeGroup) throws Exception {
		mapper.update(codeGroup);
	}

	@Override
	public void remove(String groupCode) throws Exception {
		mapper.delete(groupCode);
	}
}
