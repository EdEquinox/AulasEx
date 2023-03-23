package pt.isec.pa.aulas.ex15.models;

import java.util.HashMap;
import java.util.Map;

public class Dictionary1 implements IDictionary {

    private String lang;
    private final Map<String, Map<String,String>> dict_of_dict;

    public Dictionary1() {
        this.dict_of_dict = new HashMap<>();
    }

    @Override
    public void add(String lang, String word, String trad) {
        if (!dict_of_dict.containsKey(lang)){
            HashMap<String,String> dict = new HashMap<>();
            dict.put(word,trad);
            dict_of_dict.put(lang, dict);
        } else {
            dict_of_dict.get(lang).put(word,trad);
        }
    }

    @Override
    public void setLanguage(String lang) {
        this.lang = lang;
    }
    @Override
    public String get(String word) {
        Map<String,String> dummy = dict_of_dict.get(lang);
        return dummy.get(word);
    }
}
