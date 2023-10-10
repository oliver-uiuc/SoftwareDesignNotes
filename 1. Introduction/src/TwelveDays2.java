public class TwelveDays2
{
	private static boolean asDigits = false;
	
	public static void main(String[] args)
	{
		detectDigits(args);
		System.out.println(poem());
	}
	
	static void detectDigits(String[] args)
	{
		asDigits = args != null && args.length > 0 && args[0].equals("digits");
	}
	
	static String[] DAYS = {"first", "second", "third", "fourth",
							"fifth", "sixth", "seventh", "eighth",
							"ninth", "tenth", "eleventh", "twelfth"};
	
	static String[] DAYS_DIGITS = {"1st", "2nd", "3rd", "4th",
			"5th", "6th", "7th", "8th",
			"9th", "10th", "11th", "12th"};
	
	static String day(int day)
	{
		if(asDigits)
		{
			return DAYS_DIGITS[day];
		}
		else
		{
			return DAYS[day];
		}
	}
	
	static String[] GIFTS = {
			"a partridge in a pear tree",
			"two turtle doves",
			"three French Hens",
			"four Calling Birds",
			"five Golden Rings",
			"six Geese a Laying",
			"seven Swans a Swimming",
			"eight Maids a Milking",
			"nine Ladies Dancing",
			"ten Lords a Leaping",
			"eleven Pipers Piping",
			"twelve Drummers Drumming"
	};
	
	/*
     * Returns the first line in the verse for a given day.
	 */
	static String firstLine(int day)
	{
	  return "On the " + day(day) +
	    " day of Christmas my true love sent to me:\n";
	}
	
	/*
     * Returns a string that lists all the gifts received on a given
     * day.
	 */
	static String allGifts(int day)
	{
		if( day == 0 ) 
		{ 
			return "and " + GIFTS[0]; 
		}
		else 
		{ 
			return GIFTS[day] + "\n" + allGifts(day-1);	
		}
	}
	
	/*
	 * Returns the text of the entire poem. 
	 */
	static String poem()
	{
		String poem = firstLine(0) + GIFTS[0] + "\n\n";
		for( int day = 1; day < 12; day++ )
		{ 
			poem += firstLine(day) + allGifts(day) + "\n\n"; 
		}
		return poem;
	}
}