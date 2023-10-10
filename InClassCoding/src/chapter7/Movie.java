package chapter7;

public class Movie extends AbstractShow implements Cloneable{
	private int aYear;
	
	public Movie(String pTitle, int pYear, int pTime) {
		super(pTitle, pTime);
		aYear = pYear;
	}
//	public Movie(Movie pMovie) {
//		aTitle = pMovie.aTitle;
//		aYear = pMovie.aYear;
//		aTime = pMovie.aTime;
//	}
//	@Override
//	public int time() {
//		return aTime;
//	}

//	@Override
//	public String description() {
//		return String.format("[%s (%d) : %d minutes]", title(), aYear, time());
//	}
//	@Override
//	//from Show to Movie
//	public Movie copy() {
//		return new Movie(this);
//	}

	@Override
	protected String extraInformation() {
		return String.format("(%d)",aYear);
	}
	@Override
	public Movie clone() {
//		try {
			return (Movie) super.clone();
//		} 
		    //catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//			return null;
//		}
	}

}

