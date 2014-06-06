package fr.skytech.application.controller;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(final ModelMap model) {

		return "admin_page";

	}

	@Secured({ "ROLE_REGULAR_USER", "ROLE_ADMIN" })
	@RequestMapping(value = "/common", method = RequestMethod.GET)
	public String common(final ModelMap model) {

		return "common_page";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(final ModelMap model) {

		return "login_page";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginerror(final ModelMap model) {
		model.addAttribute("error", "true");
		return "login_page";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(final ModelMap model) {

		return this.login(model);

	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model, final Principal principal) {

		final String name = principal.getName();
		model.addAttribute("username", name);
		return "main_page";

	}

}
