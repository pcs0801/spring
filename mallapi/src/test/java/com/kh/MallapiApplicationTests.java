package com.kh;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.kh.mallapi.MallapiApplication;
import com.kh.mallapi.domain.Todo;
import com.kh.mallapi.dto.PageRequestDTO;
import com.kh.mallapi.dto.PageResponseDTO;
import com.kh.mallapi.dto.TodoDTO;
import com.kh.mallapi.repository.TodoRepository;
import com.kh.mallapi.service.TodoService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest(classes = MallapiApplication.class)
@Log4j2
class MallapiApplicationTests {
	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private TodoService todoService;

	@Test
	void contextLoads() {
		for (int i = 1; i <= 100; i++) {
			Todo todo = Todo.builder().title("Title" + i).dueDate(LocalDate.of(2025, 7, 15)).writer("텔레토비").build();
			todoRepository.save(todo);
		}

	}

	@Test
	void testRead() {
		Long tno = 20L;
		Optional<Todo> result = todoRepository.findById(tno);
		Todo todo = result.orElseThrow();
		log.info(todo);
	}

	@Test
	void testModify() {
		Long tno = 20L;
		Optional<Todo> result = todoRepository.findById(tno);
		Todo todo = result.orElseThrow();
		todo.changeComplete(true);
		todo.changeWriter("보라돌이");
		todo.changeDueDate(LocalDate.of(2025, 7, 7));
		todoRepository.save(todo);
	}

	@Test
	void testDelete() {
		Long tno = 20L;
		todoRepository.deleteById(tno);
	}

	@Test
	void testPaging() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());
		Page<Todo> result = todoRepository.findAll(pageable);
		log.info(result.getTotalElements());
		result.getContent().stream().forEach(todo -> log.info(todo));
	}

	@Test
	void testRegister() {
		TodoDTO todoDTO = TodoDTO.builder().title("뚜비").writer("나나").dueDate(LocalDate.of(2025, 7, 16)).build();
		Long tno = todoService.register(todoDTO);
		log.info(tno);
	}

	@Test
	void testGet() {
		Long tno = 501L;
		TodoDTO todoDTO = TodoDTO.builder().tno(tno).build();
		TodoDTO _todoDTO = todoService.get(todoDTO);
		log.info(_todoDTO);
	}
	
	@Test
	void testNumber() {
		List<Integer> listInteger = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
	}
	
	@Test
	void testList() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(2).size(10).build();
		PageResponseDTO<TodoDTO> response = todoService.list(pageRequestDTO);
		log.info(response);
	}

}
