package deckOfCards;

import deckOfCards.Card.Shape;

public class NormDeck extends Collection {
	

	public NormDeck () {
		super();
	    Card newCard;

	    for (int i =2; i <=14; i++) {
	    	for (Shape suits : Shape.values()) {
	    		newCard = new Card(i,suits);
	    		super.addCardTop(newCard);
	    	}
	    }
	}
	
	
}
