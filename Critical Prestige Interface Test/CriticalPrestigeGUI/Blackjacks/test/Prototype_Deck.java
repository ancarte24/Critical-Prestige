/**
 * importing necessary Random utility library
 */
import java.util.Random;
/**
 * Deck class
 */
class Deck {
	/**
	 * defining initial variables
	 */
	String cards[][];
   int records[][];  //Vincent 9/23 5:36PM
	int cardsUsed;
	Random r;
   int num_of_decks = 0;   //Vincent 9/23 3:41PM
	/**
	 * defining Deck method
	 */
	public Deck(int numbr) {   //Vincent 9/23 3:57PM
      numbr = numbr + 1;   //Vincent 9/23 3:57PM
		cards = new String [52][numbr];   //Vincent 9/23 3:41PM
      records =  new int [52][numbr];  //Vincent 9/23 5:36PM
		cardsUsed = 0;
		r = new Random();
		int i, j, k;
		/**
		 * create deck. j is always which card you're on
		 */
		j = 0;
		for (i = 0; i < 4; i++) {
			cards[j][0] = "A";
			j++;
		}
		for (i = 2; i < 11; i++) {
			for (k = 0; k < 4; k++) {
				cards[j][0] = String.valueOf(i);
				j++;
			}
		}
		for (i = 0; i < 4; i++) {
			cards[j][0] = "J";
			j++;
		}
		for (i = 0; i < 4; i++) {
			cards[j][0] = "Q";
			j++;
		}
		for (i = 0; i < 4; i++) {
			cards[j][0] = "K";
			j++;
		}
		/**
		 * done making deck and initializing it
		 */
		cardsUsed = 0;
      for(int ii = 1; ii < numbr; ii++){   //Vincent 9/23 3:41PM
		   for (i = 0; i < 52; i++) {
			   cards[i][ii] = "notUsed";
            records[i][ii] = 0;  //Vincent 9/23 5:36PM
		   }
      }
	}
	/**
	 * shuffle deck
	 */
	public void shuffle() {
		int i;
		System.out.println("Reshuffle");
		cardsUsed = 0;
		for(int ii = 1; ii < num_of_decks; ii++){   //Vincent 9/23 3:41PM
		   for (i = 0; i < 52; i++) {
			   cards[i][ii] = "notUsed";
		  }
      }
	}
	/**
	 * deal cards
	 * @return  tempString
	 */
	public String deal() {
		int realRandom;
      int realRandomDeck;   //Vincent 9/23 3:41PM
		String tempString;
      int reset_counter = 0;  //Vincent   9/23  1:22PM
		/**
		 * pick a card, will hang if no options
		 */
      int rR_count = 0;
		realRandom = r.nextInt(52);
      realRandomDeck = r.nextInt(num_of_decks);   //Vincent 9/23 3:41PM
      while (realRandomDeck <= 0){   //Vincent 9/23 3:41PM
         realRandomDeck = r.nextInt(num_of_decks);   //Vincent 9/23 3:41PM
      }   //Vincent 9/23 3:41PM
		while ((cards[realRandom][realRandomDeck].equals("used"))) {
			rR_count++;
			if (rR_count == (52 * num_of_decks)) {
            shuffle();  //Vincent   9/23  4:17  **This line may cause errors, needs to be tested.
            /*while (reset_counter < realRandom){   //Vincent   9/23  1:22PM
               cards[reset_counter][realRandomDeck] = "notUsed";     //Vincent   9/23  1:22PM
               reset_counter++;    //Vincent   9/23  1:22PM
            }    //Vincent   9/23  1:22PM*/
				realRandom = 0;
			}
         realRandom = r.nextInt(52);
         realRandomDeck = r.nextInt(num_of_decks);   //Vincent 9/23 3:41PM
         while (realRandomDeck <= 0){   //Vincent 9/23 3:41PM
            realRandomDeck = r.nextInt(num_of_decks);   //Vincent 9/23 3:41PM
         }   //Vincent 9/23 3:41PM        
		}
		cardsUsed++;
		cards[realRandom][realRandomDeck] = "used";   //Vincent 9/23 3:41PM
      records[realRandom][realRandomDeck] = records[realRandom][realRandomDeck]++;  //Vincent 9/23 5:36PM
		/**
		 * done picking a card
		 * card will be randomly chosen using external function
		 */
		tempString = cards[realRandom][0];
		return tempString;
	}
	/**
	 * how many cards are left
	 * @return  cards used
	 */
	public int numCardsUsed() {
		return cardsUsed;
	}
   
   public void numDecks(int number){   //Vincent 9/23 3:41PM
      num_of_decks = (number + 1);   //Vincent 9/23 3:41PM
   }
     
}