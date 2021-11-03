package ie.rc.SpringWebApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ie.rc.userdao.User;

@Controller
public class MainController {

	@GetMapping("/home")
	public String homePage() {
		
		return "home";	// name of the view to display
	}
	
	@GetMapping("/message")
	public String showMessage(Model model) {
		
		model.addAttribute("message", "This is a message");
		
		return "message";
	}
	
	@GetMapping("/showuser") 
	public String showUser(Model model) {
		
		User u = new User(1, "Alice", "alice@gmail.com", false);
		
		model.addAttribute("user", u);
		
		return "showuser";
	}
	
}
