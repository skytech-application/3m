package fr.skytech.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.skytech.application.adapter.RoleAdapter;
import fr.skytech.application.dao.RoleDao;
import fr.skytech.application.dto.RoleDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;

@Service
public class RoleService {

	@Autowired
	RoleDao dao;

	@Autowired
	RoleAdapter roleAdapter;

	@Transactional
	public List<RoleDto> findAll() throws TechnicalException,
			FunctionalException {
		return this.roleAdapter.modelsToDtos(this.dao.findAll());
	}

	@Transactional
	public RoleDto findRoleById(final Long id) throws TechnicalException,
			FunctionalException {
		return this.roleAdapter.modelToDto(this.dao.find(id));
	}

}
