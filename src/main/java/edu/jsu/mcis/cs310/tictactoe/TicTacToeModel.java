package edu.jsu.mcis.cs310.tictactoe;

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
        
        
        int r = row;
        int c = col;

        if((isValidSquare(r, c) == true) && (isSquareMarked(r, c) == false))
        {              
            
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
            return false; 
        
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
        
        
        int r = row;
        int c = col;

        if((r < dimension) && (c < dimension) && (r >= 0) && (c >= 0))
        {
            return true;    
        }    
        else
            return false; 
        
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
        {
            return true;
        }
        else       
            return false; 
                              
        
  
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
        
        int r = row;
        int c = col;

        return board[r][c];
            
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
        

        if(isMarkWin(TicTacToeSquare.X) == true)
        {
            return TicTacToeState.X;
        }
        else if(isMarkWin(TicTacToeSquare.O) == true)
        {
            return TicTacToeState.O;
        }
        else if(isTie() == true)
        {
            return TicTacToeState.TIE;
        }
        else
            return TicTacToeState.NONE;
        
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
        



        int i = 0;                 //used for testing first diagonal wins
        int k = (dimension - 1);   //used for second diagonal wins
        int m = 0;               
        int p = 0;                  //used for horizontal wins
        int s = 0;
        int u = 0;                  //used for vertical wins
        int w = 0;

        int diag_a_count = 0;
        int diag_b_count = 0;
        int hcount = 0;
        int vcount = 0;

        int diag_exit_a = 0;        //used for exiting loops
        int diag_exit_b = 0;
        

        int diag_a = 0;           // used to verify a win 
        int diag_b = 0;           // will equal one if the condition was met
        int horiz = 0;
        int vert = 0;


            while(diag_exit_a == 0)                   // tests diagonal (a)    
            {                                         //x
                for(i = 0; i < dimension; i++)        // x
                {                                     //  x
                    if(board[i][i] != mark)
                    {
                        diag_a_count++;
                    }
                }

                if(diag_a_count == 0)
                {
                    diag_a = 1;
                }

                diag_exit_a++;

            }

            while(diag_exit_b == 0)                      // tests diagonal (b)
            {                

                if(board[k][m] != mark)
                {
                    diag_b_count++;
                }

                if(board[k][m] == board[0][(dimension - 1)])
                {
                    if(diag_b_count == 0)
                    {
                        diag_b = 1;
                        diag_exit_b++;
                    }
                    else
                        diag_exit_b++;

                }
                
                    

                k--;
                m++;
            }

            while(p < dimension)               //checks horizontal wins 
            {   
                for(s = 0; s < dimension; s++)
                {
                    if(board[p][s] != mark)
                    {
                        hcount++;
                    }
                }

                if(hcount == 0)
                {
                    horiz = 1;
                    p = dimension;
                }

                p++;
                hcount = 0;

            }


            while(w < dimension)        //checks vertical wins not working
            {
                for(u = 0; u < dimension; u++)
                {
                    if(board[u][w] != mark)
                    {
                        vcount++;
                    }
                }

                if(vcount == 0)
                {
                    vert = 1;
                    w = dimension;
                }

                w++;
                vcount = 0;

            }
        
                
        if((diag_a == 1) || (diag_b == 1) || (horiz == 1) || (vert == 1))
        {
            return true;
        }
        else
            return false; 
        
        
    }
    
    /**
    * Check the squares of the board to see if the Tic-Tac-Toe game is currently
    * in a tie state.
    *
    * @return  true if the game is currently a tie, or false otherwise
    */	
    private boolean isTie() {
        
        int count = 0;

        int spaces = (dimension * dimension);
        
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board.length; c++)
            {
                if(board[r][c] != TicTacToeSquare.EMPTY)
                {
                    count++;
                }
            }

        if((spaces == count) && (isMarkWin(TicTacToeSquare.X) == false) && (isMarkWin(TicTacToeSquare.O) == false))
        {
            return true;
        }
        else
            return false;
        
            
        
        
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
        
        StringBuilder output = new StringBuilder("");
        
  
        int a = (dimension + 2);    //for extended rows and columns with spaces;
        


        int b = 2; //counter for columns
        int d = 0; //numbers for columns   

        int e = 1; //counter for rows
        int f = 0; //numbers for rows
        

        String disboard[][] = new String[a][a];   // a larger 2D array to display output



        for (int r = 0; r < disboard.length; r++)          //sets every space as blank initially
            for (int c = 0; c < disboard.length; c++)     
                disboard[r][c] = "";
        
        disboard[0][0] = " "; //empty space for corner
        disboard[0][1] = " "; //


        while(b < a)                  //for columns lable
        {
            disboard[0][b] = Integer.toString(d);
            b++;
            d++;

        }



        while(e < a)                //for rows lable
        {
            disboard[e][0] = Integer.toString(f);
            disboard[e][1] = " ";        //fixes spacing 
            e++;
            f++;
        }


        for(int droe = 0; droe < disboard.length; droe++)               // displays "  012"
        {                                                            //           0
            output.append("\n");                                     //           1            
                                                                    //            2           

            for(int dcol = 0; dcol < disboard.length; dcol++)
            {
                if(droe <= board.length)
                {
                    
                    output.append(disboard[droe][dcol]);
                }


                if((droe > 0) && (droe < (dimension + 1)) && (dcol > 1))    //translates TTTSquare objects into string
                {
                    int r = (droe - 1);                                  // translators for the larger 2D array that is the output
                    int c = (dcol - 2);
                    if(board[r][c].equals(TicTacToeSquare.X))
                    {
                        disboard[droe][dcol] = "X";
                        output.append(disboard[droe][dcol]);
                    }
                    else if(board[r][c].equals(TicTacToeSquare.O))
                    {
                        disboard[droe][dcol] = "O";
                        output.append(disboard[droe][dcol]);
                    }
                    else
                    {
                        disboard[droe][dcol] = " ";
                        output.append(disboard[droe][dcol]);
                    }                        

                }  
            }  
        }

        return output.toString();
        
    }
    
}