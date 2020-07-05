package com.cherokeelessons.deck;

public class Card<T extends ICardData> implements ICard<T> {

	protected T data;
	protected Deck<T, ? extends ICard<T>> myDeck;

	protected CardStats cardStats = new CardStats();

	@Override
	public int compareTo(final ICard<T> o) {
		if (o == null) {
			return -1;
		}
		return sortKey().compareTo(o.sortKey());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <U extends ICard<T>> U copy() {
		final Card<T> copy = new Card<>();
		copy.cardStats = new CardStats(cardStats);
		copy.data = (T) data.copy();
		copy.myDeck = null;
		return (U) copy;
	}

	@Override
	public <U extends ICard<T>> boolean equals(final U obj) {
		if (obj == null) {
			return false;
		}
		return sortKey().equals(obj.sortKey());
	}

	@Override
	public CardStats getCardStats() {
		return cardStats;
	}

	@Override
	public T getData() {
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Deck<T, ? extends ICard<T>> getMyDeck() {
		return myDeck;
	}

	/**
	 * How many times a card must be shown in the session. <br>
	 * When using strict Pimsleur timings, the Pimsleur timing value based on
	 * maxShows must not exceed 1/2 to 3/4 the session length or else the card will
	 * never be successfully marked as answered correctly all times and moved to the
	 * next higher Leitner box! For example: 5 minutes sessions can not have a maxShows > 3.<br>
	 * Basically returns the supplied value - the current Leitner box the card is
	 * in.
	 * @param maxShows
	 * @return
	 */
	protected int getMyNextSessionThreshold(final int maxShows) {
		final int leitnerBox = getCardStats().getLeitnerBox();
		return Math.max(maxShows - leitnerBox, 1);
	}

	@Override
	public String id() {
		return data == null ? null : data.id();
	}

	@Override
	public boolean isInDeck() {
		return this.myDeck != null && this.myDeck.cards.contains(this);
	}

	@Override
	public void resetStats() {
		cardStats.setCorrect(true);
		cardStats.setShown(0);
		cardStats.setTotalShownTime(0f);
	}

	@Override
	public void resetTriesRemaining(final int maxTriesRemaining) {
		getCardStats().setTriesRemaining(getMyNextSessionThreshold(maxTriesRemaining));
	}
	
	/**
	 * Use default value of 3 for max tries to align with 5 minutes session windows.
	 */
	public void resetTriesRemaining() {
		resetTriesRemaining(3);
	}

	@Override
	public void setCardStats(final CardStats cardStats) {
		this.cardStats = cardStats;
	}

	@Override
	public void setData(final T data) {
		this.data = data;
	}

	@Override
	public <U extends ICard<T>> void setMyDeck(final Deck<T, U> deck) {
		this.myDeck = deck;
	}

	@Override
	public String sortKey() {
		return data.sortKey();
	}
}
