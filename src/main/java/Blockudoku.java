package main.java;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.Scanner;

public class Blockudoku {

   
    private Integer[][] board = new Integer[9][9];
   
    boolean gameOver = false;
    private int count = 0;


    static final Logger logger = Logger.getLogger(Blockudoku.class.getName());

    public Blockudoku() {
       
        createGrid();
        
    }



 

    public void createGrid() {
        for (int i = 0; i < 9; i++) {
           
            for (int j = 0; j < 9; j++) {
              
                board[i][j] = 0;
          }
        }
    }



     public void play(int x, int y){
        if(count%8 == 0)
        {

             if (board[x][y] == 0  && board[x+1][y] == 0 && board[x+2][y] == 0 && 
                board[x+2][y+1] == 0 && board[x+2][y+2] == 0 )
                {
                board[x][y] = 1;
                board[x+1][y] = 1 ;
                board[x+2][y] = 1 ;
                board[x+2][y+1] = 1 ;
                board[x+2][y+2] = 1 ;
                }

             else gameOver = true;   


            
        }

        else if (count%8 ==1 ){



             if (board[x][y] == 0  && board[x][y-1] == 0 && board[x][y-2] == 0 && 
                board[x+1][y] == 0 && board[x+2][y] == 0 )
                {
                    board[x][y] = 1;
                    board[x][y-1] = 1 ;
                    board[x][y-2] = 1 ;
                    board[x+1][y] = 1 ;
                    board[x+2][y] = 1 ;
                }

             else gameOver = true; 

           

        }

        else if (count%8 ==2 ){
              if (board[x][y] == 0  && board[x][y-1] == 0 && board[x][y-2] == 0 )
              {
                    board[x][y] = 1;
                    board[x][y-1] = 1 ;
                    board[x][y-2] = 1 ;
              }

             else gameOver = true; 

        }

        else if (count%8 ==3 ){
              if (board[x][y] == 0  && board[x+1][y] == 0 && board[x+2][y] == 0 )
              {
                board[x][y] = 1;
                board[x+1][y] = 1 ;
                board[x+2][y] = 1 ;
              }

             else gameOver = true; 

        }


        else if (count%8 ==4 ){
              if (board[x][y] == 0  && board[x+1][y] == 0 && board[x+2][y] == 0 && 
                board[x][y-1] == 0 && board[x][y-2] == 0 )
                {     
                    board[x][y] = 1;
                    board[x+1][ y ] = 1 ;
                    board[x+2][ y ] = 1 ;
                    board[x][ y - 1] = 1 ;
                    board[x][ y - 2] = 1 ;
                }

             else gameOver = true; 

        }

        else if (count%8 ==5 ){

            if (board[x][y] == 0  && board[x][y-1] == 0  && board[x+1][y-1] == 0 && board[x+2][y-1] == 0 && 
                board[x][y-2] == 0 )
                {     
                    board[x][y] = 1;
                    board[ x ][ y - 1 ] = 1 ;
                    board[ x + 1 ][ y - 1 ] = 1 ;
                    board[ x + 2 ][ y - 1] = 1 ;
                    board[ x  ][ y - 2 ] = 1 ;
                }

             else gameOver = true; 


        }

        else if (count%8 ==6 ){

              if (board[x][y] == 0  && board[x+1][y] == 0 && board[x+2][y] == 0 && 
                board[x+2][y+1] == 0 )
                
                {
                    board[x][y] = 1 ;
                    board[x + 1][y] = 1 ;
                    board[x + 2][y] = 1 ;
                    board[x + 2][y+1] = 1 ;
                }

             else gameOver = true; 
        }
        else {

                if (board[x][y] == 0  && board[x][y-1] == 0 && board[x+1][y-1] == 0 && 
                board[x+2][y-1] == 0 )
                
                {
                    board[x][y] = 1 ;
                    board[x][y-1] = 1 ;
                    board[x + 1][y-1] = 1 ;
                    board[x + 2][y-1] = 1 ;
                }

             else gameOver = true;
        }

        count += 1;


    }



    public boolean getGameOver() {
        return gameOver;
    }
    


    public static void main(String[] args){
        logger.info("CS-UTEC Software Engineering I");
        Scanner input = new Scanner(System.in);
        Integer boardSize = input.nextInt();
        Blockudoku game = new Blockudoku();
        int x;
        int y;
        while(!game.gameOver){
            logger.info("Ingrese la coordenada x: "); x = input.nextInt();
            logger.info("Ingrese la coordenada y: "); y = input.nextInt();
            game.play(x, y);
        }
        logger.info("PERDISTE!!!");
        input.close();
    }
}
