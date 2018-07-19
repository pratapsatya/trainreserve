package com.Trains.auth.model;

import javax.persistence.*;
import java.util.Set;


/**
 * 
 * @author laharipratap
 *This is a pojo class for user
 * this has the information about all users
 * the name and password of the user
 * the password is bcrypted before entering into database
 */

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    public User() {
		super();
	}

	public User(String username) {
		super();
		
		this.username = username;
		
	}
	

	
   
}
