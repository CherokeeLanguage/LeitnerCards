package com.cherokeelessons.deck;

public class CardStats {
	private boolean correct;
	private int leitnerBox;
	private int pimsleurSlot;
	private long showAgainDelay_ms;
	private int shown;
	private float totalShownTime;
	private int triesRemaining;
	private boolean newCard;

	protected int nextSessionShow;

	public CardStats() {
	}

	public CardStats(final CardStats copy) {
		if (copy == null) {
			return;
		}
		correct = copy.correct;
		leitnerBox = copy.leitnerBox;
		pimsleurSlot = copy.pimsleurSlot;
		showAgainDelay_ms = copy.showAgainDelay_ms;
		shown = copy.shown;
		totalShownTime = copy.totalShownTime;
		triesRemaining = copy.triesRemaining;
	}

	public int getLeitnerBox() {
		return leitnerBox;
	}

	public int getNextSessionShow() {
		return nextSessionShow;
	}

	public int getPimsleurSlot() {
		return pimsleurSlot;
	}

	public long getShowAgainDelay_ms() {
		return showAgainDelay_ms;
	}

	public int getShown() {
		return shown;
	}

	public float getTotalShownTime() {
		return totalShownTime;
	}

	public int getTriesRemaining() {
		return triesRemaining;
	}

	public boolean isCorrect() {
		return correct;
	}

	public boolean isNewCard() {
		return newCard;
	}

	public void leitnerBoxDec() {
		if (leitnerBox > 0) {
			leitnerBox--;
		}
	}

	public void leitnerBoxInc() {
		leitnerBox++;
	}

	public void pimsleurSlotDec() {
		if (pimsleurSlot > 0) {
			pimsleurSlot--;
		}
	}

	public void pimsleurSlotInc() {
		pimsleurSlot++;
	}

	public void setCorrect(final boolean correct) {
		this.correct = correct;
	}

	public void setLeitnerBox(final int leitnerBox) {
		this.leitnerBox = leitnerBox;
	}

	public void setNewCard(final boolean newCard) {
		this.newCard = newCard;
	}

	public void setNextSessionShow(final int nextSessionShow) {
		this.nextSessionShow = nextSessionShow;
	}

	public void setPimsleurSlot(final int pimsleurSlot) {
		this.pimsleurSlot = pimsleurSlot;
	}

	public void setShowAgainDelay_ms(final long showAgainDelay_ms) {
		this.showAgainDelay_ms = showAgainDelay_ms;
	}

	public void setShown(final int shown) {
		this.shown = shown;
	}

	public void setTotalShownTime(final float totalShownTime) {
		this.totalShownTime = totalShownTime;
	}

	public void setTriesRemaining(final int triesRemaining) {
		this.triesRemaining = triesRemaining;
	}

	public void triesRemainingDec() {
		if (triesRemaining > 0) {
			triesRemaining--;
		}
	}

	public void triesRemainingInc() {
		triesRemaining++;
	}

}