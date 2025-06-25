package com.kh.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
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
public class MyBatisBoard {
	private int no;
	@NotBlank
	private String title;
	private String content;
	private String writer;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date regDate;
}
