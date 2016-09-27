package com.cherokeelessons.deck;

public class Card<T extends ICardData> implements ICard<T> {
	
	protected T data;
	protected Deck<T> myDeck;
	
	protected CardStats cardStats = new CardStats();

	@Override
	public CardStats getCardStats() {
		return cardStats;
	}

	@Override
	public void setCardStats(CardStats cardStats) {
		this.cardStats = cardStats;
	}

	@Override
	public void resetStats(){
		cardStats.setCorrect(true);
		cardStats.setShown(0);
		cardStats.setTotalShownTime(0f);
	}

	@Override
	public T getData() {
		return data;
	}
	
	@Override
	public String id(){
		return data==null?null:data.id();
	}

	@Override
	public Deck<T> getMyDeck() {
		return myDeck;
	}

	@Override
	public boolean isInDeck() {
		return (this.myDeck!=null) && this.myDeck.cards.contains(this); 
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public void setMyDeck(Deck<T> deck) {
		this.myDeck = deck;
	}

	@Override
	public String sortKey() {
		return data.sortKey();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ICard<T> copy() {
		Card<T> copy = new Card<>();
		copy.cardStats=new CardStats(cardStats);
		copy.data=(T) data.copy();
		copy.myDeck=null;
		return copy;
	}

	@Override
	public int compareTo(ICard<T> o) {
		if (o == null) {
			return -1;
		}
		return sortKey().compareTo(o.sortKey());
	}

	@Override
	public boolean equals(ICard<T> obj) {
		if (obj == null || !(obj instanceof ICard)) {
			return false;
		}
		return sortKey().equals(((ICard<T>) obj).sortKey());
	}
	
	/**
	 * How many times a card must be shown in the session. <br>
	 * When using strict pimsleur timings, the pimsleur timing value based on
	 * maxShows must not exceed 1/2 to 3/4 the session length or else the card
	 * will never be successfully marked as known! <br>
	 * 5 minutes sessions can not have a value > 3!
	 * 
	 * @return
	 */
	protected int getMyNextSessionThreshold(int maxShows) {
		int leitnerBox = getCardStats().getLeitnerBox();
		while (leitnerBox>0 && maxShows>1) {
			leitnerBox--;
			maxShows--;
		}
		return maxShows;
	};

	@Override
	public void resetTriesRemaining(int maxTriesRemaining) {
		getCardStats().setTriesRemaining(getMyNextSessionThreshold(maxTriesRemaining));
	}
}
