package com.cherokeelessons.deck;

public interface ICard<T> extends Comparable<ICard<T>> {
	
	@Override
	default int compareTo(ICard<T> o) {
		if (o==null) {
			return -1;
		}
		return sortKey().compareTo(o.sortKey());
	}
	default boolean equals(ICard<T> obj) {
		if (obj==null || !(obj instanceof ICard)) {
			return false;
		}
		return sortKey().equals(((ICard<T>)obj).sortKey());
	}
	
	T getData();
	Deck<T> getDeck();
	int getNextLeitnerInterval();
	int getPimsleurSlot();
	long getShowAgainDelay();
	int getTriesRemaining();
	boolean isCorrect();
	void setCorrect(boolean correct);
	void setData(T data);
	void setDeck(Deck<T> deck);
	void setLeitnerBox(int box);
	void setNextPimsleurInterval(int interval);
	void setShowAgainDelay(long ms);
	void setTriesRemaining(int triesRemaining);
	String sortKey();
}