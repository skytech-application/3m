package fr.skytech.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.skytech.application.adapter.GenericAdapter;
import fr.skytech.application.dao.UserDao;
import fr.skytech.application.dto.UserDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.User;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	@Transactional
	public List<UserDto> findAll() throws TechnicalException,
			FunctionalException {
		final GenericAdapter<UserDto, User> adapter = new GenericAdapter<UserDto, User>(
				UserDto.class, User.class);
		final List<User> users = this.dao.findAll();
		final List<UserDto> usersDtos = adapter.modelsToDtos(users);
		return usersDtos;
	}

	public UserDto findUserById(final Long id) throws TechnicalException,
			FunctionalException {
		final GenericAdapter<UserDto, User> adapter = new GenericAdapter<UserDto, User>(
				UserDto.class, User.class);
		final User user = this.dao.find(id);
		final UserDto userDto = adapter.modelToDto(user);
		return userDto;
	}

	public UserDto findUserByUsername(final String username)
			throws TechnicalException, FunctionalException {
		final GenericAdapter<UserDto, User> adapter = new GenericAdapter<UserDto, User>(
				UserDto.class, User.class);
		final User user = this.dao.findUserByUsername(username);
		return adapter.modelToDto(user);
	}

}
