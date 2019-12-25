package gamesuite.game;

import gamesuite.board.BoardManager;
import gamesuite.move.MoveValidator;
import gamesuite.players.Player;
import gamesuite.players.PlayersFactory;
import gamesuite.status.GameStatus;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public abstract class GameSetter {

    private final InputManager iManager;
    private final OutputManager oManager;

    public GameSetter(InputManager iManager, OutputManager oManager){

        this.iManager = iManager;
        this.oManager = oManager;
    }

   public final Game newGame() throws DataFormatException {

       List<Player> players = setPlayers();
       BoardManager bManager = createBoard();
       MoveValidator mValidator = setValidator(bManager);
       GameStatus gStatus = setStatus(players, bManager, mValidator);

       return new Game(iManager, oManager, bManager, mValidator, gStatus, players);
   }

    private BoardManager createBoard() throws DataFormatException {

        List<Integer> dimensions = iManager.getGridDimensions(); //function that asks for grid dimensions and returns it
        return  setBoard(dimensions.get(0), dimensions.get(1));
    }

    private List<Player> setPlayers() throws DataFormatException {

        Integer nPlayers = iManager.getPlayersNumber(); //how many players are there?

        List<Player> players = new ArrayList<>(nPlayers);
        PlayersFactory playerGenerator= new PlayersFactory();

        boolean custom = iManager.customPlayers(); //do you want to customize Players name? Yes=True
        if (custom) {

            for (Integer i = 0; i < nPlayers ; i++) {

                String name = iManager.getPlayerName();
                if (name.isEmpty())
                    players.set(i, playerGenerator.newPlayer());
                else
                    players.set(i, playerGenerator.newPlayer(name));
            }
        }
        else{
            for(int i=0;i<nPlayers;i++) {
                players.set(i, playerGenerator.newPlayer());
            }
        }

        return players;
    }

    protected abstract GameStatus setStatus(List<Player> players, BoardManager bManager, MoveValidator mValidator);

    protected abstract MoveValidator setValidator(BoardManager bManager);

    protected abstract BoardManager setBoard(Integer rows, Integer cols);
}