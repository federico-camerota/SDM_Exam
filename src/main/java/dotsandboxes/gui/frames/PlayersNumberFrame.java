package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.DBLabel;
import dotsandboxes.gui.graphics.NumButton;
import dotsandboxes.gui.graphics.BackgroundPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlayersNumberFrame extends InputFrame<Integer>{

    Integer numPlayers;
    List<NumButton> buttons;


    public PlayersNumberFrame(BackgroundPanel bP){

        super(bP);
        DBLabel playerQuestion= new DBLabel("NUMBER OF PLAYERS",200, 30, 200, 30);

        backgroundPanel.add(playerQuestion);

        buttons= new ArrayList<>(3);
        int yOffset = 100;

        for (int i=2; i<5; i++) {
            NumButton button=new NumButton(i,260, yOffset, 80, 30);
            button.addActionListener(x ->
            {
                numPlayers=button.number;
                button.setDark();
                inputGiven=true;
            });
            yOffset+=40;
            backgroundPanel.add(button);
            buttons.add(button);
        }

        updatePanel(backgroundPanel);
    }

    @Override
    public void setPanel() {

    }


    @Override
    public Integer getInput(){


        waitInput();

        this.inputGiven=false;

        clear(backgroundPanel);

        return numPlayers;
    }
}


