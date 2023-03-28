package pt.isec.pa.aulas.ex23.models;

import java.util.Comparator;

public class PassageirosComparator implements Comparator<IPassagers> {
    @Override
    public int compare(IPassagers o1, IPassagers o2) {
        return o1.getNumberPassengers() - o2.getNumberPassengers();
    }
}
