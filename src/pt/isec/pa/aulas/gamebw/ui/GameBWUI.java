package pt.isec.pa.aulas.gamebw.ui;

import pt.isec.pa.aulas.gamebw.model.fsm.GameBWContext;
import pt.isec.pa.aulas.utils.PAInput;

public class GameBWUI {
    GameBWContext fsm;

    public GameBWUI(GameBWContext fsm) {
        this.fsm = fsm;
    }

    private boolean finish = false;
    public void start() {
        while(!finish) {
            showResults();
            if (fsm.getState() == null) System.exit(-1); // TODO: remove!
            switch (fsm.getState()) {
                case BEGIN -> begin();
                case APOSTA -> aposta();
                case LOST_WAITDECISION -> lostWait();
                default -> finish = true;
            }
        }
    }

    private void lostWait() {
        switch (PAInput.chooseOption("  ",
                "Remover 2 bolas", "Perder bola")) {
            case 1 -> fsm.removeTwoBalls();
            case 2 -> fsm.loseWhiteBall();
        }
    }

    private void aposta() {
        switch (PAInput.chooseOption("  ",
                "Apostar", "Sair")) {
            case 1 -> {
                int a = PAInput.readInt("Quantas bolas");
                fsm.bet(a);
            }
            case 2 -> finish = true;
        }
    }

    private void begin() {
        switch (PAInput.chooseOption("  ",
                "Começar", "Sair")) {
            case 1 -> fsm.start();
            case 2 -> finish = true;
        }
    }

    private void showResults() {
        System.out.println("\n*** Game GW ***");
        System.out.printf("White Balls won: %d\n",fsm.getNrWhiteBallsWon());
        System.out.printf("White Balls out: %d\n",fsm.getNrWhiteBallsOut());
        System.out.printf("Black Balls out: %d\n",fsm.getNrBlackBallsOut());
    }
}
