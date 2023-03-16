package pt.isec.pa.aulas.ex13.models;

import java.util.ArrayList;

public interface ILibrary {
    void addBook(String title, ArrayList<String> authors);

    Book findBook(int bookId);

    boolean removeBook(int codigo);

    String getName();

    void setName(String name);
}
