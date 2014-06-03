package fr.skytech.application.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.skytech.application.controller.dto.UserDto;
import fr.skytech.application.model.User;

@Component
public class UserAdapter{

	public UserDto modelToDTO(User model){
		//TODO how avoid stack overflow adapter ?
		UserDto dto = new UserDto();
		dto.setId(model.getId());
		dto.setUsername(model.getUsername());
		List<UserDto> friends = new ArrayList<UserDto>();
		if(model.getFriends()!= null){
			for(User user : model.getFriends()){
				friends.add(modelToDTO(user));
			}
		}
		dto.setFriends(friends);
		return dto;
	}
	
}
