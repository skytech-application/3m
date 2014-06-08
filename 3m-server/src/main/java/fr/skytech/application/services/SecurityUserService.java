package fr.skytech.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.skytech.application.dto.RoleDto;
import fr.skytech.application.dto.UserDto;

@Service
public class SecurityUserService implements
		org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	public UserDetails loadUserByUsername(final String arg0)
			throws UsernameNotFoundException {
		final UserDto user = this.userService.findUserByUsername(arg0);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username/password.");
		}

		final List<RoleDto> authorities = new ArrayList<RoleDto>();
		authorities.add(user.getRole());

		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), authorities);
	}

}
