package com.mmse.insurance.model.entities;

import java.io.Serializable;

/**
 * Entity class defined with getters and setters only
 * @author Adam
 */
public class User implements Serializable {
	
    /** Default serial version ID */
	private static final long serialVersionUID = 1L;
	private String username;
	private String passwordHash;
	private Role role;

	public User(String username, String passwordHash, Role role) {
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

    @Override
    public String toString() {
        return  username +  ", role=" + role ;
    }
        
        




}
