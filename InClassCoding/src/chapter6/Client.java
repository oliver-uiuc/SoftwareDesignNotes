package chapter6;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private static final Movie CARVE_UP = new Movie("What a Carve Up!", 1961, 87);
	private static final Movie GIANT_CLAW = new Movie("The Giant Claw", 1957, 75);
	private static final Movie ALLIGATOR = new Movie("The Alligator People", 1959, 74);
	
	private static final Comedy CHAVEZ = new Comedy("Martha Chavez", 82, "Rebel Without a Pause");
	
	public static void main(String [] args) {
//		Program program = new Program();
//		program.add(Day.Thursday, new CompositeShow(CHAVEZ, GIANT_CLAW)); 
//		//program.add(Day.Monday, new CompositeShow(CHAVEZ, GIANT_CLAW, new CompositeShow(CARVE_UP, ALLIGATOR)));
//		program.add(Day.Friday, CHAVEZ);
//		program.add(Day.Saturday, CARVE_UP);
//		program.add(Day.Sunday, new DoubleBill(GIANT_CLAW, ALLIGATOR));
//		System.out.println(program);
//		//System.out.println(program.get(Day.Thursday).time());
//		CompositeShow show = new CompositeShow(CHAVEZ, new DoubleBill(GIANT_CLAW, ALLIGATOR));
//		System.out.println(show.time());
//		IntroducedShow monday = new IntroducedShow(CHAVEZ, "Ali Hassan", 5);
//		CompositeShow tuesday = new CompositeShow(monday, CARVE_UP);
//		IntroducedShow wednesday = new IntroducedShow(tuesday, "Martin Robillard", 10);
//		System.out.println(wednesday.description());
//		
//		System.out.println();
//		IntroducedShow defaultShow = new IntroducedShow(new CompositeShow(
//				new IntroducedShow(CHAVEZ, "Ali Hassan", 5), CARVE_UP), "Martin Robillard", 10);
//		Program program2 = new Program();
//		System.out.println(program2);
//		program2.setDefault(defaultShow);
//		program2.initialize(Day.Monday, Day.Tuesday);
//		System.out.println(program2);
//		program2.clear();
//		program2.initialize();
//		System.out.println(program2);
//		program2.setDefault(CARVE_UP);
//		program2.initialize(Day.Friday);
//		System.out.println(program2);
		
		IntroducedShow defaultShow = new IntroducedShow(new CompositeShow(
				new IntroducedShow(CHAVEZ, "Ali Hassan", 5), CARVE_UP), "Martin Robillard", 10);
		Program program = new Program();
		List<Command> commands = new ArrayList<>();
		commands.add(program.createAddCommand(Day.Monday, defaultShow));
		commands.add(program.createClearCommand());
		commands.add(program.createAddCommand(Day.Monday, CARVE_UP));
		commands.add(program.createAddCommand(Day.Tuesday, ALLIGATOR));
		commands.add(program.createAddCommand(Day.Friday, GIANT_CLAW));
		commands.add(program.createRemoveCommand(Day.Monday));
		//Collections.reverse(commands);
		for(Command command: commands) {
			System.out.println(command);
			command.execute();
		}
		System.out.println();
		System.out.println(program);
	}
}
