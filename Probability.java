/**
 * importing necessary input/output classes and String Tokenizer
 */
import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.FileWriter; 
import java.io.File;

public class Probability {

  public static int numberOfSplits = 4;
  static String userAction[][] = new String [30][11]; // size of table of input file (strategy card)

  public static void main(String[] args) throws IOException{
    
    // split variables
    Hand playerSplit[] = new Hand[4];
    int numSplits = 0;
    
    // to display scores
    int dScore = 0, pScore = 0;
    
    // user input stream reader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner keyboard = new Scanner(System.in);
    FileWriter fileWriter = new FileWriter(new File("Hand_Frequency_Table.csv"));
    //FileWriter fileWriter = new FileWriter(new File("Hit_Table.csv"));
    
    // to analyze player actions
    String playerMove = null, realTemp = "", tempDecisionString = "";
    boolean doubleDownFlag = false;
    
    System.out.println("Enter the Number of Hands: ");   //Vincent   9/23  3:01PM
    int hands = keyboard.nextInt();   //Vincent   9/23  3:01PM
    
    System.out.println("Enter the Number of Decks: ");
    int decks = keyboard.nextInt();
    
    // define normal play variables       //Vincent 9/23 3:41PM
    Deck theDeck = new Deck(decks);
    Hand player = new Hand();
    Hand dealer = new Hand();
    boolean hasSplit = false;
    int count = 0;
    
    theDeck.numDecks(decks);     //Vincent 9/23 3:41PM
    Hand_Frequency Fill = new Hand_Frequency();
    int hit_array[][] = new int[10][29];  //Vincent 10/15
    int stand_array[][] = new int[10][29];
    int dd_array[][] = new int[10][29];
    
    for(int xxxx = 0; xxxx < 10; xxxx++){ //Vincent 10/15
      for(int yyyy = 0; yyyy < 29; yyyy++){
         hit_array[xxxx][yyyy] = 0;
         stand_array[xxxx][yyyy] = 0;
         dd_array[xxxx][yyyy] = 0;
      }
    }
    

    
    // main play loop

    /*for(int ddd = 0; ddd < hands; ddd++){   //Vincent   9/23  3:01PM
      //System.out.println(count + "\t-----------------------------------------------------------------------------------count");
      count++;
      
      Fill.filler(startNewGame(player, dealer, pScore, dScore, theDeck));

      checkScores(player, dealer, pScore, dScore, theDeck, "false");
      
    }*/

//HIT-------------------------------------------------------------------------------------------------------------------------------------------------------------------------HIT    
     for(int xxx = 0; xxx < 10; xxx++){   
        for(int yyy = 0; yyy < 29; yyy++){
          for(int fff = 0; fff < 100; fff++){
            startNewGame(player, dealer, pScore, dScore, theDeck);
            int pValue;
            int dValue;
            if(yyy < 10){  //normal
               String yValue1 = "" + ((yyy + 8)/2);
               String yValue2 = "" + (((yyy + 8)/2) + ((yyy + 8) % 2));
               String xValue = "" + (xxx + 2);
               player.setCards(yValue1, yValue2);
               dealer.setHand(xValue);
               while(player.value() < 18 && dealer.value() < 17){
                  if(player.value() < 18){
                     player.hit(theDeck.deal());  
                     //System.out.println("1Player Hits ----------------" + (yyy - 8) * 2 + "\t\t" + player.value() + "\t" + dealer.value()); 
                  }      
                  if(dealer.value() < 17){   
                     dealer.hit(theDeck.deal());
                     //System.out.println("1Dealer Hits ----------------" + (xxx + 2) + "\t\t" + player.value() + "\t" + dealer.value()); 
                  }
               }
               //System.out.println((yyy + 8) + "\t\t" + player.value() + "\t" + dealer.value());           
               if(player.value() > dealer.value() && player.value() <= 21){
                  hit_array[xxx][yyy] = hit_array[xxx][yyy] + 1;
               }
               //System.out.println((yyy + 8) + "\t\t" + player.value() + "\t" + dealer.value());
               if(player.value() < dealer.value() && player.value() <= 21 && dealer.value() > 21){
                  hit_array[xxx][yyy] = hit_array[xxx][yyy] + 1;
               }
               theDeck.shuffle();
            }
            if(yyy > 9 && yyy < 19){   //splits
               String yValue = "" + (yyy - 8);
               String xValue = "" + (xxx + 2);
               player.setCards(yValue, yValue);
               dealer.setHand(xValue);
               while(player.value() < 18 && dealer.value() < 17){
                  if(player.value() < 18){
                     player.hit(theDeck.deal());  
                     //System.out.println("2Player Hits ----------------" + player.value() + "\t\t" + player.value(); + "\t" + dealer.value()); 
                  }      
                  if(dealer.value() < 17){   
                     dealer.hit(theDeck.deal());
                     //System.out.println("2Dealer Hits ----------------" + (xxx + 2) + "\t\t" + player.value() + "\t" + dealer.value()); 
                  }
               }
               /*if(yyy == 18){ // 10, 10 ------------------------------------------------------------
                  if(dealer.value() < 20){
                     hit_array[xxx][yyy] = hit_array[xxx][yyy] + 1;
                     //System.out.println("7Player Hits ----------------" + (yyy - 8) * 2 + "\t\t" + player.value() + "\t" + dealer.value());
                  }
               }*/
               System.out.println((yyy - 8) * 2 + "\t\t" + player.value() + "\t" + dealer.value() + "\t\t\t\t" + fff);           
               if(player.value() > dealer.value() && player.value() <= 21){
                              //System.out.println("check");
                  hit_array[xxx][yyy] = hit_array[xxx][yyy] + 1;
               }
               System.out.println((yyy - 8) * 2 + "\t\t" + player.value() + "\t" + dealer.value() + "\t\t\t\t" + fff);
               if(player.value() < dealer.value() && player.value() <= 21 && dealer.value() > 21){
                              //System.out.println("check");
                  hit_array[xxx][yyy] = hit_array[xxx][yyy] + 1;
               }
               theDeck.shuffle();
            }    
            if(yyy > 18){  //aces
               String yValue = "" + (yyy - 18);
               String xValue = "" + (xxx + 2);
               player.setCards("A", yValue);
               dealer.setHand(xValue);
               while(player.value() < 18 && dealer.value() < 17){
                  if(player.value() < 18){
                     //System.out.println("3Player Hits ----------------" + (yyy - 7) + "\t\t" + player.value() + "\t" + dealer.value()); 
                     player.hit(theDeck.deal());  
                  }      
                  if(dealer.value() < 17){  
                     //System.out.println("3Dealer Hits ----------------" + (xxx + 2) + "\t\t" + player.value() + "\t" + dealer.value());  
                     dealer.hit(theDeck.deal());
                  }
               }    
               //System.out.println((yyy - 7) + "\t\t" + player.value() + "\t" + dealer.value());      
               if(player.value() > dealer.value() && player.value() <= 21){
                  hit_array[xxx][yyy] = hit_array[xxx][yyy] + 1;
               }
               //System.out.println((yyy -7 ) + "\t\t" + player.inputValue(yyy - 7, true) + "\t" + dealer.inputValue(xxx + 2, true));
               if(player.value() < dealer.value() && player.value() <= 21 && dealer.value() > 21){
                  hit_array[xxx][yyy] = hit_array[xxx][yyy] + 1;
               }
               theDeck.shuffle();
            }     
          }
        }
     }
//HIT---------------------------------------------------------------------------------------------------------------------------------------------------------------------------HIT

//STAND------------------------------------------------------------------------------------------------------------------------------------------------------------------------STAND
     for(int xxx = 0; xxx < 10; xxx++){   
        for(int yyy = 0; yyy < 29; yyy++){
          for(int fff = 0; fff < 100; fff++){
            startNewGame(player, dealer, pScore, dScore, theDeck);
            if(yyy < 10){  //normal
               String yValue1 = "" + ((yyy + 8)/2);
               String yValue2 = "" + (((yyy + 8)/2) + ((yyy + 8) % 2));
               String xValue = "" + (xxx + 2);
               player.setCards(yValue1, yValue2);
               dealer.setHand(xValue);
               while(dealer.value() < 17){   
                  dealer.hit(theDeck.deal());
               }
               System.out.println((yyy + 8) + "\t\t" + player.value() + "\t" + dealer.value());           
               if(player.value() > dealer.value() && player.value() <= 21){
               //System.out.println("check");
                  stand_array[xxx][yyy] = stand_array[xxx][yyy] + 1;
               }
               System.out.println((yyy + 8) + "\t\t" + player.value() + "\t" + dealer.value());
               if(player.value() < dealer.value() && player.value() <= 21 && dealer.value() > 21){
               //System.out.println("check");
                  stand_array[xxx][yyy] = stand_array[xxx][yyy] + 1;
               }
               theDeck.shuffle();
            }
            if(yyy > 9 && yyy < 19){   //splits
               String yValue = "" + (yyy - 8);
               String xValue = "" + (xxx + 2);
               player.setCards(yValue, yValue);
               dealer.setHand(xValue);
               while(dealer.value() < 17){   
                  dealer.hit(theDeck.deal());
               } 
               /*if(yyy == 18){
                  if(dealer.value() < 20){
                     stand_array[xxx][yyy] = stand_array[xxx][yyy] + 1;
                  }
               }*/
               //System.out.println((yyy - 8)*2 + "\t\t" + player.value() + "\t" + dealer.value());           
               if(player.value() > dealer.value() && player.value() <= 21){
                  stand_array[xxx][yyy] = stand_array[xxx][yyy] + 1;
               }
               //System.out.println((yyy - 8)*2 + "\t\t" + player.value() + "\t" + dealer.value());
               if(player.value() < dealer.value() && player.value() <= 21 && dealer.value() > 21){
                  stand_array[xxx][yyy] = stand_array[xxx][yyy] + 1;
               }
               theDeck.shuffle();
            }    
            if(yyy > 18){  //aces
               String yValue = "" + (yyy - 18);
               String xValue = "" + (xxx + 2);
               player.setCards("A", yValue);
               dealer.setHand(xValue);
               while(dealer.value() < 17){   
                  dealer.hit(theDeck.deal());
               }     
               //System.out.println((yyy - 7) + "\t\t" + player.value() + "\t" + dealer.value());      
               if(player.value() > dealer.value() && player.value() <= 21){
                  stand_array[xxx][yyy] = stand_array[xxx][yyy] + 1;
               }
               //System.out.println((yyy -7 ) + "\t\t" + player.value() + "\t" + dealer.value());
               if(player.value() < dealer.value() && player.value() <= 21 && dealer.value() > 21){
                  stand_array[xxx][yyy] = stand_array[xxx][yyy] + 1;
               }
               theDeck.shuffle();
            }     
          }
        }
     }
//STAND------------------------------------------------------------------------------------------------------------------------------------------------------------------------STAND

    for(int xxxx = 0; xxxx < 10; xxxx++){
      System.out.println("\n");
      for(int yyyy = 0; yyyy < 29; yyyy++){
         System.out.print(hit_array[xxxx][yyyy] + ",");
      }
    }
    
    System.out.println("\n\n");
    
    for(int xxxx = 0; xxxx < 10; xxxx++){
      System.out.println("\n");
      for(int yyyy = 0; yyyy < 29; yyyy++){
         System.out.print(stand_array[xxxx][yyyy] + ",");
      }
    }
    
    int temp_array[][] = Fill.table();
    
    String header = " ,8,9,10,11,12,13,14,15,16,17,2_2,3_3,4_4,5_5,6_6,7_7,8_8,9_9,10_10,A_A,A_2,A_3,A_4,A_5,A_6,A_7,A_8,A_9,A_10";
    //System.out.println(header);
    fileWriter.write(header);
    fileWriter.write(System.lineSeparator());
    
    for(int first = 0; first < 10; first++){ //Hand frequency loop file writing loop ------------------------------------------------
      //System.out.println();
      String concat = "";
      for(int second = 0; second < 29; second++){
         //System.out.print(temp_array[first][second] + "   ");
         concat += temp_array[first][second] + ",";
      }
      int temp_first = first + 2;
      String tmp_first = Integer.toString(temp_first);
      if(tmp_first.equals("11")){
         tmp_first = "A";
      }
      concat = tmp_first + "," +  concat.substring(0, concat.length() - 1);
      //System.out.println(concat);
      fileWriter.write(concat);
      fileWriter.write(System.lineSeparator());
    }
    fileWriter.close();
  }

