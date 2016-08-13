package com.cherokeelessons.deck;

import java.util.ArrayList;
import java.util.List;

public class Deck<T> {
	public Deck() {
		cards=new ArrayList<>();
	}
	protected List<ICard<T>> cards;
	public void add(ICard<T> card) {
		card.getDeck().remove(card);
		cards.add(card);
	}
	public void remove(ICard<T> card) {
		cards.remove(card);
	}
}
