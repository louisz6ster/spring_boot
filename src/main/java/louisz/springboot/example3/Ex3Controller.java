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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/user") // 上層路徑配置
@Api(value = "User Function", description = "操作User的RESTful 線上文件說明") // 最上層的說明																	
public class Ex3Controller {
	// 單一儲存庫
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

	/**
	 * 取得所有User清單
	 * 
	 * @return
	 */
	@ApiOperation(value = "取得所有User清單", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "正常回覆"), @ApiResponse(code = 401, message = "你尚未驗證通過"),
			@ApiResponse(code = 403, message = "你沒有權限可以使用該功能"), @ApiResponse(code = 404, message = "URL錯誤") })
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
	@ApiOperation(value = "新增一筆User的資料", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "正常回覆"), @ApiResponse(code = 401, message = "你尚未驗證通過"),
			@ApiResponse(code = 403, message = "你沒有權限可以使用該功能"), @ApiResponse(code = 404, message = "URL錯誤") })
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
	@ApiOperation(value = "透過ID查詢User資料", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "正常回覆"), @ApiResponse(code = 401, message = "你尚未驗證通過"),
			@ApiResponse(code = 403, message = "你沒有權限可以使用該功能"), @ApiResponse(code = 404, message = "URL錯誤") })
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
	@ApiOperation(value = "更新特定User資料", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "正常回覆"), @ApiResponse(code = 401, message = "你尚未驗證通過"),
			@ApiResponse(code = 403, message = "你沒有權限可以使用該功能"), @ApiResponse(code = 404, message = "URL錯誤") })
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
		// 更新User資料
		User u = users.get(id);
		// System.out.println(u.getName()+"=>"+user.getMobileNumber());
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
	@ApiOperation(value = "刪除特定User資料", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "正常回覆"), @ApiResponse(code = 401, message = "你尚未驗證通過"),
			@ApiResponse(code = 403, message = "你沒有權限可以使用該功能"), @ApiResponse(code = 404, message = "URL錯誤") })
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public String removeUser(@PathVariable Long id) {
		// 刪除user資料
		users.remove(id);
		return "delete success";
	}

}
