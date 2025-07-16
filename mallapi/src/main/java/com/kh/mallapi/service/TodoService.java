package com.kh.mallapi.service;

import com.kh.mallapi.dto.PageRequestDTO;
import com.kh.mallapi.dto.PageResponseDTO;
import com.kh.mallapi.dto.TodoDTO;

public interface TodoService {
	public Long register(TodoDTO todoDTO);

	public TodoDTO get(TodoDTO todoDTO);

	public void modify(TodoDTO todoDTO);

	public void remove(TodoDTO todoDTO);
	
	public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);

}
