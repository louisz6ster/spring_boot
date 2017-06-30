package louisz.springboot.example5;

import java.util.List;

import louisz.springboot.example3.User;

public interface UserService {
	/**
	 * 新增一个用户
	 * 
	 * @param name
	 * @param age
	 */
	void merge(User user);

	/**
	 * 根据name删除一个用户高
	 * 
	 * @param name
	 */
	void deleteByName(String name);

	/**
	 * 获取用户总量
	 */
	List<User> listAll();

	/**
	 * 删除所有用户
	 */
	void deleteAllUsers();
	
	void updateUser(Long id,User user);
}
