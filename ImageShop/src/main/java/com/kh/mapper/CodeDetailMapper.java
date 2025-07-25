package com.kh.mapper;

import java.util.List;

import com.kh.domain.CodeDetail;

public interface CodeDetailMapper {

	public void create(CodeDetail codeDetail) throws Exception;

	public Integer getMaxSortSeq(String groupCode) throws Exception;

	public List<CodeDetail> list() throws Exception;

	public CodeDetail read(CodeDetail codeDetail) throws Exception;

	public void update(CodeDetail codeDetail) throws Exception;

	public void delete(CodeDetail codeDetail) throws Exception;
}