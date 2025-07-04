package com.kh.service;

import java.util.List;

import com.kh.domain.CodeDetail;

public interface CodeDetailService {
	
	public void register(CodeDetail codeDetail) throws Exception;

	public List<CodeDetail> list() throws Exception;

	public CodeDetail read(CodeDetail codeDetail) throws Exception;

	public void modify(CodeDetail codeDetail) throws Exception;

	public void remove(CodeDetail codeDetail) throws Exception;
}
