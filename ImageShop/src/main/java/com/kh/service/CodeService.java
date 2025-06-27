package com.kh.service;

import java.util.List;

import com.kh.common.CodeLabelValue;

public interface CodeService {

	public List<CodeLabelValue> getCodeGroupList() throws Exception;

	public List<CodeLabelValue> getCodeList(String groupCode) throws Exception;

}
