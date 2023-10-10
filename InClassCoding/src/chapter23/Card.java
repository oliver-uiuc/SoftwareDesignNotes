package chapter23;


public class Card implements Comparable<Card>{
	private Rank aRank;
	private Suit aSuit;
	
	//constructor
	/**
	 * 
	 * @param pRank
	 * @param pSuit
	 * @pre pRank != null && pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
//	
//	public int getId() {
//		return aSuit * 13 + aRank;
//	}
	public Rank getRank() {
		return aRank;
	}
	public Suit getSuit() {
		return aSuit;
	}
	public String cardAsString() {
		//return EncapsulatedCardClient.RANKS[aRank]+" of "+EncapsulatedCardClient.SUITS[aSuit];
		return aRank+" of "+aSuit;
	}
	public String toString() {
		return cardAsString();
	}
	public boolean isBlack() {
		return aSuit.isBlack();
	}
	@Override
	public int compareTo(Card pCard) {
		//enum is comparable!!
		return this.getSuit().compareTo(pCard.getSuit());
	}
}
