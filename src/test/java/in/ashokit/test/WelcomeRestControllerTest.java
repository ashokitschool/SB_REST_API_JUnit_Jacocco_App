package in.ashokit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.ashokit.rest.WelcomeRestController;
import in.ashokit.service.WelcomeService;

@WebMvcTest(value = WelcomeRestController.class)
public class WelcomeRestControllerTest {

	@MockBean
	private WelcomeService service;

	@Autowired
	private MockMvc mvc;

	@Test
	public void testGetWelcomeMsg() throws Exception {
		
		// define mock obj behaviour
		when(service.getMsg()).thenReturn("Welcome to Ashok IT..!!");
		
		// prepare http get request
		MockHttpServletRequestBuilder reqBuilder = 
				MockMvcRequestBuilders.get("/welcome");
		
		// send request & hold response
		MvcResult mvcResult = mvc.perform(reqBuilder).andReturn();
		
		// validate response
		MockHttpServletResponse response = mvcResult.getResponse();
		
		//String contentAsString = response.getContentAsString();
		
		int status = response.getStatus();
		assertEquals(200, status);
		
	}
	
	@Test
	public void testGetGreetMsg() throws Exception {
		
		// define mock obj behaviour
		when(service.getGreetMsg()).thenReturn("Hello");
		
		// prepare http get request
		MockHttpServletRequestBuilder reqBuilder = 
				MockMvcRequestBuilders.get("/greet");
		
		// send request & hold response
		MvcResult mvcResult = mvc.perform(reqBuilder).andReturn();
		
		// validate response
		MockHttpServletResponse response = mvcResult.getResponse();
		
		int status = response.getStatus();
		assertEquals(200, status);
	}
}
