package main.java;

import java.util.logging.Logger;


public class Blockudoku {

   
    private Integer[][] board = new Integer[9][9];
   
    boolean gameOver = false;
    private int count = 0;
    private int puntaje = 0;

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
                board[x+2][y-1] == 0 && board[x+2][y+1] == 0 )
                {     
                    board[x][y] = 1;
                    board[x+1][ y ] = 1 ;
                    board[x+2][ y ] = 1 ;
                    board[x + 2][ y - 1] = 1 ;
                    board[x +2][ y +1] = 1 ;
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

    public void Puntaje() {
        int cnthorizontal = 0;
       
        for (int i = 0; i < 9  ; i++) {
            int horizontal = 0;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0)
                   horizontal +=1;
          }
          if(horizontal == 0) cnthorizontal += 1;
        }


        int cntvertical= 0;
       
        for (int i = 0; i < 9  ; i++) {
            int vertical = 0;
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == 0)
                   vertical+=1;
          }
          if(vertical == 0) cntvertical += 1;
        }


     
       int cntcuadrado= 0;
      
        for (int i = 0; i < 9  ; i+=3) {
            int horizontal = 0;
            for (int j = 0; j < 9; j+=3) {
                if (board[i][j] == 0 && board[i][j+1]== 0  && board[i][j+2]== 0 
                    && board[i+1][j]== 0 && board[i + 1][j + 1 ]== 0 &&  board[i + 1][j +2 ]== 0 &&
                       board[i+2][j]== 0 && board[i + 2][j + 1 ]== 0 &&  board[i + 2][j +2 ]== 0  )

                         cntcuadrado += 1;
          }
        }

        puntaje +=  (cntcuadrado * 150 + cnthorizontal*120 + cntvertical*120)*(cnthorizontal + cntvertical + cntcuadrado);

    }

    public boolean getGameOver() {
        return gameOver;
    }
    
}
