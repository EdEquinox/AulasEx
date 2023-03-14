package pt.isec.pa.aulas.ex13.models;

import java.util.ArrayList;

public class Library {
    private String name;
    ArrayList<Book> lstBooks;
    public Library(String s) {
        this.name = s;
    }

    public void addBook(String title, ArrayList<String> authors) {
        Book book = new Book(title,authors);
        lstBooks.add(book);
    }

    public Book findBook(int bookId) {
        if (lstBooks == null || lstBooks.size()==0)
            return null;
        for (Book book: lstBooks) {
            return book;
        }
        return null;
    }public Book findBook2(int bookId) {
        if (lstBooks == null || lstBooks.size()==0)
            return null;
        Book book = Book.getDummyBook(bookId);
        int index = lstBooks.indexOf(book);
        if (index<0)
            return null;
        return lstBooks.get(index);
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
