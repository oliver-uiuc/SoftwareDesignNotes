package chapter6;

/**
 * Two movie one after the other
 */
public class DoubleBill implements Show {
	private final Movie aMovie1;
	private final Movie aMovie2;
	
	public DoubleBill(Movie pMovie1, Movie pMovie2) {
		aMovie1 = pMovie1;
		aMovie2 = pMovie2;
	}

	@Override
	public int time() {
		return aMovie1.time()+aMovie2.time();
	}

	@Override
	public String description() {
		return aMovie1.description()+" followed by "+aMovie2.description();
	}

	@Override
	public Show copy() {
		return new DoubleBill(aMovie1.copy(), aMovie2.copy());
	}
}
