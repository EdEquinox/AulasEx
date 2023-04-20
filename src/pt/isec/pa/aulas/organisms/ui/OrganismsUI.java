package pt.isec.pa.aulas.organisms.ui;

import pt.isec.pa.aulas.organisms.model.ModelLog;
import pt.isec.pa.aulas.organisms.model.data.Environment;
import pt.isec.pa.aulas.organisms.model.data.EnvironmentManager;

public class OrganismsUI {
    EnvironmentManager environment;

    public OrganismsUI(EnvironmentManager environment) { this.environment = environment; }

    public void show() {
        ModelLog.getInstance().getLog().forEach(System.out::println);
        ModelLog.getInstance().reset();

        char [][] env = environment.getEnvironment();
        System.out.println();
        for(int y=0;y<env.length;y++) {
            for(int x = 0; x< env[0].length;x++)
                System.out.print(env[y][x]);
            System.out.println();
        }
    }
}
