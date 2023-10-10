package chapter7;

public abstract class AbstractShow implements Show, Cloneable{
	private final String aTitle;
	private final int aTime;
	
	protected AbstractShow (String pTitle, int pTime){
		aTitle = pTitle;
		aTime = pTime;
	}
	protected String title() {
		return aTitle;
	}
	@Override
	public int time() {
		return aTime;
	}
	//this is the step method
	protected abstract String extraInformation();
	
	//this is the template method
	@Override
	public final String description() {
		return String.format("[%s %s %d minutes]", title(), extraInformation(), time());
	}
	public Show clone() {
		try {
			return (AbstractShow) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	};
}
