package pt.isec.pa.aulas.ex13.views;

import pt.isec.pa.aulas.ex13.models.*;
import pt.isec.pa.aulas.utils.PAInput;

import java.util.ArrayList;

public class LibraryUI {
    ILibrary lib;
    public LibraryUI(ILibrary lib) {
        this.lib = lib;
    }

    void addRecentBook(){
        String title = PAInput.readString("Book title: ",false);
        String author;
        ArrayList<String> authors = new ArrayList<>();
        do {
            author = PAInput.readString("Name of one author [\'exit\' to finish]: ",false);
            if (author!=null && !author.equalsIgnoreCase("exit"))
                authors.add(author);
        } while (!author.equalsIgnoreCase("exit"));
        if (authors.isEmpty())
            authors.add("Author unknown");
        String isbn = PAInput.readString("ISBN: ",true);
        double preco = PAInput.readNumber("Preço: ");
        RecentBook recentBook = new RecentBook(title,authors,isbn,preco);
        lib.addBook(recentBook);
    }
    void addOldBook(){
        String title = PAInput.readString("Book title: ",false);
        String author;
        ArrayList<String> authors = new ArrayList<>();
        do {
            author = PAInput.readString("Name of one author [\'exit\' to finish]: ",false);
            if (author!=null && !author.equalsIgnoreCase("exit"))
                authors.add(author);
        } while (!author.equalsIgnoreCase("exit"));
        if (authors.isEmpty())
            authors.add("Author unknown");
        int nCopias = PAInput.readInt("Número de cópias: ");
        OldBook oldBook = new OldBook(title,authors,nCopias);
        lib.addBook(oldBook);
    }
    void addBook() {
        int escolha = PAInput.readInt("Recente (0) ou Antigo (1)? ");
        if (escolha == 0){
            addRecentBook();
        } else {
            addOldBook();
        }

    }

    void findBook() {
        int bookId = PAInput.readInt("ID of the book to search: ");
        Book book = lib.findBook(bookId);
        if (book == null)
            System.out.println("Book not found");
        else
            System.out.println("Book found: "+book);
    }

    void removeBook() {
        int codigo = PAInput.readInt("ID of the book to remove: ");
        boolean deleted = lib.removeBook(codigo);
        if (!deleted)
            System.out.println("Book not found");
        else
            System.out.println("Book deleted");
    }

    public void start() {
        while (true) {
            switch (PAInput.chooseOption("Library Manager - "+lib.getName(),
                    "Add new book","Search book","Remove book","Show books",
                    "Quit")) {
                case 1:
                    addBook();
                    break;
                case 2:
                    findBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    System.out.println(lib.toString());
                    break;
                case 5:
                    return;
            }
        }
    }

}
