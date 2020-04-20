package com.gummybear.myparking.web.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gummybear.myparking.domain.parking.ParkingLots;

import lombok.Getter;

// View를 위한 DTO Class (Reqeust/Response 용)
@Getter
public class ParkingLotsResponseDto {
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
	
	public ParkingLotsResponseDto(ParkingLots entity) {
		this.parkingLotNo = entity.getParkingLotNo();
		this.parkingLotNm = entity.getParkingLotNm();
		this.parkingLotSection = entity.getParkingLotSection();
		this.parkingLotType = entity.getParkingLotType();
		this.numberNameAddress = entity.getNumberNameAddress();
		this.parkingCompartment = entity.getParkingCompartment();
		this.feedDivision = entity.getFeedDivision();
		this.alternateDayNoDrivingDivision = entity.getAlternateDayNoDrivingDivision();
		this.operatingDay = entity.getOperatingDay();
		this.weekdayOpeningHour = entity.getWeekdayOpeningHour();
		this.weekdayClosingHour = entity.getWeekdayClosingHour();
		this.saturdayOpeningHour = entity.getSaturdayOpeningHour();
		this.saturdayClosingHour = entity.getSaturdayClosingHour();
		this.holidayOpeningHour = entity.getHolidayOpeningHour();
		this.holidayClosingHour = entity.getHolidayClosingHour();
		this.parkingFeeInfomation = entity.getParkingFeeInfomation();
		this.basicParkingTime = entity.getBasicParkingTime();
		this.basicParkingFee = entity.getBasicParkingFee();
		this.additionalParkingFee = entity.getAdditionalParkingFee();
		this.additionalUnitTime = entity.getAdditionalUnitTime();
		this.dayParkingFeeApplicationTime = entity.getDayParkingFeeApplicationTime();
		this.dayParkingFee = entity.getDayParkingFee();
		this.monthlyFee = entity.getMonthlyFee();
		this.managementAgencyName = entity.getManagementAgencyName();
		this.managementAgencyPhoneNumber = entity.getManagementAgencyPhoneNumber();
		this.latitude = entity.getLatitude();
		this.longitude = entity.getLongitude();
		this.referenceDate = entity.getReferenceDate();
		this.institudeCode = entity.getInstitudeCode();
		this.institudeName = entity.getInstitudeName();
	}
	
	public ParkingLotsResponseDto(String parkingLotNo) {
		this.parkingLotNo = parkingLotNo;
	}
	
}
