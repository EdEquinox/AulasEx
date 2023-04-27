package pt.isec.pa.aulas.organisms;

import pt.isec.pa.aulas.organisms.gameengine.GameEngine;
import pt.isec.pa.aulas.organisms.model.data.Environment;
import pt.isec.pa.aulas.organisms.model.data.EnvironmentManager;
import pt.isec.pa.aulas.organisms.model.data.Evolver;
import pt.isec.pa.aulas.organisms.model.data.Virus;
import pt.isec.pa.aulas.organisms.ui.OrganismsLanternaUI;
import pt.isec.pa.aulas.organisms.ui.OrganismsUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        EnvironmentManager environment = new EnvironmentManager();
        OrganismsUI ui = new OrganismsUI(environment);
        //OrganismsLanternaUI ui = new OrganismsLanternaUI(environment);
        //gameEngine.registerClient(environment);
        //gameEngine.registerClient();
        GameEngine gameEngine = new GameEngine();
        // Lambda expression para implementar IGameEngineEvolve
        gameEngine.registerClient(environment::evolve);
        gameEngine.registerClient((g,t) -> ui.show());
        gameEngine.start(500);
        gameEngine.waitForTheEnd();
    }

}
