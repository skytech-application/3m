package fr.skytech.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.skytech.application.adapter.GenericAdapter;
import fr.skytech.application.dao.RoleDao;
import fr.skytech.application.dto.RoleDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.Role;

@Service
public class RoleService {

	// TODO remove Transactional

	@Autowired
	RoleDao dao;

	@Transactional
	public List<RoleDto> findAll() throws TechnicalException,
			FunctionalException {
		final GenericAdapter<RoleDto, Role> adapter = new GenericAdapter<RoleDto, Role>(
				RoleDto.class, Role.class);
		return adapter.modelsToDtos(this.dao.findAll());
	}

	@Transactional
	public RoleDto findRoleById(final Long id) throws TechnicalException,
			FunctionalException {
		final GenericAdapter<RoleDto, Role> adapter = new GenericAdapter<RoleDto, Role>(
				RoleDto.class, Role.class);
		return adapter.modelToDto(this.dao.find(id));
	}

}
