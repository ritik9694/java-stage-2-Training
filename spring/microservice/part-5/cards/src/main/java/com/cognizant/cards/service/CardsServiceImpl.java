package com.cognizant.cards.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cards.dto.CardsDto;
import com.cognizant.cards.entity.Cards;
import com.cognizant.cards.exception.CardAlreadyExistsException;
import com.cognizant.cards.exception.ResourceNotFoundException;
import com.cognizant.cards.mapper.CardsMapper;
import com.cognizant.cards.repository.CardsRepository;

@Service
public class CardsServiceImpl implements CardsService {

	@Autowired
	private CardsRepository cardsRepository;

	@Override
	public void createCard(String mobileNumber) {
		Optional<Cards> cardsOpt = cardsRepository.findByMobileNumber(mobileNumber);
		if (cardsOpt.isPresent()) {
			throw new CardAlreadyExistsException("card Already exist with given mobile number" + mobileNumber);
		}
		cardsRepository.save(createNewCard(mobileNumber));

	}

	private Cards createNewCard(String mobileNumber) {
		Cards newCards = new Cards();
		long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
		newCards.setCardNumber(Long.toString(randomCardNumber));
		newCards.setMobileNumber(mobileNumber);
		newCards.setAmountUsed(0);
		newCards.setAvailableAmount(187876);
		newCards.setCardType("credit type");
		newCards.setTotalLimit(187876);
		return newCards;
	}

	@Override
	public CardsDto fetchCard(String mobileNumber) {
		Cards cards=cardsRepository.findByMobileNumber(mobileNumber)
				                    .orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
				  );
		return CardsMapper.mapToCardDto(cards, new CardsDto());
		
	}

	@Override
	public boolean updateDetails(CardsDto cardsDto) {
		Cards cards = cardsRepository.findByMobileNumber(cardsDto.getMobileNumber())
				                     .orElseThrow(() -> new ResourceNotFoundException("Card", "Cardnumber", cardsDto.getCardNumber())
		);
		CardsMapper.mapToCards(cards, cardsDto);
		cardsRepository.save(cards);
		
		return true;
	}

	@Override
	public boolean deleteDetails(String mobileNumber) {
		Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
				() -> new ResourceNotFoundException("Cards","mobileNumber", mobileNumber)
		);
		
		cardsRepository.deleteById(cards.getCardId());
		return true;
		
	}

}
