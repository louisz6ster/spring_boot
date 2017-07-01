package louisz.springboot.example5;

import java.util.List;

import louisz.springboot.example3.User;

public interface UserService {
	/**
	 * 新增一筆User資料
	 * 
	 * @param User
	 */
	void merge(User user);

	/**
	 * 刪除傳入相同姓名的資料
	 * 
	 * @param name
	 */
	void deleteByName(String name);

	/**
	 * 查詢所有資料，並回傳List物件
	 */
	List<User> listAll();

	/**
	 * 查詢特定id資料，並回該User Object
	 */
	
	User findById(Long id);
	
	/**
	 * 删除所有用户
	 */
	void deleteAllUsers();

	/**
	 * 依據傳入的id，依據傳入的User物件，更新資料表中相同id的資料
	 * 
	 * @param id
	 * @param user
	 */
	void updateUser(Long id, User user);
}
