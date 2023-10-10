package chapter4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestDeck {
	private final Deck aDeck = new Deck();
	
	static class ValidatorStub implements CardValidator{
		private boolean aAccept;
		private int aCount = 0;
		public ValidatorStub(boolean pAccept) {
			aAccept = pAccept;
		}
		@Override
		public boolean isValid(Card pCard) {
			aCount++;
			return aAccept;
		}
		public int getCount() {
			return aCount;
		}
	}
	@Test
	public void testShuffle_ValidatorAccept() {
		ValidatorStub stub = new ValidatorStub(true);
		aDeck.shuffle(stub);
		assertEquals(52, stub.getCount());
		assertEquals(52, getCards().size());
	}
	@Test
	public void testShuffle_ValidatorReject() {
		ValidatorStub stub = new ValidatorStub(false);
		aDeck.shuffle(stub);
		assertEquals(52, stub.getCount());
		assertEquals(0, getCards().size());
	}
	
	@BeforeEach
	public void setup() {
		aDeck.shuffle();
	}
	@Test
	public void testDraw_NonEmpty() {
		List<Card> cards=getCards();
		Card last = cards.get(cards.size()-1);
		int size = cards.size();
		Card drawn = aDeck.draw();
		assertSame(last, drawn);
		assertEquals(size-1,cards.size());
	}
	@Test
	public void testDraw_Empty() {
//		try {
			List<Card> cards = getCards();
			cards.clear();
			
			assertThrows(EmptyDeckException.class, new Executable() {
				@Override
				public void execute() throws Throwable {
					aDeck.draw();
				}
			});
			
//			deck.draw();
//			//If I get to this point, the exception did not get raised
//			fail();
//		}
//		catch(EmptyDeckException e) {
//			//The passes, do nothing
//		}
	}
	@Test
	public void testInitialize() {
		invokeInitialize();
		List<Card> cards = getCards();
		assertEquals(52,cards.size());
		assertSame(Card.get(Rank.Ace, Suit.Clubs),cards.get(0));
	}
	@SuppressWarnings("unchecked")
	public List<Card> getCards(){
		try {
			Field field = Deck.class.getDeclaredField("aCards");
			field.setAccessible(true);
			return (List<Card>)field.get(aDeck);
		}
		catch(ReflectiveOperationException e) {
			fail();
			return null;
		}
	}
	public void invokeInitialize() {
		try {
			Method method = Deck.class.getDeclaredMethod("initialize");
			method.setAccessible(true);
			method.invoke(aDeck);
		}catch(ReflectiveOperationException e) {
			fail();
		}
	}
	@Test
	public void testRedFaced_Empty() {
		List<Card> cards = getCards();
		cards.clear();
		assertFalse(aDeck.redFaced());
	}
	@Test
	public void testRedFaced_HeartNotFace() {
		List<Card> cards = getCards();
		cards.clear();
		cards.add(Card.get(Rank.Eight, Suit.Hearts));
		assertFalse(aDeck.redFaced());
	}
	@Test
	public void testRedFaced_DiamonsFace() {
		List<Card> cards = getCards();
		cards.clear();
		cards.add(Card.get(Rank.Jack, Suit.Diamonds));
		assertTrue(aDeck.redFaced());
	}
	@Test
	public void testRedFaced_ClubsFace() {
		List<Card> cards = getCards();
		cards.clear();
		cards.add(Card.get(Rank.Jack,Suit.Clubs));
		assertFalse(aDeck.redFaced());
	}
}

