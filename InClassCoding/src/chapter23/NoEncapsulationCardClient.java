package chapter23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class NoEncapsulationCardClient {
	public static final String[] RANKS = {"Ace","Two","Three","Four","Five",
			"Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	public static final String[] SUITS = {"Clubs","Diamonds","Spades","Hearts"};
	private static final int MAX_CARDS = RANKS.length*SUITS.length;
	
	public static void main(String [] pArgs) {
		List<Integer> deck = new ArrayList<>();
		for(int i=0; i<MAX_CARDS; i++) {
			deck.add(i);
			System.out.println(cardAsString(i));
		}
		Collections.shuffle(deck);
		for(int i: deck) {
			System.out.println(cardAsString(i));
		}
		int card = deck.get(0);
		//card =+ MAX_CARDS; will cause problem, how to design a more robust program??
		System.out.println(cardAsString(card));
	}
	private static String cardAsString(int pcard) {
		return RANKS[pcard%RANKS.length]+" of "+SUITS[pcard/RANKS.length];
	}
	private NoEncapsulationCardClient() {}
}
