package com.cherokeelessons.deck;

public interface ICard<T extends ICardData> extends Comparable<ICard<T>> {
	/**
	 * Returns a deep copy of the card, INCLUDING the card data. The copy will not
	 * be assigned to a deck!
	 *
	 * @return Deep Cloned Copy.
	 */
	<U extends ICard<T>> U copy();

	<U extends ICard<T>> boolean equals(U obj);

	CardStats getCardStats();

	T getData();

	<U extends ICard<T>> Deck<T, U> getMyDeck();

	String id();

	boolean isInDeck();

	void resetStats();

	void resetTriesRemaining(int maxTriesRemaining);
	
	void setCardStats(CardStats cardStats);

	void setData(T data);

	<U extends ICard<T>> void setMyDeck(Deck<T, U> deck);

	String sortKey();
}
