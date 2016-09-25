package com.cherokeelessons.deck;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DeckStats implements Serializable {
	public static final int FULLY_LEARNED_BOX = 10;
	public static final int JUST_LEARNED_BOX = 1;
	public static final int PROFICIENT_BOX = 5;
	private static int StatsVersion = 1;

	public static <T extends ICardData> DeckStats calculateStats(Deck<T> activeDeck) {
		DeckStats info = new DeckStats();
		if (activeDeck == null || activeDeck.size() == 0) {
			return info;
		}

		/*
		 * Set "level" to ceil(average box value) found in active deck. Negative
		 * box values are ignored.
		 */

		int boxsum = 0;
		for (ICard<T> card : activeDeck.getCards()) {
			CardStats cardStats = card.getCardStats();
			boxsum += (cardStats.getLeitnerBox() > 0 ? cardStats.getLeitnerBox() : 0);
		}
		info.level = SkillLevel.forLevel((int) Math.ceil((double) (boxsum) / (double) activeDeck.size()));
		/*
		 * Set "fullScore" to sum of all box values found in active deck
		 */
		boxsum = 0;
		for (ICard<T> card : activeDeck.getCards()) {
			boxsum += card.getCardStats().getLeitnerBox();
		}
		info.fullScore = boxsum;

		/*
		 * Set last score based on timings of most recent session. Cards with
		 * errors count as "-1" each. Apply "boxlevel" values as bonus points.
		 */
		float maxCardScore = 60; // 60 seconds max, 1 point per second not used
									// up
		float score = 0f;
		boolean perfect = true;
		for (ICard<T> card : activeDeck.getCards()) {
			CardStats cardStats = card.getCardStats();
			if (cardStats.getShown() == 0) {
				continue;
			}
			if (!cardStats.isCorrect()) {
				score -= maxCardScore;
				perfect = false;
			}
			double avgShowTime = cardStats.getTotalShownTime() / (float) cardStats.getShown();
			double cardScore = maxCardScore - avgShowTime;
			if (cardScore < 1) {
				cardScore = 1;
			}
			score += (cardScore + cardStats.getLeitnerBox());
		}
		if (perfect) {
			score *= 1.1f; // 10% percent bonus for perfect runs
		}
		info.lastScore = (int) Math.ceil(score);
		info.perfect = perfect;
		/*
		 * Calculate total proficiency with active cards (based on most recent
		 * noErrors flag)
		 */
		int totalCards = activeDeck.size();
		int correctCount = 0;
		for (ICard<T> card : activeDeck.getCards()) {
			if (card.getCardStats().isCorrect()) {
				correctCount++;
			}
			info.proficiency = ((100 * correctCount) / totalCards);
		}

		/*
		 * How many are "fully learned" out of the active deck?
		 */
		info.longTerm = 0;
		for (ICard<T> card : activeDeck.getCards()) {
			if (card.getCardStats().getLeitnerBox() >= FULLY_LEARNED_BOX) {
				info.longTerm++;
			}
		}

		/*
		 * count all active cards that aren't "fully learned"
		 */
		info.activeCards = activeDeck.size() - info.longTerm;

		/*
		 * How many are "well known" out of the active deck? (excluding full
		 * learned ones)
		 */
		info.mediumTerm = 0;
		for (ICard<T> card : activeDeck.getCards()) {
			CardStats cardStats = card.getCardStats();
			if (cardStats.getLeitnerBox() >= PROFICIENT_BOX && cardStats.getLeitnerBox() < FULLY_LEARNED_BOX) {
				info.mediumTerm++;
			}
		}

		/*
		 * How many are "short term known" out of the active deck? (excluding
		 * full learned ones)
		 */
		info.shortTerm = 0;
		for (ICard<T> card : activeDeck.getCards()) {
			CardStats cardStats = card.getCardStats();
			if (cardStats.getLeitnerBox() >= JUST_LEARNED_BOX && cardStats.getLeitnerBox() < PROFICIENT_BOX) {
				info.shortTerm++;
			}
		}

		return info;
	}

	public static int getStatsVersion() {
		return StatsVersion;
	}

	public static void setStatsVersion(int statsVersion) {
		StatsVersion = statsVersion;
	}

	public int activeCards = 0;
	/**
	 * The summed "box" values for all active cards
	 */
	public int fullScore = 0;

	public long lastrun;
	public int lastScore;

	public SkillLevel level;
	public int longTerm = 0;
	public int mediumTerm = 0;
	public boolean perfect;
	public int proficiency = 0;
	/**
	 * The summed "box" values for the most recent learning session
	 */
	public int sessionScore = 0;
	public int shortTerm = 0;
	private String signature = "";
	private int version;

	public DeckStats() {
	}

	public DeckStats(DeckStats deskStats) {
		this.activeCards = deskStats.activeCards;
		this.level = deskStats.level;
		this.longTerm = deskStats.longTerm;
		this.mediumTerm = deskStats.mediumTerm;

	}

	public String getSignature() {
		return signature;
	}

	public int getVersion() {
		return StatsVersion;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean updatedVersion() {
		return version == StatsVersion;
	}

	public void validate() {
		if (level == null) {
			level = SkillLevel.Newbie;
		}
	}
}
