package chapter6;

public class Comedy implements Show{
	private String aComedian;
	private int aTime;
	private String aTitle;

	public Comedy(String pComedian, int pTime, String pTitle) {
		aComedian = pComedian;
		aTime = pTime;
		aTitle = pTitle;
	}
	public Comedy(Comedy pComedy) {
		aComedian = pComedy.aComedian;
		aTitle = pComedy.aTitle;
		aTime = pComedy.aTime;
	}
	
	@Override
	public int time() {
		return aTime;
	}

	@Override
	public String description() {
		return "["+aComedian+": "+aTitle+" ("+aTime+" minutes)]";
	}
	@Override
	public Show copy() {
		return new Comedy(this);
	}

}
