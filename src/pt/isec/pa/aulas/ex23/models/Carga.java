package pt.isec.pa.aulas.ex23.models;

public class Carga extends Vehicle implements IMaxLoad{
    int maxLoad;

    public Carga(String matricula, int ano, int maxLoad) {
        this.maxLoad = maxLoad;
        this.matricula = matricula;
        this.ano = ano;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    @Override
    public int getMaxWeight() {
        return maxLoad;
    }

    @Override
    public String toString() {
        return " Pessado de Mercadorias { " +
                super.toString() + ", Máximo de carga = " + maxLoad +
                " }";
    }
}
