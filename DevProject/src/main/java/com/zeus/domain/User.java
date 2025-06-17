package com.zeus.domain;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User{
	private String userId;
	private String userName;
	private String userPassword;
	private String introduction;
	private ArrayList<String> cbList;
	
}