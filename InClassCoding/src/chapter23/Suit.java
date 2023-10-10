package chapter23;

public enum Suit {
	Clubs,Diamonds,Spades,Hearts;
	
	public boolean isBlack() {
		return this == Clubs || this == Spades;
	}
}