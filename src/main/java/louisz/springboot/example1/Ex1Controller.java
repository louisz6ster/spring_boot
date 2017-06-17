package louisz.springboot.example1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex1Controller {
	@RequestMapping("/")
    public String index() {
        return "This is Louisz Spring Boot (一)!";
    } 
}
