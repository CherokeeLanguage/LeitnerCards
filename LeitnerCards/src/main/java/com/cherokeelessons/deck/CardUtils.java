package com.cherokeelessons.deck;

import java.util.ArrayList;
import java.util.List;

public class CardUtils {

	private static final List<Long> pimsleur_intervals = new ArrayList<Long>();
	private static final List<Long> sm2_intervals_ms = new ArrayList<Long>();
	private static final List<Long> sm2_intervals_days = new ArrayList<Long>();

	static {
		/*
		 * for Pimsleur
		 */
		long ms = 1000l;
		for (int i = 0; i < 15; i++) {
			ms *= 5l;
			pimsleur_intervals.add(ms);
		}
		/*
		 * for SM2 gaps in ms
		 */
		long ms_day = 1000l * 60l * 60l * 24;
		float days = 4f;
		sm2_intervals_ms.add(ms_day);
		for (int i = 0; i < 15; i++) {
			sm2_intervals_ms.add((long) (ms_day * days));
			days *= 1.7f;
		}
		/*
		 * for SM2 gaps in whole days
		 */
		days = 4f;
		sm2_intervals_days.add(1l);
		for (int i = 0; i < 15; i++) {
			sm2_intervals_days.add((long) Math.ceil(days));
			days *= 1.7f;
		}
	}

	/**
	 * Pimsleur staggered intervals (powers of 5) seconds as ms
	 * 
	 * @param correct_in_a_row
	 * @return
	 */
	public static long getNextInterval(int correct_in_a_row) {
		if (correct_in_a_row < 0) {
			correct_in_a_row = 0;
		}
		if (correct_in_a_row > pimsleur_intervals.size() - 1) {
			correct_in_a_row = pimsleur_intervals.size() - 1;
		}
		return pimsleur_intervals.get(correct_in_a_row);
	}

	/**
	 * SM2 staggered intervals (powers of 1.7) days as ms
	 * 
	 * @param box
	 * @return
	 */
	public static long getNextSessionInterval_ms(int box) {
		if (box >= sm2_intervals_ms.size()) {
			box = sm2_intervals_ms.size() - 1;
		}
		if (box < 0) {
			box = 0;
		}
		return sm2_intervals_ms.get(box);
	}

	/**
	 * SM2 staggered intervals (powers of 1.7) days. (Rounded up to the next
	 * whole day). *
	 * 
	 * @param box
	 * @return
	 */
	public static long getNextSessionIntervalDays(int box) {
		if (box >= sm2_intervals_days.size()) {
			box = sm2_intervals_days.size() - 1;
		}
		if (box < 0) {
			box = 0;
		}
		return sm2_intervals_days.get(box);
	}
}
