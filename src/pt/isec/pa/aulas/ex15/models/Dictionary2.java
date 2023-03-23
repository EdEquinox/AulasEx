package pt.isec.pa.aulas.ex15.models;

import java.util.HashMap;
import java.util.Map;

public class Dictionary2 implements IDictionary{

    String lang;
    private class DictionaryOneLang {
        private final Map<String, String> dictionary;

        private DictionaryOneLang(Map<String, String> dictionary) {
            this.dictionary = dictionary;
        }

        public String get(String word) {
            return dictionary.get(word);
        }

        public void put(String word, String trad) {
            dictionary.put(word,trad);
        }
    }
    private final Map<String, Dictionary2.DictionaryOneLang> dict_of_dict;
    private final DictionaryOneLang oneLang;
    public Dictionary2() {
        dict_of_dict = new HashMap<>();
        this.oneLang = new DictionaryOneLang(new HashMap<>());
    }

    @Override
    public void add(String lang, String word, String trad) {
        if (!dict_of_dict.containsKey(lang)){
            HashMap<String,String> dict = new HashMap<>();
            dict.put(word,trad);
            dict_of_dict.put(lang, oneLang);
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
        DictionaryOneLang dummy = dict_of_dict.get(lang);
        return dummy.get(word);
    }
}
