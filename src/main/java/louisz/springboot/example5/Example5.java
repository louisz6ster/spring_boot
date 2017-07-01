package louisz.springboot.example5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Louisz Spring boot introduce ex.5
 *
 */

@SpringBootApplication
@PropertySource(name = "EncryptedProperties", value = "classpath:example5.properties")//針對需加解密的設定檔檔名及位置
public class Example5 {
	/**
	 * 程式執行起點
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Example5.class, args);

	}

}
