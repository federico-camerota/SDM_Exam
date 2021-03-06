package dotsandboxes.gui.frames;

import dotsandboxes.gui.components.BackgroundPanel;
import dotsandboxes.gui.components.DBlabels.DBLabel;
import dotsandboxes.gui.filesAndFont.FontSetter;
import dotsandboxes.gui.components.ObjSpecifics;
import gamesuite.game.Game;
import gamesuite.players.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EndFrame extends Frame{
    public EndFrame(BackgroundPanel bP) {

        super(bP);
    }

    @Override
    public void setPanel() {

    }

    public void printWinner(Game game){


        List<Player> winners = game.getWinner();
        clear();
        DBLabel winMessage = new DBLabel("",new ObjSpecifics(175, 30, 250, 50,80));

        List<JLabel> winnersLabels= new ArrayList<>();

        if (winners.size() == 1) winMessage.setText("The winner is");
        else winMessage.setText("<html><body style='text-align: center'>Game is a draw<br/>The following players have the same score:<html>");
        winMessage.setFont(FontSetter.setFont());

        BACKGROUND_PANEL.add(winMessage);
        int yOffset = 90;

        for (Player p : winners) {
            DBLabel label= new DBLabel(p.getName(),new ObjSpecifics(260, yOffset, 80, 30,80));

            yOffset+=30;
            BACKGROUND_PANEL.add(label);
            winnersLabels.add(label);
        }
        updatePanel();
    }
}
