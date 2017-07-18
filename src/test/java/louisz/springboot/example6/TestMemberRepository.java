package louisz.springboot.example6;

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
public class TestMemberRepository {

	@Autowired
	private MemberRepository memberRepository;

	@Before
	public void setUp() {
		// 先清除所有資料
		memberRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {
		/*
		 * 進行單元測試，先規劃相關情境
		 */
		// 先確認是否清除完成
		Assert.assertEquals(0, memberRepository.findAll().size());
		// 新增一筆資料
		Member m = new Member();
		m.setId(1l);
		m.setAge(new Integer(12));
		m.setName("louisz");
		memberRepository.save(m);
		// 確認新增資料筆數
		Assert.assertEquals(1, memberRepository.findAll().size());
		// 檢查新增的資料是否正確
		Assert.assertEquals(12, memberRepository.findByName("louisz").getAge().longValue());
		// 修改姓名
		m.setName("jessie");
		memberRepository.save(m);
		// 檢查新增的資料是否正確
		Assert.assertEquals("jessie", memberRepository.findById(1l).getName());
		// 刪除新增的資料
		memberRepository.delete(memberRepository.findById(1l));
		// 確認刪除資料筆數
		Assert.assertEquals(0, memberRepository.findAll().size());
	}

}
