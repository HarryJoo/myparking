package com.gummybear.myparking.domain.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	
	@Query("SELECT u FROM User u ORDER BY u.id DESC")
	List<User> findAllDesc();
}
