package louisz.springboot.example4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


//spring boot 1.4以後的方式
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TestExampleProperties {
	@Autowired
	private ExampleProperties exampleProperties;//注入
	
	@Test
	public void getHello() throws Exception {
		//驗證是否符合預期
		Assert.assertEquals(exampleProperties.getName(), "example4");
		Assert.assertEquals(exampleProperties.getVersion(), "1");
		Assert.assertEquals(exampleProperties.getNameversion(), "example4_1");
		System.out.println(exampleProperties.getIntvalue());
		System.out.println(exampleProperties.getTwentyvalue());
	}
	
}
