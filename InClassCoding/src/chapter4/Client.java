package chapter4;

import java.util.HashSet;
import java.util.Set;

import chapter4.Card.Joker;

public class Client {
	public static void main(String [] args) {
		//String test1 = "hello";
		//String test2 = new String("hello");
		
		//equals: reflexive, symmetric, transitive, consistent ...
		
		Card card1 = Card.get (Rank.Ace, Suit.Clubs);
		Card card2 = Card.get (Rank.Ace, Suit.Clubs);
		//Card card2 = new Card (Rank.Ace, Suit.Clubs);
		
		System.out.println(card1==card2);
		System.out.println(card1.equals(card2));
		
		Set<Card> set = new HashSet<>();
		set.add(card1);
		System.out.println(set.contains(card2));
		set.add(card2);
		System.out.println(set);
		
		Card card = Card.get(Rank.Ace, Suit.Clubs);
		Card joker = Card.getJoker(Joker.WHITE);
		System.out.println(card+" "+joker);
		//System.out.println(card.jokerType()+" "+joker.jokerType());
		System.out.println(joker.jokerType());
		
		//Rank myRank = joker.getRank();
	}
}

