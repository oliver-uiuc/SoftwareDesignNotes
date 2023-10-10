package chapter7;

/**
 * A performance that can take place in a theater
 * @author huxinyue
 */
public interface Show extends Cloneable {
	
	Show clone();
	
	//factory method
	private static Show createNull() {
		return new Show() {
			@Override
			public int time() {
				return 0;
			}
			@Override
			public String description() {
				return "No Show!";
			}
			@Override
			public boolean isNull() {return true; }
			//@Override
			//public Show copy() {return createNull();}
			public Show clone() {return createNull();}
		};
	} 
	static Show NULL = createNull();
	// return the total running time for the show
	int time();
	
	// returns a different but equal object
	//Show copy();
	
	// A description of the show to appear in the program
	String description();
	
	default boolean isNull() {return false;}
	
}
