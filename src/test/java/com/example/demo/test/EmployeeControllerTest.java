package com.example.demo.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;  // ✅ CORRECT
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.EmployeeController;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@SuppressWarnings("removal")
	@MockBean
	private EmployeeService service;

	@Test
	void testCreate() throws Exception {
		Employee e = new Employee(1, "amol", "HR", 50000);
		when(service.save(any())).thenReturn(e);

		mockMvc.perform(post("/api/employees").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"amol\",\"department\":\"HR\",\"salary\":50000}")).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("amol"));
	}

}
