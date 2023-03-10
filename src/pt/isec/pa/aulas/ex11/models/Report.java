package pt.isec.pa.aulas.ex11.models;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Report {
    private static final int MAX_AUTH = 5;
    private static final int INC_AUTHORS = 5;
    private String title;
    private String[] authors;
    private StringBuilder text;
    private int qtAuthors;

    public Report(String title) {
        this.title = title;
        this.text = new StringBuilder();
        this.authors = new String[MAX_AUTH];
        this.qtAuthors = 0;
    }

    public String getTitle() {
        return title;
    }

    public static int getMaxAuth() {
        return MAX_AUTH;
    }

    public int getQtAuthors() {
        return qtAuthors;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getText() {
        return text.toString();
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public void setQtAuthors(int qtAuthors) {
        this.qtAuthors = qtAuthors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean addAuthor(String author) {
        if (qtAuthors<0 || author.isBlank()){
            return false;
        }
        for (int i=0;i<qtAuthors;i++){
            if (authors[i].equalsIgnoreCase(author)){
                return false;
            }
        }
        if (qtAuthors >= authors.length){
            String[] new_authors = new String[authors.length+INC_AUTHORS];
            System.arraycopy(authors,0,new_authors,0,authors.length);
            authors = new_authors;
            //alternativa
            //authors = Arrays.copyOf(authors,authors.length+INC_AUTHORS);
        }
        authors[qtAuthors++] = author;
        return true;
    }

    public boolean removeAuthor(String author) {
        for (int i=0;i<MAX_AUTH;i++){
            if (authors[i].equalsIgnoreCase(author)){
                for (int j =i;j<qtAuthors-1;j++){
                    authors[j] = authors[j+1];
                }
                qtAuthors--;
                authors[qtAuthors]=null;
                return true;
            }
        }
        return false;
    }

    public void addText(String text) {
        if (this.text == null){
            this.text = new StringBuilder(text);
        }
        else {
            this.text.append(text);
        }
    }

    public void capitalizeSentences() {
        boolean changeNext = true;
        for (int i=0;i<text.length();i++){
            char c = text.charAt(i);
            if (changeNext && Character.isLetter(c)){
                text.setCharAt(i,Character.toUpperCase(c));
                changeNext = false;
            } else if (".!?".indexOf(c)>0){
                changeNext=true;
            }
        }
    }

    public Object getNumberOfWords() {
//        int count = 0;
//        Scanner sc = new Scanner(this.text.toString());
//        sc.useDelimiter("[\\s, .!?]+");
//        while (sc.hasNext()){
//            count++;
//            sc.next();
//        }
//        return count;

//        String [] words = text.toString().split("[\\s,.!?]+");
//        return  words.length;

        StringTokenizer st =new StringTokenizer(text.toString(),"\t\n,.!?");
        return st.countTokens();

    }

    public Object getNumberOfOccurrences(String word) {
        int count = 0;
        StringTokenizer st =new StringTokenizer(text.toString(),"\t\n,.!?");
        while (st.hasMoreTokens()){
            if (word.equalsIgnoreCase(st.nextToken())){
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Report\n");
        sb.append(String.format("Title: %s\n",title));
        sb.append("Authors: ");
        for (int i=0;i<qtAuthors;i++){
            if (i>0){
                sb.append(", ");
            }
            sb.append(authors[i]);
        }
        sb.append("\nText: \n");
        sb.append(text);
        return sb.toString();
    }
}
