package pt.isec.pa.aulas.Ex04;

public class Main {
    public static void main(String[] args) {
        Array20 array = new Array20();
        array.fill();
        array.list();
        System.out.println("NÃºmero de duplicados: " + array.getnDup());
    }
}
