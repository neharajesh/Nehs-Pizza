package mainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class NehsPizzaApplication {
	public static void main(String[] args) {
		SpringApplication.run(NehsPizzaApplication.class, args);
	}
	
	@GetMapping("/")
	 public String index(Model model) {
		 return "index";
	 }
}
