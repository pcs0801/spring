package com.kh.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AOPMember {
	private int no;
	private String id;
	private String pw;
	private String name;
	private Date regDate;
}