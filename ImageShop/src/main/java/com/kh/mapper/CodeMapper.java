package com.kh.mapper;

import java.util.List;

import com.kh.common.CodeLabelValue;

public interface CodeMapper {

	public List<CodeLabelValue> getCodeGroupList() throws Exception;

	public List<CodeLabelValue> getCodeList(String groupCode) throws Exception;

	}
