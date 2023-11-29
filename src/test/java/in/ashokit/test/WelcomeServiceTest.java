package in.ashokit.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import in.ashokit.dao.MessageDao;
import in.ashokit.service.WelcomeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class WelcomeServiceTest {

	@MockBean
	private MessageDao dao;

	@InjectMocks
	private WelcomeService service;

	@Test
	public void testGetGreetMsg() {
		when(dao.getMsg()).thenReturn("Good Morning..!!");
		String greetMsg = service.getGreetMsg();
		assertNotNull(greetMsg);
	}

	@Test
	public void testGetMsg() {
		when(dao.getMsg()).thenReturn("Welcome to Ashok IT..!!");
		String msg = service.getMsg();
		assertNotNull(msg);
	}
}