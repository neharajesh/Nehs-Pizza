import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class NehsPizzaApplication {
	
	@RequestMapping("/")
	public String welcome() {
		return "home";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NehsPizzaApplication.class, args);
	}
}
