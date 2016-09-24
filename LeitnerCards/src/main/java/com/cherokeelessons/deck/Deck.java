package com.cherokeelessons.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

public class Deck<T extends ICardData> {
	public Deck() {
		cards = new ArrayList<>();
	}

	/**
	 * Returns {@linkplain ListIterator} for assigned cards.
	 * 
	 * @return
	 */
	public ListIterator<ICard<T>> cardsIterator() {
		return cards.listIterator();
	}

	/**
	 * Returns {@linkplain List} of assigned cards.
	 * 
	 * @return
	 */
	public List<ICard<T>> getCards() {
		return cards;
	}

	protected List<ICard<T>> cards;

	/**
	 * Adds card to this deck. Removes card from previous deck (if any).
	 * 
	 * @param card
	 */
	public void add(ICard<T> card) {
		if (card.isInDeck()) {
			card.getMyDeck().remove(card);
		}
		card.setMyDeck(this);
		cards.add(card);
	}

	/**
	 * Removes card from this deck. Sets card's assigned deck to NULL.
	 * 
	 * @param card
	 */
	public void remove(ICard<T> card) {
		card.setMyDeck(null);
		cards.remove(card);
	}

	/**
	 * Current count of cards in the deck.
	 * 
	 * @return
	 */
	public int size() {
		return cards.size();
	}

	/**
	 * Are there any cards remaining in this deck?
	 * 
	 * @return
	 */
	public boolean hasNext() {
		return cards.size() != 0;
	}

	/**
	 * Retrieve and remove the next available card from the deck. <br/>
	 * 
	 * @return
	 */
	public ICard<T> next() {
		return cards.remove(0);
	}

	/**
	 * Peek at the next available card on the deck. <br/>
	 * 
	 * @return
	 */
	public ICard<T> peek() {
		return cards.get(0);
	}

	/**
	 * Shuffle. (GWT safe method.) <br/>
	 * Uses random access shuffle algorithm based on OpenJDK's
	 * {@linkplain Collections#shuffle(List, Random)}
	 */
	public void shuffle(long seed) {
		Random r = new Random(seed);
		for (int i = cards.size(); i > 1; i--) {
			int j = r.nextInt(i);
			cards.set(i - 1, cards.set(j, cards.get(i - 1)));
		}
	}

	/**
	 * Shuffle. (GWT safe method.)
	 */
	public void shuffle() {
		shuffle(System.currentTimeMillis());
	}

	/**
	 * Sort deck using each card's full sortKey.
	 */
	public void sort() {
		Collections.sort(cards);
	}

	/**
	 * Sort deck using fixed length prefix of sortKey. <br/>
	 * Useful when cards are prefixed with a group identifier. First shuffle the
	 * deck, then sort by the group identifier's length. Each group will still
	 * be shuffled, but the groups will be grouped together in order in the
	 * deck.
	 */
	public void sort(final int keyLength) {
		Collections.sort(cards, new Comparator<ICard<T>>() {
			Map<ICard<T>, String> prefixCache = new HashMap<>();

			@Override
			public int compare(ICard<T> o1, ICard<T> o2) {
				if (o1 == o2) {
					return 0;
				}
				if (o1 == null) {
					return -1;
				}
				if (o2 == null) {
					return 1;
				}
				String key1 = prefixCache.get(o1);
				if (key1 == null) {
					key1 = o1.sortKey();
					key1 = key1.substring(0, Math.min(keyLength, key1.length()));
					prefixCache.put(o1, key1);
				}
				String key2 = prefixCache.get(o2);
				if (key2 == null) {
					key2 = o2.sortKey();
					key2 = key2.substring(0, Math.min(keyLength, key2.length()));
					prefixCache.put(o2, key2);
				}
				return key1.compareTo(key2);
			}
		});
	}

	/**
	 * Order cards in deck based on the next session each card is scheduled
	 * for.<br/>
	 * First shuffles the deck, then sorts by the key prefix length, and finally
	 * sorts by what session the card should be seen in next.
	 */
	public void shuffleAndSortForPlay(final int keyLength) {
		this.shuffle();
		this.sort(keyLength);

		Collections.sort(cards, new Comparator<ICard<T>>() {
			@Override
			public int compare(ICard<T> o1, ICard<T> o2) {
				if (o1 == o2) {
					return 0;
				}
				if (o1 == null) {
					return -1;
				}
				if (o2 == null) {
					return 1;
				}
				return o1.getNextSessionShow() - o2.getNextSessionShow();
			}
		});
	}

	/**
	 * Reverse the order of the deck.
	 */
	public void reverse() {
		Collections.reverse(cards);
	}

}
