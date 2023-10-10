package chapter7;

public class SponsoredComedy extends Comedy{
	private String aSponsor;
	private int aSponsorTime;
	
	//actually we are overloading!
	public void setSimilar (SponsoredComedy pSimilar) {
		System.out.println("SC");
		super.setSimilar(pSimilar);
	}
	
	public SponsoredComedy(String pComedian, String pTitle, int pTime, String pSponsor, int pSponsorTime) {
		// an invisible operation : call the constructor of Comedy
		super(pComedian, pTime, pTitle);
		System.out.println("1");
		aSponsor = pSponsor;
		aSponsorTime = pSponsorTime;
	}
	
	@Override
	public int time() {
		return super.time()+aSponsorTime;
	}
	
//	@Override
//	public String description() {
//		return String.format("[%s: %s sponsored by %s (%d minutes)]", comedian(), title(), aSponsor, time());
//	}
	@Override
	protected String extraInformation() {
		return String.format("%s sponsored by %s ", super.extraInformation(), aSponsor);
	}

}
