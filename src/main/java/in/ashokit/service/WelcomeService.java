package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dao.MessageDao;

@Service
public class WelcomeService {

	@Autowired
	private MessageDao dao;

	public String getMsg() {
		String msg = dao.getMsg();
		return msg;
	}

	public String getGreetMsg() {
		String msg = dao.getMsg();
		return msg;
	}

}
