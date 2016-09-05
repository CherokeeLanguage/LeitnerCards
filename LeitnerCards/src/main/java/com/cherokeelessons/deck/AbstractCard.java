package com.cherokeelessons.deck;

public abstract class AbstractCard<T extends ICardData> implements Card<T> {
	protected T data;
	protected Deck<T> myDeck;
	protected int leitnerIntervalBox;
	protected int pimsleurIntervalSlot;
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
	public int getNextLeitnerInterval() {
		return leitnerIntervalBox;
	}

	@Override
	public int getPimsleurSlot() {
		return pimsleurIntervalSlot;
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
		this.leitnerIntervalBox = box;
	}

	@Override
	public void setNextPimsleurInterval(int interval) {
		this.pimsleurIntervalSlot = interval;
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
}
