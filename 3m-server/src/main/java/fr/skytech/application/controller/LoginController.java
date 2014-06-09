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
		return "admin/admin_page";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String connected(final HttpServletRequest request,
			final Model model, final Principal principal) {
		if (request.getParameter("error") != null) {
			model.addAttribute("error", request.getParameter("error"));
		}
		model.addAttribute("principal", principal);
		return "index";

	}

}
