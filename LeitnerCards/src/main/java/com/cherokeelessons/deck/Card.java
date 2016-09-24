package com.cherokeelessons.deck;

public class Card<T extends ICardData> implements ICard<T> {
	
	protected boolean correct;
	protected T data;
	protected int leitnerBox;
	protected Deck<T> myDeck;
	protected int pimsleurSlot;
	protected long showAgainDelay_ms;
	/*
	 * For scoring..
	 */
	protected int shown;
	protected float totalShownTime;
	protected int triesRemaining;
	
	public void resetStats(){
		correct=true;
		shown=0;
		totalShownTime=0f;
		triesRemaining=0;
	}

	@Override
	public T getData() {
		return data;
	}
	
	public String id(){
		return data==null?null:data.id();
	}

	@Override
	public int getLeitnerBox() {
		return leitnerBox;
	}

	@Override
	public Deck<T> getMyDeck() {
		return myDeck;
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
	public long getShowAgainDelay_ms() {
		return showAgainDelay_ms;
	}

	@Override
	public int getShown() {
		return shown;
	}
	
	@Override
	public float getTotalShownTime() {
		return totalShownTime;
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
	public boolean isInDeck() {
		return (this.myDeck!=null) && this.myDeck.cards.contains(this); 
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
	public void setLeitnerBox(int box) {
		this.leitnerBox = box;
	}

	@Override
	public void setMyDeck(Deck<T> deck) {
		this.myDeck = deck;
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
	public void setShowAgainDelay_ms(long showAgainDelay_ms) {
		this.showAgainDelay_ms = showAgainDelay_ms;
	}

	@Override
	public void setShown(int shown) {
		this.shown = shown;
	}

	@Override
	public void setTotalShownTime(float totalShownTime) {
		this.totalShownTime = totalShownTime;
	}

	@Override
	public void setTriesRemaining(int triesRemaining) {
		this.triesRemaining = triesRemaining;
	}

	@Override
	public String sortKey() {
		return data.sortKey();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ICard<T> copy() {
		Card<T> copy = new Card<>();
		copy.correct=correct;
		copy.data=(T) data.copy();
		copy.leitnerBox=leitnerBox;
		copy.myDeck=null;
		copy.pimsleurSlot=pimsleurSlot;
		copy.showAgainDelay_ms=showAgainDelay_ms;
		copy.shown=shown;
		copy.totalShownTime=totalShownTime;
		copy.triesRemaining=triesRemaining;
		return copy;
	}
}
