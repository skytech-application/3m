package fr.skytech.application.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public String admin(final ModelMap model) {
		return "admin/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(final HttpServletRequest request, final Model model,
			final Principal principal) {
		model.addAttribute("principal", principal);
		return "index";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(final HttpServletRequest request, final Model model,
			final Principal principal) {
		model.addAttribute("principal", principal);
		return "login";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(final HttpServletRequest request,
			final Model model, final Principal principal) {
		model.addAttribute("error", "error.login.connect");
		model.addAttribute("principal", principal);
		return this.login(request, model, principal);

	}

}
