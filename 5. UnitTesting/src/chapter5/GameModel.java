package chapter5;

public class GameModel implements GameModelView
{
	private static GameModel INSTANCE = new GameModel();
	
	private PlayingStrategy aPlayingStrategy;
	
	public static GameModel instance()
	{
		return INSTANCE;
	}
	
	public void tryToAutoPlay()
	{
		aPlayingStrategy.computeNextMove(this);
	}
}
