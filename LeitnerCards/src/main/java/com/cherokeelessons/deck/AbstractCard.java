package com.cherokeelessons.deck;

public abstract class AbstractCard<T> implements ICard<T> {

	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deck<T> getDeck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNextLeitnerInterval() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPimsleurSlot() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getShowAgainDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTriesRemaining() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCorrect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCorrect(boolean correct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setData(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDeck(Deck<T> deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLeitnerBox(int box) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNextPimsleurInterval(int interval) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setShowAgainDelay(long ms) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTriesRemaining(int triesRemaining) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String sortKey() {
		// TODO Auto-generated method stub
		return null;
	}
}
