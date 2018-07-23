package deckOfCards;


public class Hand extends Collection {


	public Hand () {
		super();

	}
	
	public int sumBlackJackOptimal() {
		int sum = 0;
		
		if ( this.getNumberOfCards() == 0) {
			return sum;
		}
		
		
		int numBigAces = 0;// number of aces valued at 11
		Card helper = this.getHead();
		
		while (helper != null && sum < 70) {
			switch (helper.getValue()) {
			case 14: numBigAces++;
					sum += 11;
					break;
			case 13: 
			case 12:
			case 11:sum += 10;
					break;
			default: sum += helper.getValue();
					break;
			}
			
			helper = helper.getNext();
		}
		
		while (sum > 21 && numBigAces >0) {
			numBigAces--;
			sum -= 10;
		}
		
		return sum;
		
	}
	
	public int sum() {
		int sum = 0;
		
		if ( this.getNumberOfCards() == 0) {
			return sum;
		}
				
		Card helper = this.getHead();
		while (helper != null) {
			sum += helper.getValue();
	
			helper = helper.getNext();
		}
		
		return sum;
		
	}

	
	public void fillHand(Collection from,int fillTo) {
		while (this.getNumberOfCards()<fillTo && from.getNumberOfCards()>0) {
				this.addCardTop(from.removeCardTop());

		}
	}
	
	public void discardAll(Collection to) {
		while (this.getNumberOfCards()>0 ) {
				to.addCardBottom(this.removeCardTop());

		}
	}
	
	public void takeOne(Collection from) {
		if (from.getNumberOfCards()>0) {
			this.addCardTop(from.removeCardTop());

		}
	}
	
	public void discardBottom(Collection to) {
		if (this.getNumberOfCards()>0) {
			to.addCardBottom(this.removeCardTop());

		}
	}
	

}

