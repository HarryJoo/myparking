package com.gummybear.myparking.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gummybear.myparking.config.auth.dto.SessionUser;
import com.gummybear.myparking.service.ParkingLotsService;
import com.gummybear.myparking.service.UserService;
import com.gummybear.myparking.web.dto.ParkingLotsResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final ParkingLotsService parkingLotsService;
	private final UserService userService;
	private final HttpSession httpSession;
	
	@GetMapping("/")
	public String index(Model model) {
		//model.addAttribute("user", userService.findAllDesc());
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		if(user != null) {
			model.addAttribute("userName", user.getName());
			model.addAttribute("userRole", user.getRole());
		}
		
		return "index";
	}
	
	// 주차장 데이터 등록 화면
	@GetMapping("/parking-lots/register")
	public String parkingLotsRegister() {
		return "/parking-lots/parking-lots-register";
	}
	
	// 인덱스 페이지 > 주차장 목록 조회
	@GetMapping("/parking-lots/view")
	public String parkingLotsView(Model model) {
		model.addAttribute("parkingLots", parkingLotsService.findParkingLotList());
		
		return "/parking-lots/parking-lots-view";
	}
	
	// 인덱스 페이지 > 주차장 목록 조회 > 수정 화면 호출
	@GetMapping("/parking-lots/update/{id}")
	public String parkingLotsUpdate(@PathVariable Long id, Model model) {
		ParkingLotsResponseDto dto = parkingLotsService.findById(id);
		model.addAttribute("parkingLots", dto);
		
		return "/parking-lots/parking-lots-update";
	}
	
	// 사용자 데이터 등록
	@GetMapping("/users/register")
	public String usersRegister() {
		return "/users/users-register";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home.html";
	}
}
