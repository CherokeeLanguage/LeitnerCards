package com.cherokeelessons.deck;

public interface ICard<T extends ICardData> extends Comparable<ICard<T>> {

	/**
	 * Returns a deep copy of the card, INCLUDING the card data. The copy does NOT
	 * include the assigned deck of the original card!
	 * 
	 * @return
	 */
	public ICard<T> copy();

	@Override
	default int compareTo(ICard<T> o) {
		if (o == null) {
			return -1;
		}
		return sortKey().compareTo(o.sortKey());
	}

	default boolean equals(ICard<T> obj) {
		if (obj == null || !(obj instanceof ICard)) {
			return false;
		}
		return sortKey().equals(((ICard<T>) obj).sortKey());
	}

	T getData();

	Deck<T> getMyDeck();

	int getLeitnerBox();

	int getPimsleurSlot();

	long getShowAgainDelay();

	int getTriesRemaining();

	boolean isCorrect();

	void setCorrect(boolean correct);

	void setData(T data);

	void setMyDeck(Deck<T> deck);

	void setLeitnerBox(int box);

	void setPimsleurSlot(int interval);

	void setShowAgainDelay(long ms);

	void setTriesRemaining(int triesRemaining);

	String sortKey();

	boolean isInDeck();

	void setTotalShownTime(float totalShownTime);

	void setShown(int shown);

	void setShowAgainDelay_ms(long showAgainDelay_ms);

	float getTotalShownTime();

	int getShown();

	long getShowAgainDelay_ms();
}
