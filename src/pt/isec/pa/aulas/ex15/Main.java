package pt.isec.pa.aulas.ex15;

import pt.isec.pa.aulas.ex15.models.Dictionary1;
import pt.isec.pa.aulas.ex15.models.Dictionary2;
import pt.isec.pa.aulas.ex15.models.Dictionary3;

public class Main {

    public static void main(String[] args) {
        Dictionary1 d = new Dictionary1();
        //Dictionary2 d = new Dictionary2();
        //Dictionary3 d = new Dictionary3();
        d.add("english", "BOOK", "book");
        d.add("francais", "BOOK", "livre");
        d.add("portugues", "BOOK", "livro");
        d.add("english", "YEAR", "year");
        d.add("francais", "YEAR", "an");
        d.add("portugues", "YEAR", "ano");
        d.setLanguage("english");
        System.out.println(d.get("YEAR")); // year
        d.setLanguage("portugues");
        System.out.println(d.get("YEAR")); // ano
        d.setLanguage("francais");
        System.out.println(d.get("BOOK")); // livre
    }

}
