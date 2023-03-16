package pt.isec.pa.aulas.ex13;

import pt.isec.pa.aulas.ex13.models.LibraryList;
import pt.isec.pa.aulas.ex13.models.LibraryMap;
import pt.isec.pa.aulas.ex13.models.LibrarySet;
import pt.isec.pa.aulas.ex13.views.LibraryUI;
import pt.isec.pa.aulas.utils.PAInput;

public class MainList {
    public static void main(String[] args) {
        LibraryList library = new LibraryList("DEIS-ISEC");
        LibraryUI libraryUI = new LibraryUI(library);

        libraryUI.start();
    }
}
