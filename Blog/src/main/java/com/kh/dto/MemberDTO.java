package com.kh.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

	private String name;
	private String email;
	private String nickname;
	private String password;
	private String role;
	private LocalDateTime regDate;
}