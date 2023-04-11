package pt.isec.pa.aulas.ex24.models.data;

import java.util.Objects;

public class Elevator {
    private int piso;
    private String password;
    private boolean underMaintenance;

    public Elevator(int piso, String password) {
        this.piso = piso;
        this.password = password;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean enterMaintenance() {
        underMaintenance = true;
        return true;
    }

    public boolean leaveMaintenance(String password) {
        if (Objects.equals(password, this.password)){
            underMaintenance = false;
            return true;
        }
        else return false;
    }

    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Current floor: " + piso;
    }
}
