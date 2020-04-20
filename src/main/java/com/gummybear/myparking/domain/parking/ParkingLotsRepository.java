package com.gummybear.myparking.domain.parking;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParkingLotsRepository extends JpaRepository<ParkingLots, Long> {
	
	Optional<ParkingLots> findByRoadNameAddressLike(String addroad);
	
	@Query("SELECT p FROM ParkingLots p ORDER BY p.id ASC")
	List<ParkingLots> findParkingLotInfo();
	
}
