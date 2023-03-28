package pt.isec.pa.aulas.ex23.models;

public class Ligeiro extends Vehicle implements IPassagers {
    int maxPass;

    public Ligeiro(String matricula, int ano, int maxPass) {
        this.maxPass = maxPass;
        this.matricula = matricula;
        this.ano = ano;
    }

    public void setMaxPass(int maxPass) {
        this.maxPass = maxPass;
    }

    @Override
    public int getNumberPassengers() {
        return maxPass;
    }

    @Override
    public String toString() {
        return " Ligeiro { " +
                super.toString() + ", Máximo de passageiros = " + maxPass +
                " }";
    }
}
