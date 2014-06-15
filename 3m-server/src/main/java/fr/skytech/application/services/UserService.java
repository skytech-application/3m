package fr.skytech.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.skytech.application.adapter.GenericAdapter;
import fr.skytech.application.dao.RoleDao;
import fr.skytech.application.dao.UserDao;
import fr.skytech.application.dto.UserDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;

	@Transactional
	public List<UserDto> findAll() throws TechnicalException,
			FunctionalException {
		final GenericAdapter<UserDto, User> adapter = new GenericAdapter<UserDto, User>(
				UserDto.class, User.class);
		final List<User> users = this.userDao.findAll();
		final List<UserDto> usersDtos = adapter.modelsToDtos(users);
		return usersDtos;
	}

	@Transactional
	public UserDto findUserById(final Long id) throws TechnicalException,
			FunctionalException {
		final GenericAdapter<UserDto, User> adapter = new GenericAdapter<UserDto, User>(
				UserDto.class, User.class);
		final User user = this.userDao.find(id);
		final UserDto userDto = adapter.modelToDto(user);
		return userDto;
	}

	public UserDto findUserByUsername(final String username)
			throws TechnicalException, FunctionalException {
		final GenericAdapter<UserDto, User> adapter = new GenericAdapter<UserDto, User>(
				UserDto.class, User.class);
		final User user = this.userDao.findUserByUsername(username);
		return adapter.modelToDto(user);
	}

	@Transactional
	public UserDto save(final UserDto user) throws TechnicalException,
			FunctionalException {
		// Initialisation de l'adapter
		final GenericAdapter<UserDto, User> adapter = new GenericAdapter<UserDto, User>(
				UserDto.class, User.class);
		UserDto userToReturn = null;
		final User toSave = adapter.dtoToModel(user);
		User userSaved = null;
		// Si le user n'a pas d'ID alors on fait un update
		if (user.getId() == null) {
			// Si un user existe déjà avec ce username
			if (this.userDao.existUsername(user.getUsername())) {
				throw new FunctionalException(
						"rest.api.users.subscribe.username.exists");
			} else if (this.userDao.existEmail(user.getEmail())) {
				throw new FunctionalException(
						"rest.api.users.subscribe.email.exists");
			} else {
				// On active l'utilisateur par défaut
				toSave.setEnabled(true);
				toSave.setRole(this.roleDao.findRoleByName("ROLE_REGULAR_USER"));
				// On crée le user
				userSaved = this.userDao.create(toSave);
				userToReturn = adapter.modelToDto(userSaved);
				userToReturn
						.setControllerResponse("rest.api.users.subscribe.success");
			}

		} else {
			// On met à jour le user
			userSaved = this.userDao.update(toSave);
			userToReturn = adapter.modelToDto(userSaved);
		}
		// On retourne le résultat en l'adaptant
		return userToReturn;
	}

}
