package deckOfCards;
//import java.util.Scanner;

public class Main {
	
	public static void main(String [ ] args)
	{
		

		
		//************
		
		int numPlayers =3;
		NormDeck blackJackDeck = new NormDeck();		
		
		Player[] players = new Player[numPlayers];
		
		int bet = 10;
		String dealerName = "Dealer Dan";
		int dealerWealth = 500;
		Hand dealerHand = new Hand();
		Player dealer = new Player(dealerName, dealerWealth, dealerHand, 1);
		players[0] = dealer;
		
		Hand handA = new Hand();
		Player playerA = new Player("Adam", 500, handA, 2);
		players[1] = playerA;
		
		Hand handB = new Hand();
		Player playerB = new Player("Bob", 500, handB, 3);
		players[2] = playerB;
		
/*		Hand handC = new Hand();		
		Player playerC = new Player("Chuck", 500, handC, 3);
		players[3] = playerC;*/
		
		System.out.println("Number of players are: "+ numPlayers);
		System.out.print("Deck first card is: ");
		blackJackDeck.getHead().printCard();
		
		for (int i = numPlayers-1; i>= 0; i--) { 
			System.out.println(players[i].getName()+ " number of cards are: "+ players[i].getPlayerHand().getNumberOfCards());
		}


		blackJackDeck.shuffle();
		System.out.println("Shuffling... ");
		
		System.out.print("Deck new first card: ");
		blackJackDeck.getHead().printCard();
		
		System.out.println("Each takes two cards.");
		for (int i = numPlayers-1; i>= 0; i--) { 
			players[i].getPlayerHand().fillHand(blackJackDeck, 2);
		}



		System.out.print("Deck new first card: ");
		blackJackDeck.getHead().printCard();
		
		
		for (int i = numPlayers-1; i>= 0; i--) { 
			
			System.out.print(players[i].getName()+ " first card is: ");
			players[i].getPlayerHand().getHead().printCard();
			System.out.println(players[i].getName()+ " number of cards are: "+ players[i].getPlayerHand().getNumberOfCards());
			System.out.print(players[i].getName()+ " blackjack sum is: ");
			System.out.println(players[i].getPlayerHand().sumBlackJackOptimal());
		}
		System.out.println("Round begins.*******************************");
		
		int count;
		for (int i = numPlayers-1; i>= 0; i--) { 
			System.out.println(players[i].getName() + " strategy is " + players[i].getStrategy());
			count = 0;
			System.out.println("Their sum is " + players[i].getPlayerHand().sumBlackJackOptimal());
			while (players[i].strategy(players[i].getStrategy())) { //come up with more efficient strategy, individual?
				players[i].getPlayerHand().takeOne(blackJackDeck);
				System.out.println(players[i].getName()+ " says HIT ME.");
				System.out.print(players[i].getName() + " drew ");
				players[i].getPlayerHand().getHead().printCard();
				count++;
			}
			System.out.println(players[i].getName()+ " says: STAY");
			System.out.println(players[i].getName() + " took " + count + " cards.");
			System.out.println(players[i].getName()+ " number of cards are: "+ players[i].getPlayerHand().getNumberOfCards());
			System.out.println(players[i].getName()+ " blackjack sum is: " + players[i].getPlayerHand().sumBlackJackOptimal());
		}
		

		

		for (int i = numPlayers-1; i> 0; i--) {//greater than zero, cuz we can't compare dealer to dealer 
			System.out.println("Outcome for " + players[i].getName());
			if (players[i].getPlayerHand().sumBlackJackOptimal()>21) {
				players[i].setWealth(players[i].getWealth()-bet);
				players[0].setWealth(players[0].getWealth()+bet);
				System.out.println(players[i].getName()+ " busted. They pay " + bet + " to "+ players[0].getName()); 
			} else if (players[0].getPlayerHand().sumBlackJackOptimal()>21) {
				players[i].setWealth(players[i].getWealth()+bet);
				players[0].setWealth(players[0].getWealth()-bet);
				System.out.println(players[0].getName()+ " busted. They pay " + bet + " to "+ players[i].getName()); 
			} else if (players[i].getPlayerHand().sumBlackJackOptimal() > players[0].getPlayerHand().sumBlackJackOptimal()) {
				players[i].setWealth(players[i].getWealth()+bet);
				players[0].setWealth(players[0].getWealth()-bet);
				System.out.println(players[0].getName()+ " pays "+ bet + " to "+ players[i].getName());
			} else if (players[0].getPlayerHand().sumBlackJackOptimal()>players[i].getPlayerHand().sumBlackJackOptimal()) {
				players[i].setWealth(players[i].getWealth()-bet);
				players[0].setWealth(players[0].getWealth()+bet);
				System.out.println(players[i].getName()+ " pays "+ bet + " to "+ players[0].getName()); 
			} else if (players[i].getPlayerHand().sumBlackJackOptimal()==players[0].getPlayerHand().sumBlackJackOptimal()) {
				System.out.println("Tie. no one gets money.");
			} else {
				System.out.println("Unexpected outcome.");
			}
			
		}
		
		System.out.println("number cards in deck are " + blackJackDeck.getNumberOfCards());
		
		for (int i = numPlayers-1; i>= 0; i--) { 
			
			System.out.println(players[i].getName()+ " cards were: ");
			players[i].getPlayerHand().revealCards();
			System.out.println("Their wealth is " + players[i].getWealth());
			players[i].getPlayerHand().discardAll(blackJackDeck);
			System.out.println("num cards should be zero: " + players[i].getPlayerHand().getNumberOfCards());
	}
		
		System.out.println("number cards in deck are " + blackJackDeck.getNumberOfCards());		

		
		
		

		/*		
		NormDeck myDickDeck = new NormDeck(); 
		Hand myHand = new Hand();
		Hand second = new Hand();
		
		myHand.fillHand(myDickDeck, 5);
		second.fillHand(myDickDeck, 7);
		myHand.takeOne(second);
		second.discardBottom(myHand);
		second.getHead().moveCard(second, myHand);
		
		System.out.println("first cards are: ");
		myHand.revealCards();
		System.out.println("second hand cards are: ");
		second.revealCards();

	    myDickDeck.shuffle();
	    while (myDickDeck.getNumberOfCards() > 1) {
	    	myDickDeck.removeCardTop().printCard();
	    	System.out.println(myDickDeck.getNumberOfCards());
	    }
	    System.out.println("number of cards is " + myDickDeck.getNumberOfCards() );
	    System.out.println("shuffle again");
	    myDickDeck.shuffle();*/
	    
	}

}
