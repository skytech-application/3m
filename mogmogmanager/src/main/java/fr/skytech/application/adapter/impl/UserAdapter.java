package fr.skytech.application.adapter.impl;

import org.springframework.stereotype.Component;

import fr.skytech.application.adapter.IUserAdapter;
import fr.skytech.application.controller.dto.UserDTO;
import fr.skytech.application.model.User;

@Component
public class UserAdapter implements IUserAdapter{

	public UserDTO modelToDTO(User model){
		UserDTO dto = new UserDTO();
		dto.setId(model.getId());
		dto.setUsername(model.getUsername());
		return dto;
	}
	
}
