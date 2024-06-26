import java.util.Scanner;

  class TicTacToe

{
   static char [][] board;
    public TicTacToe()
    {
         board = new char[3][3];
         initBoard();
    }
    void initBoard()
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
            {
                board[i][j] = ' ';
            }
        }
    }
   static void dispBoard()
    {
        System.out.println("----------------");
        for(int i=0; i<board.length; i++)
        {
            System.out.print("|  ");
            for(int j=0; j<board[i].length; j++)
            {
                System.out.print(board[i][j] + " |  ");
            }
            System.out.println();
            System.out.println("----------------");
        }
    }
   static void placeMark(int row, int column, char mark)
    {
       if(row >=0 && row<=2 && column >=0 && column <=2)
       {
        board[row][column] = mark;
       }
       else
       {
        System.out.println("Invalid Position");
       }
    }
   static boolean checkColWin()
    {
       for(int j=0; j<=2; j++)
       {
        if(board[0][j] != ' ' &&   board[0][j] == board[1][j] && board[1][j] == board[2][j])
        {
               return true;
        }
       }
       return false;
       }
        
      static boolean checkRowWin()
       {
        for(int i=0; i<=2; i++)
        {
            if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
            {
                return true;
            }
        }
        return false;
       }
     static  boolean checkDiagWin()
       {
        
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] 
        ||board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            return true;
        }
        else{
            return false;
        }
       }
 static class HumanPlayer
{
    String name;
    char mark;
    HumanPlayer(String name, char mark)
    {
        this.name = name;
        this.mark = mark;
    }
    void makeMove()
    {
        Scanner scan = new Scanner(System.in);
        int row;
        int column;
        do
        {
            System.out.println("Enter The Row And Column");
         row = scan.nextInt();
         column = scan.nextInt();
        } while(!isValidMove(row, column));

        TicTacToe.placeMark(row, column, mark);

    }
    boolean isValidMove( int row, int column)
    {
        if(row>=0 && row <=2 &&
        column >=0 && column <=2)
        {
            if(TicTacToe.board[row][column] == ' ')
            {
                return true;
            }
        }
        return false;
    }
}

public class tictactoegame {

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
          
      HumanPlayer p1 =  new HumanPlayer("Chhotu ", 'X');
      HumanPlayer p2 = new HumanPlayer("Lisa ", 'O');
      HumanPlayer cp;
      cp = p1;
       
      while(true)
      {
        System.out.println(cp.name + "turn");
      cp.makeMove();
      TicTacToe.dispBoard();
      if(TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin())
      {
        System.out.println(cp.name + "has won");
        break;
      }
      else{
        if(cp == p1)
        {
            cp = p2;
        }
        else
        {
            cp = p1;
        }
    
    
      }
    
    }

}

}
}