package com.cherokeelessons.deck;

public enum SkillLevel {
	Newbie("Newbie", 0), Novice("Novice", 1), Rookie("Rookie", 2), Beginner("Beginner", 3), Apprentice("Apprentice", 4),
	Intermediate("Intermediate", 5), Advanced("Advanced", 6), Proficient("Proficient", 7), Expert("Expert", 8),
	Master("Master", 9), GrandMaster("Grandmaster", 10);

	public static SkillLevel forLevel(final int level_number) {
		SkillLevel level = Newbie;
		for (final SkillLevel maybe : SkillLevel.values()) {
			if (maybe.level == level_number) {
				return maybe;
			}
			if (maybe.level > level.level && maybe.level < level_number) {
				level = maybe;
			}
		}
		return level;
	}

	public static SkillLevel getNext(final SkillLevel current) {
		return current.next();
	}

	private final int level;

	private final String english;

	private SkillLevel(final String english, final int level) {
		this.english = english;
		this.level = level;
	}

	public int getAchievementPoints() {
		return (level + 1) * 5;
	}

	public String getEnglish() {
		return english;
	}

	public int getLevel() {
		return level;
	}

	public SkillLevel next() {
		final SkillLevel[] values = SkillLevel.values();
		final int ix = (ordinal() + 1) % values.length;
		return values[ix];
	}

	@Override
	public String toString() {
		return getEnglish();
	}

}