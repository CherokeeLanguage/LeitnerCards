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

	public void resetStats(){
		cardStats.setCorrect(true);
		cardStats.setShown(0);
		cardStats.setTotalShownTime(0f);
		cardStats.setTriesRemaining(0);
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
	public int getLeitnerBox() {
		return cardStats.getLeitnerBox();
	}

	@Override
	public Deck<T> getMyDeck() {
		return myDeck;
	}

	@Override
	public int getPimsleurSlot() {
		return cardStats.getPimsleurSlot();
	}

	@Override
	public long getShowAgainDelay_ms() {
		return cardStats.getShowAgainDelay_ms();
	}

	@Override
	public int getShown() {
		return cardStats.getShown();
	}
	
	@Override
	public float getTotalShownTime() {
		return cardStats.getTotalShownTime();
	}

	@Override
	public int getTriesRemaining() {
		return cardStats.getTriesRemaining();
	}

	@Override
	public boolean isCorrect() {
		return cardStats.isCorrect();
	}

	@Override
	public boolean isInDeck() {
		return (this.myDeck!=null) && this.myDeck.cards.contains(this); 
	}

	@Override
	public void setCorrect(boolean correct) {
		this.cardStats.setCorrect(correct);
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public void setLeitnerBox(int box) {
		this.cardStats.setLeitnerBox(box);
	}

	@Override
	public void setMyDeck(Deck<T> deck) {
		this.myDeck = deck;
	}

	@Override
	public void setPimsleurSlot(int slot) {
		this.cardStats.setPimsleurSlot(slot);
	}

	@Override
	public void setShowAgainDelay_ms(long showAgainDelay_ms) {
		this.cardStats.setShowAgainDelay_ms(showAgainDelay_ms);
	}

	@Override
	public void setShown(int shown) {
		this.cardStats.setShown(shown);
	}

	@Override
	public void setTotalShownTime(float totalShownTime) {
		this.cardStats.setTotalShownTime(totalShownTime);
	}

	@Override
	public void setTriesRemaining(int triesRemaining) {
		this.cardStats.setTriesRemaining(triesRemaining);
	}

	@Override
	public String sortKey() {
		return data.sortKey();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ICard<T> copy() {
		Card<T> copy = new Card<>();
		copy.cardStats.setCorrect(cardStats.isCorrect());
		copy.data=(T) data.copy();
		copy.cardStats.setLeitnerBox(cardStats.getLeitnerBox());
		copy.myDeck=null;
		copy.cardStats.setPimsleurSlot(cardStats.getPimsleurSlot());
		copy.cardStats.setShowAgainDelay_ms(cardStats.getShowAgainDelay_ms());
		copy.cardStats.setShown(cardStats.getShown());
		copy.cardStats.setTotalShownTime(cardStats.getTotalShownTime());
		copy.cardStats.setTriesRemaining(cardStats.getTriesRemaining());
		return copy;
	}
}
