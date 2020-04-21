package com.gummybear.myparking.domain.parking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gummybear.myparking.web.dto.ParkingLotsUpdateRequestDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// DB 테이블 전용인 Entity Class
@Getter
@NoArgsConstructor
@Entity
public class ParkingLots {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String parkingLotNo;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String parkingLotNm;
	
	private String parkingLotSection;
	
	private String parkingLotType;
	
	@Column(columnDefinition = "TEXT")
	private String roadNameAddress;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String numberNameAddress;
	
	private String parkingCompartment;
	
	private String feedDivision;
	
	private String alternateDayNoDrivingDivision;
	
	private String operatingDay;
	
	private String weekdayOpeningHour;
	
	private String weekdayClosingHour;
	
	private String saturdayOpeningHour;
	
	private String saturdayClosingHour;
	
	private String holidayOpeningHour;
	
	private String holidayClosingHour;
	
	private String parkingFeeInfomation;
	
	private int basicParkingTime;
	
	private int basicParkingFee;
	
	private String additionalUnitTime;
	
	private String additionalParkingFee;
	
	private String dayParkingFeeApplicationTime;
	
	private String dayParkingFee;
	
	private String monthlyFee;
	
	private String paymentMethod;
	
	private String remarks;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String managementAgencyName;
	
	private String managementAgencyPhoneNumber;
	
	private String latitude;
	
	private String longitude;
	
	private String referenceDate;
	
	private String institudeCode;
	 
	@Column(columnDefinition = "TEXT", nullable = false)
	private String institudeName;
	
	@Builder
	public ParkingLots(String parkingLotNo, String parkingLotNm, 
			String parkingLotSection, String parkingLotType, String roadNameAddress, String numberNameAddress, String parkingCompartment,
			String feedDivision, String alternateDayNoDrivingDivision, String operatingDay, String weekdayOpeningHour,
			String weekdayClosingHour, String saturdayOpeningHour, String saturdayClosingHour, String holidayOpeningHour,
			String holidayClosingHour, String parkingFeeInfomation, int basicParkingTime, int basicParkingFee,
			String additionalParkingFee, String additionalUnitTime, String dayParkingFeeApplicationTime, String dayParkingFee, 
			String monthlyFee, String paymentMethod, String remarks, String managementAgencyName, String managementAgencyPhoneNumber, String latitude, 
			String longitude, String referenceDate, String institudeCode, String institudeName) {
		this.parkingLotNo = parkingLotNo;
		this.parkingLotNm = parkingLotNm;
		this.parkingLotSection = parkingLotSection;
		this.parkingLotType = parkingLotType;
		this.roadNameAddress = roadNameAddress;
		this.numberNameAddress = numberNameAddress;
		this.parkingCompartment = parkingCompartment;
		this.feedDivision = feedDivision;
		this.alternateDayNoDrivingDivision = alternateDayNoDrivingDivision;
		this.operatingDay = operatingDay;
		this.weekdayOpeningHour = weekdayOpeningHour;
		this.weekdayClosingHour = weekdayClosingHour;
		this.saturdayOpeningHour = saturdayOpeningHour;
		this.saturdayClosingHour = saturdayClosingHour;
		this.holidayOpeningHour = holidayOpeningHour;
		this.holidayClosingHour = holidayClosingHour;
		this.parkingFeeInfomation = parkingFeeInfomation;
		this.basicParkingTime = basicParkingTime;
		this.basicParkingFee = basicParkingFee;
		this.additionalParkingFee = additionalParkingFee;
		this.additionalUnitTime = additionalUnitTime;
		this.dayParkingFeeApplicationTime = dayParkingFeeApplicationTime;
		this.dayParkingFee = dayParkingFee;
		this.monthlyFee = monthlyFee;
		this.paymentMethod = paymentMethod;
		this.remarks = remarks;
		this.managementAgencyName = managementAgencyName;
		this.managementAgencyPhoneNumber = managementAgencyPhoneNumber;
		this.latitude = latitude;
		this.longitude = longitude;
		this.referenceDate = referenceDate;
		this.institudeCode = institudeCode;
		this.institudeName = institudeName;
	}

	public void update(ParkingLotsUpdateRequestDto dto) {
		this.parkingLotNo = dto.getParkingLotNo();
		this.parkingLotNm = dto.getParkingLotNm();
		this.parkingLotSection = dto.getParkingLotSection();
		this.parkingLotType = dto.getParkingLotType();
		this.roadNameAddress = dto.getRoadNameAddress();
		this.numberNameAddress = dto.getNumberNameAddress();
		this.parkingCompartment = dto.getParkingCompartment();
		this.feedDivision = dto.getFeedDivision();
		this.alternateDayNoDrivingDivision = dto.getAlternateDayNoDrivingDivision();
		this.operatingDay = dto.getOperatingDay();
		this.weekdayOpeningHour = dto.getWeekdayOpeningHour();
		this.weekdayClosingHour = dto.getWeekdayClosingHour();
		this.saturdayOpeningHour = dto.getSaturdayOpeningHour();
		this.saturdayClosingHour = dto.getSaturdayClosingHour();
		this.holidayOpeningHour = dto.getHolidayOpeningHour();
		this.holidayClosingHour = dto.getHolidayClosingHour();
		this.parkingFeeInfomation = dto.getParkingFeeInfomation();
		this.basicParkingTime = dto.getBasicParkingFee();
		this.basicParkingFee = dto.getBasicParkingFee();
		this.additionalParkingFee = dto.getAdditionalParkingFee();
		this.additionalUnitTime = dto.getAdditionalUnitTime();
		this.dayParkingFeeApplicationTime = dto.getDayParkingFeeApplicationTime();
		this.dayParkingFee = dto.getDayParkingFee();
		this.monthlyFee = dto.getMonthlyFee();
		this.paymentMethod = dto.getPaymentMethod();
		this.remarks = dto.getRemarks();
		this.managementAgencyName = dto.getManagementAgencyName();
		this.managementAgencyPhoneNumber = dto.getManagementAgencyPhoneNumber();
		this.latitude = dto.getLatitude();
		this.longitude = dto.getLongitude();
		this.referenceDate = dto.getReferenceDate();
		this.institudeCode = dto.getInstitudeCode();
		this.institudeName = dto.getInstitudeName();
	}
	
}
