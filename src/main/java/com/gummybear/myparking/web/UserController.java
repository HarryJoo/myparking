package com.gummybear.myparking.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gummybear.myparking.domain.user.User;
import com.gummybear.myparking.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {
	
	private final UserService userService;
	
	// 1.사용자 데이터 등록
	@PostMapping("/api/v1/users")
	public Long userSave(@RequestBody User user) {
		return userService.save(user);
	}
	
}
