package com.cherokeelessons.deck;

public interface ICardData {
	/**
	 * Returns a deep copy of this object.
	 *
	 * @param <T>
	 * @return The copy
	 */
	<T extends ICardData> T copy();

	/**
	 * A string generated from selected fields for card id purposes. Useful to keep
	 * track of what cards are "in play" between sessions. Should be unique per
	 * card.
	 *
	 * @return Card ID
	 */
	String id();

	/**
	 * A string generated from selected fields for sorting purposes.
	 *
	 * @return Generated sorting key.
	 */
	String sortKey();
}