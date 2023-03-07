package pt.isec.pa.aulas.ex10.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class JogoEnforcadoModelo {

    int erros;
    String palavra;
    char []letras = {};
    StringBuilder situacao;

    public JogoEnforcadoModelo(){
        iniciar();
    }

    public void iniciar() {
        Random random = new Random();
        //this.palavra = JogoEnforcadoDicionario.getPalavra(random.nextInt(JogoEnforcadoDicionario.getNumeroPalavras()));
        this.palavra = "casa";
        situacao();
    }

    public void bet(String tentativa){
        //System.out.println(tentativa.length());
        char c = tentativa.charAt(0);
        if(tentativa.length() == 1){
            if (palavra.contains(tentativa)){
                for (int i=0;i<situacao.length();i++){
                    if (palavra.charAt(i) == c){
                        situacao.setCharAt(i,c);
                    }
                }
            } else{
                erros++;
            }
            letras = Arrays.copyOf(letras,letras.length+1);
            letras[letras.length-1] = c;
            comparaPalavra();
        }else {
            if (tentativa.equals(palavra)){
                fim();
            }
            else fim();
        }
    }

    public boolean fim() {
        return true;
    }

    public void situacao(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_".repeat(palavra.length()));
        situacao = stringBuilder;
    }

    public char[] getLetras() {
        return letras;
    }

    public void comparaPalavra(){
        if (situacao.equals(palavra)){
            fim();
        }
    }

    public StringBuilder getSituacao() {
        return situacao;
    }

    public int getErros() {
        return erros+1;
    }
}
