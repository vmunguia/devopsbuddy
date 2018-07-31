package com.devopsbuddy.web.domian.frontend;

import java.io.Serializable;

/**
 * 
 * @author munga
 *
 */
public class FeedbackPojo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String firstName;
	private String lastName;
	private String feedback;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("FeedbackPojo {");
		builder.append("email='").append(email).append('\'');
		builder.append(", firstName='").append(firstName).append('\'');
		builder.append(", lastName='").append(lastName).append('\'');
		builder.append(", feedback='").append(feedback).append('\'');
		builder.append("}");
		
		return builder.toString();
	}
}
