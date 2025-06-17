package com.kh.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int no;
	private String id;
	private String pwd;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
}
