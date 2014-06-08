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
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public String admin(final ModelMap model) {
		return "admin/admin_page";
	}

	@Secured({ "ROLE_REGULAR_USER", "ROLE_ADMIN" })
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public String connected(final ModelMap model, final Principal principal) {
		if (principal != null) {
			final String name = principal.getName();
			model.addAttribute("username", name);
		}
		return "user/index";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginerror(final ModelMap model) {
		model.addAttribute("error", "true");
		return this.userIndex(model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String userIndex(final ModelMap model) {
		return "index";

	}

}
