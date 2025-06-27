package com.kh.service;

import java.util.List;

import com.kh.domain.CodeGroup;

public interface CodeGroupService {
	public void register(CodeGroup codeGroup) throws Exception;

	public List<CodeGroup> list() throws Exception;

	public CodeGroup read(String groupCode) throws Exception;

	public void modify(CodeGroup codeGroup) throws Exception;

	public void remove(String groupCode) throws Exception;
	
	
}
