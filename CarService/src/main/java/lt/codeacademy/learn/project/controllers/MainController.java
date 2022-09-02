package lt.codeacademy.learn.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping("/index")
    public String showMainPage() {
        return "index";
	}
	
	@GetMapping("/login")
	public String login() {
        return "login";
	}
	
}
