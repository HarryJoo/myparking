package com.gummybear.myparking.domain.parking;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotsRepository extends JpaRepository<ParkingLots, Long> {
	Optional<ParkingLots> findByRoadNameAddressLike(String addroad);
}
