package fr.skytech.application.controller.api;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.skytech.application.controller.MangaNetworkController;
import fr.skytech.application.dto.UserDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.services.UserService;

@Controller
@RequestMapping(value = "/api/users", headers = "Accept=application/json", produces = { "application/json" })
public class UserController extends MangaNetworkController {

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
	UserDto findUserById(@PathVariable final Long userId) {
		return this.moreFindUserById(userId);
	}

	@RequestMapping(value = "/id/{userId}", method = RequestMethod.GET)
	public @ResponseBody
	UserDto moreFindUserById(@PathVariable final Long userId) {
		if (userId < 0) {
			throw new FunctionalException("rest.api.users.id.positive");
		}
		final UserDto dto = this.service.findUserById(userId);
		return dto;
	}

	@RequestMapping(value = "/id/", method = RequestMethod.GET)
	public @ResponseBody
	UserDto moreFindUserByIdEmpty() {
		throw new FunctionalException("rest.api.users.id.mandatory");
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
		throw new FunctionalException("rest.api.users.username.mandatory");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public UserDto savePerson(final Locale locale, final UserDto user) {
		final UserDto toReturn = this.service.save(user);
		// Send translated message to frontend
		toReturn.setControllerResponse(this.getProperty(locale,
				toReturn.getControllerResponse()));
		return toReturn;
	}

}