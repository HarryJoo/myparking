package com.gummybear.myparking.web.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ParkingLotsResponseDtoTest {
	
	@Test
	public void lombok_function_test() {
		//given
		String parkingLotNo = "391-2-000001";
		
		//when
		ParkingLotsResponseDto dto = new ParkingLotsResponseDto(parkingLotNo);
		
		//then
		assertThat(dto.getParkingLotNo()).isEqualTo(parkingLotNo);
	}
}
