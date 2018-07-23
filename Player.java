package deckOfCards;

public class Player {
	private String name;
	private int wealth;
	private Hand playerHand; //allow for double down? array? doubly linked list?
	private int strategy; //let people choose which strategy they use? Dealer always has single strategy
	//preferred bet? or just way to bet?
	
	public Player (String name, int wealth, Hand playerHand, int strategy){
		this.setName(name);
		this.setWealth(wealth);
		this.setPlayerHand(playerHand);
		this.setStrategy(strategy);
	}
	
	public Player (String name, int wealth){
		this(name, wealth,null,1);
	}
	
	public boolean strategy (int choice) {
		boolean value = false;
		switch (choice) {
		case 1: if (this.getPlayerHand().sumBlackJackOptimal()<17) {
					System.out.println(this.getPlayerHand().sumBlackJackOptimal()+ " is less than 17");
					value = true;
					}
					break;
		case 2: if (this.getPlayerHand().sumBlackJackOptimal()<22) {
					System.out.println(this.getPlayerHand().sumBlackJackOptimal()+ " is less than 22");
					value = true;
					}
					break;
		case 3: if (this.getPlayerHand().sumBlackJackOptimal()<11) {
					System.out.println(this.getPlayerHand().sumBlackJackOptimal()+ " is less than 11");
					value = true;
					}
					break;
		case 4: //count up ace, faces shown so far? or number that have been counted?
				//
			value = true;
			break;

		}
		return value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWealth() {
		return wealth;
	}

	public void setWealth(int wealth) {
		this.wealth = wealth;
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	public int getStrategy() {
		return strategy;
	}

	public void setStrategy(int strategy) {
		this.strategy = strategy;
	}
}
