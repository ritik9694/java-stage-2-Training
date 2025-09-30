package com.cognizant.cards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cards.entity.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards,Long > {
	
	Optional<Cards> findByMobileNumber(String mobileNumber);
	Optional<Cards> findByCardNumber(String cardNumber);

}
