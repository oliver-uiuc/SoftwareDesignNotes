package chapter4;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Card implements Comparable<Card>{
	public enum Joker {WHITE,BLACK}
	//private static List<Card> aCards = new ArrayList<>();
	//private static Map<Integer, Card> aCards = new HashMap<>();
	private static Map<Suit, Map<Rank, Card>> aCards = new HashMap<>();
	private static Card aBlackJoker = new Card(Joker.BLACK);
	private static Card aWhiteJoker = new Card(Joker.WHITE);
	private Optional<Rank> aRank = Optional.empty(); 
	private Optional<Suit> aSuit = Optional.empty();
	private Joker aJoker = Joker.BLACK;
	
	private Card(Joker pJoker) {
		aJoker = pJoker;
	}
	public static Card getJoker(Joker pJoker) {
		if(pJoker ==Joker.BLACK) return aBlackJoker;
		else return aWhiteJoker;
	}
	public Joker jokerType() {
		assert !aRank.isPresent();
		return aJoker;
	}
	
	//static initializer block
	static {
		for(Suit suit:Suit.values()) {
			aCards.put(suit, new HashMap<>());
			for(Rank rank:Rank.values()) {
				aCards.get(suit).put(rank, new Card(rank, suit));
			}
		}
	}
	
	//constructor
	/**
	 * @param pRank
	 * @param pSuit
	 * @pre pRank != null && pSuit != null
	 */
	
	//first step of making flyWeight design pattern: private constructor
	private Card(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = Optional.of(pRank);
		aSuit = Optional.of(pSuit);
	}
	public static Card get(Rank pRank, Suit pSuit) {
		return aCards.get(pSuit).get(pRank);
//		if(!aCards.containsKey(pSuit)) {
//			aCards.put(pSuit, new HashMap<>());
//		}
//		Map<Rank,Card> inner = aCards.get(pSuit);
//		if(!inner.containsKey(pRank)) {
//			inner.put(pRank,new Card(pRank,pSuit));
//		}
//		return inner.get(pRank);
		
//		Card card = aCards.get(code(pRank,pSuit));
//		if(card == null) {
//			aCards.put(code(pRank,pSuit),new Card(pRank,pSuit));
//		}
//		return aCards.get(code(pRank,pSuit));
		
//		for(Card card : aCards) {
//			if(card.getRank()==pRank && card.getSuit()==pSuit) {
//				return card;
//			}
//		}
//		Card card= new Card(pRank,pSuit);
//		aCards.add(card);
//		return card;
	}
	public Rank getRank() {
		return aRank.get();
	}
	public Suit getSuit() {
		return aSuit.get();
	}
	public String cardAsString() {
		return aRank+" of "+aSuit;
	}
	public String toString() {
		return cardAsString();
	}
	public boolean isBlack() {
		return aSuit.get().isBlack();
	}
	@Override
	public int compareTo(Card pCard) {
		return this.getSuit().compareTo(pCard.getSuit());
	}
	
//	@Override
//	public boolean equals(Object pObject) {
//		if(pObject == null) {
//			return false;
//		}
//		if(pObject == this) {
//			return true;
//		}
//		if(pObject.getClass()!=this.getClass()) {
//			return false;
//		}
//		Card other = (Card)pObject;
//		return aRank == other.aRank && aSuit == other.aSuit;
//	}
//	@Override
//	public int hashCode() {
//		return code (aRank,aSuit);
//	}
//	public static int code(Rank pRank, Suit pSuit) {
//		return Rank.values().length*pSuit.ordinal()+pRank.ordinal();
//	}
}


