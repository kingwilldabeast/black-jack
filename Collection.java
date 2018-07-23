package deckOfCards;

public class Collection {
	private int numberOfCards;
	private Card head;
	private Card tail;


	public Collection () {
		this.setNumberOfCards(0);
		this.head = null;
		this.tail = null;
	}
	

	
	public void shuffle() {
		if (getNumberOfCards() > 1) {
			double index =  (int) ((Math.random() * 50) + 100); //anywhere between 100 and 150
			for (int i = 0; i < index; i++) {
				shuffleToEnd();
			}
		}
		
	}
	
	public void shuffleToEnd() {
		//chooses random cards in middle, sends to end
		//will never choose the last card, so don't worry about exception for that
		//ensure two or more cards
		if (getNumberOfCards() > 1) {
			double pos = (int) (Math.random() * (getNumberOfCards()-1) + 1); //any card from 1 to 52
			Card move = this.getHead();
			for (int i =1; i< pos; i++) { //chooses card from 1 to 51, stops before 52. if 1, already head, no loop
				move = move.getNext();
				
			}
			//System.out.println("The position is " + pos);
			//move.printCard();
			if (move==head) {
				move.getNext().setPrev(null);
				head =head.getNext();
				tail.setNext(move);
				move.setNext(null);
				move.setPrev(tail);
				tail=move; 
			} else {
				
				move.getPrev().setNext(move.getNext());
				move.getNext().setPrev(move.getPrev());
				tail.setNext(move);
				move.setNext(null);
				move.setPrev(tail);
				tail=move; 
			} 
		}
		
	}

	public void revealCards() {
		Card helper = this.getHead();
		while (helper != null) {
	    	helper.printCard();
	    	helper = helper.getNext();
	    }
	}

	
	public void addCardTop(Card newCard) {
		switch (getNumberOfCards()) {
		case 0: this.setNumberOfCards(getNumberOfCards()+1);
				head = newCard;
				tail = newCard;
				break;
		default: this.setNumberOfCards(getNumberOfCards()+1);
				head.setPrev(newCard);
				newCard.setNext(head); 
				head = newCard;
				break;
		}
	}
	
	public void addCardBottom(Card newCard) {
		switch (getNumberOfCards()) {
		case 0: this.setNumberOfCards(getNumberOfCards()+1);
				head = newCard;
				tail = newCard;
				break;
		default: this.setNumberOfCards(getNumberOfCards()+1);
				tail.setNext(newCard);
				newCard.setPrev(tail); 
				tail = newCard;
				break;
		}
	}
	
	public Card removeCardTop() {

		Card aux;
		switch (getNumberOfCards()) {
		
		case 0: System.out.println("Nothing to remove.");
				return null;
		case 1: this.setNumberOfCards(getNumberOfCards()-1);
				aux = head;
				head = null;
				tail = null;
				return aux;
		default: this.setNumberOfCards(getNumberOfCards()-1);
				head.getNext().setPrev(null);
				aux = head;
				head = head.getNext();
				aux.setNext(null);
				aux.setPrev(null);
				return aux;
		}		
		 
	}
	
	public Card removeCardBottom() {
		Card aux;
		switch (getNumberOfCards()) {
		
		case 0: System.out.println("Nothing to remove.");
				return null;
		case 1: this.setNumberOfCards(getNumberOfCards()-1);
				aux = tail;
				head = null;
				tail = null;
				return aux;
		default: this.setNumberOfCards(getNumberOfCards()-1);
				aux = tail;
				tail.getPrev().setNext(null);
				tail = tail.getPrev();
				aux.setNext(null);
				aux.setPrev(null);
				return aux;
		}		
	}

	public Card getHead() {
		return head;
	}
	
	public Card getTail() {
		return tail;
	}
	
	
	public int getNumberOfCards() {
		return numberOfCards;
	}

	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}	
	
}
