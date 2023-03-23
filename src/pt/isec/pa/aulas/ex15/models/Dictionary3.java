package pt.isec.pa.aulas.ex15.models;

import java.util.HashMap;
import java.util.Map;

public class Dictionary3 implements IDictionary{

    String lang;
    private class DictionaryOneLang extends HashMap<String,String> {    }
    private final Map<String, DictionaryOneLang> dict_of_dict;

    public Dictionary3() {
        dict_of_dict =  new HashMap<>();
    }

    @Override
    public void add(String lang, String word, String trad) {
        if (!dict_of_dict.containsKey(lang)){
            DictionaryOneLang dict = new DictionaryOneLang();
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
