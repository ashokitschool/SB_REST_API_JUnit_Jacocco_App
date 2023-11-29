package in.ashokit.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl implements MessageDao {

	@Override
	public String getMsg() {
		return "hi";
	}

}
