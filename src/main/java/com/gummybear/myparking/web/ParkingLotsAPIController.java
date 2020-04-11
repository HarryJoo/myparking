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

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ParkingLotsAPIController {
	
	private final ParkingLotsService parkingLotsService;
	
	// A.Test...
	// 1.주차장 데이터 추가 저장
	@PostMapping("/api/v1/parking-lots")
	public Long save(@RequestBody ParkingLotsRequestDto requestDto) {
		return parkingLotsService.save(requestDto);
	}
	
	// 2.주차장 데이터 수정
	@PutMapping("/api/v1/parking-lots/{id}")
	public Long update(@PathVariable Long id, @RequestBody ParkingLotsRequestDto requestDto) {
		return parkingLotsService.update(id, requestDto);
	}
	
	// 3.주차장별 상세 데이터 조회
	@GetMapping("/api/v1/parking-lots/{id}")
	public ParkingLotsResponseDto findById(@PathVariable Long id) {
		return parkingLotsService.findById(id);
	}	
	
	// B.MyParking API
	// 1.내 위치 주변 주차장 정보 조회
	
	// 2.사용자가 즐겨찾기 한 주차장 조회
	@GetMapping("/api/v1/parking-lots/favorites/{id}")
	public ParkingLotsResponseDto selectFavorites(@PathVariable Long id) {
		return parkingLotsService.selectFavorites(id);
	}	
	
	// 3.조건으로 주차장 검색
	
	// 4. 주차장별 평가 데이터 조회
	// @GetMapping("/api/v1/parking-lots/score/{id}")

}
