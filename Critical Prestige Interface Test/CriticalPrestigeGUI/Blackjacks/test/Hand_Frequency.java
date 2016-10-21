import java.util.StringTokenizer;

class Hand_Frequency {

   int freq[][] = new int[10][29];

   String ph1;
   String ph2;
   String dh;
   int temp;
   int temp2;
   int temp3;
   
   public void filler(String initial) {
   
      StringTokenizer st = new StringTokenizer(initial);
      
      dh = st.nextElement().toString();
      ph1 = st.nextElement().toString();
      ph2 = st.nextElement().toString();
      
      // freq[x-axis][y-axis] on sheet, reverse on file
      // player, player, dealer
      
      if(ph2.equals("A") && !ph1.equals("A")){
         String swtch;
         swtch = ph2;
         ph2 = ph1;
         ph1 = swtch;
      }   
      else if(ph1.equals("A")){
         if(ph2.equals("A")){
            if(dh.equals("A")){
               freq[9][19] = freq[9][19] + 1;   // A, A, A
            }
            else{
               temp = Integer.parseInt(dh);
               freq[temp - 2][19] = freq[temp - 2][19] + 1; // A, A, X
            }
         }
         else{
            temp = Integer.parseInt(ph2);
            if(dh.equals("A")){
               freq[9][18 + temp] = freq[9][18 + temp] + 1; // A, X, A
            }
            else{
               temp2 = Integer.parseInt(dh);
               freq[temp2 - 2][18 + temp] = freq[temp2 - 2][18 + temp] + 1;   // A, X, X
            }
         }
      }
      else if(ph1.equals(ph2)){  // Splits
         temp = Integer.parseInt(ph1);
         if(dh.equals("A")){
            freq[9][temp + 8] = freq[9][temp + 8] + 1;   // S, S, A
         }
         else{
            temp2 = Integer.parseInt(dh);
            freq[temp2 - 2][temp + 8] = freq[temp2 - 2][temp + 8] + 1;  // S, S, X
         }
      }
      else if(dh.equals("A")){
         temp = Integer.parseInt(ph1);
         temp2 = Integer.parseInt(ph2);
         if(((temp + temp2) < 18) && (temp + temp2) > 7 ){
            freq[9][(temp + temp2) - 8] = freq[9][(temp + temp2) - 8] + 1; // X, X, A
         }
      }
      else{
         temp = Integer.parseInt(ph1);
         temp2 = Integer.parseInt(ph2);
         temp3 = Integer.parseInt(dh);
         if(((temp + temp2) < 18) && (temp + temp2) > 7 ){
            freq[temp3 - 2][(temp + temp2) - 8] = freq[temp3 - 2][(temp + temp2) - 8] + 1;   // X, X, X
         }
      }
   }
   
   public int[][] table(){
      return freq;
   }
}