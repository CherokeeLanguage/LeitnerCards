package com.cherokeelessons.deck;

import java.util.ArrayList;
import java.util.List;

public class Deck<T extends CardData> {
	public Deck() {
		cards = new ArrayList<>();
	}

	protected List<Card<T>> cards;

	public void add(Card<T> card) {
		card.getMyDeck().remove(card);
		cards.add(card);
	}

	public void remove(Card<T> card) {
		cards.remove(card);
	}
}
