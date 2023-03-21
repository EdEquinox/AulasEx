package pt.isec.pa.aulas.ex13.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LibraryList implements ILibrary{
    private String name;
    private List<Book> lstBooks;
    public LibraryList(String s) {
        this.name = s;
        lstBooks = new ArrayList<>();
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
        if (lstBooks == null || lstBooks.size()==0)
            return null;
        for (Book book: lstBooks) {
            return book;
        }
        return null;
    }

    public Book findBook2(int bookId) {
        if (lstBooks == null || lstBooks.size()==0)
            return null;
        Book book = Book.getDummyBook(bookId);
        int index = lstBooks.indexOf(book);
        if (index<0)
            return null;
        return lstBooks.get(index);
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
        ArrayList<Book> collection = new ArrayList<>(lstBooks);
        Collections.sort(collection);
        return collection.toString();
     }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Book: %s\n",name));
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
