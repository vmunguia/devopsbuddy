package com.devopsbuddy.backend.persistance.domain.backend;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author munga
 *
 */
@Entity
@Table(name="user_role")
public class UserRole implements Serializable {

	/** The Serial Version UID for serializable classes. */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UserRole() {
		
	}

	@Id
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;

	@Id
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role role;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = user.hashCode();

		result = prime * result + role.hashCode();

		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if ((obj == null) ||(getClass() != obj.getClass()))
			return false;

		UserRole userRole = (UserRole) obj;

		if(!user.equals(userRole.user))
			return false;

		return role.equals(userRole.role);
	}
}
