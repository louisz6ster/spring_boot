package louisz.springboot.example2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex2Controller {
	@RequestMapping("/")
    public String index() {
        return "This is Louisz Spring Boot!";
    } 
}
