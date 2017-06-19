package louisz.springboot.example2;

//採用的是slf4j外框
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex2Controller {
	//請注意不要用static，才能使用this.getClass
	 private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	 //log level 設定為debug
	@RequestMapping("/log_debug")
    public String debug() {
		logger.debug("This is debug msg.");		
        return "debug level";
    } 
	 //log level 設定為info
	@RequestMapping("/log_info")
    public String info() {
		logger.info("This is info msg.");		
        return "info level";
    } 
	 //log level 設定為error
	@RequestMapping("/log_error")
    public String error() {
		logger.debug("This is error msg.");		
        return "error level";
    } 
	
	
}
