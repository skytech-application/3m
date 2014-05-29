package fr.skytech.application.adapter;

import fr.skytech.application.controller.dto.UserDTO;
import fr.skytech.application.model.User;

public interface IUserAdapter {

	public UserDTO modelToDTO(User model);
}
