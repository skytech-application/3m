package fr.skytech.application.controller.api;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.skytech.application.dto.RoleDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.services.RoleService;

@Controller
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	RoleService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	List<RoleDto> findAll() {
		final List<RoleDto> dtos = this.service.findAll();
		return dtos;
	}

	@RequestMapping(value = "/{roleId}", headers = "Accept=application/json", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody
	RoleDto findRoleById(final Locale locale, @PathVariable final Long roleId) {
		return this.moreFindRoleById(locale, roleId);
	}

	@RequestMapping(value = "/id/{roleId}", headers = "Accept=application/json", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody
	RoleDto moreFindRoleById(final Locale locale,
			@PathVariable final Long roleId) throws TechnicalException,
			FunctionalException {
		if (roleId < 0) {
			throw new FunctionalException(this.applicationContext.getMessage(
					"rest.api.roles.id.positive", new Object[] {}, locale));
		}
		final RoleDto dto = this.service.findRoleById(roleId);
		return dto;
	}

	@RequestMapping(value = "/id/", headers = "Accept=application/json", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody
	RoleDto moreFindUserByIdEmpty(final Locale locale)
			throws TechnicalException, FunctionalException {
		throw new FunctionalException(this.applicationContext.getMessage(
				"rest.api.roles.id.mandatory", new Object[] {}, locale));
	}

}