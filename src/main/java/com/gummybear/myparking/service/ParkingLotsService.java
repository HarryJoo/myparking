package com.gummybear.myparking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gummybear.myparking.domain.parking.ParkingLots;
import com.gummybear.myparking.domain.parking.ParkingLotsRepository;
import com.gummybear.myparking.web.dto.ParkingLotsRequestDto;
import com.gummybear.myparking.web.dto.ParkingLotsResponseDto;
import com.gummybear.myparking.web.dto.ParkingLotsUpdateRequestDto;
import com.gummybear.myparking.web.dto.UserResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ParkingLotsService {
	
	private final ParkingLotsRepository parkingLotsRepository;
	
	@Transactional
	public Long save(ParkingLotsRequestDto requestDto) {
		return parkingLotsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, ParkingLotsUpdateRequestDto requestDto) {
		ParkingLots parkingLots = parkingLotsRepository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("해당 주차장 정보가 없습니다. id=" + id));
		
		// dirty checking
		parkingLots.update(requestDto.getParkingLotNo(), requestDto.getParkingLotNm());
		
		return id;
	}

	public ParkingLotsResponseDto findById(Long id) {
		ParkingLots entity = parkingLotsRepository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("해당 주차장 정보가 없습니다. id=" + id));
		
		return new ParkingLotsResponseDto(entity);
	}
	
	// 인덱스 페이지 > 주차장 정보 조회
	@Transactional(readOnly = true)
	public List<ParkingLotsResponseDto> findParkingLotInfo() {
		return parkingLotsRepository.findParkingLotInfo().stream().map(ParkingLotsResponseDto::new).collect(Collectors.toList());
	}

	// 2.사용자가 즐겨찾기 한 주차장 조회
	public ParkingLotsResponseDto selectFavorites(Long id) {
		ParkingLots entity = parkingLotsRepository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("해당 주차장 정보가 없습니다. id=" + id));
	
		return new ParkingLotsResponseDto(entity);
	}
	//내 위치 주변 주차장 정보 조회
	public ParkingLotsResponseDto findByMyLocation(Long id) {
		ParkingLots entity = parkingLotsRepository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("해당 주차장 정보가 없습니다. id=" + id));
		
		return new ParkingLotsResponseDto(entity);
	}
	//parkingLotsService.findByOption(location1,location2,location3);
	//institudeName Where 절
	public ParkingLotsResponseDto findByOption(String location1, String location2, String location3) {
		
		String addroad = location1 +" " + location2 + " " +location3 + "%";
		ParkingLots entity = parkingLotsRepository.findByRoadNameAddressLike(addroad).orElseThrow(() -> 
		new IllegalArgumentException("해당 주차장 정보가 없습니다. addroad=" + addroad));
		
		return new ParkingLotsResponseDto(entity);
	}

	// 4.평가 데이터 별 주차장 조회
	/*
	public ParkingLotsResponseDto selectByScore(int page) {
		ParkingLots entity = parkingLotsRepository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("해당 주차장 정보가 없습니다. id=" + id));
	
		return new ParkingLotsResponseDto(entity);
	}
	*/

}
