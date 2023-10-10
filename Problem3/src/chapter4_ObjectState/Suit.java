package chapter4_ObjectState;

public enum Suit {
	Clubs,Diamonds,Spades,Hearts;
	
	public boolean isBlack() {
		return this == Clubs || this == Spades;
	}
}
