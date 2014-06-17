package fr.skytech.application.controller.api;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.skytech.application.controller.MangaNetworkController;
import fr.skytech.application.dto.UserDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.services.UserService;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json", produces = { "application/json" })
public class UserController extends MangaNetworkController {

	@Autowired
	UserService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<UserDto> findAll() {
		final List<UserDto> dtos = this.service.findAll();
		return dtos;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public UserDto findUserById(@PathVariable final Long userId) {
		return this.moreFindUserById(userId);
	}

	@RequestMapping(value = "/id/{userId}", method = RequestMethod.GET)
	public UserDto moreFindUserById(@PathVariable final Long userId) {
		if (userId < 0) {
			throw new FunctionalException("rest.api.users.id.positive");
		}
		final UserDto dto = this.service.findUserById(userId);
		return dto;
	}

	@RequestMapping(value = "/id/", method = RequestMethod.GET)
	public UserDto moreFindUserByIdEmpty() {
		throw new FunctionalException("rest.api.users.id.mandatory");
	}

	@RequestMapping(value = "/username/{userName}", method = RequestMethod.GET)
	public UserDto moreFindUserByUsername(@PathVariable final String userName) {
		final UserDto dto = this.service.findUserByUsername(userName);
		return dto;
	}

	@RequestMapping(value = "/username/", method = RequestMethod.GET)
	public UserDto moreFindUserByUsernameEmpty(final Locale locale) {
		throw new FunctionalException("rest.api.users.username.mandatory");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public UserDto savePerson(final Locale locale, final UserDto user) {
		final UserDto toReturn = this.service.save(user);
		// Send translated message to frontend
		toReturn.setControllerResponse(this.getProperty(locale,
				toReturn.getControllerResponse()));
		return toReturn;
	}

}