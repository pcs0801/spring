package com.kh.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
	private Long boardId;
	private MemberDTO member;
	private String title;
	private String content;
	private LocalDateTime writingDate;
	private LocalDateTime updatedDate;
}