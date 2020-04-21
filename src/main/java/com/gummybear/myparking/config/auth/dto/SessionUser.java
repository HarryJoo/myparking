package com.gummybear.myparking.config.auth.dto;

import java.io.Serializable;

import com.gummybear.myparking.domain.user.Role;
import com.gummybear.myparking.domain.user.User;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	private String name;
	private String email;
	private String picture;
	private Role role;
	
	public SessionUser(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
		this.role =  user.getRole();
	}
}
