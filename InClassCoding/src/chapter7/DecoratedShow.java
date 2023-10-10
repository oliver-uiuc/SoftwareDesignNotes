package chapter7;

public abstract class DecoratedShow implements Show, Cloneable{
	private Show aShow;
	
	protected DecoratedShow (Show pShow) {
		aShow = pShow;
	}
	@Override
	public int time() {
		return aShow.time();
	}
	@Override
	public String description() {
		return aShow.description();
	}
	@Override
	public DecoratedShow clone() {
		try {
			DecoratedShow clone = (DecoratedShow) super.clone();
			clone.aShow = aShow.clone();
			return clone;
			// return (DecoratedShow) super.clone(); not a deep copy
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
