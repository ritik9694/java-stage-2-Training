package com.cognizant.cards.mapper;

import com.cognizant.cards.dto.CardsDto;
import com.cognizant.cards.entity.Cards;

public class CardsMapper {

	public static CardsDto mapToCardDto(Cards cards,CardsDto cardsDto) {
		cardsDto.setMobileNumber(cards.getMobileNumber());
		cardsDto.setCardNumber(cards.getCardNumber());
		cardsDto.setCardType(cards.getCardType());
		cardsDto.setAvailableAmount(cards.getAvailableAmount());
		cardsDto.setTotalLimit(cards.getTotalLimit());
		cardsDto.setAmountUsed(cards.getAmountUsed());
		
		return cardsDto;
	}
	
	public static Cards mapToCards(Cards cards, CardsDto cardsDto) {
		cards.setAmountUsed(cardsDto.getAmountUsed());
		cards.setAvailableAmount(cardsDto.getAvailableAmount());
		cards.setCardNumber(cardsDto.getCardNumber());
		cards.setCardType(cardsDto.getCardType());
		cards.setMobileNumber(cardsDto.getMobileNumber());
		cards.setTotalLimit(cardsDto.getTotalLimit());
		
		return cards;
	}
}
