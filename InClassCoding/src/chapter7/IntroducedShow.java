package chapter7;

public class IntroducedShow extends DecoratedShow{
	private final String aSpeaker;
	private final int aTime;

	protected IntroducedShow(Show pShow, String pSpeaker, int pTime) {
		super(pShow);
		aSpeaker = pSpeaker;
		aTime = pTime;
	}
	public int time() {
		return super.time() + aTime;
	}
	public String description() {
		return super.description()+ " introducted by "+ aSpeaker;
	}

}
