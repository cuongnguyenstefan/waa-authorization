package edu.mum.waa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.waa.model.User;
import edu.mum.waa.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private LoginService loginService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/authentication", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {
		if (request.getAttribute("error") != null)
			model.addAttribute("error", "Invalid login");
		return "login";
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public String authenticating(@ModelAttribute User user, HttpServletRequest request, Model model) {
		boolean login = loginService.login(user);
		if (login) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			return "redirect:welcome";
		}
		model.addAttribute("error", "error");
		return "login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		Object attribute = request.getSession().getAttribute("username");
		if (attribute != null) {
			model.addAttribute("username", attribute);
			return "welcome";
		}
		return "forward:/authentication";
	}
}
