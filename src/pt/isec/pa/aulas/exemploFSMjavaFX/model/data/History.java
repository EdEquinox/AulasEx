package pt.isec.pa.aulas.exemploFSMjavaFX.model.data;

public record History(int nrWBwon, int nrWBout, int nrBBout, int bet, Type type) {
    public enum Type {BET, BETWON, BETLOST, LOSE, REMOVE, OTHER}
}
