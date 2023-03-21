package pt.isec.pa.aulas.ex13.models;

import java.util.List;

public class RecentBook extends Book{
    String isbn;
    double preco;
    public RecentBook(String title, List<String> authors, String isbn, double preco) {
        super(title, authors);
        this.preco = preco;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        if (getTitle() ==null)
            return "DUMMYBOOK ['+id+']";
        if (getAuthors()==null || getAuthors().size()==0)
            return getID() + " " + getTitle() + " ";
        String string = getAuthors().toString();
        return getID() + "," + getTitle() + "," + isbn + "," + preco + "," + string.substring(1,string.length()-1);
    }
}
