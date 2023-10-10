package chapter5;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import org.junit.Test;

public class TestGameModel
{
	static class StubStrategy implements PlayingStrategy
	{
		private boolean aExecuted = false;
		
		public boolean hasExecuted()
		{ 
			return aExecuted; 
		}
		
		public Move computeNextMove(GameModelView pModelView)
		{
			aExecuted = true;
			return new NullMove();
		}
	}
	
	@Test
	public void testTryToAutoPlay()
	{
		try
		{
			Field strategyField = GameModel.class.getDeclaredField("aPlayingStrategy");
			strategyField.setAccessible(true);
			StubStrategy strategy = new StubStrategy();
			GameModel model = GameModel.instance();
			strategyField.set(model, strategy);
			model.tryToAutoPlay();
			assertTrue(strategy.hasExecuted());
		}
		catch( ReflectiveOperationException e )
		{
			fail();
		}
	}
}
