package deckOfCards;

public class Card {
	
	private int value;
	private Shape suit; 
	private Card prev;
	private Card next;
	
	public  Card(int value, Shape suit, Card prev, Card next) {
		this.value = value;
		this.suit = suit;
		this.prev = prev;
		this.next = next;
	}
	
	public Card(int value, Shape suit) {
		this(value, suit, null, null);
	}
	
	
	public enum Shape {
	    SPADES, CLUBS, DIAMONDS, HEARTS
	}
	
	public void printCard() {
		String printValue;
		switch (getValue()) {
		case 14: printValue = "ACE"; 
		break;
		case 2: printValue = "DEUCE";
		break;
		case 11: printValue = "JACK";
		break;
		case 12: printValue = "QUEEN";
		break;
		case 13: printValue = "KING";
		break;
		default: printValue = String.valueOf(getValue());
		break;
			
		}
		System.out.println(printValue + " of " + getSuit());
	}
	
	public boolean HigherThan(Card toCompare) {
		if (this.value > toCompare.value) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean EqualTo (Card toCompare ) {
		if (this.value == toCompare.value) {
			return true;
		} else {
			return false;
		}
	}
	
	/*public void moveCard(Collection from, Collection to) {
		if (from.getNumberOfCards()>0) {
			to.addCardTop(from.removeCardTop());

		}
		
	}*/
	
	public int getValue() {
		return this.value;
	}
	
	public Shape getSuit() {
		return this.suit;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setSuit(Shape suit) {
		this.suit = suit;
	}
	
	public Card getPrev() {
		return this.prev;
	}
	
	public void setPrev(Card prev) {
		this.prev = prev;
	}
	
	public Card getNext() {
		return this.next;
	}
	
	public void setNext(Card next) {
		this.next = next;
	}
	


}

