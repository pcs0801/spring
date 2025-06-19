package com.kh.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MyBatisMember {
	private int no;
	private String id;
	private String pw;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date regDate;
}
