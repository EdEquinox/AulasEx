package pt.isec.pa.aulas.ex13;

import pt.isec.pa.aulas.ex13.models.Library;
import pt.isec.pa.aulas.ex13.views.LibraryUI;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("DEIS-ISEC");
        LibraryUI libraryUI = new LibraryUI(library);

        libraryUI.start();
    }
}
