/**
 * Minesweeper the Game
 * 
 * @author Gabriel Murillo 
 * @version 11.14.2016
 */
import java.lang.Math;

public class Minesweeper{
    int[] board;
    int rows;
    int columns;

    public Minesweeper(int rows, int columns) 
    {
        this.rows = rows;
        this.columns = columns; 
        board = new int[rows*columns];
    }

    public Minesweeper() 
    {
        this(10, 10);
        board[95] = 9;
        board[5] = 9;
        board[49] = 9;
        board[30] = 9;
        board[0] = 9;
    }

    public void printSquareArray()
    {
        System.out.println();
        System.out.println("M I N E S W E E P E R");
        for (int i = 0; i < board.length ; i++) 
        {    
            if (i%columns == 0) {
                System.out.println();
            } 
            if (board[i] >= 9) 
            {
                System.out.print("X ") ;
            }
            else {
                System.out.print(board[i] + " ");                
            }    
            
        }
    }

    public void addBombs(int bombs) 
    {
        while (bombs > 0) 
        {

            int pos = (int)(Math.random()*(board.length + 1));      
            try 
            {
                if (board[pos] != 9) {
                    board[pos] = 9;
                    bombs -= 1;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e){
                System.out.println();
            }
        }
    }

    public void addNums() {
        
        for (int i = 0; i < board.length; i++)  
        {      
            try 
            {                
                if (board[i] == 9) 
                {

                    //Left 
                    if ((board[i-1] < 9 && i%columns != 0)) 
                    {
                        board[i-1] ++;
                    }
                    //Right
                    if (board[i+1] < 9 && i%columns != (columns -1) ) 
                    {
                        board[i+1] ++;
                    }
                    //Bottom
                    if (board[i+columns] < 9) 
                    {
                        board[i+columns] ++;
                    }
                    //Top
                    if (board[i-columns] < 9) 
                    {
                        board[i-columns] ++;
                    }
                    //Top Right (Corner)
                    if (board[i-columns + 1] < 9 && i%columns != (columns -1)) 
                    {
                        board[i - columns +1 ] ++;
                    }
                    //Top Left (Corner)
                    if (board[i - columns - 1] < 9 && i%columns != 0) 
                    {
                        board[i - columns - 1 ] ++;
                    }              
                    //Bottom Right (Corner)
                    if (board[i+columns + 1] < 9 && i%columns != (columns -1)) 
                    {
                        board[i+columns + 1 ] ++;
                    }
                    //Bottom Left(Corner)                    
                    if (board[i+columns - 1] < 9 && i%columns != 0) 
                    {
                        board[i + columns - 1 ] ++;
                    }
                }
            } catch(java.lang.ArrayIndexOutOfBoundsException e) {
                System.out.println();
            }
        }
    }
}
/*
 * if ((board[i + 1] < 9) && i%columns != 0) { //right
board[i + 1] ++;
}  
if ((board[i - 1] < 9) && (i%columns != 1))
{ //left
board[i - 1] ++;
}               
if ((board[i + columns] < 9)) 
{ //down
board[i + columns] ++;
}
if ((board[i - columns] < 9)) 
{ //up
board[i - columns] ++;      
}
if ((board[i + columns + 1 ]) < 9 && (i%columns != 0)) 
{ //down right
board[i + columns + 1] ++;
}
if ((board[i + columns - 1 ]) < 9 && (i%columns != 1)) 
{ //down left
board[i + columns - 1] ++;
}
if ((board[i - columns + 1 ]) < 9 && (i%columns != 0)) 
{ //up right
board[i - columns + 1] ++;
}
if ((board[i - columns - 1 ] < 9) && (i%columns != 1)) 
{ //up left
board[i - columns - 1] ++;
}   
 */