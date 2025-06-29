package com.kh.service;

import java.util.List;

import com.kh.common.domain.CodeLabelValue;

public interface CodeService {

	public List<CodeLabelValue> getCodeGroupList() throws Exception;

	public List<CodeLabelValue> getCodeList(String groupCode) throws Exception;

}
