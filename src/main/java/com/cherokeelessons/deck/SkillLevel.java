package com.cherokeelessons.deck;

public enum SkillLevel {
	Newbie("Newbie", 0), Novice("Novice", 1), Rookie("Rookie", 2), Beginner(
			"Beginner", 3), Apprentice("Apprentice",
			4), Intermediate("Intermediate", 5), Advanced("Advanced", 6), Proficient("Proficient", 7), Expert("Expert", 8), Master(
			"Master", 9), GrandMaster("Grandmaster",
			10);

	public SkillLevel next() {
		SkillLevel[] values = SkillLevel.values();
		int ix = (ordinal() + 1) % (values.length);
		return values[ix];
	}

	private final int level;
	private final String english;

	public static SkillLevel getNext(SkillLevel current) {
		return current.next();
	}

	public int getAchievementPoints() {
		return (level + 1) * 5;
	}

	private SkillLevel(String english, int level) {
		this.english = english;
		this.level = level;
	}

	public static SkillLevel forLevel(int level_number) {
		SkillLevel level = Newbie;
		for (SkillLevel maybe : SkillLevel.values()) {
			if (maybe.level == level_number) {
				return maybe;
			}
			if (maybe.level > level.level && maybe.level < level_number) {
				level = maybe;
			}
		}
		return level;
	}

	public int getLevel() {
		return level;
	}

	public String getEnglish() {
		return english;
	}

	@Override
	public String toString() {
		return getEnglish();
	}

}