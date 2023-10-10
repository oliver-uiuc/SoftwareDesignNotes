package Chapter23;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

//import Chapter23.Deck.Config;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;

public final class ClientEncapsulatedCard {
//	public static final String[] RANKS = {"Ace","Two","Three","Four","Five",
//			"Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
//	public static final String[] SUITS = {"Clubs","Diamonds","Spades","Hearts"};
	//private static final int MAX_CARDS = RANKS.length*SUITS.length;
	public static void print(Iterable<Card> pCards) {//Iterator<Card> pCards
		int index=1;
		for(Card card:pCards) {
			System.out.println(index++ +" : "+card);
		}
//		Iterator<Card> iterator = pCards.iterator();
////		for(Card card : pDeck.cards()) {
////			System.out.println(index++ + " : "+card);
////		}
//		while(iterator.hasNext()) {//pCards.hasNext()
//			Card card = iterator.next();
//			//Card card = pCards.next();
//			System.out.println(index++ + " : "+card);
//		}
	}
	
	public static void main(String [] pArgs) {
		
		Deck deck = new Deck(new StandardDeck());
		List<Card> someCards = new ArrayList<>();
		someCards.add(deck.draw());
		someCards.add(deck.draw());
		someCards.add(deck.draw());
		//print(someCards);
		print(deck);
		//print(someCards.iterator());
		
		
//		Iterator<Card> iterator = deck.cardIterator();
//		System.out.println(iterator.next());
		
		//deck.sort();
		//print(deck);
		
		
		//System.out.println(new Card(100,100)); will cause problem
		
		//System.out.println(new Card(Rank.Ace,Suit.Clubs));
		//System.out.println(new Card(null,Suit.Clubs));
		
		//Deck deck = new Deck();
		//deck.getCards().remove(0); !!!!!!this is a problem
		//deck.getCards().add(null);
		
//		System.out.println(deck.draw());
//		System.out.println(deck.draw());
//		System.out.println(deck.draw());
		
//		List<Card> deck = new ArrayList<>();
//		for(int rank = 0; rank < 13; rank++) {
//			for(int suit = 0; suit < 4; suit++) {
//				Card newCard = new Card (rank, suit);
//				deck.add(newCard);
//				System.out.println(newCard);
//			}
//		}
		
//		for(int card=0; card<MAX_CARDS; card++) {
//			Card newCard= new Card(card);
//			deck.add(newCard);
//			System.out.println(newCard);
//			deck.add(i);
//			System.out.println(cardAsString(i));
		
//		Collections.shuffle(deck);
//		for(Card i: deck) {
//			System.out.println(i);
//		}
//		
//		Card card = deck.get(0);
		//card =+ MAX_CARDS; type error
		//but card.id=card.id+MAX_CARDS will be a problem
		//card.setId(card.getId()+MAX_CARDS);
//		System.out.println(card);
	}
	
	private ClientEncapsulatedCard() {}
}
