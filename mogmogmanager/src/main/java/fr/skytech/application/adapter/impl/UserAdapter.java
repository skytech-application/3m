package fr.skytech.application.adapter.impl;

import org.springframework.stereotype.Component;

import fr.skytech.application.adapter.IUserAdapter;
import fr.skytech.application.controller.dto.UserDto;
import fr.skytech.application.model.User;

@Component
public class UserAdapter implements IUserAdapter{

	public UserDto modelToDTO(User model){
		UserDto dto = new UserDto();
		dto.setId(model.getId());
		dto.setUsername(model.getUsername());
		return dto;
	}
	
}
