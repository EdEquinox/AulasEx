package pt.isec.pa.aulas.ex13.views;

import pt.isec.pa.aulas.ex13.models.Book;
import pt.isec.pa.aulas.ex13.models.ILibrary;
import pt.isec.pa.aulas.ex13.models.LibraryList;
import pt.isec.pa.aulas.utils.PAInput;

import java.util.ArrayList;

public class LibraryUI {
    ILibrary lib;
    public LibraryUI(ILibrary lib) {
        this.lib = lib;
    }

    void addBook() {
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
        lib.addBook(title,authors);
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
