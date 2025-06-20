package com.kh.domain;

import jakarta.validation.constraints.Pattern;
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
public class MemberEmail {
	private int no;
	@Pattern(regexp = "^$|^[a-zA-Z0-9가-힣._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "이메일 형식이 올바르지 않습니다. ex) example@email.com")
	private String email;

}
