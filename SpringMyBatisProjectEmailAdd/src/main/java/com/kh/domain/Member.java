package com.kh.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
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
public class Member {
	private int no;
	private String id;
	private String pw;
	private String name;
	private int coin;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date regDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date updDate;
	private String enabled;
	
	// 1:N 만들기(N으로 설정하고 싶은 테이블을 List로 추가)
	private List<MemberAuth> authList;
	@Valid
	private List<MemberEmail> emailList;
}
