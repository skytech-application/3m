package fr.skytech.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.skytech.application.dto.UserDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.services.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	List<UserDto> findAll() {
		final List<UserDto> dtos = this.service.findAll();
		return dtos;
	}

	@RequestMapping(value = "/{userId}", headers = "Accept=application/json", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody
	UserDto findUserById(@PathVariable final Long userId) {
		return this.moreFindUserById(userId);
	}

	@RequestMapping(value = "/id/{userId}", method = RequestMethod.GET)
	public @ResponseBody
	UserDto moreFindUserById(@PathVariable final Long userId)
			throws TechnicalException, FunctionalException {
		if (userId < 0) {
			throw new FunctionalException("ID must be positive");
		}
		final UserDto dto = this.service.findUserById(userId);
		return dto;
	}

	@RequestMapping(value = "/id/", method = RequestMethod.GET)
	public @ResponseBody
	UserDto moreFindUserByIdEmpty() throws TechnicalException,
			FunctionalException {
		throw new FunctionalException("ID is mandatory");
	}

	@RequestMapping(value = "/username/{userName}", method = RequestMethod.GET)
	public @ResponseBody
	UserDto moreFindUserByUsername(@PathVariable final String userName) {
		final UserDto dto = this.service.findUserByUsername(userName);
		return dto;
	}

	@RequestMapping(value = "/username/", method = RequestMethod.GET)
	public @ResponseBody
	UserDto moreFindUserByUsernameEmpty() {
		throw new FunctionalException("Username is mandatory");
	}

}