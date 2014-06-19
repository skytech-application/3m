package fr.skytech.application.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.skytech.application.dto.RoleDto;
import fr.skytech.application.model.Role;

@Component
public class RoleAdapter {

	public List<Role> dtosToModels(final List<RoleDto> dtos) {
		final List<Role> roles = new ArrayList<Role>();
		for (final RoleDto roleDto : dtos) {
			roles.add(this.dtoToModel(roleDto));
		}
		return roles;
	}

	public Role dtoToModel(final RoleDto roleDto) {
		final Role model = new Role();
		model.setId(roleDto.getId());
		model.setName(roleDto.getName());
		return model;
	}

	public List<RoleDto> modelsToDtos(final List<Role> models) {
		final List<RoleDto> roles = new ArrayList<RoleDto>();
		for (final Role role : models) {
			roles.add(this.modelToDto(role));
		}
		return roles;
	}

	public RoleDto modelToDto(final Role role) {
		final RoleDto dto = new RoleDto();
		dto.setId(role.getId());
		dto.setName(role.getName());
		return dto;
	}

}
