package louisz.springboot.example1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Ex1Controller.class)
public class TestEx1Controller {
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private Ex1Controller service;
    
    @Before
    public void setUp() throws Exception{
    	mvc = MockMvcBuilders.standaloneSetup(new Ex1Controller()).build();
    }
    
    @Test
    public void testHello() throws Exception{
    	mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk())
	.andExpect(content().string(equalTo("This is Louisz Spring Boot!")));
    }
    
}
