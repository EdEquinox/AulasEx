package pt.isec.pa.aulas.ex13.models;

import java.util.*;

public class LibraryMap implements ILibrary{
    private String name;
    private Map<Integer,Book> lstBooks;
    public LibraryMap(String s) {
        this.name = s;
        lstBooks = new HashMap<>();
    }
    @Override
    public void addBook(String title, ArrayList<String> authors) {
        Book book = new Book(title,authors);
        lstBooks.put(book.getID(), book);
    }

    @Override
    public void addBook(Book book) {
        lstBooks.put(book.getID(), book);
    }

    @Override
    public Book findBook(int bookId) {
        if (lstBooks == null || lstBooks.size() == 0)
            return null;
        return lstBooks.get(bookId);
    }

    @Override
    public boolean removeBook(int codigo) {
        if (lstBooks == null || lstBooks.size()==0)
            return false;
        lstBooks.remove(codigo);
        return true;
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
        HashMap<Integer,Book> collection = new HashMap<>(lstBooks);

        return collection.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("LibraryMap: %s\n",name));
        sb.append("Books: ");
        if (lstBooks ==null || lstBooks.size()==0){
            sb.append("library empty");
        }else {
            for (Book book : lstBooks.values()){
                sb.append(String.format("- %s\n",book.toString()));
            }
        }
        return sb.toString();
    }
}
