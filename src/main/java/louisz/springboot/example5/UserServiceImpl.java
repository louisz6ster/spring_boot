package louisz.springboot.example5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import louisz.springboot.example3.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void merge(User user) {
		jdbcTemplate.update("insert into users(id,name,email,mobilenumber) values(?, ?,?,?)", user.getId(),
				user.getName(), user.getEmail(), user.getMobilenumber());
	}

	@Override
	public void deleteByName(String name) {
		jdbcTemplate.update("delete from users where name = ?", name);
	}

	@Override
	public List<User> listAll() {
		return jdbcTemplate.query("select * from users", new BeanPropertyRowMapper(User.class));
	}

	@Override
	public void deleteAllUsers() {
		jdbcTemplate.update("delete from users ");
	}

	@Override
	public void updateUser(Long id, User user) {
		jdbcTemplate.update("update users set name = ? where id = ?", user.getName(), id);
	}

	@Override
	public User findById(Long id) {
		return (User)jdbcTemplate.queryForObject(
				"select * from users where id = ?", new Object[] { id },
				new BeanPropertyRowMapper(User.class));
	}

}
