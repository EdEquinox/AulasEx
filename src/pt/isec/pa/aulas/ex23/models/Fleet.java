package pt.isec.pa.aulas.ex23.models;

import pt.isec.pa.aulas.ex13.models.Book;

import java.util.*;

public class Fleet{
    private String name;
    private Set<Vehicle> setVehicles;

    public Fleet(String name) {
        this.name = name;
        this.setVehicles = new HashSet<>();
    }

    public boolean addCar(Vehicle car) {
        return setVehicles.add(car);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Frota: %s\n",name));
        if (setVehicles ==null || setVehicles.size()==0){
            sb.append("fleet empty");
        }else {
            for (Vehicle vehicle : setVehicles){
                sb.append(String.format("- %s\n",vehicle.toString()));
            }
        }
        return sb.toString();
    }

    public boolean removeVehicle(String matricula) {
        if (setVehicles == null || setVehicles.size()==0)
            return false;
        for (Vehicle vehicle: setVehicles) {
            if (vehicle.getMatricula().equalsIgnoreCase(matricula)){
                setVehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    public String listPass() {
        List<IPassagers> set = new ArrayList<>();
        for (Vehicle vehicle: setVehicles) {
            if (vehicle instanceof IPassagers){
                set.add((IPassagers) vehicle);
            }
        }

        Collections.sort(set,new PassageirosComparator());

        return set.toString();
    }

    public String listCarga() {
        HashSet<Vehicle> set = new HashSet<>();
        for (Vehicle vehicle: setVehicles) {
            if (vehicle instanceof IMaxLoad){
                set.add(vehicle);
            }
        }
        return set.toString();
    }

}
