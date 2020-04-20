package com.gummybear.myparking.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gummybear.myparking.service.ParkingLotsService;
import com.gummybear.myparking.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final ParkingLotsService parkingLotsService;
	private final UserService userService;
	private final HttpSession httpSession;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", userService.findAllDesc());
		
		return "index";
	}
	
	/*
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("parkingLots", parkingLotsService.findById(98316L));
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
		}
		
		return "index";
	}*/
	
	// 주차장 데이터 등록 화면
	@GetMapping("/parking-lots/register")
	public String parkingLotsRegister() {
		return "parking-lots-register";
	}
	
	// 주차장 데이터 보기
	@GetMapping("/parking-lots/view")
	public String parkingLotsView(Model model) {
		model.addAttribute("parkingLots", parkingLotsService.findParkingLotInfo());
		
		return "parking-lots-view";
	}
	
	// 사용자 데이터 등록
	@GetMapping("/users/register")
	public String usersRegister() {
		return "users-register";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home.html";
	}
}
