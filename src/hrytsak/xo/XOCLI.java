package hrytsak.xo;


import hrytsak.xo.View.ConsoleView;
import hrytsak.xo.model.Field;
import hrytsak.xo.model.Figure;
import hrytsak.xo.model.Game;
import hrytsak.xo.model.Player;

import java.util.Scanner;

public class XOCLI {

    public static void main(final String[] args) {
        System.out.print("Input player name 1: ");
        final String name1 = inputName();
        System.out.print("Input player name 2: ");
        final String name2 = inputName();
        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);
        final Game game = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while(consoleView.move(game)) {
            consoleView.show(game);
        }
    }

    static String inputName() {
        final Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    

}
