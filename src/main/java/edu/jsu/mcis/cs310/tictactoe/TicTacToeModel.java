package edu.jsu.mcis.cs310.tictactoe;

//import javax.xml.transform.OutputKeys;

//import jdk.vm.ci.code.site.Mark;
//import java.lang.*;
/**
* TicTacToeModel implements the Model for the Tic-Tac-Toe game.
*
* @author  Andrew Parton
* @version 1.0
*/
public class TicTacToeModel {
    
    /**
     * The contents of the Tic-Tac-Toe game board
     */
    private TicTacToeSquare[][] board;
    
    /**
     * xTurn is true if X is the current player, or false if O is the current
     * player
     */
    private boolean xTurn;
    
    /**
     * The dimension (width and height) of the game board
     */
    private int dimension;

    /**
    * Default Constructor (uses the default dimension)
    */    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_DIMENSION);
        
    }
    
    /**
    * Constructor (uses specified dimension)
    * 
    * @param dimension The <em>dimension</em> (width and height) of the new
    * Tic-Tac-Toe board.
    */
    public TicTacToeModel(int dimension) {
        
        /* Initialize dimension; X goes first */
        
        this.dimension = dimension;
        xTurn = true;
        
        /* Create board as a 2D TicTacToeSquare array */
        
        board = new TicTacToeSquare[dimension][dimension];

        /* Initialize board (fill with TicTacToeSquare.EMPTY) */
        
        // INSERT YOUR CODE HERE
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board.length; c++)
                board[r][c] = TicTacToeSquare.EMPTY;
        
    }
    /**
    * Use isValidSquare(int, int) to check if the specified square is in range,
    * and use isSquareMarked(int, int) to check if the square is currently
    * empty.  If both conditions are satisfied, create a mark in the square for
    * the current player, then toggle xTurn from true to false (or vice-versa)
    * to switch to the other player before returning TRUE.  Otherwise, return
    * FALSE.
    *
    * @param  row  the row (Y coordinate) of the square
    * @param  col  the column (X coordinate) of the square
    * @return      a Boolean value representing the result of the attempt to
    * make this mark: true if the attempt was successful, and false otherwise
    * @see         TicTacToeSquare
    */
    public boolean makeMark(int row, int col) {
        
        // INSERT YOUR CODE HERE
        int r = row;
        int c = col;

        if(isValidSquare(r, c) == true && isSquareMarked(r, c) == false)
        {              
            //needs work
            if(xTurn == true)
            {
                board[r][c] = TicTacToeSquare.X;
                xTurn = false;                    
            }
            else
            {
                board[r][c] = TicTacToeSquare.O;
                xTurn = true;
            }                
            return true;                            
        }
        else
            return false; // this is a stub; you may need to remove it later!
        
    }
    
    /**
    * Checks if the specified square is within range (that is, within the bounds
    * of the game board).
    *
    * @param  row  the row (Y coordinate) of the square
    * @param  col  the column (X coordinate) of the square
    * @return      a Boolean value: true if the square is in range, and false
    * if it is not
    */
    private boolean isValidSquare(int row, int col) {
        
        // INSERT YOUR CODE HERE
        int ro = row;
        int co = col;

        if(ro < dimension && co < dimension)
        {
            return true;    
        }    
        else
            return false; // this is a stub; you may need to remove it later!
        
    }
    
    /**
    * Checks if the specified square is marked.
    *
    * @param  row  the row (Y coordinate) of the square
    * @param  col  the column (X coordinate) of the square
    * @return      a Boolean value: true if the square is marked, and false
    * if it is not
    */
    private boolean isSquareMarked(int row, int col) {
                
        // INSERT YOUR CODE HERE
        int r = row;
        int c = col;
        
        
        if(board[r][c] != TicTacToeSquare.EMPTY)
            return true;
        else       
            return false; // this is a stub; you may need to remove it later!
            
    }
    
    /**
    * Returns a {@link TicTacToeSquare} object representing the content of the
    * specified square of the Tic-Tac-Toe board.
    *
    * @param  row  the row (Y coordinate) of the square
    * @param  col  the column (X coordinate) of the square
    * @return      the content of the specified square
    * @see         TicTacToeSquare
    */
    public TicTacToeSquare getSquare(int row, int col) {
        
        // INSERT YOUR CODE HERE
        //started 24
        int r = row;
        int c = col;

        

        return board[r][c];
        //return null; // this is a stub; you should remove it later!
            
    }
    
    /**
    * Use isMarkWin() to determine if X or O is the winner, if the game is a
    * tie, or if the game is still in progress. Return the current state of the
    * game as a {@link TicTacToeState} object.
    *
    * @return      the current state of the Tic-Tac-Toe game
    * @see         TicTacToeState
    */
    public TicTacToeState getState() {
        
        // INSERT YOUR CODE HERE

        if(isMarkWin(TicTacToeSquare.X) == true)
        {
            return TicTacToeState.X;
        }
        else if(isMarkWin(TicTacToeSquare.O) == true)
        {
            return TicTacToeState.O;
        }
        else if((isTie() == true) && (isMarkWin(TicTacToeSquare.X) == false) && (isMarkWin(TicTacToeSquare.O) == false))
        {
            return TicTacToeState.TIE;
        }
        else
            return TicTacToeState.NONE;
        //return null; // this is a stub; you should remove it later!
        
    }
    
    /**
    * Check the squares of the Tic-Tac-Toe board to see if the specified player
    * is the winner.
    *
    * @param  mark  the mark representing the player to be checked (X or O)
    * @return       true if the specified player is the winner, or false if not
    * @see          TicTacToeSquare
    */
    private boolean isMarkWin(TicTacToeSquare mark) {
        
        // INSERT YOUR CODE HERE
        //this.mark = mark; 1 less error when commented out
        // not done

        int i = 0; 
        int k = (dimension - 1);
        int m = (dimension - 1);
        int p = 0;
        int s = 0;
        int u = 0;
        int w = 0;

        int diag_a = 0;
        int diag_b = 0;
        int horiz = 0;
        int vert = 0;


            while(i < dimension)                   // tests diagonal
            {                                        //x
                if(board[i][i] != mark)              // x
                {                                    //  x
                    i = 60;
                }

                if(board[(dimension - 1)][(dimension - 1)] == mark)
                {
                    diag_a = 1;
                }                
                i++;
            }

            while(k < dimension)                      // tests diagonal 
            {                                          //  x
                                                       // x
                if(board[k][m] != mark)                //x
                {
                    k = 60;
                }

                if(board[(dimension - 1)][0] == mark)
                {
                    diag_b = 1;
                }
                k++;
                m--;
            }

            /*while(p != dimension)               //checks horizontal wins not working
            {
                if(board[p][s] == mark)
                {
                    s++;

                }
                else
                {
                    s = 0;
                    p++;

                }

                if(s == (dimension - 1))                            //board [p][s] == board[][(dimension - 1)]
                {                    
                    horiz = 1;
                    p = dimension;
                    
                    
                }

            }

            while(w != dimension)        //checks vertical wins not working
            {
                if(board[u][w] == mark)
                {
                    u++;
                }
                else
                {
                    u = 0;
                    w++;
                }

                if(u == (dimension - 1))
                {
                    vert = 1;
                    w = dimension;
                    
                    
                }

            }*/
        
        
        
        if((diag_a == 1) || (diag_b == 1) || (horiz == 1) || (vert == 1))
        {
            return true;
        }
        else
            return false; // this is a stub; you may need to remove it later!
        
        
    }
    
    /**
    * Check the squares of the board to see if the Tic-Tac-Toe game is currently
    * in a tie state.
    *
    * @return  true if the game is currently a tie, or false otherwise
    */	
    private boolean isTie() {
        
        // INSERT YOUR CODE HERE
        int tie = 0;

        for (int r = 0; r < (dimension - 1); r++)              // tests if there are empty spaces on the board
            for (int c = 0; c < (dimension - 1); c++)
            {
                if(board[r][c] == TicTacToeSquare.EMPTY);
                {                    
                    tie = 1;
                   
                    
                }
            }
        
        if((tie == 0) && ((isMarkWin(TicTacToeSquare.X)) == false) && ((isMarkWin(TicTacToeSquare.O)) == false))
        {
            return true;
        }
        else
            return false;
        /*if(isMarkWin() == true)
            return true;
        else*/
            
        
        
    }

    /**
    * Uses {@link #getState() getState} to checks if the Tic-Tac-Toe game is
    * currently over, either because a player has won or because the game is
    * in a tie state.
    *
    * @return  true if the game is currently over, or false otherwise
    */	
    public boolean isGameover() {
        
        return TicTacToeState.NONE != getState();
        
    }

    /**
    * Getter for xTurn.
    *
    * @return  true if X is the current player, or false if O is the current
    * player
    */
    public boolean isXTurn() {
        
        return xTurn;
        
    }
    
    /**
    * Getter for dimension.
    *
    * @return  the <em>dimension</em> (width and height) of the Tic-Tac-Toe
    * game board
    */
    public int getDimension() {
        
        return dimension;
        
    }
    
    /**
    * <p>Returns the current content and state of the Tic-Tac-Toe game board as
    * a formatted String.  This method <em>must</em> use a {@link StringBuilder}
    * to compose the output String, which should not include any empty lines.</p>
    * <p>Here is an example of how the output for a 3x3 game board should
    * appear (also see the example output on Canvas):</p>
    * <code>&nbsp;&nbsp;012<br>0&nbsp;O&nbsp;&nbsp;<br>1&nbsp;&nbsp;X&nbsp;<br>2&nbsp;O&nbsp;X</code>
    * @return      the representation of the Tic-Tac-Toe game board
    * @see         StringBuilder
    */
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("");//"  "
        
        // INSERT YOUR CODE HERE
        int a = (dimension + 2);    //for extended rows and columns with spaces;
        


        int b = 2; //counter for columns
        int d = 0; //numbers for columns
        int s = 0;


        int e = 1; //counter for rows
        int f = 0; //numbers for rows
        int t = 0;
        int u = 0;
        

        String disboard[][] = new String[a][a];



        for (int r = 0; r < disboard.length; r++)          //sets every space as blank initially
            for (int c = 0; c < disboard.length; c++)     // will say null on every space of not
                disboard[r][c] = "";
        
        disboard[0][0] = " "; //empty space for corner
        disboard[0][1] = " "; //


        while(b < a)                  //for columns lable
        {
            disboard[0][b] = Integer.toString(d);
            b++;
            d++;

        }

        /*while(s < a) //displays "  012"
        {
        output.append(disboard[0][s]);
        s++;
        }*/

        while(e < a)                //for rows lable
        {
            disboard[e][0] = Integer.toString(f);
            disboard[e][1] = " ";        //fixes some spacing issues might need something for columns
            e++;
            f++;
        }

        /*while(t < (a - 1))                  //displays    0        both just like his output
        {                                   //            1        but only first column on new lines
            output.append(disboard[t][0]);  //            2
            t++;
            
            output.append("\n");

        }*/
        

        /*for(int y = 0; y < disboard.length; y++)               // displays "  012"
        {                                                      //           0
            output.append("\n");                                //          1
                                                                    //      2

            for(int z = 0; z < disboard.length; z++)
                if(y <= board.length)
                {
                    output.append(disboard[y][z]);
                }
        }*/

        /*for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board.length; c++)
            {
                if(board[r][c].equals(TicTacToeSquare.X))
                {
                    disboard[(r + 2)][(c + 1)] = "X";
                    //output.append(disboard[(r + 2)][(c + 1)]);
                }
                else if(board[r][c].equals(TicTacToeSquare.O))
                {
                    disboard[(r + 2)][(c + 1)] = "O";
                    //output.append(disboard[(r + 2)][(c + 1)]);
                }
                
            }
        }*/

        for(int roe = 0; roe < disboard.length; roe++)               // displays "  012"
        {                                                      //           0
            output.append("\n");                                //          1            roe = y
                                                                    //      2            cal = z

            for(int cal = 0; cal < disboard.length; cal++)
            {
                if(roe <= board.length)
                {
                    
                    output.append(disboard[roe][cal]);
                }


                if((roe > 0) && (roe < (dimension + 1)) && (cal > 1)) //columns still wrong on output
                {
                    int r = (roe - 1);
                    int c = (cal - 2);
                    if(board[r][c].equals(TicTacToeSquare.X))
                    {
                        disboard[roe][cal] = "X";
                        output.append(disboard[roe][cal]);
                    }
                    else if(board[r][c].equals(TicTacToeSquare.O))
                    {
                        disboard[roe][cal] = "O";
                        output.append(disboard[roe][cal]);
                    }
                    else
                    {
                        disboard[roe][cal] = " ";
                        output.append(disboard[roe][cal]);
                    }                        

                }  
            }    
        }

        return output.toString();
        
    }
    
}