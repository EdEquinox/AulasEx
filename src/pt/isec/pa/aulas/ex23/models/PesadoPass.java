package pt.isec.pa.aulas.ex23.models;

public class PesadoPass extends Vehicle implements IPassagers,IMaxLoad{
    int maxPass;
    int maxLoad;

    public PesadoPass(String matricula, int ano, int maxPass, int maxLoad) {
        this.maxPass = maxPass;
        this.maxLoad = maxLoad;
        this.matricula = matricula;
        this.ano = ano;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public void setMaxPass(int maxPass) {
        this.maxPass = maxPass;
    }

    @Override
    public int getMaxWeight() {
        return maxLoad;
    }

    @Override
    public int getNumberPassengers() {
        return maxPass;
    }

    @Override
    public String toString() {
        return " Pessado de Passageiros {" +
                super.toString() + ", Máximo de passageiros = " + maxPass + ", Máximo de carga = " + maxLoad +
                " }";
    }
}
