package pt.isec.pa.aulas.ex13.models;

import java.util.List;

public class OldBook extends Book{
    private int nCopias;
    public OldBook(String title, List<String> authors, int nCopias) {
        super(title, authors);
        this.nCopias = nCopias;
    }

    public int getnCopias() {
        return nCopias;
    }

    public void setnCopias(int nCopias) {
        this.nCopias = nCopias;
    }

    @Override
    public String toString() {
        if (getTitle() ==null)
            return "DUMMYBOOK ['+id+']";
        if (getAuthors()==null || getAuthors().size()==0)
            return getID() + " " + getTitle() + " ";
        String string = getAuthors().toString();
        return getID() + "," + getTitle() + "," + nCopias + "," + string.substring(1,string.length()-1);
    }
}
