package com.devopsbuddy.enums;

public enum PlansEnum {

	BASIC(1, "Basic"),
	PRO(2, "Pro");

	private final int id;
	private final String planName;

	private PlansEnum(int id, String planName) {
		this.id = id;
		this.planName = planName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the planName
	 */
	public String getPlanName() {
		return planName;
	}
}
