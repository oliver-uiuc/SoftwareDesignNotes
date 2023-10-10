package chapter4_ObjectState;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestDeck {
	private final Deck aDeck = new Deck();
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
}
