package louisz.springboot.example3;

//這邊要注意import的方式採用static
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.we。.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//spring boot 1.4以後的方式
@RunWith(SpringRunner.class)
@WebMvcTest(Ex3Controller.class)
public class TestEx3Controller {
	@Autowired
	private MockMvc mvc;

	/**
	 * 單元測試測試前前置設定
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new Ex3Controller()).build();
	}

	/**
	 * 測試範例三的RestController各項method
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEx3Controller() throws Exception {
		/*
		 * 撰寫單元測試的時候，先想清楚要測試的流程，例如本範例為測試新增修改刪除功能，
		 * 你可以一個一個method測試，你也可以使用先新增一筆，然後進行修改，再查詢後刪 除等，把單元測試想做一個情境會比較好進行撰寫。
		 */

		RequestBuilder request = null;
		// 我這裡設定使用post進行查詢
		// 1.測試是否回覆200的訊息，並且確認是否尚無資料
		request = post("/users/all/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
		// 2.新增一筆資料，新增成功後須回覆success的資訊
		request = post("/users/add/").param("id", "1").param("name", "Louisz").param("email", "louisz6ster@gmail.com")
				.param("mobileNumber", "0912345678");
		mvc.perform(request).andExpect(content().string(equalTo("success")));
		// 3.再進行查詢，因為只有一筆不用特別指定，確認回覆的資訊是否與預期相同
		request = post("/users/all/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo(
				"[{\"id\":1,\"name\":\"Louisz\",\"email\":\"louisz6ster@gmail.com\",\"mobileNumber\":\"0912345678\"}]")));
		// 4.修改原有資訊資料，修改成功後須回覆success的資訊
		request = post("/users/update/1").param("name", "Jessie").param("email", "louisz6ster@gmail.com")
				.param("mobileNumber", "0923456789");
		mvc.perform(request).andExpect(content().string(equalTo("success")));
		// 5.使用指定查詢進行該資料比對，確認修改的資訊是否正確
		request = post("/users/find/1");
		mvc.perform(request).andExpect(content().string(equalTo(
				"{\"id\":1,\"name\":\"Jessie\",\"email\":\"louisz6ster@gmail.com\",\"mobileNumber\":\"0923456789\"}")));

		// 6.刪除指定的資料，刪除成功後須回覆success
		request = delete("/users/remove/1");
		mvc.perform(request).andExpect(content().string(equalTo("success")));

		// 7.最後再查詢一次全部資料，須回覆空值，表示單元測試完成
		request = post("/users/all/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
	}
}
