package pt.isec.pa.aulas.exemploFSMjavaFX.ui.text;

import pt.isec.pa.aulas.exemploFSMjavaFX.Main;
import pt.isec.pa.aulas.exemploFSMjavaFX.model.GameBWManager;
import pt.isec.pa.aulas.exemploFSMjavaFX.ui.text.utils.PAInput;

public class GameBWUI {
    GameBWManager manager;

    public GameBWUI() {
        this.manager = Main.gameBWManager;
    }

    private boolean finish = false;
    public void start() {
        while(!finish) {
            showResults();
            switch (manager.getState()) {
                case BEGIN -> beginUI();
                case WAIT_BET -> waitBetUI();
                case LOST_WAIT_DECISION -> lost_WaitDecisionUI();
            }
        }
    }

    private void beginUI() {
        if (PAInput.chooseOption("Game BW", "Start", "Exit App") == 1)
            manager.start();
        else
            finish = true;
    }

    private void waitBetUI() {
        switch (PAInput.chooseOption("Game BW - Waiting for a decision", "Bet","Leave game","Exit App")) {
            case 1 -> {
                int nr_balls = PAInput.readInt(
                        String.format("How many balls do you want to bet [0..%d]? ", manager.getNrWhiteBallsWon()));
                System.out.println( "\nResult: "+
                        switch (manager.bet(nr_balls)) {
                            case WON -> "You won the bet";
                            case LOST -> "The bet was lost";
                            case ERROR -> "Invalid bet";
                });
            }
            case 2 -> manager.end();
            default -> finish = true;
        }
    }

    private void lost_WaitDecisionUI() {
        switch (PAInput.chooseOption("Game BW - The Bet was Lost",
                "Lose on more white ball", "Remove two balls from the bag", "Exit App")) {
            case 1 -> manager.loseWhiteball();
            case 2 -> manager.removeTwoBalls();
            default -> finish = true;
        }
    }

    private void showResults() {
        System.out.println("\n*** Game GW ***");
        System.out.printf("White Balls won: %d\n", manager.getNrWhiteBallsWon());
        System.out.printf("White Balls out: %d\n", manager.getNrWhiteBallsOut());
        System.out.printf("Black Balls out: %d\n", manager.getNrBlackBallsOut());
    }
}
