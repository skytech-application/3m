package fr.skytech.application.adapter;

import fr.skytech.application.controller.dto.UserDto;
import fr.skytech.application.model.User;

public interface IUserAdapter {

	public UserDto modelToDTO(User model);
}
