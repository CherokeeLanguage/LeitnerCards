package com.cherokeelessons.deck;

public class CardStats {
	private boolean correct;
	private int leitnerBox;
	private int pimsleurSlot;
	private long showAgainDelay_ms;
	private int shown;
	private float totalShownTime;
	private int triesRemaining;

	public CardStats() {
	}
	
	public void leitnerBoxInc() {
		leitnerBox++;
	}
	public void leitnerBoxDec() {
		if (leitnerBox>0) {
			leitnerBox--;
		}
	}
	
	public void pimsleurSlotInc() {
		pimsleurSlot++;
	}
	public void pimsleurSlotDec() {
		if (pimsleurSlot>0) {
			pimsleurSlot--;
		}
	}
	
	public CardStats(CardStats copy) {
		if (copy==null) {
			return;
		}
		correct=copy.correct;
		leitnerBox=copy.leitnerBox;
		pimsleurSlot=copy.pimsleurSlot;
		showAgainDelay_ms=copy.showAgainDelay_ms;
		shown=copy.shown;
		totalShownTime=copy.totalShownTime;
		triesRemaining=copy.triesRemaining;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public int getLeitnerBox() {
		return leitnerBox;
	}

	public void setLeitnerBox(int leitnerBox) {
		this.leitnerBox = leitnerBox;
	}

	public int getPimsleurSlot() {
		return pimsleurSlot;
	}

	public void setPimsleurSlot(int pimsleurSlot) {
		this.pimsleurSlot = pimsleurSlot;
	}

	public long getShowAgainDelay_ms() {
		return showAgainDelay_ms;
	}

	public void setShowAgainDelay_ms(long showAgainDelay_ms) {
		this.showAgainDelay_ms = showAgainDelay_ms;
	}

	public int getShown() {
		return shown;
	}

	public void setShown(int shown) {
		this.shown = shown;
	}

	public float getTotalShownTime() {
		return totalShownTime;
	}

	public void setTotalShownTime(float totalShownTime) {
		this.totalShownTime = totalShownTime;
	}

	public int getTriesRemaining() {
		return triesRemaining;
	}

	public void setTriesRemaining(int triesRemaining) {
		this.triesRemaining = triesRemaining;
	}
}