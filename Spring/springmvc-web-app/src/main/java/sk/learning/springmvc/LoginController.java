package sk.learning.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPageHandler(@RequestParam String name, @RequestParam String pass, ModelMap modelMap) {
		boolean isUserValid = UserValidation.isValidUser(name, pass);
		
		if (isUserValid) {
			modelMap.put("name",name);
			return "welcome";
		}
		else {
			modelMap.put("error","Invalid Username or Password");
			return "login";
		}
	}
}
