package louisz.springboot.example6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Louisz Spring boot introduce ex.6
 *
 */

@SpringBootApplication
@PropertySource(name = "EncryptedProperties", value = "classpath:example5.properties")//針對需加解密的設定檔檔名及位置
@EntityScan(basePackages = {"louisz.springboot.example6"})//載入指定package的entity
@EnableJpaRepositories(basePackages = {"louisz.springboot.example6"})//載入指定package jpaRepositories
@EnableTransactionManagement//啟動交易模式
public class Example6 {
	/**
	 * 程式執行起點
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Example6.class, args);
	}

}