    public static String startNewGame(Hand player, Hand dealer, int pScore, int dScore, Deck theDeck) 
    {
      //System.out.println("Line 185---------------------------------------------------------------------");
      player.newHand();
      dealer.newHand();
      //System.out.println("Line 188---------------------------------------------------------------------");
      // deal first cards    

      String temp1 = theDeck.deal();
      dealer.hit(temp1);
      if (temp1.equals("J") || temp1.equals("Q") || temp1.equals("K")){
         temp1 = "10";
      }
      String temp2 = theDeck.deal();
      player.hit(temp2);
      if (temp2.equals("J") || temp2.equals("Q") || temp2.equals("K")){
         temp2 = "10";
      }
      String temp3 = theDeck.deal();
      player.hit(temp3);
      if (temp3.equals("J") || temp3.equals("Q") || temp3.equals("K")){
         temp3 = "10";
      }
      
      /*dealer.hit(temp1);
      player.hit(temp2);
      player.hit(temp3);*/
     // System.out.println("----------------------------Temps: " + temp1 + " " +  temp2 + " " + temp3);
      return temp1 + " " +  temp2 + " " + temp3;   // dh, ph1, ph2
      
    }

    public static void checkScores(Hand player, Hand dealer, int pScore, int dScore, Deck theDeck, String firstPlay) {
        //System.out.println("Dealer Cards\t\t" + dealer.displayHand());
       // System.out.println("Your Cards\t\t\t" + player.displayHand() + " = " + player.value());
       System.out.print("");
      } 
  }