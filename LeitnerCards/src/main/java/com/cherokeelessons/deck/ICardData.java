package com.cherokeelessons.deck;

public interface ICardData {
	/**
	 * A string generated from selected fields for sorting purposes.
	 */
	public String sortKey();

	/**
	 * A string generated from selected fields for card id purposes. Useful to
	 * keep track of what cards are "in play" between sessions.
	 */
	public String id();
}