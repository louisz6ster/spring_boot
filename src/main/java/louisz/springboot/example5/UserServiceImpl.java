package louisz.springboot.example5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import louisz.springboot.example3.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void merge(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into USER(id,name,email.mobileNumber) values(?, ?,?,?)", 
				user.getId(),
				user.getName(),
				user.getEmail(),
				user.getMobileNumber());
	}

	@Override
	public void deleteByName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(Long id, User user) {
		// TODO Auto-generated method stub

	}

}
