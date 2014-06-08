package fr.skytech.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	RoleService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	List<RoleDto> findAll() {
		final List<RoleDto> dtos = this.service.findAll();
		return dtos;
	}

	@RequestMapping(value = "/{roleId}", headers = "Accept=application/json", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody
	RoleDto findRoleById(@PathVariable final Long roleId) {
		return this.moreFindRoleById(roleId);
	}

	@RequestMapping(value = "/id/{roleId}", method = RequestMethod.GET)
	public @ResponseBody
	RoleDto moreFindRoleById(@PathVariable final Long roleId)
			throws TechnicalException, FunctionalException {
		if (roleId < 0) {
			throw new FunctionalException("ID must be positive");
		}
		final RoleDto dto = this.service.findRoleById(roleId);
		return dto;
	}

	@RequestMapping(value = "/id/", method = RequestMethod.GET)
	public @ResponseBody
	RoleDto moreFindUserByIdEmpty() throws TechnicalException,
			FunctionalException {
		throw new FunctionalException("ID is mandatory");
	}

}