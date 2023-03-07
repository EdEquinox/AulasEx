package pt.isec.pa.aulas.ex10;

import pt.isec.pa.aulas.ex10.model.JogoEnforcadoModelo;
import pt.isec.pa.aulas.ex10.views.JogoEnforcadoUI;

public class Main {
    public static void main(String[] args) {

        JogoEnforcadoModelo Jogo = new JogoEnforcadoModelo();
        JogoEnforcadoUI JogoUI = new JogoEnforcadoUI(Jogo);
        JogoUI.jogar();

    }
}
