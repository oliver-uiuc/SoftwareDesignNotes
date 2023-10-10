package chapter23;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * concrete iterable
 */
public class Pair implements Iterable<Card>{
	
	public static void main(String [] args) {
		Pair pair = new Pair(new Card(Rank.Ace,Suit.Clubs),new Card(Rank.Ace,Suit.Diamonds));
//		Iterator<Card> iterator = pair.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		for(Card card : pair) {
			System.out.println(card);
		}
	}
	
	private Card aFirst;
	private Card aSecond;
	
	public Pair(Card pCard1, Card pCard2) {
		aFirst = pCard1;
		aSecond = pCard2;
	}
	
	public Card first() {
		return aFirst;
	}
	public Card second() {
		return aSecond;
	}
	public Iterator<Card> iterator(){
		return new PairIterator(this); //associate with return aCards.iterator() -- arrayList
	}
}
/**
 * concrete iterator
 */
class PairIterator implements Iterator<Card>{
	private Queue<Card> aCards;
	public PairIterator(Pair pPair) {
		aCards = new LinkedList<>(Arrays.asList(pPair.first(),pPair.second()));
	}

	@Override
	public boolean hasNext() {
		return !aCards.isEmpty();
	}

	@Override
	public Card next() {
		return aCards.remove();
	}
}
