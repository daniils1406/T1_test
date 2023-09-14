package com.example.test;

import com.example.test.controller.impl.TaskController;
import com.example.test.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class TestApplicationTests {

	@Autowired
	TaskController taskController;

	@Autowired
	TaskService taskService;

	@Autowired
	MockMvc mockMvc;


	@Test
	void testString() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test")
				.param("string","aaaaabcccc")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.content().json("{\n" +
						"    \"a\": 5,\n" +
						"    \"c\": 4,\n" +
						"    \"b\": 1\n" +
						"}"));
	}

	@Test
	void testStringWithWhitespace() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test")
						.param("string","a b c ssd a")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.content().json("{\n" +
						"    \"a\": 2,\n" +
						"    \"s\": 2,\n" +
						"    \"b\": 1,\n" +
						"    \"c\": 1,\n" +
						"    \"d\": 1\n" +
						"}"));
	}


	@Test
	void testEmptyString() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test")
						.param("string","")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.content().json("{\n" +
						"    \"endpoint\": \"/test\",\n" +
						"    \"message\": \"countStringChars.arg0: must not be blank\",\n" +
						"    \"exceptionName\": \"ConstraintViolationException\"\n" +
						"}"));
	}
}
