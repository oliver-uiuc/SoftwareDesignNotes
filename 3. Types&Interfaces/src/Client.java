import java.util.ArrayList;
import java.util.List;

/**
 * Simulates code that uses various card sources.
 */
public class Client
{
	/**
	 * A utility method to draw up to pNumber cards from the source. 
	 * Mostly a demonstration of how to access an object through 
	 * an interface.
	 * 
	 * @param pSource The source object. Can be any subtype of CardSource
	 * @param pNumber The number of cards to extract.
	 * @return A list of the cards drawn from the source.
	 */
	public static List<Card> drawCards(CardSource pSource, int pNumber)
	{
		List<Card> result = new ArrayList<>();
		
		for( int i = 0; i < pNumber && !pSource.isEmpty(); i++ )
		{ 
			result.add(pSource.draw()); 
		}
		
		return result;
	}
}