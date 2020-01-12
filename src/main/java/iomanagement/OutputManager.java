package iomanagement;

import gamesuite.board.AbstractBoard;
import gamesuite.game.EndGameException;
import gamesuite.game.Game;
import gamesuite.move.InvalidMoveException;

public interface OutputManager {



    public void startGame(Game game);

    public  void printGame(Game game);

    public  void printInvalidMove(InvalidMoveException e);

    public  void outputPrintln(String message);

    public  void errorPrintln(String s);

    public  void outputPrint(String s);

    public void resetGame(Game game);

    public  void errorPrint(String s);

    public  void printWinner(Game game, boolean gameManuallyEnded);

    public  void printBoard(AbstractBoard board);

}
