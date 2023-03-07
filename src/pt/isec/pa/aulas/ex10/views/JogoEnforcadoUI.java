package pt.isec.pa.aulas.ex10.views;

import pt.isec.pa.aulas.ex10.model.JogoEnforcadoModelo;

import java.util.Scanner;

public class JogoEnforcadoUI {
    JogoEnforcadoModelo jogo;

    public JogoEnforcadoUI(JogoEnforcadoModelo jogo) {
        this.jogo = jogo;
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        while (jogo.fim()){

            System.out.println("Tentativa: ");
            String resp = scanner.nextLine();
            jogo.bet(resp);
            System.out.println(jogo.getLetras());
            jogo.comparaPalavra();
            System.out.println(jogo.getSituacao());
            System.out.println(jogo.getErros());
        }
    }
}
