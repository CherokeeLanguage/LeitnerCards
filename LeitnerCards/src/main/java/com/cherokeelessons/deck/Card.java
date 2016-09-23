package com.cherokeelessons.deck;

public class Card<T extends ICardData> implements ICard<T> {
	protected T data;
	protected Deck<T> myDeck;
	protected int leitnerBox;
	protected int pimsleurSlot;
	protected long showAgainDelay_ms;
	protected int triesRemaining;
	protected boolean correct;

	@Override
	public T getData() {
		return data;
	}

	@Override
	public Deck<T> getMyDeck() {
		return myDeck;
	}

	@Override
	public int getLeitnerBox() {
		return leitnerBox;
	}

	@Override
	public int getPimsleurSlot() {
		return pimsleurSlot;
	}

	@Override
	public long getShowAgainDelay() {
		return showAgainDelay_ms;
	}

	@Override
	public int getTriesRemaining() {
		return triesRemaining;
	}

	@Override
	public boolean isCorrect() {
		return correct;
	}

	@Override
	public void setCorrect(boolean correct) {
		this.correct = correct;
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
	public void setLeitnerBox(int box) {
		this.leitnerBox = box;
	}

	@Override
	public void setPimsleurSlot(int slot) {
		this.pimsleurSlot = slot;
	}

	@Override
	public void setShowAgainDelay(long ms) {
		this.showAgainDelay_ms = ms;
	}

	@Override
	public void setTriesRemaining(int triesRemaining) {
		this.triesRemaining = triesRemaining;
	}

	@Override
	public String sortKey() {
		return data.sortKey();
	}

	@Override
	public boolean isInDeck() {
		return (this.myDeck!=null) && this.myDeck.cards.contains(this); 
	}
}
