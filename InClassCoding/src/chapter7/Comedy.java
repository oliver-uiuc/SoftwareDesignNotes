package chapter7;

public class Comedy extends AbstractShow implements Cloneable{
	private String aComedian;
//	private int aTime;
//	private String aTitle;
	private Comedy aSimilar;
	public enum Day {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
	}
	public String comedian() {
		return aComedian;
	}
//	public String title() {
//		return aTitle;
//	}
	public void setSimilar (Comedy pSimilar) {
		System.out.println("C");
		aSimilar = pSimilar;
	}
	@Override
	public Comedy clone() {
		//return new Comedy(aComedian, time(), title());
//		try {
			return (Comedy) super.clone();
//		} 
//		catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
	}

	public Comedy(String pComedian, int pTime, String pTitle) {
		super(pTitle, pTime);
		aComedian = pComedian;
	}
//	public Comedy(Comedy pComedy) {
//		aComedian = pComedy.aComedian;
//		aTitle = pComedy.aTitle;
//		aTime = pComedy.aTime;
//	}
//	public Comedy () {
//		System.out.println("2");
//		aComedian = "No one";
//		aTitle = "Not funny";
//		aTime = 0;
//	}
//	public void setTitle (String pTitle) {
//		System.out.println("String");
//		aTitle = pTitle;
//	}
//	public void setTitle (Day pTitle) {
//		System.out.println("Day");
//		aTitle = pTitle.name().toLowerCase()+" night comedy";
//	}
//	public void setTitle (Object pTitle) {
//		System.out.println("Object");
//		aTitle = pTitle.toString();
//	}
//	@Override
//	public int time() {
//		return aTime;
//	}
//	
//	public static int time (Comedy pComedy) {
//		return pComedy.aTime;
//	}

//	@Override
//	public String description() {
//		return String.format("[%s: %s (%d minutes)]", aComedian, title(),time());
//	}
//	@Override
//	public Show copy() {
//		return new Comedy(this);
//	}
	@Override
	protected String extraInformation() {
		return String.format("by %s ", aComedian);
	}

}
