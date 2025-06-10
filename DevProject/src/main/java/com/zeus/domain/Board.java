package com.zeus.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "content")
@EqualsAndHashCode(of = {"boardNo","title"})
public class Board{
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	
}