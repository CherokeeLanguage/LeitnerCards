package com.cherokeelessons.deck;

public interface ICard<T extends ICardData> extends Comparable<ICard<T>> {
	/**
	 * Returns a deep copy of the card, INCLUDING the card data. The copy does NOT
	 * include the assigned deck of the original card!
	 * 
	 * @return
	 */
	public ICard<T> copy();

	public int getNextSessionShow();
	public void setNextSessionShow(int sessions);

	CardStats getCardStats();

	T getData();

	int getLeitnerBox();

	Deck<T> getMyDeck();

	int getPimsleurSlot();

	long getShowAgainDelay_ms();

	int getShown();

	float getTotalShownTime();

	int getTriesRemaining();

	String id();

	boolean isCorrect();

	boolean isInDeck();

	void setCardStats(CardStats cardStats);

	void setCorrect(boolean correct);

	void setData(T data);

	void setLeitnerBox(int box);

	void setMyDeck(Deck<T> deck);

	void setPimsleurSlot(int interval);

	void setShowAgainDelay_ms(long showAgainDelay_ms);

	void setShown(int shown);

	void setTotalShownTime(float totalShownTime);
	
	void setTriesRemaining(int triesRemaining);
	String sortKey();

	boolean equals(ICard<T> obj);
}
