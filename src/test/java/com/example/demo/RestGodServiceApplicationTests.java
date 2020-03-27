package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = GodController.class)
public class RestGodServiceApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private GodController godController;
	
	@MockBean
	private GodService godService;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(godController).build();
	}
	
	@Test
	public void whenValidInputGreek_thenReturns200() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/gods?nationality=greek")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		verify(godService, times(1)).getGod("greek");
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void whenValidInputRoman_thenReturns200() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/gods?nationality=roman")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		verify(godService, times(1)).getGod("roman");
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void whenValidInputNordic_Returns200() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/gods?nationality=nordic")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		verify(godService, times(1)).getGod("nordic");
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
