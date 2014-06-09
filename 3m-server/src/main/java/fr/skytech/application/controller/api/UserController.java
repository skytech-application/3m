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

import fr.skytech.application.dto.UserDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.services.UserService;

@Controller
@RequestMapping(value = "/api/users", headers = "Accept=application/json", produces = { "application/json" })
public class UserController {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	UserService service;

	@RequestMapping(value = "/")
	public @ResponseBody
	List<UserDto> findAll() {
		final List<UserDto> dtos = this.service.findAll();
		return dtos;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public @ResponseBody
	UserDto findUserById(final Locale locale, @PathVariable final Long userId) {
		return this.moreFindUserById(locale, userId);
	}

	@RequestMapping(value = "/id/{userId}", method = RequestMethod.GET)
	public @ResponseBody
	UserDto moreFindUserById(final Locale locale,
			@PathVariable final Long userId) throws TechnicalException,
			FunctionalException {
		if (userId < 0) {
			throw new FunctionalException(this.applicationContext.getMessage(
					"rest.api.users.id.positive", new Object[] {}, locale));
		}
		final UserDto dto = this.service.findUserById(userId);
		return dto;
	}

	@RequestMapping(value = "/id/", method = RequestMethod.GET)
	public @ResponseBody
	UserDto moreFindUserByIdEmpty(final Locale locale)
			throws TechnicalException, FunctionalException {
		throw new FunctionalException(this.applicationContext.getMessage(
				"rest.api.users.id.mandatory", new Object[] {}, locale));
	}

	@RequestMapping(value = "/username/{userName}", method = RequestMethod.GET)
	public @ResponseBody
	UserDto moreFindUserByUsername(@PathVariable final String userName) {
		final UserDto dto = this.service.findUserByUsername(userName);
		return dto;
	}

	@RequestMapping(value = "/username/", method = RequestMethod.GET)
	public @ResponseBody
	UserDto moreFindUserByUsernameEmpty(final Locale locale) {
		throw new FunctionalException(this.applicationContext.getMessage(
				"rest.api.users.username.mandatory", new Object[] {}, locale));
	}

}