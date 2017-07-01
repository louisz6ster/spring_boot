package louisz.springboot.example5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import louisz.springboot.example3.User;

//spring boot 1.4以後的方式
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestUserServiceImpl {

	@Autowired
	private UserService userSerivce;// 注入UserService
									// interface，實際instance會呼叫UserServiceImpl物件

	@Before
	public void setUp() {
		// 先清除所有資料
		userSerivce.deleteAllUsers();
	}

	@Test
	public void test() throws Exception {
		/*
		 * 進行單元測試，先規劃相關情境
		 */
		User user1 = new User();
		user1.setId(1l);
		user1.setEmail("louisz6ster@gmail.com");
		user1.setName("user1");
		user1.setMobilenumber("0912345678");

		User user2 = new User();
		user2.setId(2l);
		user2.setEmail("louisz6ster@gmail.com");
		user2.setName("user2");
		user2.setMobilenumber("0912345678");

		User user3 = new User();
		user3.setId(3l);
		user3.setEmail("louisz6ster@gmail.com");
		user3.setName("user3");
		user3.setMobilenumber("0912345678");
		// 新增三個User資料
		userSerivce.merge(user1);
		userSerivce.merge(user2);
		userSerivce.merge(user3);

		// 查詢全部資料筆數是否吻合，確認新增成功
		Assert.assertEquals(3, userSerivce.listAll().size());
		// 刪除資料
		userSerivce.deleteByName("user1");
		userSerivce.deleteByName("user2");
		// 查詢全部資料筆數是否吻合，確認刪除成功
		Assert.assertEquals(1, userSerivce.listAll().size());
		
		//更新User3姓名跟email
		user3.setName("Jessie");
		userSerivce.updateUser(user3.getId(), user3);
		
		//查詢資料表中User3的資料是否更新成功
		User newUser3 = userSerivce.findById(user3.getId());
		Assert.assertEquals(user3.getName(), newUser3.getName());
		
	}

}
