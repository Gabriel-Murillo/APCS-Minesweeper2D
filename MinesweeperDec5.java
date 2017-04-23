/**
 * 'Tis minesweeper.
 * 
 * @author Gabriel Murillo 
 * @version 11.14.2016
 */
import java.lang.Math;
public class MinesweeperDec5{
    int[] board;
    int rows;
    int columns;
    int bombs;

    public MinesweeperDec5(int rows, int columns) {
        this.rows = rows;
        this.columns = columns; 
        board = new int[rows*columns];
    }

    public void printSquareArray() {
        System.out.println("M I N E S W E E P E R");
        for (int i = 0; i < board.length ; i++) {    
            if (i%columns == 0) {
                System.out.println();
                
            } 
            if (board[i] == 9) {
                System.out.print("X ") ;
            }
            else {
                System.out.print(board[i] + " ");                
            }         
        }
    }

    public void addBombs(int bombs) {
        while (bombs > 0) {
            this.bombs = bombs;
            int pos = (int)(Math.random()*(rows*columns));

            if (board[pos] == 9) {
                pos = (int) (Math.random()*(rows*columns));
            }
            else {
                board[pos] = 9;
            }
            bombs -= 1;
        }
    }

    public void addNums() {
        for (int i = 0; i < board.length; i++) { 
            try {                
                if (board[i] == 9) {
                    if ((board[i + 1] < 9) && (i%columns != 0)) { //right
                        board[i + 1] ++;
                    }  
                    if ((board[i - 1] < 9) && (i%columns != 1)){ //left
                        board[i - 1] ++;
                    }               
                    if ((board[i + columns] < 9)) { //down
                        board[i + columns] ++;
                    }
                    if ((board[i - columns] < 9)) { //up
                        board[i - columns] ++;      
                    }
                    if ((board[i + columns + 1 ]) < 9 && (i%columns != 0)) { //down right
                        board[i + columns + 1] ++;
                    }
                    if ((board[i + columns - 1 ]) < 9 && (i%columns != 1)) { //down left
                        board[i + columns - 1] ++;
                    }
                    if ((board[i - columns + 1 ]) < 9 && (i%columns != 0)) { //up right
                        board[i - columns + 1] ++;
                    }
                    if ((board[i - columns - 1 ] < 9) && (i%columns != 1)) { //up left
                        board[i - columns - 1] ++;
                    }       
                }
            } catch(java.lang.ArrayIndexOutOfBoundsException e) {
                System.out.println();
            }
        }
    }
}

