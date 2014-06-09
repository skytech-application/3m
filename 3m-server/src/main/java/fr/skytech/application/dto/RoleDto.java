package fr.skytech.application.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

public class RoleDto implements Serializable, GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3891014325611047517L;

	Long id;
	String name;

	// A ignorer car sinon le getter est appellé automatiquement par Jackson
	// pour la sérialisation
	// ce qui provoque une exception de LazyLoading, la session hibernate est
	// fermée ici.
	@JsonIgnore
	public String getAuthority() {
		return this.getName();
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
