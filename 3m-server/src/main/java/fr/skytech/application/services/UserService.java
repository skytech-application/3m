package fr.skytech.application.services;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.skytech.application.adapter.UserAdapter;
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

	@Autowired
	UserAdapter userAdapter;

	@Transactional
	public boolean delete(final Long id, final Principal principal)
			throws TechnicalException, FunctionalException {
		final User userModel = this.userDao.find(id);
		if (userModel.getUsername().equals(principal.getName())) {
			throw new FunctionalException("rest.api.users.delete.current");
		} else {
			return this.userDao.delete(userModel);
		}

	}

	@Transactional
	public List<UserDto> findAll() throws TechnicalException,
			FunctionalException {
		final List<User> users = this.userDao.findAll();
		final List<UserDto> usersDtos = this.userAdapter.modelsToDtos(users);
		return usersDtos;
	}

	@Transactional
	public UserDto findUserById(final Long id) throws TechnicalException,
			FunctionalException {
		final User user = this.userDao.find(id);
		final UserDto userDto = this.userAdapter.modelToDto(user);
		return userDto;
	}

	public UserDto findUserByUsername(final String username)
			throws TechnicalException, FunctionalException {
		final User user = this.userDao.findUserByUsername(username);
		return this.userAdapter.modelToDto(user);
	}

	@Transactional
	public UserDto save(final UserDto user) throws TechnicalException,
			FunctionalException {
		final User userModel = this.userAdapter.dtoToModel(user);
		if (user.getId() == null) {
			return this.subscribe(userModel);
		} else {
			return this.userAdapter.modelToDto(this.userDao.update(userModel));
		}
	}

	@Transactional
	public UserDto subscribe(final User user) throws TechnicalException,
			FunctionalException {
		// Si un user existe déjà avec ce username
		if (this.userDao.existUsername(user.getUsername())) {
			throw new FunctionalException(
					"rest.api.users.subscribe.username.exists");
		} else if (this.userDao.existEmail(user.getEmail())) {
			throw new FunctionalException(
					"rest.api.users.subscribe.email.exists");
		} else {
			// On active l'utilisateur par défaut
			user.setEnabled(true);
			user.setRole(this.roleDao.findRoleByName("ROLE_REGULAR_USER"));
			user.setSubscribeDate(new Date());
			// On crée le user
			final User userSaved = this.userDao.create(user);
			final UserDto userToReturn = this.userAdapter.modelToDto(userSaved);
			userToReturn
					.setControllerResponse("rest.api.users.subscribe.success");
			return userToReturn;
		}
	}

}
