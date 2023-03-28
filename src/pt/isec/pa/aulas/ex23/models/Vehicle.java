package pt.isec.pa.aulas.ex23.models;

import pt.isec.pa.aulas.ex13.models.Book;

import java.util.Objects;
import java.util.PrimitiveIterator;

public class Vehicle{
    String matricula;
    int ano;

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehicle vehicle)) return false;

        return Objects.equals(getMatricula(), vehicle.matricula);
    }

    @Override
    public int hashCode() {
        return matricula != null ? matricula.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Matricula = '" + matricula + '\'' +
                ", Ano = " + ano ;
    }

}
