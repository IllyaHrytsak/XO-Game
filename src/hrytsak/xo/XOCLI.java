package hrytsak.xo;


import hrytsak.xo.View.ConsoleView;
import hrytsak.xo.model.Field;
import hrytsak.xo.model.Figure;
import hrytsak.xo.model.Game;
import hrytsak.xo.model.Player;

import java.util.Scanner;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Illya";
        final String name2 = "Vlad";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while(consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }


}
