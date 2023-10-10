package chapter7;

//import chapter7.Comedy.Day;

public class Client {
	private static final Movie CARVE_UP = new Movie("What a Carve Up!", 1961, 87);
	private static final Movie GIANT_CLAW = new Movie("The Giant Claw", 1957, 75);
	private static final Movie ALLIGATOR = new Movie("The Alligator People", 1959, 74);
	
	private static final Comedy CHAVEZ = new Comedy("Martha Chavez", 82, "Rebel Without a Pause");
	
	public static void main(String [] args) {
		//SponsoredComedy comedy = new SponsoredComedy("Martha Chavez", "Rebel Without a Pause", 82, "McGill",5);
		Comedy comedy = new SponsoredComedy("Martha Chavez", "Rebel Without a Pause", 82, "McGill",5);
		System.out.println(comedy.time());
		System.out.println(comedy.description());
		comedy.setSimilar(comedy);
		
		IntroducedShow show = new IntroducedShow(comedy, "Ali Hassan", 5);
		DecoratedShow clone0 = show.clone(); 
		System.out.println(show.description());
		
		Comedy clone = comedy.clone();
		System.out.println(clone.description());
		
//		Object title1 = CARVE_UP;
//		Day title2 = Day.Friday;
//		Object title3 = "Awesome Comedy"; 
//		comedy.setTitle(title1);
//		comedy.setTitle(title2);
//		comedy.setTitle(title3);
		//override based on type of implicit argument (run time type, dynamic dispatch)
		//overload based on type of explicit parameter (type of variable, expression, argument)
	}
}

