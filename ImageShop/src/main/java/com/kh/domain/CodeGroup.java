package com.kh.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeGroup {
	private String groupCode;
	private String groupName;
	private String useYn;
	private Date regDate;
	private Date updDate;
}