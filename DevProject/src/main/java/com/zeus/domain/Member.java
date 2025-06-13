package com.zeus.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member{
	private String userId;
	private String password;
	// Data 타입 필드 변환 처리
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date dateOfBirth;
	private List<String> nationality;
	private Board board;
	
}