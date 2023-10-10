package chapter5_UnitTesting;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import chapter4_ObjectState.Card;
import chapter4_ObjectState.Deck;

public class AbsTest {
	public static void main(String [] args) throws Exception
	{
		Class<AbsTest> clazz = AbsTest.class;
		Class<?> clazz2 = new AbsTest().getClass();//an instance
		Class<?> clazz3 = Class.forName("chapter5_UnitTesting.AbsTest");
		System.out.println(clazz==clazz2);
		System.out.println(clazz3==clazz2);
		
		for(Method method : AbsTest.class.getDeclaredMethods()) {
			String result = method.toString();
			if(Modifier.isPublic(method.getModifiers())&&
					!Modifier.isStatic(method.getModifiers())&&
					method.getReturnType()==void.class) {
				result = "==> " + result; 
				//method.invoke(AbsTest.class.getDeclaredConstructor().newInstance());
			}
			System.out.println(result);
		}
		
		//Card card1 = new Deck().draw();
		Class<Deck> deckClass = Deck.class;
		Constructor<Deck> constructor = deckClass.getDeclaredConstructor();
		Deck deck = constructor.newInstance();
		Method methodDraw = deckClass.getDeclaredMethod("draw");
		Card card2 = (Card) methodDraw.invoke(deck);
		System.out.println(card2);
	}
	@Test
	public void testAbs_Zero() {
		assertEquals(0, Math.abs(0));
	}
	@Test
	public void testAbs_Positive() {
		assertEquals(1, Math.abs(1));
	}
	@Test
	public void testAbs_Negative() {
		assertEquals(1, Math.abs(-1));
	}
	private void foo() {
		System.out.println("foo");
	}
}
