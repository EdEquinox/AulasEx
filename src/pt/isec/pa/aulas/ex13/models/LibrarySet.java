package pt.isec.pa.aulas.ex13.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LibrarySet implements ILibrary{

    private String name;
    private Set<Book> lstBooks;
    public LibrarySet(String s) {
        this.name = s;
        lstBooks = new HashSet<>();
    }

    @Override
    public void addBook(String title, ArrayList<String> authors) {
        Book book = new Book(title,authors);
        lstBooks.add(book);
    }

    @Override
    public void addBook(Book book) {
        lstBooks.add(book);
    }

    @Override
    public Book findBook(int bookId) {
        if (lstBooks == null || lstBooks.size() == 0)
            return null;
        for (Book book : lstBooks) {
            if (bookId== book.getID()){
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean removeBook(int codigo) {
        if (lstBooks == null || lstBooks.size()==0)
            return false;
        for (Book book: lstBooks) {
            if (book.getID()==codigo){
                lstBooks.remove(codigo);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toStringSorted() {
        HashSet<Book> collection = new HashSet<>(lstBooks);

        return collection.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("LibrarySet: %s\n",name));
        sb.append("Books: ");
        if (lstBooks ==null || lstBooks.size()==0){
            sb.append("library empty");
        }else {
            for (Book book : lstBooks){
                sb.append(String.format("- %s\n",book.toString()));
            }
        }
        return sb.toString();
    }

}
