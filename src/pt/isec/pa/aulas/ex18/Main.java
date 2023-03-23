package pt.isec.pa.aulas.ex18;

import pt.isec.pa.aulas.ex18.models.TemperaturaDiaria;
import pt.isec.pa.aulas.ex18.models.Temperaturas;

public class Main {
    public static void main(String[] args) {
        Temperaturas temperaturas = new Temperaturas();
        int [] t_coimbra = { 1, 2, 3, 4, 5, 6, 7}; // min 1 max 7
        int [] t_lisboa = { 1, 0, 2, 0, 2, 0, 7}; // min 0 max 7
        int [] t_porto = { 1, 4, 2, 5, 2, 3, 7}; // min 1 max 7
        System.out.println("1 - Coimbra");
        temperaturas.acrescenta(
                new TemperaturaDiaria(t_coimbra, "Felisberto", "Coimbra") );
        System.out.println("2 - Lisboa");
        temperaturas.acrescenta(
                new TemperaturaDiaria(t_lisboa, "Pancrácio", "Lisboa") );
        System.out.println("3 - Porto");
        temperaturas.acrescenta(
                new TemperaturaDiaria(t_porto, "Zeferino", "Porto") );
    }
}
