package pt.isec.pa.aulas.ex13;

import pt.isec.pa.aulas.ex13.models.LibraryList;
import pt.isec.pa.aulas.ex13.models.LibraryMap;
import pt.isec.pa.aulas.ex13.models.LibrarySet;
import pt.isec.pa.aulas.ex13.views.LibraryUI;

public class MainSet {
    public static void main(String[] args) {
        LibrarySet library = new LibrarySet("DEIS-ISEC-Set");
        LibraryUI libraryUI = new LibraryUI(library);

        libraryUI.start();
    }
}
