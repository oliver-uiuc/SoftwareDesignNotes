package chapter6;

public class Movie implements Show {
	private String aTitle;
	private int aYear;
	private int aTime;
	
	public Movie(String pTitle, int pYear, int pTime) {
		aTitle = pTitle;
		aYear = pYear;
		aTime = pTime;
	}
	public Movie(Movie pMovie) {
		aTitle = pMovie.aTitle;
		aYear = pMovie.aYear;
		aTime = pMovie.aTime;
	}
	@Override
	public int time() {
		return aTime;
	}

	@Override
	public String description() {
		return String.format("[%s (%d) : %d minutes]", aTitle, aYear, aTime);
	}
	@Override
	//from Show to Movie
	public Movie copy() {
		return new Movie(this);
	}

}
