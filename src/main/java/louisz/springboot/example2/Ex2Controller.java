package louisz.springboot.example2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex2Controller {
	//請注意不要用static，才能使用this.getClass
	 private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@RequestMapping("/log_debug")
    public String debug() {
		logger.debug("This is debug msg.");		
        return "debug level";
    } 
	
	@RequestMapping("/log_info")
    public String info() {
		logger.info("This is info msg.");		
        return "info level";
    } 
	@RequestMapping("/log_error")
    public String error() {
		logger.debug("This is error msg.");		
        return "error level";
    } 
	
	
}
