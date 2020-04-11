package com.gummybear.myparking.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gummybear.myparking.domain.parking.ParkingLots;
import com.gummybear.myparking.domain.parking.ParkingLotsRepository;
import com.gummybear.myparking.web.dto.ParkingLotsRequestDto;
import com.gummybear.myparking.web.dto.ParkingLotsResponseDto;

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
	public Long update(Long id, ParkingLotsRequestDto requestDto) {
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

	// 사용자가 즐겨찾기 한 주차장 조회
	public ParkingLotsResponseDto selectFavorites(Long id) {
		ParkingLots entity = parkingLotsRepository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("해당 주차장 정보가 없습니다. id=" + id));
	
		return new ParkingLotsResponseDto(entity);
	}

}
