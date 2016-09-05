package com.cherokeelessons.deck;

public interface Card<T extends ICardData> extends Comparable<Card<T>> {

	@Override
	default int compareTo(Card<T> o) {
		if (o == null) {
			return -1;
		}
		return sortKey().compareTo(o.sortKey());
	}

	default boolean equals(Card<T> obj) {
		if (obj == null || !(obj instanceof Card)) {
			return false;
		}
		return sortKey().equals(((Card<T>) obj).sortKey());
	}

	T getData();

	Deck<T> getMyDeck();

	int getNextLeitnerInterval();

	int getPimsleurSlot();

	long getShowAgainDelay();

	int getTriesRemaining();

	boolean isCorrect();

	void setCorrect(boolean correct);

	void setData(T data);

	void setMyDeck(Deck<T> deck);

	void setLeitnerBox(int box);

	void setNextPimsleurInterval(int interval);

	void setShowAgainDelay(long ms);

	void setTriesRemaining(int triesRemaining);

	String sortKey();
}
