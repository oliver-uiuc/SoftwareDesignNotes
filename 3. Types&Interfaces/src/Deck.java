import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a deck of playing cards. In this version, the cards in the 
 * deck are stored in a list and the list of cards in the deck can 
 * be obtained by client code using an immutable wrapper object.
 * 
 * This version of the Deck class also implements {@link CardSource}
 * and has a sort() method to demonstrate the use of comparators.
 * 
 * The Deck is also iterable: it fulfills the role of ConcreteIterable
 * in the Iterator design pattern.
 */
public class Deck implements CardSource, Iterable<Card>
{
	private List<Card> aCards = new ArrayList<>();
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public Deck()
	{
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
	public void shuffle()
	{
		aCards.clear();
		for( Suit suit : Suit.values() )
		{
            for( Rank rank : Rank.values() )
            {
                aCards.add( new Card( rank, suit ));
            }
		}
		Collections.shuffle(aCards);
	}
	
	/**
	 * Places pCard on top of the deck.
	 * @param pCard The card to place on top
	 * of the deck.
	 * @pre pCard !=null
	 */
	public void push(Card pCard)
	{
		assert pCard != null;
		aCards.add(pCard);
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card draw()
	{
		assert !isEmpty();
		return aCards.remove(aCards.size() - 1);
	}
	
	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	/**
	 * @return An unmodifiable list of all the cards in the deck.
	 */
	public List<Card> getCards()
	{
		return Collections.unmodifiableList(aCards);
	}
	
	/**
	 * Sorts the cards in the deck by ascending rank.
	 */
	public void sort()
	{
		Collections.sort(aCards, new Comparator<Card>()
		{
			public int compare(Card pCard1, Card pCard2)
			{ 
				return pCard1.getRank().compareTo(pCard2.getRank());
			}
		});
	}

	@Override
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}
}
