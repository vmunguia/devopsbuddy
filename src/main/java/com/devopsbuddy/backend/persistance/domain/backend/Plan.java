package com.devopsbuddy.backend.persistance.domain.backend;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.devopsbuddy.enums.PlansEnum;

/**
 * 
 * @author munga
 *
 */
@Entity
public class Plan implements Serializable {

	/** The Serial Version UID for serializable classes. */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;

	/**
	 * Default constructor.
	 */
	public Plan() {	

	}

	/**
	 * Fall constructor.
	 * @param plansEnum
	 */
	public Plan(PlansEnum plansEnum) {
		this.id = plansEnum.getId();
		this.name = plansEnum.getPlanName();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if ((obj == null) || (getClass() != obj.getClass()))
			return false;

		Plan plan = (Plan) obj;

		return (id == plan.id);
	}

}
