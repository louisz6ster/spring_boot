package louisz.springboot.example3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user") // 上層路徑配置
public class Ex3Controller {
	//單一儲存庫
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

	/**
	 * 取得所有User清單
	 * 
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public List<User> getUserList() {
		// 取得所有User List
		return new ArrayList<User>(users.values());
	}

	/**
	 * 新增User資料，傳入User JSON資料進行新增，成功回傳success
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user) {
		// 傳入Input JSON會自動轉換為User物件
		users.put(user.getId(), user);
		return "add success";
	}

	/**
	 * 傳入id進行查詢，回傳User JSON
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/find/{id}", method = RequestMethod.POST)
	public User findUser(@PathVariable Long id) {
		// Output User會自動轉換為JSON物件
		return users.get(id);
	}

	/**
	 * 傳入id及JSON User進行資料更新
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
		// 更新User資料
		User u = users.get(id);
//		System.out.println(u.getName()+"=>"+user.getMobileNumber());
		// 使用了BeanUtils
		BeanUtils.copyProperties(user, u);
		users.put(id, u);
		return "update success";
	}

	/**
	 * 傳入id進行資料刪除，回傳success
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public String removeUser(@PathVariable Long id) {
		//刪除user資料
		users.remove(id);
		return "delete success";
	}

}
