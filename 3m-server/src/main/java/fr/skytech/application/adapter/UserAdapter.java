package fr.skytech.application.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.skytech.application.dto.FollowerDto;
import fr.skytech.application.dto.UserDto;
import fr.skytech.application.model.User;

@Component
public class UserAdapter {

	@Autowired
	RoleAdapter roleAdapter;

	public List<User> dtosToModels(final List<UserDto> dtos) {
		final List<User> users = new ArrayList<User>();
		for (final UserDto userDto : dtos) {
			users.add(this.dtoToModel(userDto));
		}
		return users;
	}

	public User dtoToModel(final UserDto userDto) {
		final User model = new User();
		model.setId(userDto.getId());
		model.setEnabled(userDto.isEnabled());
		model.setEmail(userDto.getEmail());
		model.setPassword(userDto.getPassword());
		model.setSubscribeDate(userDto.getSubscribeDate());
		model.setUsername(userDto.getUsername());
		model.setXp(userDto.getXp());
		model.setRole(this.roleAdapter.dtoToModel(userDto.getRole()));
		return model;
	}

	public List<UserDto> modelsToDtos(final List<User> models) {
		final List<UserDto> users = new ArrayList<UserDto>();
		for (final User user : models) {
			users.add(this.modelToDto(user));
		}
		return users;
	}

	public UserDto modelToDto(final User user) {
		final UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setEnabled(user.isEnabled());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setSubscribeDate(user.getSubscribeDate());
		dto.setUsername(user.getUsername());
		dto.setXp(user.getXp());
		dto.setRole(this.roleAdapter.modelToDto(user.getRole()));
		final List<FollowerDto> followersDtos = new ArrayList<FollowerDto>();
		for (final User u : user.getFollowers()) {
			followersDtos.add(this.modelToDtoFollower(u));
		}

		final List<FollowerDto> followedDtos = new ArrayList<FollowerDto>();
		for (final User u : user.getFollowed()) {
			followedDtos.add(this.modelToDtoFollower(u));
		}
		dto.setFollowers(followersDtos);
		dto.setFollowed(followedDtos);
		return dto;
	}

	public FollowerDto modelToDtoFollower(final User model) {
		final FollowerDto follower = new FollowerDto();
		follower.setId(model.getId());
		follower.setUsername(model.getUsername());
		return follower;
	}

}
