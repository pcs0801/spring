package com.kh;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.mallapi.MallapiApplication;
import com.kh.mallapi.domain.Todo;
import com.kh.mallapi.repository.TodoRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest(classes = MallapiApplication.class)
@Log4j2
class MallapiApplicationTests {
	@Autowired
	private TodoRepository todoRepository;
	@Test
	void contextLoads() {
		for(int i = 1; i <= 100; i++) {
			Todo todo = Todo.builder()
					.title("Title"+i)
					.dueDate(LocalDate.of(2025, 7, 15))
					.writer("텔레토비")
					.build();
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
		todo.changeDueDate(LocalDate.of(2025,7,7));
		todoRepository.save(todo);
	}
	
	@Test
	void testDelete() {
		Long tno = 20L;
		todoRepository.deleteById(tno);
	}

}
