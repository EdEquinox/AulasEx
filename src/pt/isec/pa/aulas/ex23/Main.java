package pt.isec.pa.aulas.ex23;

import pt.isec.pa.aulas.ex23.models.Fleet;
import pt.isec.pa.aulas.ex23.views.FleetUI;

public class Main {
    public static void main(String[] args) {

        Fleet fleet = new Fleet("Hugo na Strada");
        FleetUI fleetUI = new FleetUI(fleet);

        fleetUI.start();
    }
}
