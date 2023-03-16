package pt.isec.pa.aulas.ex13;

import pt.isec.pa.aulas.ex13.models.LibraryList;
import pt.isec.pa.aulas.ex13.models.LibraryMap;
import pt.isec.pa.aulas.ex13.models.LibrarySet;
import pt.isec.pa.aulas.ex13.views.LibraryUI;

public class MainMap {
    public static void main(String[] args) {

        LibraryMap library = new LibraryMap("DEIS-ISEC-Map");
        LibraryUI libraryUI = new LibraryUI(library);

        libraryUI.start();
    }
}
