Team Name: Critical-Prestige
Project: Improve 4LeafCo's Original Desktop Blackjack Game

Introduction: The Blackjack software will serve as a learning game. It will teach the user or player how to correctly play Blackjack.  The game will allow the user to play against a dealer that is simulated by the software.  The learning aspect is introduced at critical moments when the user makes a mistake or does not play the best move according to the Blackjack Strategy Table. The program will alert the player of the mistake and report what the correct move should have been, thus teaching to Player how to correctly play the game.  With these critical guidelines, this game of Blackjack will be useful to the novice and expert players. 

Details:
Desktop Application
The desktop game will function as the Dealer and the Player will make decisions based on the cards shown throughout the different plays whether they will split, double-down, hit, or stand every time.  The desktop game will be able to teach the Player how to correctly play Blackjack based on the strategy card developed by the database program which allows for the highest probability of winning.  The user will be able to interact with the desktop game via the graphical user interface. 

Probability Program
The Probability Program will calculate the probabilities for each possible play using the Hand Frequency CSV and will generate the probability of winning for each possible play (Split, Double Down, Hit, or Stand) for each possible hand. The program will create four tables (one for Split, Double Down, Hit, and Stand) and write them to a CSV file. The program will also create two additional tables; the Blackjack Strategy Table and a Probability Table. The Blackjack Strategy Table will use mnemonics as cell entries (P for Split, D for Double Down, H for Hit, and S for Stand) and create an ASCII text file that gives the best possible move for winning each hand. The Probability will contain the highest probability of winning each hand from the four tables (Split, Double Down, Hit, and Stand) and create a CSV file containing the results. Figure 1 contains an example of the Strategy Table.	



 
Figure 1. Strategy Table Example



Hand Frequency Program
This program takes two user inputs (number of hands to be played and number of decks to use) and creates a Hand Frequency CSV containing the number of times each hand appeared with regards to the user inputs.

Overall Probability Program
The Overall Probability Program will calculate the overall probability of winning by multiplying the Hand Frequency Table with the Probability Table.	

Hand Program
The Hand Program assigns “cards” to the user and dealer, stores those cards in an array representation of a hand, and outputs the hand array when applicable methods are called.

Deck Program
Randomly picks and returns a representational card string when applicable methods are called and “reshuffles” the deck(s) when a sufficient number of cards have been drawn.

Blackjack Program
Contains several lines of code that create a user interface that allows the user to play the game of Blackjack and instantiates Deck and Hand objects to track and handle the usage of cards throughout the game.

How to Play:
1. 
2. 
3. 
4. 
