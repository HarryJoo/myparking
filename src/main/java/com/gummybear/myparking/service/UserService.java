package com.gummybear.myparking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.gummybear.myparking.domain.user.User;
import com.gummybear.myparking.domain.user.UserRepository;
import com.gummybear.myparking.web.dto.UserResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;

	@Transactional
	public Long save(User user) {
		return userRepository.save(user).getId();
	}
	
	@Transactional(readOnly = true)
	public List<UserResponseDto> findAllDesc() {
		return userRepository.findAllDesc().stream().map(UserResponseDto::new).collect(Collectors.toList());
	}

}
