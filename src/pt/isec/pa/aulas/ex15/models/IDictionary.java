package pt.isec.pa.aulas.ex15.models;

public interface IDictionary {

    public void add(String lang, String word, String trad);

    public void setLanguage(String lang);

    public String get(String word);

}
