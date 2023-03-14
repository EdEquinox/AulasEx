package pt.isec.pa.aulas.ex13.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private static int count = 0;
    private static int getNewID(){return ++count;}
    private int ID;
    private String title;
    private List<String> authors;

    public Book(String title, List<String> authors) {
        this.ID = getNewID();
        this.title = title;
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean addAuthors(String author) {
        if ( author.isBlank() || authors.contains(author)){
            return false;
        }
        authors.add(author);
        return true;
    }

    public boolean removeAuthors(String author) {
        authors.remove(author);
        return false;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private Book(int id){
        this.ID = id;
        title=null;
        authors=null;
    }

    static Book getDummyBook(int id){
        return new Book(id);
    }

    @Override
    public String toString() {
        if (title==null)
            return "DUMMYBOOK ['+id+']";
        if (authors==null || authors.size()==0)
            return ID + " " + title + " ";
        String string = authors.toString();
        return ID + "," + title + "," + string.substring(1,string.length()-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return ID == book.ID;
    }

    @Override
    public int hashCode() {
        return ID;
    }
}
