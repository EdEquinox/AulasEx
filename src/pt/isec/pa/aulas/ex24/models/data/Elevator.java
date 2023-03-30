package pt.isec.pa.aulas.ex24.models.data;

public class Elevator {
    private int piso;

    public Elevator(int piso) {
        this.piso = piso;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    @Override
    public String toString() {
        return "Current floor: " + piso;
    }
}
