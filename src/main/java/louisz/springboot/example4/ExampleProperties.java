package louisz.springboot.example4;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component // DI之後介紹
@PropertySource("classpath:example4.properties") //設定自訂的設定檔檔名及路徑
@ConfigurationProperties("app") //prefix
public class ExampleProperties {
	//@Value("${app.name}") 也可以採用這種方式，這樣name可以不用相同，但是不建議
	//，因為後續不好維護
	private String name;
	
	private String version;
	
	private String nameversion;
	
	private String stringvalue;
	private int intvalue;
	private long longvalue;
	private int tenvalue;
	private int twentyvalue;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getNameversion() {
		return nameversion;
	}
	public void setNameversion(String nameversion) {
		this.nameversion = nameversion;
	}
	public String getStringvalue() {
		return stringvalue;
	}
	public void setStringvalue(String stringvalue) {
		this.stringvalue = stringvalue;
	}
	public int getIntvalue() {
		return intvalue;
	}
	public void setIntvalue(int intvalue) {
		this.intvalue = intvalue;
	}
	public long getLongvalue() {
		return longvalue;
	}
	public void setLongvalue(long longvalue) {
		this.longvalue = longvalue;
	}
	public int getTenvalue() {
		return tenvalue;
	}
	public void setTenvalue(int tenvalue) {
		this.tenvalue = tenvalue;
	}
	public int getTwentyvalue() {
		return twentyvalue;
	}
	public void setTwentyvalue(int twentyvalue) {
		this.twentyvalue = twentyvalue;
	}

	
}
