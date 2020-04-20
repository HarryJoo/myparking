package com.gummybear.myparking.web.dto;

import com.gummybear.myparking.domain.user.Role;
import com.gummybear.myparking.domain.user.User;

import lombok.Getter;

// View를 위한 DTO Class (Reqeust/Response 용)
@Getter
public class UserResponseDto {
	private Long id;
	private String name;
	private String email;
	private String picture;
	private Role role;
	
	public UserResponseDto(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
		this.role = user.getRole();
	}
	
}
