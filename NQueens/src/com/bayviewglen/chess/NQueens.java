package com.bayviewglen.chess;

import java.util.Scanner;
import java.util.Stack;

public class NQueens {

	static  Scanner scanner = new Scanner(System.in);

    public static String displayBoard(int N, Stack < Queen > queens) {
        Stack < Queen > temps = new Stack < Queen > ();
        String s = "";
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
            	if (!queens.empty() && queens.peek().getCol() == j && queens.peek().getRow()==i) {
                    temps.push(queens.pop());
                    s += "Q ";
                } else
                    s += "X ";
            }
            s += "\n";
        }
        while (!temps.isEmpty()) {
            queens.push(temps.pop());
        }
        return s;
    }

    public static boolean conflict(Stack < Queen > queens, Queen queen) {
        boolean conflict = false;
        Stack < Queen > temps = new Stack < Queen > ();
        while (queens.size() > 0 && !conflict) {
            Queen temp = queens.peek();
            if (queen.getCol() == temp.getCol()) {
                conflict = true;
            } else if (queen.getRow() == temp.getRow()) {
                conflict = true;
            } else if (Math.abs(queen.getRow() - temp.getRow()) == Math.abs(queen.getCol() - temp.getCol())) {
                conflict = true;
            } else
                temps.push(queens.pop());
        }
        while (!temps.isEmpty()) {
            queens.push(temps.pop());
        }
        return conflict;
    }

    public static void main(String[] args) {
    	  int N = 0;
    	while(N!=-1){
        Stack < Queen > queens = new Stack < Queen > ();
        int filled = 0;
      
        N = getValidIntegerInput(4);
      
        int col = 0;
     
        while (filled < N) {
   
        	Queen temp = new Queen(col, filled);
               
              if(col>=N){
            	  col = queens.pop().getCol()+1;
            	  filled--;
              }
              else if(conflict(queens, temp)){
            	  col++;
              }
              else{
            	  temp.setCol(col);
            	  queens.push(temp);
            	  filled++;
            	  col = 0;
              }
            
        }
        System.out.println(displayBoard(N, queens));
    	}
    	 scanner.close();
    }

	private static int getValidIntegerInput(int min) {
		int n = 0;
		
		  boolean valid=false;
			  while(!valid){
		       try{
		    	   System.out.println("Enter N number of queens above 4. Type quit to quit.");
		    	   String s = scanner.nextLine();
		    	   if(s.equalsIgnoreCase("quit"))
		    		   return -1;
		    	   n = Integer.parseInt(s);
		    	   if(n<4){
		    		      System.out.println("That is below 4.");
		    	   }else
		    	   valid = true;
		       }catch(NumberFormatException nfe){
		    	   System.out.println("That might not be an integer.");
		       }
		  }
		return n;
	}
}