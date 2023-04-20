package pt.isec.pa.aulas.organisms.model.data;

public abstract class Organism implements IMazeElement {
    protected Environment environment;

    protected Organism(Environment environment) {
        this.environment = environment;
    }

    abstract public void evolve();
}
