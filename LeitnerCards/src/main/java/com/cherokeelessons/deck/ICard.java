package com.cherokeelessons.deck;

public interface ICard<T extends ICardData> extends Comparable<ICard<T>> {
	/**
	 * Returns a deep copy of the card, INCLUDING the card data. The copy does NOT
	 * include the assigned deck of the original card!
	 * 
	 * @return
	 */
	public ICard<T> copy();

	CardStats getCardStats();

	T getData();

	Deck<T> getMyDeck();

	String id();

	boolean isInDeck();

	void setCardStats(CardStats cardStats);

	void setData(T data);

	void setMyDeck(Deck<T> deck);

	String sortKey();

	boolean equals(ICard<T> obj);

	void resetStats();

	void resetTriesRemaining();
}
