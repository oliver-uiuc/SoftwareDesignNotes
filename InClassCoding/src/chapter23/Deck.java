package chapter23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck implements Iterable<Card>{
	
	//public enum Config{STANDARD, ALL_RED, FACE_CARDS}
	
	private List<Card> aCards = new ArrayList<>();
	
	public Deck(CardValidator pValidator) {
		assert pValidator!=null;
		for(Rank rank : Rank.values()) {
			for(Suit suit : Suit.values()) {
				aCards.add(new Card(rank, suit));
			}
		}
		Collections.shuffle(aCards);
		for(Card card : cards()) {
			if(!pValidator.isValid(card)) {
				aCards.remove(card);
			}
		}
//		if(pConfig == Config.STANDARD){
//			// do nothing
//		}else if (pConfig == Config.ALL_RED){
//			for(Card card: new ArrayList<>(aCards)) {
//				if(card.isBlack()) {
//					aCards.remove(card);
//				}
//			}
//		}else if (pConfig == Config.FACE_CARDS) {
//			for(Card card: new ArrayList<>(aCards)) {
//				if(card.getRank().ordinal() < Rank.Jack.ordinal()) {
//					aCards.remove(card);
//				}
//			}
//		}
//		for(Card card: aCards) {
//			System.out.println(card);
//		}
	}
	public Card draw() {
		return aCards.remove(aCards.size()-1);
	}
//	public List<Card> getCards(){
//		return aCards;
//	}
	public List<Card> cards(){
		return new ArrayList<>(aCards);
	}
//	public Iterator<Card> cardIterator(){
//		return aCards.iterator();
//	}
	
	public void sort() {
		Collections.sort(aCards);
		// polymorphism: can sort other types by Collections.sort
	}
	@Override
	public Iterator<Card> iterator() {
		return aCards.iterator();
	}
}

