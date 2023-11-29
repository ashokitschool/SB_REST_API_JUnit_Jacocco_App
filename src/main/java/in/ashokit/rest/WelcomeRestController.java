package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.WelcomeService;

@RestController
public class WelcomeRestController {

	@Autowired
	private WelcomeService service;

	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcomeMsg() {
		String msg = service.getMsg();
		msg = msg.toUpperCase();
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/greet")
	public ResponseEntity<String> getGreetMsg() {
		String msg = service.getGreetMsg();
		msg = msg.toUpperCase();
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
