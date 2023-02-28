package pt.isec.pa.aulas;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        int lowerBound = 1, upperBound = 100, tries = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Pensa num número aleatório entre 1 e 100");

        while(lowerBound <= upperBound){
            int r = (upperBound + lowerBound) / 2;
            System.out.println("O número é o " + r + "? (número é Menor: -1; Igual: 0; Maior = 1)");
            int resp = sc.nextInt();
            if (resp == -1){
                upperBound = r - 1;

            }else if (resp == 0){
                System.out.println("Acertei em " + tries + " tentativas!");
                break;

            }else if (resp == 1){
                lowerBound = r + 1;
            }
            tries++;
        }

        System.out.println("Número de tentativas: " + tries);
    }
}