package chapter4_ObjectState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
//import java.util.Optional;

public class Deck implements Iterable<Card>{
	
	private final List<Card> aCards = new ArrayList<>();
	//private final Optional<CardValidator> aValidator;
	private final CardValidator aValidator;
	//private Undoer aUndoer = new Undoer(this);
	private Undoer aUndoer = new Undoer();
	
	public static void main(String[] args) {
		Deck deck = new Deck(byRankValidator(Rank.Jack));
		Deck deck2= new Deck();
		System.out.println(deck.aCards.size());
		System.out.println(deck2.aCards.size());
//		deck.shuffle(Deck.byRankValidator(Rank.Ace));
//		System.out.println(deck.aCards.size());
//		deck.shuffle(Deck.byRankValidator(Rank.Ten));
//		System.out.println(deck.aCards.size());
		
//		System.out.println(deck.draw());
//		System.out.println(deck.draw());
//		deck.undo();
//		deck.undo();
//		System.out.println(deck.draw());
//		System.out.println(deck.draw());
	}
	
	public Deck(CardValidator pValidator) {
//		for(Rank rank : Rank.values()) {
//			for(Suit suit : Suit.values()) {
//				aCards.add(Card.get(rank, suit));
//			}
//		}  //full sorted
		//shuffle(Deck.byRankValidator(Rank.Jack)); //full shuffled
		//aValidator=Optional.ofNullable(pValidator);
		aValidator=pValidator;
		shuffle();
	}
	public Deck() {
		//aValidator = null;
		//this(null);
		//this(c -> true);
		this(new CardValidator() {
			@Override
			public boolean isValid(Card pCard) {
				return true;
			}
		});
	}
	public void shuffle() {
		//aCards = new ArrayList<>();
		aCards.clear();
		for(Rank rank : Rank.values()) {
			for(Suit suit : Suit.values()) {
				Card card = Card.get(rank, suit);
				//if(aValidator.isEmpty()||aValidator.get().isValid(card)) {
				if(aValidator.isValid(card)){
					aCards.add(card);
				}
			}
		}
		Collections.shuffle(aCards);
		aUndoer.shuffled();
	}

	public Card draw() {
		if(isEmpty()) {
			throw new EmptyDeckException();
		}
		Card card = aCards.remove(aCards.size()-1);
		aUndoer.drawnCard(card);
		return card;
	}
	public void undo() {
		aUndoer.undo();
	}
	public List<Card> cards(){
		return new ArrayList<>(aCards);
	}
	@Override
	public Iterator<Card> iterator() {
		return aCards.iterator();
	}
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	//static class Undoer{
	class Undoer{
		private List<Card> aDrawn = new ArrayList<>();
//      private Deck aDeck;
//		Undoer(Deck pDeck){
//			aDeck = pDeck;
//		}
		public void drawnCard (Card pCard) {
			aDrawn.add(pCard);
		}
		public void shuffled() {
			aDrawn = new ArrayList<>();
		}
		public void undo() {
			//aDeck.aCards.add(aDrawn.remove(aDrawn.size()-1));
			aCards.add(aDrawn.remove(aDrawn.size()-1));
		}
	}
	//advantages of using non-static inner class: have access to the outer instance
	public static CardValidator byRankValidator(Rank pRank) {
		return new CardValidator() {
			public boolean isValid(Card pCard) {
				return pCard.getRank().compareTo(pRank)>=0;
			}
		};
	}
}

//class RankBasedValidator implements CardValidator{
//	private Rank aRank;
//	public RankBasedValidator(Rank pRank) {
//		aRank = pRank;
//	}
//	@Override
//	public boolean isValid(Card pCard) {
//		return pCard.getRank().compareTo(aRank)>=0;
//	}
//}







