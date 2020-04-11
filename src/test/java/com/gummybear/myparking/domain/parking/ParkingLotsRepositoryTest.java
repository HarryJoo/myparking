package com.gummybear.myparking.domain.parking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.Column;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingLotsRepositoryTest {

	@Autowired
	ParkingLotsRepository parkingLotsRepository;
	
	@After
	public void cleanup() {
		parkingLotsRepository.deleteAll();
	}
	
	@Test
	public void getParkingLots() {
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
		
		parkingLotsRepository.save(ParkingLots.builder()
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
		
		//when
		List<ParkingLots> parkingLotsList = parkingLotsRepository.findAll();
		
		//then
		ParkingLots parkingLots = parkingLotsList.get(0);
		assertThat(parkingLots.getParkingLotNo()).isEqualTo(parkingLotNo);
		assertThat(parkingLots.getParkingLotNm()).isEqualTo(parkingLotNm);
	}
	
}
