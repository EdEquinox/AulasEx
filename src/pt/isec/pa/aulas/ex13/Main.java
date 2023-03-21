package pt.isec.pa.aulas.ex13;

import pt.isec.pa.aulas.ex13.models.LibraryList;
import pt.isec.pa.aulas.ex13.views.LibraryUI;

public class Main {
    public static void main(String[] args) {
        LibraryList library = new LibraryList("DEIS-ISEC");
        LibraryUI libraryUI = new LibraryUI(library);

        libraryUI.start();
    }
}
