package com.gummybear.myparking.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.gummybear.myparking.domain.parking.ParkingLots;
import com.gummybear.myparking.domain.parking.ParkingLotsRepository;
import com.gummybear.myparking.web.dto.ParkingLotsRequestDto;
import com.gummybear.myparking.web.dto.ParkingLotsUpdateRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingLotsAPIControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private ParkingLotsRepository parkingLotsRepository;
	
	@After
	public void tearDown() throws Exception {
		parkingLotsRepository.deleteAll();
	}
	
	// 주차장 데이터 등록 테스트 메서드
	@Test
	public void registerParkingLots() throws Exception {
		//given data
		String parkingLotNo = "391-2-999999";
		String parkingLotNm = "테스트주차장";
		String parkingLotSection = "공영";
		String parkingLotType = "노외";
		//String roadNameAddress = "";
		String numberNameAddress = "경기도 성남시 분당구 수내1동 ";
		String parkingCompartment = "50";
		String feedDivision = "1";
		String alternateDayNoDrivingDivision = "미시행";
		String operatingDay = "평일+토요일+공휴일";
		String weekdayOpeningHour = "00:00:00";
		String weekdayClosingHour = "00:00:00";
		String saturdayOpeningHour = "00:00:00";
		String saturdayClosingHour = "00:00:00";
		String holidayOpeningHour = "00:00:00";
		String holidayClosingHour = "00:00:00";
		String parkingFeeInfomation = "0";
		int basicParkingTime = 0;
		int basicParkingFee = 200;
		String additionalUnitTime = "";
		String additionalParkingFee = "";
		String dayParkingFeeApplicationTime = "";
		String dayParkingFee = "";
		String monthlyFee = "";
		//String paymentMethod = "";
		//String remarks = "";
		String managementAgencyName = "분당구청";
		String managementAgencyPhoneNumber = "000-0000-0000";
		String latitude = "35.5";
		String longitude = "128.5";
		String referenceDate = "2020-04-08 00:00:00";
		String institudeCode = "99999999";
		String institudeName = "테스트 기관";
		
		ParkingLotsRequestDto requestDto = ParkingLotsRequestDto.builder()
											.parkingLotNo(parkingLotNo)
											.parkingLotNm(parkingLotNm)
											.parkingLotSection(parkingLotSection)
											.parkingLotType(parkingLotType)
											.numberNameAddress(numberNameAddress)
											.parkingCompartment(parkingCompartment)
											.feedDivision(feedDivision)
											.alternateDayNoDrivingDivision(alternateDayNoDrivingDivision)
											.operatingDay(operatingDay)
											.weekdayOpeningHour(weekdayOpeningHour)
											.weekdayClosingHour(weekdayClosingHour)
											.saturdayOpeningHour(saturdayOpeningHour)
											.saturdayClosingHour(saturdayClosingHour)
											.holidayOpeningHour(holidayOpeningHour)
											.holidayClosingHour(holidayClosingHour)
											.parkingFeeInfomation(parkingFeeInfomation)
											.basicParkingTime(basicParkingTime)
											.basicParkingFee(basicParkingFee)
											.additionalParkingFee(additionalParkingFee)
											.additionalUnitTime(additionalUnitTime)
											.dayParkingFeeApplicationTime(dayParkingFeeApplicationTime)
											.dayParkingFee(dayParkingFee)
											.monthlyFee(monthlyFee)
											.managementAgencyName(managementAgencyName)
											.managementAgencyPhoneNumber(managementAgencyPhoneNumber)
											.latitude(latitude)
											.longitude(longitude)
											.referenceDate(referenceDate)
											.institudeCode(institudeCode)
											.institudeName(institudeName)
											.build();
		
		String url = "http://localhost:" + port + "/api/v1/parking-lots";
		
		//when
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
		
		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<ParkingLots> all = parkingLotsRepository.findAll();
		assertThat(all.get(0).getParkingLotNo()).isEqualTo(parkingLotNo);
		assertThat(all.get(0).getParkingLotNm()).isEqualTo(parkingLotNm);
		
		
	}
	
	// 주차장 데이터 수정 테스트 메서드
	//@Test
	public void updateParkingLots() throws Exception {
		//given
		String parkingLotNo = "391-2-000001";
		String parkingLotNm = "옥천주차장";
		String parkingLotSection = "공영";
		String parkingLotType = "노외";
		//String roadNameAddress = "";
		String numberNameAddress = "경상남도 창녕군 창녕읍 옥천리 1394-45";
		String parkingCompartment = "50";
		String feedDivision = "1";
		String alternateDayNoDrivingDivision = "미시행";
		String operatingDay = "평일+토요일+공휴일";
		String weekdayOpeningHour = "00:00:00";
		String weekdayClosingHour = "00:00:00";
		String saturdayOpeningHour = "00:00:00";
		String saturdayClosingHour = "00:00:00";
		String holidayOpeningHour = "00:00:00";
		String holidayClosingHour = "00:00:00";
		String parkingFeeInfomation = "0";
		int basicParkingTime = 0;
		int basicParkingFee = 200;
		String additionalUnitTime = "";
		String additionalParkingFee = "";
		String dayParkingFeeApplicationTime = "";
		String dayParkingFee = "";
		String monthlyFee = "";
		//String paymentMethod = "";
		//String remarks = "";
		String managementAgencyName = "경상남도 창녕군청";
		String managementAgencyPhoneNumber = "055-530-1727";
		String latitude = "35.51885089";
		String longitude = "128.5510922";
		String referenceDate = "2020-01-03 00:00:00";
		String institudeCode = "5410000";
		String institudeName = "경상남도 창녕군";
		
		ParkingLots savedParkingLots = parkingLotsRepository.save(ParkingLots.builder()
															.parkingLotNo(parkingLotNo)
															.parkingLotNm(parkingLotNm)
															.parkingLotSection(parkingLotSection)
															.parkingLotType(parkingLotType)
															.numberNameAddress(numberNameAddress)
															.parkingCompartment(parkingCompartment)
															.feedDivision(feedDivision)
															.alternateDayNoDrivingDivision(alternateDayNoDrivingDivision)
															.operatingDay(operatingDay)
															.weekdayOpeningHour(weekdayOpeningHour)
															.weekdayClosingHour(weekdayClosingHour)
															.saturdayOpeningHour(saturdayOpeningHour)
															.saturdayClosingHour(saturdayClosingHour)
															.holidayOpeningHour(holidayOpeningHour)
															.holidayClosingHour(holidayClosingHour)
															.parkingFeeInfomation(parkingFeeInfomation)
															.basicParkingTime(basicParkingTime)
															.basicParkingFee(basicParkingFee)
															.additionalParkingFee(additionalParkingFee)
															.additionalUnitTime(additionalUnitTime)
															.dayParkingFeeApplicationTime(dayParkingFeeApplicationTime)
															.dayParkingFee(dayParkingFee)
															.monthlyFee(monthlyFee)
															.managementAgencyName(managementAgencyName)
															.managementAgencyPhoneNumber(managementAgencyPhoneNumber)
															.latitude(latitude)
															.longitude(longitude)
															.referenceDate(referenceDate)
															.institudeCode(institudeCode)
															.institudeName(institudeName)
															.build());
		
		Long updateId = savedParkingLots.getId();
		String expectedParkingLotNo = "391-2-999999";
		String expectedParkingLotNm = "테스트주차장";
		
		ParkingLotsUpdateRequestDto requestDto = ParkingLotsUpdateRequestDto.builder()
											.parkingLotNo(expectedParkingLotNo)
											.parkingLotNm(expectedParkingLotNm)
											.build();
		
		String url = "http://localhost:" + port + "/api/v1/parking-lots/" + updateId;
		
		HttpEntity<ParkingLotsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
		
		//when
		ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, 
																	requestEntity, Long.class);
		
		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<ParkingLots> all = parkingLotsRepository.findAll();
		assertThat(all.get(0).getParkingLotNo()).isEqualTo(expectedParkingLotNo);
		assertThat(all.get(0).getParkingLotNm()).isEqualTo(expectedParkingLotNm);
	}
}
