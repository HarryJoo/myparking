package com.gummybear.myparking.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gummybear.myparking.service.ParkingLotsService;
import com.gummybear.myparking.web.dto.ParkingLotsRequestDto;
import com.gummybear.myparking.web.dto.ParkingLotsResponseDto;
import com.gummybear.myparking.web.dto.ParkingLotsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ParkingLotsAPIController {
	
	private final ParkingLotsService parkingLotsService;
	
	// A.Test...
	// 1.주차장 데이터 등록
	@PostMapping("/api/v1/parking-lots")
	public Long save(@RequestBody ParkingLotsRequestDto requestDto) {
		return parkingLotsService.save(requestDto);
	}
	
	// 2.주차장 데이터 수정
	@PutMapping("/api/v1/parking-lots/{id}")
	public Long update(@PathVariable Long id, @RequestBody ParkingLotsUpdateRequestDto requestDto) {
		return parkingLotsService.update(id, requestDto);
	}
	
	// 3.주차장별 상세 데이터 조회
	@GetMapping("/api/v1/parking-lots/{id}")
	public ParkingLotsResponseDto findById(@PathVariable Long id) {
		return parkingLotsService.findById(id);
	}	
	
	// B.MyParking API
	// 1.내 위치 주변 주차장 정보 조회 //미완
	@GetMapping("/api/v1/parking-lots/user/{location}")
	public ParkingLotsResponseDto findByMyLocation(@PathVariable Long id) {
		return parkingLotsService.findByMyLocation(id);
	}
	
	// 2.사용자가 즐겨찾기 한 주차장 조회
	@GetMapping("/api/v1/parking-lots/favorites/{id}")
	public ParkingLotsResponseDto selectFavorites(@PathVariable Long id) {
		return parkingLotsService.selectFavorites(id);
	}	
	
	// 3.조건으로 주차장 검색 시,도/구,군,시/동,읍
	@GetMapping("/api/v1/parking-lots/search/{location1}/{location2}/{location3}")
	public ParkingLotsResponseDto findByOption(@PathVariable String location1,@PathVariable String location2,@PathVariable String location3) {
		return parkingLotsService.findByOption(location1,location2,location3);
	}
	
	// 4.평가 데이터 별 주차장 조회
	/*
	@GetMapping("/api/v1/parking-lots/score")
	public ParkingLotsResponseDto selectByScore(@RequestParam int page) {
		return parkingLotsService.selectByScore(page);
	}
	*/
	
}
